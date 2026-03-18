package pattern.chain;

import transport.Transport;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ColumnTransportPrinter implements TransportPrinter {
    private TransportPrinter next;

    public void print(Transport transport, String filename) throws IOException {
        if (transport.getSize() > 3) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                writer.println("Вид транспорта=" + transport.getClass().getName());
                writer.println("Марка=" + transport.getMark());
                writer.println("Размер=" + transport.getSize());
                String[] names = transport.getNamesOfAllModels();
                double[] prices = transport.getPricesOfAllModels();
                for (int i = 0; i < transport.getSize(); i++) {
                    writer.println(names[i]);
                    writer.println(prices[i]);
                }
                writer.flush();
            }
        } else if (next != null) {
            next.print(transport, filename);
        }
    }

    public void setNext(TransportPrinter next) {
        this.next = next;
    }
}
