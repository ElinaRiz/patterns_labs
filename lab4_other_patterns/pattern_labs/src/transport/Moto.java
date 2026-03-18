package transport;

import exception.*;

import java.io.Serializable;

public class Moto implements Transport {
    private String mark;
    private int size  = 0;;
    private Model head = new Model();

    {
        head.prev = head;
        head.next = head;
    }

    // метод для получения марки мотоцикла
    public String getMark(){
        return mark;
    }

    // метод для модификации марки мотоцикла
    public void setMark(String mark) {
        this.mark = mark;
    }

    public Moto(String mark, int size) {
        this.mark = mark;
        Model newModel;
        for (int i = 0; i < size; i++) {
            newModel = new Model(mark + (i + 1), i + 2000);
            newModel.next = head;
            newModel.prev = head.prev;
            head.prev.next  = newModel;
            head.prev = newModel;
            this.size++;
        }
    }

    // метод для модификации значения названия модели
    public void setModelName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        Model p = head.next;
        Model q = null;
        while (p != head) {
            if(p.getName().equals(newName))
                throw new DuplicateModelNameException("Модель " + newName + " уже существует.");
            if (p.getName().equals(name))
                q = p;
            p = p.next;
        }
        if (q == null)
            throw new NoSuchModelNameException("Модель " + name + " не найдена.");
        q.setName(newName);
    }

    // метод, возвращающий массив названий всех моделей
    public String[] getNamesOfAllModels() {
        String[] allNames = new String[size];
        Model p = head.next;
        for (int i = 0; i < size; i++) {
            allNames[i] = p.getName();
            p = p.next;
        }
        return allNames;
    }

    // метод для получения значения цены модели по ее названию
    public double getPriceModelByName(String name) throws NoSuchModelNameException {
        Model p = head.next;
        while (p != head && !p.getName().equals(name)) {
            p = p.next;
        }
        if (p == head)
            throw new NoSuchModelNameException ("Модель " + name + " не найдена.");
        return p.getPrice();
    }

    // метод для модификации цены модели по ее названию
    public void setPriceModelByName(String name, double newPrice) throws NoSuchModelNameException {
        if(newPrice < 0)
            throw new ModelPriceOutOfBoundsException("Цена модели " + name + " меньше 0.");
        Model p = head.next;
        while (p != head && !p.getName().equals(name)) {
            p = p.next;
        }
        if (p == head)
            throw new NoSuchModelNameException("Модель " + name + " не найдена.");
        p.setPrice(newPrice);
    }

    // метод, возвращающий массив значений цен моделей
    public double[] getPricesOfAllModels() {
        double[] allPrices = new double[size];
        Model p = head.next;
        for(int i = 0; i < size; i++) {
            allPrices[i] = p.getPrice();
            p = p.next;
        }
        return allPrices;
    }

    // метод добавления названия модели и ее цены
    public void addNewModelNamePrice(String newName, double newPrice) throws DuplicateModelNameException {
        if(newPrice < 0)
            throw new ModelPriceOutOfBoundsException("Цена модели " + newName + " меньше 0.");
        Model p = head.next;
        while (p != head && !p.getName().equals(newName)) {
            p = p.next;
        }
        if(p != head)
            throw new DuplicateModelNameException("Модель " + newName + " уже существует.");
        p = head.prev;
        Model newModel = new Model(newName, newPrice);
        newModel.next = p.next;
        newModel.prev = p;
        p.next.prev  = newModel;
        p.next= newModel;
        size++;
    }

    // метод удаления модели по заданному имени
    public void deleteModelByName(String name) throws NoSuchModelNameException {
        Model p = head.next;
        while (p != head && !p.getName().equals(name)) {
            p = p.next;
        }
        if (p == head)
            throw new NoSuchModelNameException ("Модель " + name + " не найдена.");
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
    }

    // метод для получения размера массива моделей
    public int getSize() {
        return size;
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
        Moto moto = null;
        try {
            moto = (Moto) super.clone();
            moto.head = head.clone();
            Model p = head.next;
            Model cloneModel = moto.head;
            while (p != head){
                cloneModel.next = p.clone();
                cloneModel.next.prev = cloneModel;
                cloneModel = cloneModel.next;
                p = p.next;
            }
            cloneModel.next = moto.head;
            moto.head.prev = cloneModel;
            return moto;
        }
        catch (CloneNotSupportedException ex){
            return moto;
        }
    }

    private class Model implements Cloneable, Serializable {
        String name = null;
        double price = Double.NaN;
        Model prev = null;
        Model next = null;

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

        Model() {}

        Model(String name, double price) {
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
}

