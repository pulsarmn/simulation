package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.entity.Creature;

public class MoveAction extends AbstractAction {

    public MoveAction(FieldMap fieldMap) {
        super(fieldMap);
    }

    @Override
    public void perform() {
        getFieldMap().getAllByType(Creature.class)
                .forEach(Creature::makeMove);
    }
}
