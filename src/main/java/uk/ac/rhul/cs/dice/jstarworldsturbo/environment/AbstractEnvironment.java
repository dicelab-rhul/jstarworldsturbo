package uk.ac.rhul.cs.dice.jstarworldsturbo.environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;

public abstract class AbstractEnvironment implements Environment {
    private Ambient ambient;
    private Map<String, Actor> actors;
    private Map<String, Body> passiveBodies;
    private long cycleNumber;
    
    protected AbstractEnvironment(Ambient ambient, Map<String, Actor> actors, Map<String, Body> passiveBodies) {
        assert ambient != null;

        this.ambient = ambient;
        this.actors = actors == null ? new HashMap<>() : actors;
        this.passiveBodies = passiveBodies == null ? new HashMap<>() : passiveBodies;
        this.cycleNumber = 0;
    }

    @Override
    public Ambient getAmbient() {
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
    public List<Actor> getActorsList() {
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
    public Optional<Actor> getActorByID(String id) {
        return Optional.ofNullable(this.actors.get(id));
    }

    @Override
    public void removeActorByID(String id) {
        this.actors.remove(id);
    }

    @Override
    public List<Body> getPassiveBodiesList() {
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
    public Optional<Body> getPassiveBodyByID(String id) {
        return Optional.ofNullable(this.passiveBodies.get(id));
    }

    @Override
    public void removePassiveBodyByID(String id) {
        this.passiveBodies.remove(id);
    }
}
