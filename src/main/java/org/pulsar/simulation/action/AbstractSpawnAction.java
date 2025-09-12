package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Entity;

public abstract class AbstractSpawnAction<T extends Entity> extends AbstractAction {

    private final Ratio ratio;

    public AbstractSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap);
        this.ratio = ratio;
    }

    @Override
    public void perform() {
        FieldMap fieldMap = getFieldMap();
        int totalEntities = getNumberOfEntities(fieldMap);

        for (int i = 0; i < totalEntities; i++) {
            Coordinates coordinates = fieldMap.getRandomFreeCoordinates(10);
            if (coordinates == null) {
                break;
            }

            fieldMap.set(coordinates, createEntity(coordinates));
        }
    }

    protected abstract T createEntity(Coordinates coordinates);

    private int getNumberOfEntities(FieldMap fieldMap) {
        int totalCells = fieldMap.getWidth() * fieldMap.getHeight();
        return (int) (totalCells * ratio.getInRange());
    }
}
