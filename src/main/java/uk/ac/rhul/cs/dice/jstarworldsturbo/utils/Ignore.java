package uk.ac.rhul.cs.dice.jstarworldsturbo.utils;

public class Ignore {
    private Ignore() {
        throw new IllegalStateException("Utility class");
    }

    public static void ignore(Object... objects) {
        // Do nothing
    }
}
