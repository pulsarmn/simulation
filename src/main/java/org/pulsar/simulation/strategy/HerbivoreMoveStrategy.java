package org.pulsar.simulation.strategy;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Health;
import org.pulsar.simulation.model.entity.Creature;
import org.pulsar.simulation.model.entity.Entity;
import org.pulsar.simulation.model.entity.Grass;

public class HerbivoreMoveStrategy extends AbstractMoveStrategy<Grass> {

    private static final int DEFAULT_NUMBER_OF_HEALTH_POINTS = 5;

    public HerbivoreMoveStrategy(FieldMap fieldMap) {
        super(fieldMap);
    }

    @Override
    protected boolean isTarget(Entity entity) {
        return entity instanceof Grass;
    }

    @Override
    protected boolean handleTargetInteraction(Creature creature, Grass targetEntity) {
        Health health = creature.getHealth();

        if (health.isEmpty()) {
            getFieldMap().set(creature.getCoordinates(), null);
        } else {
            creature.getHealth().increase(DEFAULT_NUMBER_OF_HEALTH_POINTS);
        }

        return true;
    }
}
