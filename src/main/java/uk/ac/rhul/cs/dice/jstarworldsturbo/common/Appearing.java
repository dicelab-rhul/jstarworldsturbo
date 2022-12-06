package uk.ac.rhul.cs.dice.jstarworldsturbo.common;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance.Appearance;

public interface Appearing<A extends Appearance> {
    public abstract A getAppearance(); 
}
