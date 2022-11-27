package uk.ac.rhul.cs.dice.jstarworldsturbo.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import uk.ac.rhul.cs.dice.jstarworldsturbo.common.Perception;

public abstract class AbstractSensor implements Sensor {
    private List<Class<? extends Perception>> subscribedEventClasses;
    private Queue<Perception> perceptionBuffer;

    protected AbstractSensor(List<Class<? extends Perception>> subscribedEventClasses) {
        this.subscribedEventClasses = subscribedEventClasses == null ? new ArrayList<>() : subscribedEventClasses;
        this.perceptionBuffer = new ConcurrentLinkedQueue<>();
    }

    @Override
    public List<Class<? extends Perception>> getSubscribedEventClasses() {
        return this.subscribedEventClasses;
    }

    @Override
    public void subscribeToEventClass(Class<? extends Perception> event) {
        if (!this.subscribedEventClasses.contains(event)) {
            this.subscribedEventClasses.add(event);
        }
    }

    @Override
    public void unsubscribeFromEventClass(Class<? extends Perception> event) {
        this.subscribedEventClasses.remove(event);
    }

    @Override
    public void sink(Perception perception) {
        if (this.isSubscribedTo(perception.getClass())) {
            this.perceptionBuffer.add(perception);
        }
    }

    @Override
    public boolean hasPerceptionAvailable() {
        return !this.perceptionBuffer.isEmpty();
    }

    @Override
    public Optional<Perception> source() {
        if (this.hasPerceptionAvailable()) {
            return Optional.of(this.perceptionBuffer.poll());
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public Iterable<Perception> sourceAll() {
        return () -> this.perceptionBuffer.stream().iterator();
    }
}
