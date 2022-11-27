package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

public interface Observation extends Perception {
    public abstract String getObserverID();

    public abstract Observation mergeWithPreviousObservations(Iterable<Observation> previousObservations);

    public abstract Observation mergeWithSubsequentObservations(Iterable<Observation> subsequentObservations);
}
