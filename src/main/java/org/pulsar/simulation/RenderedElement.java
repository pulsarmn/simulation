package org.pulsar.simulation;

import java.util.Objects;

public record RenderedElement(int x, int y, String texture) {

    @Override
    public int hashCode() {
        return Objects.hash(x, y, texture);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        RenderedElement element = (RenderedElement) o;
        return element.x() == x && element.y() == y && element.texture().equals(texture);
    }
}
