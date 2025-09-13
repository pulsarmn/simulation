package org.pulsar.simulation.strategy;

import org.pulsar.simulation.model.entity.Creature;

public interface MoveStrategy {

    void move(Creature creature);
}
