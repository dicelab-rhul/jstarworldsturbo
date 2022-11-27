package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import java.util.List;
import java.util.Optional;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;

public interface Actuator {
    public abstract List<Class<? extends Action>> getSubscribedEventClasses();

    public abstract void subscribeToEventClass(Class<? extends Action> eventClass);

    public abstract void unsubscribeFromEventClass(Class<? extends Action> eventClass);

    public default boolean isSubscribedTo(Class<? extends Action> eventClass) {
        return this.getSubscribedEventClasses().contains(eventClass);
    }

    public abstract void sink(Action action);

    public default void sinkAll(Iterable<Action> actions) {
        actions.forEach(this::sink);
    }

    public abstract boolean hasPendingActions();

    public abstract Optional<Action> source();

    public abstract Iterable<Action> sourceAll();
}
