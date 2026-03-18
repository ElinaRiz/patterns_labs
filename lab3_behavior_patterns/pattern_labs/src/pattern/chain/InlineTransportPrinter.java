package pattern.chain;

import transport.Transport;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InlineTransportPrinter implements TransportPrinter {
    private TransportPrinter next;

    public void print(Transport transport, String filename) throws IOException {
        if (transport.getSize() <= 3) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                writer.print("Вид_транспорта=" + transport.getClass().getName() + " ");
                writer.print("Марка=" + transport.getMark() + " ");
                writer.print("Размер=" + transport.getSize() + ": ");
                String[] names = transport.getNamesOfAllModels();
                double[] prices = transport.getPricesOfAllModels();
                for (int i = 0; i < transport.getSize(); i++) {
                    writer.print(names[i] + " ");
                    writer.print(prices[i] + ", ");
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