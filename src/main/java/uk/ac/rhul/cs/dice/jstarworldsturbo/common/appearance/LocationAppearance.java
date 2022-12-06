package uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance;

import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Coord;

public interface LocationAppearance<A, B> extends Appearance {
    public abstract Coord getCoordinates();

    public abstract Optional<A> getActorAppearance();

    public abstract Optional<B> getPassiveBodyAppearance();
}
