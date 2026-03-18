import pattern.adapter.StringByteAdapter;
import transport.Transport;
import transport.TransportMethods;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            System.out.println("-----Adapter-----");
            String[] testStrings = {"Adapter", "Decorator", "Facade", "Proxy"};
            System.out.println("Исходные данные: " + Arrays.toString(testStrings));
            File file = new File("File_Byte.txt");
            fos = new FileOutputStream(file);
            StringByteAdapter adapter = new StringByteAdapter(fos);
            adapter.writeStrings(testStrings);

            fis = new FileInputStream(file);
            String[] readStrings = StringByteAdapter.readStrings(fis);
            System.out.println("Прочитанные данные: " + Arrays.toString(readStrings));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fos != null)
                fos.close();
            if (fis != null)
                fis.close();
        }

        System.out.println("\n-----Decorator-----");
        Transport transport = TransportMethods.createInstance("Lada", 5);
        Transport transportSync = TransportMethods.synchronizedTransport(transport);
        TransportMethods.printNames(transportSync);
        TransportMethods.printPrices(transportSync);
    }
}