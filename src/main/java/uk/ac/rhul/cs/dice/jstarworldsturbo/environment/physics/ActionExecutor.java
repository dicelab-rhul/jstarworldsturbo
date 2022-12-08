package uk.ac.rhul.cs.dice.jstarworldsturbo.environment.physics;

import java.util.List;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.result.ActionOutcome;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.result.ActionResult;

public interface ActionExecutor {
    public default ActionResult execute() {
        if (!this.isPossible()) {
            return this.createImpossibleResult();
        }
        else {
            ActionResult result = this.attempt();
        
            assert result != null && List.of(ActionOutcome.SUCCESS, ActionOutcome.FAILURE).contains(result.getOutcome());

            if (!this.succeeded()) {
                result.amendOutcome(ActionOutcome.FAILURE);
            }

            return result;
        }
    }

    public abstract boolean isPossible();

    public abstract ActionResult attempt();

    public boolean succeeded();

    public ActionResult createImpossibleResult();

    public ActionResult createSucceededResult();

    public ActionResult createFailedResult();
}
