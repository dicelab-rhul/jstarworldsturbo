package uk.ac.rhul.cs.dice.jstarworldsturbo.environment;

import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Actor;
import uk.ac.rhul.cs.dice.jstarworldsturbo.elements.Body;

public abstract class AbstractEnvironment<M extends Ambient, A extends Actor, B extends Body> implements Environment<M, A, B> {
    private M ambient;
    private long cycleNumber;
    
    protected AbstractEnvironment(M ambient) {
        assert ambient != null;

        this.ambient = ambient;
        this.cycleNumber = 0;
    }

    @Override
    public M getAmbient() {
        return this.ambient;
    }

    @Override
    public long getCycleNumber() {
        return this.cycleNumber;
    }

    @Override
    public void incrementCycleNumber() {
        this.cycleNumber++;
    }
}
