package uk.ac.rhul.cs.dice.jstarworldsturbo.environment;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Appearing;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Coord;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance.LocationAppearance;

public interface Location extends Appearing<LocationAppearance> {
    public abstract Coord getCoordinates();

    public abstract LocationAppearance getAppearance();
}
