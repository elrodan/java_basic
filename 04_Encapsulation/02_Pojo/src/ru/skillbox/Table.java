package ru.skillbox;

public class Table {

    private int width;
    private int length;
    private int height;
    private int numberOfBoxes;

    public Table(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setNumberOfBoxes(int numberOfBoxes) {
        this.numberOfBoxes = numberOfBoxes;
    }

    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }
}
