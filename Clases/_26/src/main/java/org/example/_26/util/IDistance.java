package org.example._26.util;

import org.example._26.model.Position;

@FunctionalInterface
public interface IDistance {
    public double distance(Position from, Position to);
}
