package uk.ac.rhul.cs.dice.jstarworldsturbo.environment.physics;

import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.Ambient;

public interface ExecutorsFactory<M extends Ambient, A extends Actor, B extends Body> {
    public abstract Optional<ActionExecutor<M, A, B>> getExecutorFor(Action action);
}
