package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Grass;

public class GrassSpawnAction extends AbstractSpawnAction<Grass> {

    private static final Ratio DEFAULT_RATIO = new Ratio(0.075, 0.125);

    public GrassSpawnAction(FieldMap fieldMap) {
        this(fieldMap, DEFAULT_RATIO);
    }

    public GrassSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap, ratio);
    }

    @Override
    public void perform() {
        if (!getFieldMap().getAllByType(Grass.class).isEmpty()) {
            super.perform();
        }
    }

    @Override
    public Grass createEntity(Coordinates coordinates) {
        return new Grass(coordinates);
    }
}
