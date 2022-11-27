package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

public interface Action extends Event {
    public abstract String getActorID();

    public abstract void setActorID(String actorID);
}
