import exception.DuplicateModelNameException;
import exception.NoSuchModelNameException;
import pattern.chain.*;
import pattern.command.ColumnPrintCommand;
import pattern.factory.MotoFactory;
import pattern.strategy.*;
import pattern.visitor.*;
import transport.Auto;
import transport.Transport;
import transport.TransportMethods;
import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Auto auto = (Auto) TransportMethods.createInstance("Lada", 4);
        TransportMethods.setTransportFactory(new MotoFactory());
        Transport moto = TransportMethods.createInstance("Yamaha",2);

        System.out.println("---1. Chain of Responsibility---");
        try {
            TransportPrinter inlineWriter = new InlineTransportPrinter();
            inlineWriter.setNext(new ColumnTransportPrinter());

            inlineWriter.print(auto, "chain_auto.txt");
            System.out.println("chain_auto.txt записан");
            inlineWriter.print(moto, "chain_moto.txt");
            System.out.println("chain_moto.txt записан");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n---2. Command---");
        try {
            auto.print("command_auto_inline.txt");
            System.out.println("command_auto_inline.txt записан");

            auto.setPrintCommand(new ColumnPrintCommand());
            auto.print("command_auto_column.txt");
            System.out.println("command_auto_column.txt записан");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n---3. Iterator---");
        System.out.println("Модели авто:");
        for (Auto.Model model : auto) {
            System.out.println(model);
        }

        System.out.println("\n---4. Memento---");
        System.out.println("Исходное состояние:");
        System.out.println(auto);
        try {
            auto.createMemento();
            System.out.println("Состояние сохранено");

            auto.setModelName("Lada2", "NewLada2");
            auto.setPriceModelByName("Lada3", 12345.6);
            System.out.println("\nAuto изменено");
            System.out.println(auto);

            auto = Auto.setMemento();
            System.out.println("\nПосле восстановления:");
            System.out.println(auto);
        } catch (IOException| DuplicateModelNameException | NoSuchModelNameException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\n---7. Strategy---");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("strategy_array"))) {
            oos.writeObject(new int[]{2, 4, 5, 5, 2, 3, 1, 2, 2, 5, 3, 1, 4, 2, 4});
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (args.length < 1) {
            System.err.println("Укажите имя входного файла как параметр командной строки");
        } else {
            String filename = args[0];
            int[] array;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                array = (int[]) ois.readObject();

                CountContext countContext = new CountContext();
                Map<Integer, Integer> freqWithHashMap = countContext.executeStrategy(array);
                System.out.println("Стратегия с HashMap:");
                System.out.println(freqWithHashMap);

                countContext.setStrategy(new StreamCountStrategy());
                Map<Integer, Integer> freqWithStream = countContext.executeStrategy(array);
                System.out.println("Стратегия с Stream:");
                System.out.println(freqWithStream);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n---9. Visitor---");
        Visitor visitor = new PrintVisitor();
        System.out.println("Автомобили:");
        auto.accept(visitor);
        System.out.println("Мотоциклы:");
        moto.accept(visitor);
    }
}