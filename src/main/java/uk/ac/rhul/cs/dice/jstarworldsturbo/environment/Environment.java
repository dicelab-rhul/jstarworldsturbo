package uk.ac.rhul.cs.dice.jstarworldsturbo.environment;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONObject;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.BccMessage;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Coord;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Perception;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.exceptions.CommunicationException;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.exceptions.EnvironmentException;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.result.ActionResult;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.physics.ActionExecutor;

public interface Environment<M extends Ambient, A extends Actor, B extends Body> {
    public abstract M getAmbient();

    public abstract long getCycleNumber();

    public abstract void resetCycleNumber();

    public abstract void incrementCycleNumber();

    public Map<String, A> getActors();

    public abstract List<A> getActorsList();

    public abstract List<String> getActorsIDs();

    public abstract List<String> getActorsProgressiveIDs();

    public abstract Optional<A> getActorByID(String id);

    public default void removeActorByID(String id) {
        this.getAmbient().removeActorByID(id);
    }

    public abstract void addActor(A actor, Coord coordinates);

    public Map<String, B> getPassiveBodies();

    public abstract List<B> getPassiveBodiesList();

    public abstract List<String> getPassiveBodiesIDs();

    public abstract List<String> getPassiveBodiesProgressiveIDs();

    public abstract Optional<B> getPassiveBodyByID(String id);

    public default void removePassiveBodyByID(String id) {
        this.getAmbient().removePassiveBodyByID(id);
    }

    public abstract void addPassiveBody(B body, Coord coordinates);

    public default void evolve() {
        if (this.getCycleNumber() == 0) {
            this.forceInitialPerceptionToActors();
        }

        this.executeCycleActions();
        this.incrementCycleNumber();
    }

    public abstract void forceInitialPerceptionToActors();

    public abstract Perception generatePerceptionForActor(String actorID, ActionResult result);

    public default void sendMessageToRecipients(String senderID, Serializable content, List<String> recipientsIDs, boolean checkSenderId) {
        // The validation (among other things) removes the sender and the unknown recipients from the recipients list.
        List<String> processedRecipients = this.validateCommunication(senderID, recipientsIDs, checkSenderId);

        for (String recipientID : processedRecipients) {
            BccMessage message = new BccMessage(content, senderID, recipientID);

            // The recipient is guaranteed to be an actor in the environment.
            this.getActorByID(recipientID).orElseThrow().getListeningSensor().ifPresent(sensor -> sensor.sink(message));
        }
    }

    public default List<String> validateCommunication(String senderID, List<String> recipientsIDs, boolean checkSenderId) {
        if (checkSenderId && !this.getActorsIDs().contains(senderID)) {
            throw new CommunicationException("The sender ID has been spoofed, and that is not allowed.");
        }

        if (recipientsIDs == null) {
            throw new CommunicationException("The list of recipients IDs is null.");
        }

        if (recipientsIDs.isEmpty()) {  // An empty list of recipients is treated as a broadcast.
            return this.getActorsIDs().stream().filter(id -> !id.equals(senderID)).collect(Collectors.toList());
        }
        else {  // We ignore all the IDs that do not match the ID of any actor in the environment.
            return this.getActorsIDs().stream().filter(id -> recipientsIDs.contains(id) && !id.equals(senderID)).collect(Collectors.toList());
        }
    }

    public default void sendPerceptionToActor(String actorID, Perception perception) {
        if (!this.getActorsIDs().contains(actorID)) {
            throw new EnvironmentException("The actor ID does not match the ID of any actor in this environment.");
        }

        this.getActorByID(actorID).orElseThrow().getSensorFor(perception.getClass()).ifPresent(sensor -> sensor.sink(perception));
    }

    public default void executeCycleActions() {
        for (A actor: this.getActorsList()) {
            actor.cycle();

            Iterable<Action> actions = actor.getPendingActions();

            this.validateActorActionsForThisCycle(actions);

            actions.forEach(this::executeAction);
        }
    }

    public abstract void validateActorActionsForThisCycle(Iterable<Action> actions);

    public default void executeAction(Action action) {
        Optional<ActionExecutor> executor = this.getExecutorFor(action);
    
        if (!executor.isPresent()) {
            throw new EnvironmentException("No executor found for action " + action + ".");
        }
        else {
            ActionResult result = executor.get().execute();
            Perception perception = this.generatePerceptionForActor(action.getActorID(), result);

            this.sendPerceptionToActor(action.getActorID(), perception);
        }
    }

    public abstract Optional<ActionExecutor> getExecutorFor(Action action);

    public default JSONObject toJSON() {
        return this.getAmbient().toJSON();
    }
}
