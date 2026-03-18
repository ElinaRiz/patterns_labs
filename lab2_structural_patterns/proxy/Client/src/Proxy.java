import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Proxy {
    private int port;

    public Proxy(int port) {
        this.port = port;
    }

    public double multiply(double num1, double num2) throws IOException{
        double result = 0;
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            socket = new Socket("localhost", port);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            dos.writeDouble(num1);
            dos.writeDouble(num2);
            dos.flush();

            result = dis.readDouble();
        } catch (UnknownHostException e) {
            System.err.println("Неизвестный хост: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Не могу получить ввод/вывод для связи с: localhost.");
            System.exit(1);
        } finally {
            if (dis != null)
                dis.close();
            if (dos != null)
                dos.close();
            if (socket != null)
                socket.close();
        }
        return result;
    }
}
