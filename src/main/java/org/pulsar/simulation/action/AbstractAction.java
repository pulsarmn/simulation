package org.pulsar.simulation.action;

import org.pulsar.simulation.FieldMap;
import org.pulsar.simulation.model.Entity;
import org.pulsar.simulation.model.Ratio;

import java.util.Random;

public abstract class AbstractAction implements Action {

    private final FieldMap map;
    private final Ratio ratio;
    private final Random random = new Random(System.currentTimeMillis());

    public AbstractAction(FieldMap map, Ratio ratio) {
        this.map = map;
        this.ratio = ratio;
    }

    public abstract Entity createEntity();
}
