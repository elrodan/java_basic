package ru.skillbox;

public class CargoInformation {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean isReversive;
    private final String regNumber;
    private final boolean isFragile;

    public CargoInformation(double width, double height, double lenght, double weight, String deliveryAddress, boolean isReversive, String regNumber, boolean isFragile) {
        dimensions = new Dimensions(width, height, lenght);
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.isReversive = isReversive;
        this.regNumber = regNumber;
        this.isFragile = isFragile;
    }

    public CargoInformation setWeight(double weight) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength(), weight, deliveryAddress, isReversive, regNumber, isFragile);
    }

    public double getWeight() {
        return weight;
    }

    public CargoInformation setDeliveryAddress(String deliveryAddress) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength(), weight, deliveryAddress, isReversive, regNumber, isFragile);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public CargoInformation setIsReversive(boolean isReversive) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength(), weight, deliveryAddress, isReversive, regNumber, isFragile);
    }

    public CargoInformation setRegNumber(String regNumber) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength(), weight, deliveryAddress, isReversive, regNumber, isFragile);
    }

    public boolean isReversive() {
        return isReversive;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public CargoInformation setIsFragile(boolean isFragile) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength(), weight, deliveryAddress, isReversive, regNumber, isFragile);
    }

    public boolean isFragile() {
        return isFragile;
    }

    public CargoInformation setWidth(double width) {
        return new CargoInformation(width, dimensions.getHeight(), dimensions.getLength(), weight, deliveryAddress, isReversive, regNumber, isFragile);
    }

    public double getWidth() {
        return dimensions.getWidth();
    }

    public CargoInformation setHeight(double height) {
        return new CargoInformation(dimensions.getWidth(), height, dimensions.getLength(), weight, deliveryAddress, isReversive, regNumber, isFragile);
    }

    public double getHeight() {
        return dimensions.getHeight();
    }

    public CargoInformation setLength(double length) {
        return new CargoInformation(dimensions.getWidth(), dimensions.getHeight(), length, weight, deliveryAddress, isReversive, regNumber, isFragile);
    }

    public double getLenght() {
        return dimensions.getLength();
    }

}
