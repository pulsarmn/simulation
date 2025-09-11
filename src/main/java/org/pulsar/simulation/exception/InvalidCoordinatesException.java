package org.pulsar.simulation.exception;

import org.pulsar.simulation.model.Coordinates;

public class InvalidCoordinatesException extends RuntimeException {

    private static final String MESSAGE = "Invalid Coordinates: %s";

    public InvalidCoordinatesException(Coordinates coordinates) {
        super(getMessage(coordinates));
    }

    private static String getMessage(Coordinates coordinates) {
        return MESSAGE.formatted(coordinates);
    }
}
