package pattern.visitor;

import transport.Auto;
import transport.Moto;

public interface Visitor {
    void visit(Auto auto);
    void visit(Moto moto);
}
