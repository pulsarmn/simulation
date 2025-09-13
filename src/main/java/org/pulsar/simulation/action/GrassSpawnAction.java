package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Grass;

import java.util.List;

public class GrassSpawnAction extends AbstractSpawnAction<Grass> {

    private static final int MIN_THRESHOLD = 2;
    private static final Ratio DEFAULT_RATIO = new Ratio(0.075, 0.125);

    public GrassSpawnAction(FieldMap fieldMap) {
        this(fieldMap, DEFAULT_RATIO);
    }

    public GrassSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap, ratio);
    }

    // Repeating code, I'm Lazy :(
    @Override
    public void perform() {
        List<Grass> grasses = getFieldMap().getAllByType(Grass.class);

        if (grasses.isEmpty()) {
            super.perform();
            return;
        }

        int accessibleObjects = countAccessibleObjects(grasses);
        if (accessibleObjects < MIN_THRESHOLD) {
            super.perform();
        }
    }

    private int countAccessibleObjects(List<Grass> grasses) {
        int count = 0;
        for (var grass : grasses) {
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
    public Grass createEntity(Coordinates coordinates) {
        return new Grass(coordinates);
    }
}
