package io.github.bijeshos.javaexamples.generics.model;

import io.github.bijeshos.javaexamples.generics.model.TwoD;

public class Coordinates<T extends TwoD> {
    public T[] coordinates;

    public Coordinates(T[] coordinates) {
        this.coordinates = coordinates;
    }
}
