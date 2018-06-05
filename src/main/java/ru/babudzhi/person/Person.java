package ru.babudzhi.person;

import java.util.Collection;
import java.util.Iterator;

public class Person implements Collection<Person> {
    private String name1 = "";
    private String name2 = "";
    private String name3 = "";

    public Person getPerson() {
        return this;
    }

    public String getName3() {
        return this.name3;
    }

    public String getName1() {
        return this.name1;
    }

    public String getName2() {
        return this.name2;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public void setPerson(String name1_, String name2_, String name3_) {
        this.name3 = name3_;
        this.name1 = name1_;
        this.name2 = name2_;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Person> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Person> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
