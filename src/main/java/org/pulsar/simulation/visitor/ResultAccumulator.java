package org.pulsar.simulation.visitor;

import java.util.List;

public interface ResultAccumulator<T> {

    void add(T o);

    List<T> getResult();

    void clear();
}
