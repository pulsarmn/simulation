package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Rock;

public class RockSpawnAction extends AbstractSpawnAction<Rock> {

    private static final Ratio DEFAULT_RATIO = new Ratio(0.075, 0.11);

    public RockSpawnAction(FieldMap fieldMap) {
        this(fieldMap, DEFAULT_RATIO);
    }

    public RockSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap, ratio);
    }

    @Override
    public Rock createEntity(Coordinates coordinates) {
        return new Rock(coordinates);
    }
}
