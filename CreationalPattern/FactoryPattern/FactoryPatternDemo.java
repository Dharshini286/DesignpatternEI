interface Computer {
    void compute();
}

class PersonalComputer implements Computer {
    @Override
    public void compute() {
        System.out.println("Personal Computer is computing");
    }
}

class ServerComputer implements Computer {
    @Override
    public void compute() {
        System.out.println("Server Computer is computing");
    }
}

abstract class ComputerFactory {
    abstract Computer createComputer();
}

class PersonalComputerFactory extends ComputerFactory {
    @Override
    Computer createComputer() {
        return new PersonalComputer();
    }
}

class ServerComputerFactory extends ComputerFactory {
    @Override
    Computer createComputer() {
        return new ServerComputer();
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new PersonalComputerFactory();
        Computer computer = computerFactory.createComputer();
        computer.compute();

        computerFactory = new ServerComputerFactory();
        computer = computerFactory.createComputer();
        computer.compute();
    }
}
