package io.github.bijeshos.javaexamples.generics.model;

import io.github.bijeshos.javaexamples.generics.model.TwoD;

public class ThreeD extends TwoD {
    public int z;

    public ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
