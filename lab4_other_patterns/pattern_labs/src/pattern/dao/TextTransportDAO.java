package pattern.dao;

import exception.DuplicateModelNameException;
import pattern.factory.AutoFactory;
import pattern.factory.MotoFactory;
import transport.Transport;
import transport.TransportMethods;

import java.io.*;

public class TextTransportDAO implements TransportDAO {
    public Transport readTransport(String filename) throws IOException, ClassNotFoundException, DuplicateModelNameException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String type = reader.readLine();
            String mark = reader.readLine();
            switch (type) {
                case "transport.Auto":
                    TransportMethods.setTransportFactory(new AutoFactory());
                    break;
                case "transport.Moto":
                    TransportMethods.setTransportFactory(new MotoFactory());
                    break;
                default:
                    throw new ClassNotFoundException("Неизвестный вид транспорта: " + type);
            }
            Transport transport = TransportMethods.createInstance(mark, 0);

            int size = Integer.parseInt(reader.readLine());
            String name;
            double price;
            for (int i = 0; i < size; i++) {
                name = reader.readLine();
                price = Double.parseDouble(reader.readLine());
                transport.addNewModelNamePrice(name, price);
            }
            return transport;
        }
    }

    public void writeTransport(Transport transport, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(transport.getClass().getName());
            writer.println(transport.getMark());
            writer.println(transport.getSize());
            String[] names = transport.getNamesOfAllModels();
            double[] prices = transport.getPricesOfAllModels();
            for (int i = 0; i < transport.getSize(); i++) {
                writer.println(names[i]);
                writer.println(prices[i]);
            }
            writer.flush();
        }
    }
}