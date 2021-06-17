package ru.skillbox;

public class HardDrive {
    private final HardDriveType hardDriveType;
    private final double volume;
    private final double weight;

    public HardDrive(HardDriveType hardDriveType, double volume, double weight) {
        this.hardDriveType = hardDriveType;
        this.volume = volume;
        this.weight = weight;
    }

    public HardDriveType getHardDriveType() {
        return hardDriveType;
    }

    public HardDrive setVolume(double volume) {
        return new HardDrive(hardDriveType, volume, weight);
    }

    public double getVolume() {
        return volume;
    }

    public HardDrive setWeight(double weight) {
        return new HardDrive(hardDriveType, volume, weight);
    }

    public double getWeight() {
        return weight;
    }

}
