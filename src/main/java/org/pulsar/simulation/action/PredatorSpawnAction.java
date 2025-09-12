package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.AttackPower;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Health;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Predator;
import org.pulsar.simulation.util.RandomUtil;

public class PredatorSpawnAction extends AbstractSpawnAction<Predator> {

    private static final Ratio DEFAULT_RATIO = new Ratio(0.05, 0.07);

    public PredatorSpawnAction(FieldMap fieldMap) {
        this(fieldMap, DEFAULT_RATIO);
    }

    public PredatorSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap, ratio);
    }

    @Override
    public Predator createEntity(Coordinates coordinates) {
        Health health = new Health(RandomUtil.getInRange(75, 100));
        AttackPower attackPower = new AttackPower(RandomUtil.getInRange(5, 15));
        return new Predator(coordinates, health, attackPower);
    }
}
