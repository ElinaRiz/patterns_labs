package pattern.dao;

import exception.DuplicateModelNameException;
import transport.Transport;
import java.io.IOException;

public interface TransportDAO {
    Transport readTransport(String filename) throws IOException, ClassNotFoundException, DuplicateModelNameException;
    void writeTransport(Transport transport, String filename) throws IOException;
}
