package org.pulsar.simulation.action;

import org.pulsar.simulation.FieldMap;
import org.pulsar.simulation.model.Entity;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.Tree;

public class TreeGeneratorAction extends AbstractAction {

    private static final Entity ENTITY = new Tree();
    private static final Ratio DEFAULT_TREE_RATIO = new Ratio(0.075, 0.125);

    public TreeGeneratorAction(FieldMap map) {
        this(map, DEFAULT_TREE_RATIO);
    }

    public TreeGeneratorAction(FieldMap map, Ratio ratio) {
        super(map, ratio);
    }

    @Override
    public Entity createEntity() {
        return ENTITY;
    }
}
