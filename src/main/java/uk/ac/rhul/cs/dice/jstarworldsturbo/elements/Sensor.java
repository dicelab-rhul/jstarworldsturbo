package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import java.util.List;
import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Perception;

public interface Sensor {
    public abstract List<Class<? extends Perception>> getSubscribedEventClasses();

    public abstract void subscribeToEventClass(Class<? extends Perception> eventClass);

    public abstract void unsubscribeFromEventClass(Class<? extends Perception> eventClass);

    public default boolean isSubscribedTo(Class<? extends Perception> eventClass) {
        return this.getSubscribedEventClasses().contains(eventClass);
    }

    public abstract void sink(Perception perception);

    public default void sinkAll(Iterable<Perception> perceptions) {
        perceptions.forEach(this::sink);
    }

    public abstract boolean hasPerceptionAvailable();

    public abstract Optional<Perception> source();

    public abstract Iterable<Perception> sourceAll();
}
