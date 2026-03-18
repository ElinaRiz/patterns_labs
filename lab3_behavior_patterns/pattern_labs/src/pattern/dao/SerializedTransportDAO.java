package pattern.dao;

import transport.Transport;
import java.io.*;

public class SerializedTransportDAO implements TransportDAO {
    public Transport readTransport(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Transport) in.readObject();
        }
    }

    public void writeTransport(Transport transport, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(transport);
        }
    }
}