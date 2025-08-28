package org.pulsar.simulation.visitor;

import java.util.List;
import java.util.ArrayList;

public class SimpleResultHolder<T> implements ResultHolder<T> {

    private final List<T> result = new ArrayList<>();

    @Override
    public void add(T o) {
        // TODO - null check
        result.add(o);
    }

    @Override
    public List<T> getResults() {
        return new ArrayList<>(result);
    }

    @Override
    public void clear() {
        result.clear();
    }
}
