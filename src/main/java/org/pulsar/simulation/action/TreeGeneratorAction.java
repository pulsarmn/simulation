package org.pulsar.simulation.action;

import org.pulsar.simulation.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Entity;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.Tree;

import java.util.Random;

public class TreeGeneratorAction implements Action {

    private final FieldMap map;
    private final Ratio ratio;
    private final Random random = new Random(System.currentTimeMillis());

    private static final Entity ENTITY = new Tree();
    private static final Ratio DEFAULT_TREE_RATIO = new Ratio(0.075, 0.125);

    public TreeGeneratorAction(FieldMap map) {
        this(map, DEFAULT_TREE_RATIO);
    }

    public TreeGeneratorAction(FieldMap map, Ratio ratio) {
        this.map = map;
        this.ratio = ratio;
    }

    @Override
    public void perform() {

    }
}
