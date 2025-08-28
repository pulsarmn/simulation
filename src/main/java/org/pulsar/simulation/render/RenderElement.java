package org.pulsar.simulation.render;

import org.pulsar.simulation.model.Coordinates;

public record RenderElement(Coordinates coordinates, String texture) {
}
