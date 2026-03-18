package transport;

import pattern.factory.AutoFactory;
import pattern.factory.TransportFactory;

public class TransportMethods {
    private static TransportFactory factory = new AutoFactory();

    public static void setTransportFactory(TransportFactory transportFactory) {
        factory = transportFactory;
    }

    public static Transport createInstance(String mark, int size){
        return factory.createInstance(mark, size);
    }

    public static Transport synchronizedTransport(Transport transport) {
        return new SynchronizedTransport(transport);
    }

    // метод, возвращающий среднее арифметическое цен моделей
    public static double getArithmeticMean(Transport transport) {
        double sum = 0;
        double[] price = transport.getPricesOfAllModels();
        for (int i = 0; i < transport.getSize(); i++)
            sum += price[i];
        return sum/price.length;
    }

    // метод, обеспечивающий вывод на экран всех моделей
    public static void printNames(Transport transport) {
        String[] names = transport.getNamesOfAllModels();
        for (int i = 0; i < transport.getSize(); i++)
            System.out.println(names[i]);
    }

    // метод, обеспечивающий вывод на экран всех цен на модели
    public static void printPrices(Transport transport) {
        double[] prices = transport.getPricesOfAllModels();
        for (int i = 0; i < transport.getSize(); i++)
            System.out.println(prices[i]);
    }
}
