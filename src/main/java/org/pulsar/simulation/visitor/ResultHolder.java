package org.pulsar.simulation.visitor;

import java.util.List;

public interface ResultHolder<T> {

    void add(T o);

    List<T> getResults();

    void clear();
}
