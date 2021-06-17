package ru.skillbox;

public class Keyboard {
    private final KeyboardType keyboardType;
    private final boolean isBacklight;
    private final double weight;

    public Keyboard(KeyboardType keyboardType, boolean isBacklight, double weight) {
        this.keyboardType = keyboardType;
        this.isBacklight = isBacklight;
        this.weight = weight;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public Keyboard setBacklight(boolean isBacklight) {
        return new Keyboard(keyboardType, isBacklight, weight);
    }

    public boolean isBacklight() {
        return isBacklight;
    }

    public Keyboard setWeight(double weight) {
        return new Keyboard(keyboardType, isBacklight, weight);
    }

    public double getWeight() {
        return weight;
    }

}
