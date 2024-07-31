package BuilderPatternExample;
public class BuilderPatternTest {
    public static void main(String[] args) {
        // Use the builder to create different configurations of Computer

        // Create a basic computer
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();
        System.out.println(basicComputer);

        // Create a gaming computer
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setMotherboard("ASUS ROG STRIX")
                .build();
        System.out.println(gamingComputer);

        // Create a workstation computer
        Computer workstationComputer = new Computer.Builder()
                .setCPU("AMD Ryzen 9")
                .setRAM("32GB")
                .setStorage("2TB SSD")
                .setGPU("NVIDIA Quadro RTX 5000")
                .setPowerSupply("850W")
                .setMotherboard("MSI MEG X570")
                .build();
        System.out.println(workstationComputer);
    }
}