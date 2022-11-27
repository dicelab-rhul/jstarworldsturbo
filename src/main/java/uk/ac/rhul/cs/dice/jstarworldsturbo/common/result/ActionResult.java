package uk.ac.rhul.cs.dice.jstarworldsturbo.common.result;

public abstract class ActionResult {
    private ActionOutcome outcome;

    protected ActionResult(ActionOutcome outcome) {
        this.outcome = outcome;
    }

    public ActionOutcome getOutcome() {
        return this.outcome;
    }

    public void amendOutcome(ActionOutcome outcome) {
        this.outcome = outcome;
    }
}
