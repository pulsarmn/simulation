package org.pulsar.simulation.action;

import org.pulsar.simulation.map.FieldMap;

public abstract class AbstractAction implements Action {

    private final FieldMap fieldMap;

    public AbstractAction(FieldMap fieldMap) {
        this.fieldMap = fieldMap;
    }

    protected FieldMap getFieldMap() {
        return fieldMap;
    }
}
