package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        CPU coreI5 = new CPU(4100,4, CPUManufactured.INTEL, 20);
        RAM ramOne = new RAM(RAMType.DDR4, 8000, 10);
        HardDrive toshiba = new HardDrive(HardDriveType.HDD, 256, 200);
        Monitor monitorOne = new Monitor(17.3, MonitorType.IPS, 4000);
        Keyboard keyboardOne = new Keyboard(KeyboardType.MEMBRANE, true, 3000);
        Computer MSIGF75 = new Computer(coreI5, ramOne, toshiba, monitorOne, keyboardOne, "MSI", "GF75");

        CPU coreI3 = new CPU(3500,2, CPUManufactured.INTEL, 30);
        RAM ramTwo = new RAM(RAMType.DDR4, 8000, 30);
        HardDrive samsung = new HardDrive(HardDriveType.SSD, 512, 400);
        Monitor monitorTwo = new Monitor(17.3, MonitorType.IPS, 4000);
        Keyboard keyboardTwo = new Keyboard(KeyboardType.MECHANICAL, true, 3000);
        Computer HPPavilion = new Computer(coreI3, ramTwo, samsung, monitorTwo, keyboardTwo, "HP", "Pavilion");

        CPU coreI7 = new CPU(5000,8, CPUManufactured.INTEL, 30);
        RAM ramThree = new RAM(RAMType.DDR4, 16000, 30);
        HardDrive WD = new HardDrive(HardDriveType.HDD, 4000, 450);
        Monitor monitorThree = new Monitor(24, MonitorType.TN, 4000);
        Keyboard keyboardThree = new Keyboard(KeyboardType.MECHANICAL, true, 3000);
        Computer acerNitro = new Computer(coreI7, ramThree, WD, monitorThree, keyboardThree, "Acer", "Nitro");

    }
}
