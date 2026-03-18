package transport;

import exception.DuplicateModelNameException;
import exception.NoSuchModelNameException;
import pattern.visitor.Visitor;

import java.io.Serializable;

public interface Transport extends Cloneable, Serializable {
    String getMark();
    void setMark(String mark);
    void setModelName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException;
    String[] getNamesOfAllModels();
    double getPriceModelByName(String name) throws NoSuchModelNameException;
    void setPriceModelByName(String name, double newPrice) throws NoSuchModelNameException;
    double[] getPricesOfAllModels();
    void addNewModelNamePrice(String newName, double newPrice) throws DuplicateModelNameException;
    void deleteModelByName(String name) throws NoSuchModelNameException;
    int getSize();

    void accept(Visitor visitor);
}
