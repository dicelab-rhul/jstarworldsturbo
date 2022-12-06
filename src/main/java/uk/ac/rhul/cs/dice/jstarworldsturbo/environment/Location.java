package uk.ac.rhul.cs.dice.jstarworldsturbo.environment;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Appearing;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Coord;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance.LocationAppearance;

public interface Location<A, B> extends Appearing<LocationAppearance<A, B>> {
    public abstract Coord getCoordinates();

    public abstract LocationAppearance<A, B> getAppearance();
}
