package ru.skillbox;

public class Computer {
    private final CPU cpu;
    private final RAM ram;
    private final HardDrive hardDrive;
    private final Monitor monitor;
    private final Keyboard keyboard;
    private final String vendor;
    private final String name;

    public Computer(CPU cpu, RAM ram, HardDrive hardDrive, Monitor monitor, Keyboard keyboard, String vendor, String name) {
        this.cpu = cpu;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.name = name;
    }



    public String getTotalWeight() {
        return (cpu.getWeight() + ram.getWeight() + hardDrive.getWeight() + monitor.getWeight() + keyboard.getWeight()) + " грамм";
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Ваш компьютер:\n\n" +
               "Процессор: \n" +
               "Частота: " + cpu.getFrequency() + " MHz" +
               "\nКоличество ядер - " + cpu.getNumberOfCOre() +
               "\nПроизводитель: " + cpu.getCpuManufactured() +
               "\n\nОперативная память:" +
               "\nТип - " + ram.getRamType()  +
               "\nОбъем: " + ram.getVolume() + " Mbyte" +
               "\n\nНакопитель:" +
               "\nТип - " + hardDrive.getHardDriveType() +
               "\nОбъем памяти: " + hardDrive.getVolume()  + " GB" +
               "\n\nЭкран:" +
               "\nДиагональ: " + monitor.getDiagonal() + " дюймов" +
               "\nТип - " + monitor.getMonitorType()  +
               "\n\nКлавиатура:" +
               "\nТип - " + keyboard.getKeyboardType() +
               "\nНаличие подсветки: " + (keyboard.isBacklight() == true ? "Да" : "Нет");
    }

}
