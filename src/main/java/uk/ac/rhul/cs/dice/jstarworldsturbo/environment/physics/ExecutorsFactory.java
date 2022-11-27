package uk.ac.rhul.cs.dice.jstarworldsturbo.environment.physics;

import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;

public interface ExecutorsFactory {
    public abstract Optional<ActionExecutor> getExecutorFor(Action action);
}
