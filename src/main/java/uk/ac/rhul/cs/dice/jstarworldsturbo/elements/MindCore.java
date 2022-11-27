package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.BccMessage;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Observation;

public interface MindCore {
    public abstract void revise(Observation observation, Iterable<BccMessage> messages);

    public abstract Iterable<Action> decide();
}
