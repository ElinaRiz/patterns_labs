import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException e) {
            System.out.println("Невозможно прослушать порт: 5000.");
            System.exit(-1);
        }

        Socket clientSocket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            System.out.println("Ожидание обращения клиента...");
            clientSocket = serverSocket.accept();
            System.out.println("Получен запрос от клиента.");
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());
            double num1 = dis.readDouble();
            double num2 = dis.readDouble();
            dos.writeDouble(num1 * num2);
            dos.flush();
            System.out.println("Результат умножения двух вещественных чисел передан.");

        } catch (IOException e) {
            System.out.println("Принять не удалось: 5000.");
            System.exit(-1);
        } finally {
            if (dos != null)
                dos.close();
            if (dis != null)
                dis.close();
            if (clientSocket != null)
                clientSocket.close();
        }
    }
}