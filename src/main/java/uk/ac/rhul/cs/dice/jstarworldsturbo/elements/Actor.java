package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import java.util.List;
import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.BccMessage;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Identifiable;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Perception;

public interface Actor extends Identifiable {
    public abstract Mind getMind();

    public List<Sensor> getSensors();

    public abstract Optional<Sensor> getSensorFor(Class<? extends Perception> perceptionClass);

    public default Optional<Sensor> getListeningSensor() {
        return this.getSensorFor(BccMessage.class);
    }

    public List<Actuator> getActuators();

    public abstract Optional<Actuator> getActuatorFor(Class<? extends Action> actionClass);

    public abstract void cycle();

    public abstract Iterable<Action> getPendingActions();
}
