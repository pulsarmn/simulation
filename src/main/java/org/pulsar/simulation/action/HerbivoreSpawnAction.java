package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Health;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Herbivore;
import org.pulsar.simulation.util.RandomUtil;

public class HerbivoreSpawnAction extends AbstractSpawnAction<Herbivore> {

    private static final Ratio DEFAULT_RATIO = new Ratio(0.075, 0.1);

    public HerbivoreSpawnAction(FieldMap fieldMap) {
        this(fieldMap, DEFAULT_RATIO);
    }

    public HerbivoreSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap, ratio);
    }

    @Override
    public Herbivore createEntity(Coordinates coordinates) {
        Health health = new Health(RandomUtil.getInRange(50, 100));
        return new Herbivore(coordinates, health);
    }
}
