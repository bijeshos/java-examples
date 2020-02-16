package io.github.bijeshos.javaexamples.enums;

public enum SampleSingleton {
    INSTANCE;

    private SampleSingleton() {
    }

    public void performAction() {
        System.out.println("Doing something within Singleton");
    }
}
