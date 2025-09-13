package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.AttackPower;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Health;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Predator;
import org.pulsar.simulation.strategy.PredatorMoveStrategy;
import org.pulsar.simulation.util.RandomUtil;

import java.util.List;

public class PredatorSpawnAction extends AbstractSpawnAction<Predator> {

    private final PredatorMoveStrategy moveStrategy;

    private static final int MIN_THRESHOLD = 2;
    private static final Ratio DEFAULT_RATIO = new Ratio(0.05, 0.07);

    public PredatorSpawnAction(FieldMap fieldMap) {
        this(fieldMap, DEFAULT_RATIO);
    }

    public PredatorSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap, ratio);
        this.moveStrategy = new PredatorMoveStrategy(fieldMap);
    }

    @Override
    public void perform() {
        List<Predator> predators = getFieldMap().getAllByType(Predator.class);

        if (predators.isEmpty()) {
            super.perform();
            return;
        }

        int accessibleObjects = countAccessibleObjects(predators);
        if (accessibleObjects < MIN_THRESHOLD) {
            super.perform();
        }
    }

    private int countAccessibleObjects(List<Predator> predators) {
        int count = 0;
        for (var grass : predators) {
            if (hasFreeNeighbour(grass.getCoordinates())) {
                count++;
            }
        }
        return count;
    }

    private boolean hasFreeNeighbour(Coordinates coordinates) {
        for (var neighbour : getFieldMap().getNeighbours(coordinates)) {
            if (getFieldMap().isCellFree(neighbour)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Predator createEntity(Coordinates coordinates) {
        Health health = new Health(RandomUtil.getInRange(75, 100));
        AttackPower attackPower = new AttackPower(RandomUtil.getInRange(5, 15));
        return new Predator(coordinates, health, attackPower, moveStrategy);
    }
}
