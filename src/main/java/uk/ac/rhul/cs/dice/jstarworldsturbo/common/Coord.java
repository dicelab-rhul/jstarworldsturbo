package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

import org.json.JSONObject;

public interface Coord {
    public abstract long getX();

    public abstract long getY();

    public default Coord add(Coord coord) {
        return add(coord.getX(), coord.getY());
    }

    public abstract Coord add(long deltaX, long deltaY);

    public default Coord add(long delta) {
        return add(delta, delta);
    }

    public default Coord sub(Coord coord) {
        return sub(coord.getX(), coord.getY());
    }

    public abstract Coord sub(long deltaX, long deltaY);

    public default Coord sub(long delta) {
        return sub(delta, delta);
    }

    public abstract Coord deepCopy();

    public default JSONObject toJSON() {
        JSONObject json = new JSONObject();

        json.put("x", getX());
        json.put("y", getY());

        return json;
    }
}
