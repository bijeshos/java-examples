package io.github.bijeshos.javaexamples.generics.model;

import io.github.bijeshos.javaexamples.generics.model.ThreeD;

public class FourD extends ThreeD {
    public int t;

    public FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}
