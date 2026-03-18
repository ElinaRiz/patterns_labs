package transport;

import exception.*;
import pattern.command.InlinePrintCommand;
import pattern.command.PrintCommand;
import pattern.visitor.Visitor;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Auto implements Transport, Iterable<Auto.Model> {
    private String mark;
    private Model[] models;
    private transient PrintCommand printCommand = new InlinePrintCommand();

    public void setPrintCommand(PrintCommand printCommand) {
        this.printCommand = printCommand;
    }

    public void print(String filename) throws IOException {
        printCommand.print(this, filename);
    }

    public Iterator<Model> iterator() {
        return new AutoIterator();
    }

    private class AutoIterator implements Iterator<Model> {
        private int index = 0;

        public boolean hasNext() {
            return index < models.length;
        }

        public Model next() {
            return models[index++];
        }
    }

    public static class Memento {
        private static byte[] state;

        public static void setAuto(Auto auto) throws IOException {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                oos.writeObject(auto);
                state = bos.toByteArray();
            }
        }

        public static Auto getAuto() throws IOException, ClassNotFoundException {
            try (ByteArrayInputStream bis = new ByteArrayInputStream(state);
                 ObjectInputStream ois = new ObjectInputStream(bis)) {
                return (Auto) ois.readObject();
            }
        }
    }

    public void createMemento() throws IOException {
        Memento.setAuto(this);
    }

    public static Auto setMemento() throws IOException, ClassNotFoundException {
        return Memento.getAuto();
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public static class Model implements Cloneable, Serializable {
        private String name;
        private double price;

        public String toString() {
            return name + " " + price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Model clone() {
            Model model = null;
            try {
                model = (Model) super.clone();
                model.name = name;
                model.price = price;
                return model;
            }
            catch (CloneNotSupportedException e) {
                return model;
            }
        }
    }

    // метод для получения марки автомобиля
    public String getMark() {
        return mark;
    }

    // метод для модификации марки автомобиля
    public void setMark(String mark) {
        this.mark = mark;
    }

    public Auto(String mark, int size) {
        this.mark = mark;
        models = new Model[size];
        for (int i = 0; i < size; i++)
            models[i] = new Model(mark + (i + 1), i + 10000);
    }

    // метод для модификации значения названия модели
    public void setModelName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        int index = -1;
        for (int i = 0; i < models.length; i++) {
            if(models[i].getName().equals(newName))
                throw new DuplicateModelNameException("Модель " + newName + " уже существует.");
            if (models[i].getName().equals(name))
                index = i;
        }
        if (index == -1)
            throw new NoSuchModelNameException("Модель " + name + " не найдена.");
        models[index].setName(newName);
    }

    // метод, возвращающий массив названий всех моделей
    public String[] getNamesOfAllModels() {
        String[] allNames = new String[models.length];
        for(int i = 0; i < getSize(); i++)
            allNames[i] = models[i].getName();
        return allNames;
    }

    // метод для получения значения цены модели по ее названию
    public double getPriceModelByName(String name) throws NoSuchModelNameException {
        int i = 0;
        while (i < models.length && !models[i].getName().equals(name)) {
            i++;
        }
        if (i == models.length)
            throw new NoSuchModelNameException("Модель " + name + " не найдена.");
        return models[i].getPrice();
    }

    // метод для модификации цены модели по ее названию
    public void setPriceModelByName(String name, double newPrice) throws NoSuchModelNameException {
        if(newPrice < 0)
            throw new ModelPriceOutOfBoundsException("Цена модели " + name + " меньше 0.");
        int i = 0;
        while (i < models.length && !models[i].getName().equals(name)) {
            i++;
        }
        if (i == models.length)
            throw new NoSuchModelNameException("Модель " + name + " не найдена.");
        models[i].setPrice(newPrice);
    }

    // метод, возвращающий массив значений цен моделей
    public double[] getPricesOfAllModels() {
        double[] allPrices = new double[models.length];
        for (int i = 0; i < models.length; i++)
            allPrices[i] = models[i].getPrice();
        return allPrices;
    }

    // метод добавления названия модели и ее цены (путем создания нового массива Моделей)
    public void addNewModelNamePrice(String newName, double newPrice) throws DuplicateModelNameException {
        if(newPrice < 0)
            throw new ModelPriceOutOfBoundsException("Цена модели " + newName + " меньше 0.");
        int i = 0;
        while(i < models.length && !models[i].getName().equals(newName))
            i++;
        if(i != models.length)
            throw new DuplicateModelNameException("Модель " + newName + " уже существует.");
        Model[] newArrModels = Arrays.copyOf(models, models.length + 1);
        newArrModels[models.length] = new Model(newName, newPrice);
        models = newArrModels;
    }

    // метод удаления модели по заданному имени
    public void deleteModelByName(String name) throws NoSuchModelNameException {
        int i = 0;
        while(i < models.length && !models[i].getName().equals(name)){
            i++;
        }
        if (i == models.length)
            throw new NoSuchModelNameException("Модель " + name + " не найдена.");
        System.arraycopy(models, i + 1, models, i,models.length - i - 1);
        models = Arrays.copyOf(models, models.length - 1);
    }

    // метод для получения размера массива Моделей
    public int getSize(){
        return models.length;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Вид транспорта: ").append(this.getClass().getName()).append("\n");
        stringBuffer.append("Марка: ").append(mark).append("\n");
        stringBuffer.append("Количество моделей: ").append(getSize()).append("\n");
        for (int i = 0; i < getSize(); i++) {
            stringBuffer.append("[").append(getNamesOfAllModels()[i]).append(" ")
                    .append(getPricesOfAllModels()[i]).append("] ");
        }
        return stringBuffer.toString();
    }

    public Object clone() {
        Auto auto = null;
        try {
            auto = (Auto) super.clone();
            auto.models = new Model[getSize()];
            for (int i = 0; i < getSize(); ++i) {
                auto.models[i] = models[i].clone();
            }
            return auto;
        }
        catch (CloneNotSupportedException ex) {
            return auto;
        }
    }
}