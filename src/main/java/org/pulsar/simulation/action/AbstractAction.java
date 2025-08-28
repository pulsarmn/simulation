package org.pulsar.simulation.action;

import org.pulsar.simulation.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Entity;
import org.pulsar.simulation.model.Ratio;

public abstract class AbstractAction implements Action {

    private final FieldMap map;
    private final Ratio ratio;

    public AbstractAction(FieldMap map, Ratio ratio) {
        this.map = map;
        this.ratio = ratio;
    }

    public abstract Entity createEntity();

    @Override
    public void perform() {
        int totalCells = map.getArea();
        int totalEntities = (int) (totalCells * ratio.getInRange());

        for (int i = 0; i < totalEntities; i++) {
            Coordinates randomCoordinates = map.getRandomAvailableCoordinates();
            Entity newEntity = createEntity();
            map.set(randomCoordinates, newEntity);
        }
    }
}
