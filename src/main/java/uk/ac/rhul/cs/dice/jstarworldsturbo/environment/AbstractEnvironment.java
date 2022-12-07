package uk.ac.rhul.cs.dice.jstarworldsturbo.environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;

public abstract class AbstractEnvironment<M extends Ambient, A extends Actor, B extends Body> implements Environment<M, A, B> {
    private M ambient;
    private Map<String, A> actors;
    private Map<String, B> passiveBodies;
    private long cycleNumber;
    
    protected AbstractEnvironment(M ambient, Map<String, A> actors, Map<String, B> passiveBodies) {
        assert ambient != null;

        this.ambient = ambient;
        this.actors = actors == null ? new HashMap<>() : actors;
        this.passiveBodies = passiveBodies == null ? new HashMap<>() : passiveBodies;
        this.cycleNumber = 0;
    }

    @Override
    public M getAmbient() {
        return this.ambient;
    }

    @Override
    public long getCycleNumber() {
        return this.cycleNumber;
    }

    @Override
    public void incrementCycleNumber() {
        this.cycleNumber++;
    }

    @Override
    public List<A> getActorsList() {
        return this.actors.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<String> getActorsIDs() {
        return this.actors.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public List<String> getActorsProgressiveIDs() {
        return this.actors.values().stream().map(Actor::getProgressiveID).collect(Collectors.toList());
    }

    @Override
    public Optional<A> getActorByID(String id) {
        return Optional.ofNullable(this.actors.get(id));
    }

    @Override
    public void removeActorByID(String id) {
        this.actors.remove(id);
    }

    @Override
    public List<B> getPassiveBodiesList() {
        return this.passiveBodies.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<String> getPassiveBodiesIDs() {
        return this.passiveBodies.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public List<String> getPassiveBodiesProgressiveIDs() {
        return this.passiveBodies.values().stream().map(Body::getProgressiveID).collect(Collectors.toList());
    }

    @Override
    public Optional<B> getPassiveBodyByID(String id) {
        return Optional.ofNullable(this.passiveBodies.get(id));
    }

    @Override
    public void removePassiveBodyByID(String id) {
        this.passiveBodies.remove(id);
    }
}
