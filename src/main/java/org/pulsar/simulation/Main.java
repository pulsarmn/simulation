package org.pulsar.simulation;

import org.pulsar.simulation.launcher.SimulationLauncher;
import org.pulsar.simulation.map.ConsoleFieldMap;
import org.pulsar.simulation.map.FieldMap;

public class Main {

    public static void main(String[] args) {
        FieldMap fieldMap = new ConsoleFieldMap();
        SimulationLauncher launcher = new SimulationLauncher(fieldMap);

        new Thread(launcher::start).start();
    }
}
