package org.pulsar.simulation.visitor;

import java.util.List;
import java.util.ArrayList;

public class SimpleResultAccumulator<T> implements ResultAccumulator<T> {

    private final List<T> result = new ArrayList<>();

    @Override
    public void add(T o) {
        result.add(o);
    }

    @Override
    public List<T> getResult() {
        return new ArrayList<>(result);
    }

    @Override
    public void clear() {
        result.clear();
    }
}
