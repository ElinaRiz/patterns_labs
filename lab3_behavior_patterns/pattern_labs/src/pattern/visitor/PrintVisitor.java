package pattern.visitor;

import transport.Auto;
import transport.Moto;

public class PrintVisitor implements Visitor {
    public void visit(Auto auto) {
        System.out.print("Вид_транспорта=" + auto.getClass().getName() + " ");
        System.out.print("Марка=" + auto.getMark() + " ");
        System.out.print("Размер=" + auto.getSize() + ": ");
        String[] names = auto.getNamesOfAllModels();
        double[] prices = auto.getPricesOfAllModels();
        for (int i = 0; i < auto.getSize(); i++) {
            System.out.print(names[i] + " " + prices[i] + ", ");
        }
        System.out.println();
    }

    public void visit(Moto moto) {
        System.out.println("Вид транспорта=" + moto.getClass().getName());
        System.out.println("Марка=" + moto.getMark());
        System.out.println("Размер=" + moto.getSize());
        String[] names = moto.getNamesOfAllModels();
        double[] prices = moto.getPricesOfAllModels();
        for (int i = 0; i < moto.getSize(); i++) {
            System.out.println(names[i]);
            System.out.println(prices[i]);
        }
    }
}
