package io.github.bijeshos.javaexamples.generics;

import io.github.bijeshos.javaexamples.generics.model.Coordinates;
import io.github.bijeshos.javaexamples.generics.model.FourD;
import io.github.bijeshos.javaexamples.generics.model.ThreeD;
import io.github.bijeshos.javaexamples.generics.model.TwoD;

/*
    upper bound format: <? extends SuperClass>
    lower bound format: <? super SubClass>
 */
public class BoundedWildCardDemo {
    public static void main(String[] args) {
        TwoD[] twoD = {new TwoD(0, 1), new TwoD(1, 2), new TwoD(2, 3), new TwoD(3, 4), new TwoD(4, 5), new TwoD(5, 6)};
        ThreeD[] threeD = {new ThreeD(0, 1, 2), new ThreeD(1, 2, 3), new ThreeD(2, 3, 4), new ThreeD(3, 4, 5),
                new ThreeD(4, 5, 6), new ThreeD(5, 6, 7)};
        FourD[] fourD = {new FourD(0, 1, 2, 3), new FourD(1, 2, 3, 4), new FourD(2, 3, 4, 5), new FourD(3, 4, 5, 6),
                new FourD(4, 5, 6, 7), new FourD(5, 6, 7, 8)};
        Coordinates<TwoD> twoDCoordinates = new Coordinates<>(twoD);
        Coordinates<ThreeD> threeDCoordinates = new Coordinates<>(threeD);
        Coordinates<FourD> fourDCoordinates = new Coordinates<>(fourD);
        printXY(twoDCoordinates);
        //printXYZ(twoDCoordinates); //won't compile
        //printAll(twoDCoordinates); //won't compile
        System.out.println("==============================================");
        printXY(threeDCoordinates);
        printXYZ(threeDCoordinates);
        //printAll(threeDCoordinates); //won't compile
        System.out.println("==============================================");
        printXY(fourDCoordinates);
        printXYZ(fourDCoordinates);
        printAll(fourDCoordinates);
        System.out.println("==============================================");
    }

    private static void printXY(Coordinates<?> c) {
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println("x: " + c.coordinates[i].x + ", y: " + c.coordinates[i].y);
        }
        System.out.println("---------------------------------------");
    }

    private static void printXYZ(Coordinates<? extends ThreeD> c) {
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println(
                    "x: " + c.coordinates[i].x + ", y: " + c.coordinates[i].y + ", z: " + c.coordinates[i].z);
        }
        System.out.println("---------------------------------------");
    }

    private static void printAll(Coordinates<? extends FourD> c) {
        for (int i = 0; i < c.coordinates.length; i++) {
            System.out.println(
                    "x: " + c.coordinates[i].x + ", y: " + c.coordinates[i].y + ", z: " + c.coordinates[i].z + ", t: " +
                            c.coordinates[i].t);
        }
        System.out.println("---------------------------------------");
    }
}
