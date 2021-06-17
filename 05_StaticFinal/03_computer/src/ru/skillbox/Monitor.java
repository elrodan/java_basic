package ru.skillbox;

public class Monitor {
    private final double diagonal;
    private final MonitorType monitorType;
    private final double weight;

    public Monitor(double diagonal, MonitorType monitorType, double weight) {
        this.diagonal = diagonal;
        this.monitorType = monitorType;
        this.weight = weight;
    }

    public Monitor setDiagonal(double diagonal) {
        return new Monitor(diagonal, monitorType, weight);
    }

    public double getDiagonal() {
        return diagonal;
    }

    public MonitorType getMonitorType() {
        return monitorType;
    }

    public Monitor setWeight(double weight) {
        return new Monitor(diagonal, monitorType, weight);
    }

    public double getWeight() {
        return weight;
    }
}
