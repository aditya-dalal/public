package designPatternsNew;


/**
 * Created by aditya.dalal on 12/10/17.
 */
public class TempDesignPatterns {

    public static void main(String[] args) {
        Computer pc = new Computer.ComputerBuilder("8", "4").build();
        System.out.println();
    }
}

class Computer {
    private String ram;
    private String cores;
    private boolean hasGraphicsCard;

    private Computer(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.cores = builder.cores;
        this.hasGraphicsCard = builder.hasGraphicsCard;
    }

    public static class ComputerBuilder {
        private String ram;
        private String cores;
        private boolean hasGraphicsCard;

        public ComputerBuilder(String ram, String cores) {
            this.ram = ram;
            this.cores = cores;
        }

        public ComputerBuilder setGraphicsCard(boolean val) {
            hasGraphicsCard = val;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}