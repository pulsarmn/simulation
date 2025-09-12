package org.pulsar.simulation.launcher;

import org.pulsar.simulation.action.*;
import org.pulsar.simulation.map.FieldMap;
import org.pulsar.simulation.render.ConsoleFieldMapRenderer;
import org.pulsar.simulation.render.Renderer;

import java.util.Set;
import java.util.LinkedHashSet;

public class SimulationLauncher {

    private final FieldMap fieldMap;
    private final Renderer renderer;
    private boolean isRunning;

    private final Set<Action> initActions = new LinkedHashSet<>();
    private final Set<Action> actions = new LinkedHashSet<>();

    private static final int CYCLE_DURATION = 1000;

    public SimulationLauncher(FieldMap fieldMap) {
        if (fieldMap == null) {
            throw new IllegalArgumentException("FieldMap must not be null");
        }
        this.fieldMap = fieldMap;
        this.renderer = new ConsoleFieldMapRenderer(fieldMap);

        prepareActions();
        performInitActions();
    }

    private void prepareActions() {
        prepareInitActions();
        actions.add(new MoveAction(fieldMap));
        actions.add(new GrassSpawnAction(fieldMap));
    }

    private void prepareInitActions() {
        initActions.add(new RockSpawnAction(fieldMap));
        initActions.add(new TreeSpawnAction(fieldMap));
        initActions.add(new GrassSpawnAction(fieldMap));
        initActions.add(new HerbivoreSpawnAction(fieldMap));
        initActions.add(new PredatorSpawnAction(fieldMap));
    }

    private void performInitActions() {
        initActions.forEach(Action::perform);
    }

    public void start() {
        isRunning = true;
        while (isRunning) {
            renderer.render();
            sleep(CYCLE_DURATION);
            nextTurn();
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }

    private void nextTurn() {
        actions.forEach(Action::perform);
    }
}
