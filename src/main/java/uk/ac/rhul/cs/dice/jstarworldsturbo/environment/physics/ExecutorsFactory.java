package uk.ac.rhul.cs.dice.jstarworldsturbo.environment.physics;

import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.Ambient;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.Environment;

public interface ExecutorsFactory<M extends Ambient, A extends Actor, B extends Body, C extends Action, E extends Environment<M, A, B>, X extends ActionExecutor> {
    public abstract Optional<X> getExecutorFor(C action, E env);
}
