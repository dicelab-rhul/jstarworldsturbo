package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

import java.util.UUID;

import uk.ac.rhul.cs.dice.jstarworldsturbo.utils.ProgressiveIDGenerator;

public abstract class AbstractIdentifiable implements Identifiable {
    private final String id;
    private final String progressiveID;

    protected AbstractIdentifiable() {
        this.id = UUID.randomUUID().toString();
        this.progressiveID = ProgressiveIDGenerator.getInstance().nextID();
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getProgressiveID() {
        return this.progressiveID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AbstractIdentifiable other = (AbstractIdentifiable) obj;

        // Progressive IDs do not matter for equality.
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        // Progressive IDs do not matter for the hash code.
        return this.id.hashCode();
    }
}
