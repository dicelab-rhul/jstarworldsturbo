package uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance;

import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Coord;

public interface LocationAppearance extends Appearance {
    public abstract Coord getCoordinates();

    public abstract Optional<ActorAppearance> getActorAppearance();

    public abstract Optional<BodyAppearance> getPassiveBodyAppearance();
}
