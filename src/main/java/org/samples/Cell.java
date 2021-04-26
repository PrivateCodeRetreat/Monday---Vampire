package org.samples;

public class Cell {
    public int age;
    private boolean vampire;

    public Cell(boolean isVampire) {
        vampire = isVampire;
    }

    public Cell() {
        this(false);
    }

    public void advanceAge() {
        age ++;
        if (100 < age) {
            setVampire();
        }
    }

    public boolean isVampire() {
        return vampire;
    }

    public void setVampire() {
        vampire = true;
    }
}
