package org.pulsar.simulation.action;

import org.pulsar.simulation.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Entity;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.Rock;

import java.util.Random;

public class RockGeneratorAction implements Action {

    private final FieldMap map;
    private final Ratio ratio;
    private final Random random = new Random();

    private static final Entity ENTITY = new Rock();
    private static final Ratio DEFAULT_ROCK_RATIO = new Ratio(0.075, 0.125);

    public RockGeneratorAction(FieldMap map) {
        this(map, DEFAULT_ROCK_RATIO);
    }

    public RockGeneratorAction(FieldMap map, Ratio ratio) {
        this.map = map;
        this.ratio = ratio;
    }

    @Override
    public void perform() {
        int totalCells = map.getArea();
        int totalEntities = (int) (totalCells * ratio.getInRange());

        for (int i = 0; i < totalEntities; i++) {
            // TODO - handle the exception
            Coordinates randomCoordinates = map.getRandomAvailableCoordinates();
            map.set(randomCoordinates, ENTITY);
        }
    }
}
