package pattern.command;

import transport.Auto;
import java.io.IOException;

public interface PrintCommand {
    void print(Auto auto, String filename) throws IOException;
}
