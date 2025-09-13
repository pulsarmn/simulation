package org.pulsar.simulation.strategy;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.entity.Creature;
import org.pulsar.simulation.model.entity.Entity;
import org.pulsar.simulation.model.entity.Herbivore;
import org.pulsar.simulation.model.entity.Predator;

public class PredatorMoveStrategy extends AbstractMoveStrategy<Herbivore> {

    public PredatorMoveStrategy(FieldMap fieldMap) {
        super(fieldMap);
    }

    @Override
    protected boolean isTarget(Entity entity) {
        return entity instanceof Herbivore;
    }

    @Override
    protected boolean handleTargetInteraction(Creature creature, Herbivore targetEntity) {
        Predator predator = (Predator) creature;

        targetEntity.getHealth().takeDamage(predator.getAttackPower());
        predator.getHealth().increase(predator.getAttackPower().amount());

        if (targetEntity.isDead()) {
            getFieldMap().set(targetEntity.getCoordinates(), null);
        }

        return false;
    }
}
