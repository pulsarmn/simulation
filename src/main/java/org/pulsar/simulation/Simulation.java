package org.pulsar.simulation;

import org.pulsar.simulation.render.Renderer;

public class Simulation {

    private final FieldMap map;
    private final Renderer renderer;
    private boolean running;

    public Simulation(FieldMap map, Renderer renderer) {
        this.map = map;
        this.renderer = renderer;
    }

    public void startSimulation() {
        running = true;

        while (running) {
            renderer.render();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void pauseSimulation() {
        running = false;
    }

    public void nextTurn() {

    }
}
