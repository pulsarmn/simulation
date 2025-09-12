package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.Ratio;
import org.pulsar.simulation.model.entity.Tree;

public class TreeSpawnAction extends AbstractSpawnAction<Tree> {

    private static final Ratio DEFAULT_RATIO = new Ratio(0.075, 0.11);

    public TreeSpawnAction(FieldMap fieldMap) {
        this(fieldMap, DEFAULT_RATIO);
    }

    public TreeSpawnAction(FieldMap fieldMap, Ratio ratio) {
        super(fieldMap, ratio);
    }

    @Override
    public Tree createEntity(Coordinates coordinates) {
        return new Tree(coordinates);
    }
}
