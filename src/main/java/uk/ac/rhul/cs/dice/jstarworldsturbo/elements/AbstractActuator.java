package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Action;

public abstract class AbstractActuator implements Actuator {
    private List<Class<? extends Action>> subscribedEventClasses;
    private Queue<Action> actionBuffer;

    protected AbstractActuator(List<Class<? extends Action>> subscribedEventClasses) {
        this.subscribedEventClasses = subscribedEventClasses == null ? new ArrayList<>() : subscribedEventClasses;
        this.actionBuffer = new ConcurrentLinkedQueue<>();
    }

    @Override
    public List<Class<? extends Action>> getSubscribedEventClasses() {
        return this.subscribedEventClasses;
    }

    @Override
    public void subscribeToEventClass(Class<? extends Action> eventClass) {
        if (!this.subscribedEventClasses.contains(eventClass)) {
            this.subscribedEventClasses.add(eventClass);
        }
    }

    @Override
    public void unsubscribeFromEventClass(Class<? extends Action> eventClass) {
        this.subscribedEventClasses.remove(eventClass);
    }

    @Override
    public void sink(Action action) {
        if (this.isSubscribedTo(action.getClass())) {
            this.actionBuffer.add(action);
        }
    }

    @Override
    public boolean hasPendingActions() {
        return !this.actionBuffer.isEmpty();
    }

    @Override
    public Optional<Action> source() {
        if (this.hasPendingActions()) {
            return Optional.of(this.actionBuffer.poll());
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Iterable<Action> sourceAll() {
        return () -> this.actionBuffer.stream().iterator();
    }
}
