package io.github.bijeshos.javaexamples.generics.model;

public class SimpleHolder<T> {
    private T member;

    public SimpleHolder(T member) {
        this.member = member;
    }

    public T getMember() {
        return member;
    }

    public void printMemberType() {
        System.out.println("Type of member is: " + member.getClass()
                                                   .getName());
    }
}
