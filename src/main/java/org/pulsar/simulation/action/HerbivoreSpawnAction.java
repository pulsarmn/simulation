package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Health;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Herbivore;
import org.pulsar.simulation.strategy.HerbivoreMoveStrategy;
import org.pulsar.simulation.strategy.MoveStrategy;
import org.pulsar.simulation.util.RandomUtil;

import java.util.List;

public class HerbivoreSpawnAction extends AbstractSpawnAction<Herbivore> {

    private final MoveStrategy moveStrategy;

    private static final int MIN_THRESHOLD = 2;
    private static final Ratio DEFAULT_RATIO = new Ratio(0.075, 0.1);

    public HerbivoreSpawnAction(FieldMap fieldMap) {
        this(fieldMap, DEFAULT_RATIO);
    }

    public HerbivoreSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap, ratio);
        this.moveStrategy = new HerbivoreMoveStrategy(fieldMap);
    }

    // Repeating code, I'm Lazy :(
    @Override
    public void perform() {
        List<Herbivore> herbivores = getFieldMap().getAllByType(Herbivore.class);

        if (herbivores.isEmpty()) {
            super.perform();
            return;
        }

        int accessibleObjects = countAccessibleObjects(herbivores);
        if (accessibleObjects < MIN_THRESHOLD) {
            super.perform();
        }
    }

    private int countAccessibleObjects(List<Herbivore> herbivores) {
        int count = 0;
        for (var grass : herbivores) {
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
    public Herbivore createEntity(Coordinates coordinates) {
        Health health = new Health(RandomUtil.getInRange(50, 100));
        return new Herbivore(coordinates, health, moveStrategy);
    }
}
