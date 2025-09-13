package org.pulsar.simulation.strategy;

import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.model.Coordinates;
import org.pulsar.simulation.model.entity.Creature;
import org.pulsar.simulation.model.entity.Entity;

import java.util.*;

public abstract class AbstractMoveStrategy<T extends Entity> implements MoveStrategy {

    private final FieldMap fieldMap;

    private final Queue<Coordinates> queue = new ArrayDeque<>();
    private final Set<Coordinates> checked = new HashSet<>();
    private final Map<Coordinates, Coordinates> predecessors = new HashMap<>();

    public AbstractMoveStrategy(FieldMap fieldMap) {
        if (fieldMap == null) {
            throw new IllegalArgumentException("FieldMap must not be null");
        }
        this.fieldMap = fieldMap;
    }

    protected FieldMap getFieldMap() {
        return fieldMap;
    }

    @Override
    public void move(Creature creature) {
        if (creature == null) {
            throw new IllegalArgumentException("Entity must not be null");
        }

        Coordinates targetCoordinates = findTarget(creature.getCoordinates());
        if (targetCoordinates != null) {
            List<Coordinates> pathToTarget = restorePath(creature.getCoordinates(), targetCoordinates);
            if (!pathToTarget.isEmpty()) {
                Coordinates nextStep = pathToTarget.getFirst();
                performMove(creature, nextStep);
                return;
            }
        }

        moveToRandomFreeCoordinates(creature);
    }

    public Coordinates findTarget(Coordinates start) {
        clearContext();

        queue.add(start);
        checked.add(start);
        predecessors.put(start, null);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            Entity entityAtCurrent = fieldMap.get(current);

            if (isTarget(entityAtCurrent)) {
                return current;
            }

            if (entityAtCurrent == null || current.equals(start)) {
                addNeighbours(current);
            }
        }

        return null;
    }

    protected abstract boolean isTarget(Entity entity);

    private void addNeighbours(Coordinates coordinates) {
        for (var neighbour : fieldMap.getNeighbours(coordinates)) {
            if (!checked.contains(neighbour)) {
                queue.add(neighbour);
                checked.add(neighbour);
                predecessors.put(neighbour, coordinates);
            }
        }
    }

    private List<Coordinates> restorePath(Coordinates start, Coordinates target) {
        List<Coordinates> path = new ArrayList<>();
        Coordinates current = target;

        while (current != null && !current.equals(start)) {
            path.addFirst(current);
            current = predecessors.get(current);
        }

        return path;
    }

    @SuppressWarnings("unchecked")
    protected void performMove(Creature creature, Coordinates newCoordinates) {
        if (creature == null || newCoordinates == null) {
            throw new IllegalArgumentException("Creature and Coordinates must not be null");
        }
        boolean shouldMove = true;
        Entity entity = fieldMap.get(newCoordinates);

        if (isTarget(entity)) {
            shouldMove = handleTargetInteraction(creature, (T) entity);
        } {
            creature.getHealth().takeDamage(1);
        }

        if (shouldMove && !creature.isDead()) {
            moveCreature(creature, newCoordinates);
        } else if (creature.isDead()) {
            fieldMap.set(creature.getCoordinates(), null);
        }
    }

    protected abstract boolean handleTargetInteraction(Creature entity, T targetEntity);

    private void moveCreature(Creature creature, Coordinates newCoordinates) {
        fieldMap.set(creature.getCoordinates(), null);
        creature.setCoordinates(newCoordinates);
        fieldMap.set(newCoordinates, creature);
    }

    private void moveToRandomFreeCoordinates(Creature creature) {
        List<Coordinates> neighbours = fieldMap.getNeighbours(creature.getCoordinates());
        Collections.shuffle(neighbours);

        for (var neighbour : neighbours) {
            if (fieldMap.isCellFree(neighbour)) {
                performMove(creature, neighbour);
                return;
            }
        }
    }

    private void clearContext() {
        queue.clear();
        checked.clear();
        predecessors.clear();
    }
}
