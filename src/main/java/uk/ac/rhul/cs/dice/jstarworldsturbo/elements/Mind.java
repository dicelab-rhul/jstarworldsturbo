package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.BccMessage;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Observation;

public interface Mind {
    public abstract MindCore getCore();

    public abstract void replaceCore(MindCore newCord);

    public abstract void perceive(Observation observation, Iterable<BccMessage> messages);

    public abstract void revise();

    public abstract void decide();

    public abstract Iterable<Action> execute();
}
