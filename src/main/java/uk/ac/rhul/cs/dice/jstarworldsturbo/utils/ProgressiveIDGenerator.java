package uk.ac.rhul.cs.dice.jstarworldsturbo.utils;

public class ProgressiveIDGenerator {
    private static ProgressiveIDGenerator instance = null;
    private int id;

    private ProgressiveIDGenerator() {
        this.id = 0;
    }

    public static ProgressiveIDGenerator getInstance() {
        if (ProgressiveIDGenerator.instance == null) {
            ProgressiveIDGenerator.instance = new ProgressiveIDGenerator();
        }

        return ProgressiveIDGenerator.instance;
    }

    public String nextID() {
        return String.valueOf(this.id++);
    }
}
