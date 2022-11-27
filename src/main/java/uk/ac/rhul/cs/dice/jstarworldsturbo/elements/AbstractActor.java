package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Iterables;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;
import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Perception;

public abstract class AbstractActor extends Body implements Actor {
    private Mind mind;
    private List<Sensor> sensors;
    private List<Actuator> actuators;

    protected AbstractActor(Mind mind, List<Sensor> sensors, List<Actuator> actuators) {
        super();

        this.mind = mind;
        this.sensors = sensors == null ? new ArrayList<>() : sensors;
        this.actuators = actuators == null ? new ArrayList<>() : actuators;
    }

    @Override
    public Mind getMind() {
        return this.mind;
    }

    @Override
    public List<Sensor> getSensors() {
        return this.sensors;
    }

    @Override
    public Optional<Sensor> getSensorFor(Class<? extends Perception> perceptionClass) {
        return this.sensors.stream().filter(sensor -> sensor.isSubscribedTo(perceptionClass)).findFirst();
    }

    @Override
    public List<Actuator> getActuators() {
        return this.actuators;
    }

    @Override
    public Optional<Actuator> getActuatorFor(Class<? extends Action> actionClass) {
        return this.actuators.stream().filter(actuator -> actuator.isSubscribedTo(actionClass)).findFirst();
    }

    @Override
    public Iterable<Action> getPendingActions() {
        return Iterables.concat(this.actuators.stream().map(Actuator::sourceAll).collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AbstractActor other = (AbstractActor) obj;

        return super.equals(other) && this.mind.equals(other.mind) && this.sensors.equals(other.sensors) && this.actuators.equals(other.actuators);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.mind.hashCode() + this.sensors.hashCode() + this.actuators.hashCode();
    }
}
