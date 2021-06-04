package ru.skillbox;

public class Elevator {
    private int maxFloor = 0;
    private int currentFloor = 1;
    private int minFloor = 0;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public void moveDown() {
        if (currentFloor >= minFloor) {
            currentFloor--;
        }
        System.out.println("Этаж " + getCurrentFloor());
    }

    public void moveUp() {
        if (currentFloor <= maxFloor) {
            currentFloor++;
        }
        System.out.println("Этаж " + getCurrentFloor());
    }

    public void move(int floor) {
        if (floor >= minFloor && floor <= maxFloor) {
            while (currentFloor != floor) {
                if(currentFloor <= floor) {
                    moveUp();
                } else {
                    moveDown();
                }
            }
        } else {
            System.out.println("Такого этажа не существует");
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
}