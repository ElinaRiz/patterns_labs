package pattern.command;

import transport.Auto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class InlinePrintCommand implements PrintCommand {
    public void print(Auto auto, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.print("Марка=" + auto.getMark() + " ");
            writer.print("Размер=" + auto.getSize() + ": ");
            String[] names = auto.getNamesOfAllModels();
            double[] prices = auto.getPricesOfAllModels();
            for (int i = 0; i < auto.getSize(); i++) {
                writer.print(names[i] + " ");
                writer.print(prices[i] + ", ");
            }
            writer.flush();
        }
    }
}
