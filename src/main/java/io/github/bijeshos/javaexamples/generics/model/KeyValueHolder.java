package io.github.bijeshos.javaexamples.generics.model;

public class KeyValueHolder<K, V> {
    private K key;
    private V value;

    public KeyValueHolder(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void printKeyValueTypes() {
        System.out.println("Type of K is: " + key.getClass()
                                                 .getName() + "\nType of V is: " + value.getClass()
                                                                                         .getName());
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}
