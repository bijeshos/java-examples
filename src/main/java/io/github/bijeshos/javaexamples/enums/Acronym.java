package io.github.bijeshos.javaexamples.enums;

public enum Acronym {
    DTO("Data Transfer Object"),
    VO("Value Object");
    private final String value;

    Acronym(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
