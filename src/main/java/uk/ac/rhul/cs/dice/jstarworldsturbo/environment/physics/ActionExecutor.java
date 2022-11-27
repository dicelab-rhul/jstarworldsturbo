package uk.ac.rhul.cs.dice.jstarworldsturbo.environment.physics;

import java.util.List;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.result.ActionOutcome;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.result.ActionResult;
import uk.ac.rhul.cs.dice.jstarworldsturbo.environment.Environment;

public interface ActionExecutor {
    public default ActionResult execute(Action action, Environment environment) {
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

    public abstract boolean isPossible(Action action, Environment environment);

    public abstract ActionResult attempt(Action action, Environment environment);

    public boolean succeeded(Action action, Environment environment);

    public ActionResult createImpossibleResult(Action action, Environment environment);

    public ActionResult createSucceededResult(Action action, Environment environment);

    public ActionResult createFailedResult(Action action, Environment environment);
}
