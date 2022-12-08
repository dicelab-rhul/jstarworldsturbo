package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

import org.json.JSONObject;

/**
 * This interface represents a coordinate in a 2D space.<br/><br/>
 * 
 * The x and y values are represented as longs, so that they can be used to represent coordinates in a very large space.<br/><br/>
 */
public interface Coord {
    /**
     * Returns the x value of this object.
     * 
     * @return the x value of this object.
     */
    public abstract long getX();

    /**
     * Returns the y value of this object.
     * 
     * @return the y value of this object.
     */
    public abstract long getY();

    /**
     * Increments the x value of this object by the given delta.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     * 
     * @param delta the delta to add to this object's x value.
     */
    public abstract void incrementX(long delta);

    /**
     * Increments the y value of this object by the given delta.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     * 
     * @param delta the delta to add to this object's y value.
     */
    public abstract void incrementY(long delta);

    /**
     * Increments the x and y values of this object by the x and y values of the given {@link Coord} object.<br/><br/>
     * 
     * This method is equivalent to {@code incrementX(deltaX)} followed by {@code incrementY(deltaY)}.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     */
    public default void increment(long deltaX, long deltaY) {
        incrementX(deltaX);
        incrementY(deltaY);
    }

    /**
     * Increments the x and y values of this object by the given delta (for both x and y).<br/><br/>
     * 
     * This method is equivalent to {@code increment(delta, delta)}.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     * 
     * @param delta the delta to add to this object (for both x and y).
     */
    public default void increment(long delta) {
        increment(delta, delta);
    }

    /**
     * Increments the x and y values of this object by the x and y values of the given {@link Coord} object.<br/><br/>
     * 
     * This method is equivalent to {@code increment(coord.getX(), coord.getY())}.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     * 
     * @param coord the {@link Coord} object to add to this object.
     */
    public default void increment(Coord coord) {
        increment(coord.getX(), coord.getY());
    }

    /**
     * Returns a new {@link Coord} object whose x and y values are the sum of the x and y values of this object and the x and y values of the given {@link Coord} object.<br/><br/>
     * 
     * This method is equivalent to {@code add(coord.getX(), coord.getY())}.<br/><br/>
     * 
     * This method has no side effects.
     * 
     * @param coord the {@link Coord} object to add to this object.
     * 
     * @return a new {@link Coord} object whose x and y values are the sum of the x and y values of this object and the x and y values of the given {@link Coord} object.
     */
    public default Coord add(Coord coord) {
        return add(coord.getX(), coord.getY());
    }

    /**
     * Returns a new {@link Coord} object whose x and y values are the sum of the x and y values of this object and the given deltas.<br/><br/>
     * 
     * This method has no side effects.
     * 
     * @param deltaX the x delta to add to this object.
     * @param deltaY the y delta to add to this object.
     * 
     * @return a new {@link Coord} object whose x and y values are the sum of the x and y values of this object and the given deltas.
     */
    public abstract Coord add(long deltaX, long deltaY);

    /**
     * Returns a new {@link Coord} object whose x and y values are the sum of the x and y values of this object and the given delta (for both x and y).<br/><br/>
     * 
     * This method is equivalent to {@code add(delta, delta)}.<br/><br/>
     * 
     * This method has no side effects.
     * 
     * @param delta the delta to add to this object (for both x and y).
     * 
     * @return a new {@link Coord} object whose x and y values are the sum of the x and y values of this object and the given delta (for both x and y).
     */
    public default Coord add(long delta) {
        return add(delta, delta);
    }

    /**
     * Decrements the x value of this object by the given delta.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     * 
     * @param delta the delta to subtract from this object's x value.
     */
    public abstract void decrementX(long delta);

    /**
     * Decrements the y value of this object by the given delta.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     * 
     * @param delta the delta to subtract from this object's y value.
     */
    public abstract void decrementY(long delta);

    /**
     * Decrements the x and y values of this object by the x and y values of the given {@link Coord} object.<br/><br/>
     * 
     * This method is equivalent to {@code decrementX(deltaX)} followed by {@code decrementY(deltaY)}.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     */
    public default void decrement(long deltaX, long deltaY) {
        decrementX(deltaX);
        decrementY(deltaY);
    }

    /**
     * Decrements the x and y values of this object by the given delta (for both x and y).<br/><br/>
     * 
     * This method is equivalent to {@code decrement(delta, delta)}.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     * 
     * @param delta the delta to subtract from this object (for both x and y).
     */
    public default void decrement(long delta) {
        decrement(delta, delta);
    }

    /**
     * Decrements the x and y values of this object by the x and y values of the given {@link Coord} object.<br/><br/>
     * 
     * This method is equivalent to {@code decrement(coord.getX(), coord.getY())}.<br/><br/>
     * 
     * The whole purpose of this method is to have side effects.
     * 
     * @param coord the {@link Coord} object to subtract from this object.
     */
    public default void decrement(Coord coord) {
        decrement(coord.getX(), coord.getY());
    }

    /**
     * Returns a new {@link Coord} object whose x and y values are the difference of the x and y values of this object and the x and y values of the given {@link Coord} object.<br/><br/>
     * 
     * This method is equivalent to {@code sub(coord.getX(), coord.getY())}.<br/><br/>
     * 
     * This method has no side effects.
     * 
     * @param coord the {@link Coord} object to subtract from this object.
     * 
     * @return a new {@link Coord} object whose x and y values are the difference of the x and y values of this object and the x and y values of the given {@link Coord} object.
     */
    public default Coord sub(Coord coord) {
        return sub(coord.getX(), coord.getY());
    }

    /**
     * Returns a new {@link Coord} object whose x and y values are the difference of the x and y values of this object and the given deltas.<br/><br/>
     * 
     * This method has no side effects.
     * 
     * @param deltaX the x delta to subtract from this object.
     * @param deltaY the y delta to subtract from this object.
     * 
     * @return a new {@link Coord} object whose x and y values are the difference of the x and y values of this object and the given deltas.
     */
    public abstract Coord sub(long deltaX, long deltaY);

    /**
     * Returns a new {@link Coord} object whose x and y values are the difference of the x and y values of this object and the given delta (for both x and y).<br/><br/>
     * 
     * This method is equivalent to {@code sub(delta, delta)}.<br/><br/>
     * 
     * This method has no side effects.
     * 
     * @param delta the delta to subtract from this object (for both x and y).
     * 
     * @return a new {@link Coord} object whose x and y values are the difference of the x and y values of this object and the given delta (for both x and y).
     */
    public default Coord sub(long delta) {
        return sub(delta, delta);
    }

    /**
     * Returns whether or not this object's x and y values are both non-negative (i.e., >= 0).
     * 
     * @return {@code true} this object's x and y values are both non-negative (i.e., >= 0), {@code false} otherwise.
     */
    public default boolean nonNegative() {
        return getX() >= 0 && getY() >= 0;
    }

    /**
     * Creates and returns a deep copy of this object.
     * 
     * @return a deep copy of this object.
     */
    public abstract Coord deepCopy();

    /**
     * Creates and returns a {@link JSONObject} representation of this object.
     * 
     * @return a {@link JSONObject} representation of this object.
     */
    public default JSONObject toJSON() {
        JSONObject json = new JSONObject();

        json.put("x", getX());
        json.put("y", getY());

        return json;
    }
}
