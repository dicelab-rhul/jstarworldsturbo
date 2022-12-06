package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

public interface Observation extends Perception {
    public abstract String getObserverID();

    public abstract void mergeWithPreviousObservations(Iterable<Observation> previousObservations);

    public abstract void mergeWithSubsequentObservations(Iterable<Observation> subsequentObservations);
}
