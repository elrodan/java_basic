package ru.skillbox;

public class RAM {
    private final RAMType ramType;
    private final int volume;
    private final double weight;

    public RAM(RAMType ramType, int volume, double weight) {
        this.ramType = ramType;
        this.volume = volume;
        this.weight = weight;
    }

    public RAMType getRamType() {
        return ramType;
    }

    public RAM setVolume(int volume) {
        return new RAM(ramType, volume, weight);
    }

    public int getVolume() {
        return volume;
    }

    public RAM setWeight(double weight) {
        return new RAM(ramType, volume, weight);
    }

    public double getWeight() {
        return weight;
    }

}
