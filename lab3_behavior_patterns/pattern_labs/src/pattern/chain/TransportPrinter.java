package pattern.chain;

import transport.Transport;
import java.io.IOException;

public interface TransportPrinter {
    void print(Transport transport, String filename) throws IOException;
    void setNext(TransportPrinter next);
}