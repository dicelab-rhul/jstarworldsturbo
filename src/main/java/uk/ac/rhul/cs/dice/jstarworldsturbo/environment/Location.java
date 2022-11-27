package uk.ac.rhul.cs.dice.jstarworldsturbo.environment;

import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Coord;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance.ActorAppearance;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance.BodyAppearance;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance.LocationAppearance;

public interface Location {
    public abstract Coord getCoordinates();

    public abstract LocationAppearance getAppearance();

    public abstract Optional<ActorAppearance> getActorAppearance();

    public abstract Optional<BodyAppearance> getPassiveBodyAppearance();
}
