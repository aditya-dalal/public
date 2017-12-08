package designPatternsNew.creational.builder;

/**
 * Created by aditya.dalal on 19/01/17.
 */
public class Computer {

    private String ram;
    private String cores;
    private boolean isGrapgicCardEnabled;
    private boolean isUSBEnabled;

    private Computer(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.cores = builder.cores;
        this.isGrapgicCardEnabled = builder.isGrapgicCardEnabled;
        this.isUSBEnabled = builder.isUSBEnabled;
    }

    @Override
    public String toString() {
        return "RAM: " + ram + ", CORES: " + cores + ", GraphicCard: " + isGrapgicCardEnabled + ", USB: " + isUSBEnabled;
    }

    public static class ComputerBuilder {
        private String ram;
        private String cores;
        private boolean isGrapgicCardEnabled;
        private boolean isUSBEnabled;

        public ComputerBuilder(String ram, String cores) {
            this.ram = ram;
            this.cores = cores;
        }

        public ComputerBuilder setGraphicCardEnabled(boolean state) {
            this.isGrapgicCardEnabled = state;
            return this;
        }

        public ComputerBuilder setUSBEnabled(boolean state) {
            this.isUSBEnabled = state;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
