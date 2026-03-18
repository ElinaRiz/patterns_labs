package pattern.factory;

import transport.Transport;

public interface TransportFactory {
    Transport createInstance(String mark, int size);
}
