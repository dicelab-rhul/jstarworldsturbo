package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import java.util.ArrayList;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.BccMessage;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Observation;

public abstract class AbstractMind implements Mind {
    private MindCore core;
    private Observation latestReceivedObservation;
    private Iterable<BccMessage> latestReceivedMessages;
    private Iterable<Action> latestDecidedActions;

    protected AbstractMind(MindCore core) {
        this.core = core;
    }

    @Override
    public MindCore getCore() {
        return this.core;
    }

    @Override
    public void replaceCore(MindCore newCore) {
        this.core = newCore;
    }

    @Override
    public void perceive(Observation observation, Iterable<BccMessage> messages) {
        this.latestReceivedObservation = observation;
        this.latestReceivedMessages = messages == null ? new ArrayList<>() : messages;
    }

    @Override
    public void revise() {
        this.core.revise(this.latestReceivedObservation, this.latestReceivedMessages);
    }

    @Override
    public void decide() {
        this.latestDecidedActions = this.core.decide();
    }

    @Override
    public Iterable<Action> execute() {
        return this.latestDecidedActions;
    }
}
