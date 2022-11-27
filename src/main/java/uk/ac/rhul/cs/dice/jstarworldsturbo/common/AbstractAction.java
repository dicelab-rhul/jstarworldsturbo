package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

public abstract class AbstractAction implements Action {
    private String actorID;

    protected AbstractAction(String actorID) {
        this.actorID = actorID;
    }

    public String getActorID() {
        return this.actorID;
    }

    public void setActorID(String actorID) {
        this.actorID = actorID;
    }
}
