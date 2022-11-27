package uk.ac.rhul.cs.dice.jstarworldsturbo.environment;

import org.json.JSONObject;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Coord;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;

public interface Ambient {
    public default void addActor(Actor actor, Coord coordinates) {
        this.addActor(actor, actor.getID(), coordinates);
    }

    public abstract void addActor(Actor actor, String actorID, Coord coordinates);

    public abstract void removeActorByID(String actorID);

    public abstract void moveActorByID(String actorID, Coord newCoordinates);

    public abstract void moveActor(Coord currentCoordinates, Coord newCoordinates);

    public default void addPassiveBody(Body body, Coord coordinates) {
        this.addPassiveBody(body, body.getID(), coordinates);
    }

    public abstract void addPassiveBody(Body body, String bodyID, Coord coordinates);

    public abstract void removePassiveBodyByID(String bodyID);

    public abstract void movePassiveBodyByID(String bodyID, Coord newCoordinates);

    public abstract void movePassiveBody(Coord currentCoordinates, Coord newCoordinates);

    public abstract JSONObject toJSON();
}
