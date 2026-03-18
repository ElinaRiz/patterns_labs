package transport;

import exception.DuplicateModelNameException;
import exception.NoSuchModelNameException;

public class SynchronizedTransport implements Transport {
    private Transport transport;

    public SynchronizedTransport(Transport transport) {
        this.transport = transport;
    }

    public synchronized String getMark() {
        return transport.getMark();
    }

    public synchronized void setMark(String mark) {
        transport.setMark(mark);
    }

    public synchronized void setModelName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException{
        transport.setModelName(name, newName);
    }

    public synchronized String[] getNamesOfAllModels() {
        return transport.getNamesOfAllModels();
    }

    public synchronized double getPriceModelByName(String name) throws NoSuchModelNameException {
        return transport.getPriceModelByName(name);
    }

    public synchronized void setPriceModelByName(String name, double newPrice) throws NoSuchModelNameException {
        transport.setPriceModelByName(name, newPrice);
    }

    public synchronized double[] getPricesOfAllModels() {
        return transport.getPricesOfAllModels();
    }

    public synchronized void addNewModelNamePrice(String newName, double newPrice) throws DuplicateModelNameException {
        transport.addNewModelNamePrice(newName, newPrice);
    }

    public synchronized void deleteModelByName(String name) throws NoSuchModelNameException {
        transport.deleteModelByName(name);
    }

    public synchronized int getSize() {
        return transport.getSize();
    }
}