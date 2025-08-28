package org.pulsar.simulation.action;

import org.pulsar.simulation.FieldMap;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Rock;
import org.pulsar.simulation.model.entity.Entity;

public class RockGeneratorAction extends AbstractAction {

    private static final Entity ENTITY = new Rock();
    private static final Ratio DEFAULT_ROCK_RATIO = new Ratio(0.075, 0.125);

    public RockGeneratorAction(FieldMap map) {
        this(map, DEFAULT_ROCK_RATIO);
    }

    public RockGeneratorAction(FieldMap map, Ratio ratio) {
        super(map, ratio);
    }

    @Override
    public Entity createEntity() {
        return ENTITY;
    }
}
