package uk.ac.rhul.cs.dice.jstarworldsturbo.common.appearance;

import org.json.JSONObject;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Identifiable;

public interface Appearance extends Identifiable {
    public abstract JSONObject toJSON();
}
