package uk.ac.rhul.cs.dice.jstarworldsturbo.environment.physics;

import java.util.List;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.result.ActionOutcome;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.result.ActionResult;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.Ambient;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.Environment;

public interface ActionExecutor<M extends Ambient, A extends Actor, B extends Body> {
    public default ActionResult execute(Action action, Environment<M, A, B> environment) {
        if (!this.isPossible(action, environment)) {
            return this.createImpossibleResult(action, environment);
        }
        else {
            ActionResult result = this.attempt(action, environment);
        
            assert result != null && List.of(ActionOutcome.SUCCESS, ActionOutcome.FAILURE).contains(result.getOutcome());

            if (!this.succeeded(action, environment)) {
                result.amendOutcome(ActionOutcome.FAILURE);
            }

            return result;
        }
    }

    public abstract boolean isPossible(Action action, Environment<M, A, B> environment);

    public abstract ActionResult attempt(Action action, Environment<M, A, B> environment);

    public boolean succeeded(Action action, Environment<M, A, B> environment);

    public ActionResult createImpossibleResult(Action action, Environment<M, A, B> environment);

    public ActionResult createSucceededResult(Action action, Environment<M, A, B> environment);

    public ActionResult createFailedResult(Action action, Environment<M, A, B> environment);
}
