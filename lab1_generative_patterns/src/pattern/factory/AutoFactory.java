package pattern.factory;

import transport.Auto;
import transport.Transport;

public class AutoFactory implements TransportFactory {
    public Transport createInstance(String mark, int size) {
        return new Auto(mark, size);
    }
}