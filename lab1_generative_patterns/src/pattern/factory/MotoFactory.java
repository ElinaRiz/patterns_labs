package pattern.factory;

import transport.Moto;
import transport.Transport;

public class MotoFactory implements TransportFactory {
    public Transport createInstance(String mark, int size) {
        return new Moto(mark, size);
    }
}