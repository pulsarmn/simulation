package org.pulsar.simulation.action;

import org.pulsar.simulation.FieldMap;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Grass;
import org.pulsar.simulation.model.entity.Entity;

public class GrassGeneratorAction extends AbstractAction {

    private static final Entity ENTITY = new Grass();
    private static final Ratio DEFAULT_GRASS_RATIO = new Ratio(0.1, 0.175);

    public GrassGeneratorAction(FieldMap map) {
        this(map, DEFAULT_GRASS_RATIO);
    }

    public GrassGeneratorAction(FieldMap map, Ratio ratio) {
        super(map, ratio);
    }

    @Override
    public Entity createEntity() {
        return ENTITY;
    }
}
