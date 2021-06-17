package ru.skillbox;

public class CPU {
    private final int frequency;
    private final int numberOfCOre;
    private final CPUManufactured cpuManufactured;
    private final double weight;

    public CPU(int frequency, int numberOfCOre, CPUManufactured cpuManufactured, double weight) {
        this.frequency = frequency;
        this.numberOfCOre = numberOfCOre;
        this.cpuManufactured = cpuManufactured;
        this.weight = weight;
    }

    public CPU setFrequency(int frequency) {
        return new CPU(frequency, numberOfCOre, cpuManufactured, weight);
    }

    public int getFrequency() {
        return frequency;
    }

    public CPU setNumberOfCore(int numberOfCOre) {
        return new CPU(frequency, numberOfCOre, cpuManufactured, weight);
    }

    public int getNumberOfCOre() {
        return numberOfCOre;
    }

    public CPUManufactured getCpuManufactured() {
        return cpuManufactured;
    }

    public CPU setWeight(double weight) {
        return new CPU(frequency, numberOfCOre, cpuManufactured, weight);
    }

    public double getWeight() {
        return weight;
    }
}
