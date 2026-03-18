import exception.DuplicateModelNameException;
import exception.ModelPriceOutOfBoundsException;
import exception.NoSuchModelNameException;
import pattern.factory.MotoFactory;
import pattern.singleton.ConfigProperties;
import transport.Auto;
import transport.Moto;
import transport.Transport;
import transport.TransportMethods;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----Singleton-----");
        ConfigProperties config = ConfigProperties.getInstance();
        Properties properties = config.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));

        try {
            System.out.println("\n-----Factory Method-----");
            System.out.println("Автомобили:");
            Transport transportLada = TransportMethods.createInstance("Lada", 5);
            System.out.println(transportLada.getClass());
            Auto auto = (Auto) transportLada;
            System.out.println("Названия и цены автомобилей " + auto.getMark() + " до изменений:");
            TransportMethods.printNames(auto);
            TransportMethods.printPrices(auto);
            auto.setModelName("Lada2","NewLada2");
            auto.setPriceModelByName("Lada3", 12675.0);
            auto.addNewModelNamePrice("NewLada6",23000.0);
            auto.deleteModelByName("Lada4");
            auto.setMark("Lada*");
            System.out.println("Названия и цены автомобилей " + auto.getMark() + " после изменений:");
            TransportMethods.printNames(auto);
            TransportMethods.printPrices(auto);
            String autoName = "NewLada2";
            double autoPrice = auto.getPriceModelByName(autoName);
            System.out.println("Цена " + autoName + " : " + autoPrice);
            double autoMean = TransportMethods.getArithmeticMean(auto);
            System.out.println("Среднее арифметическое цен автомобилей: " + autoMean);

            System.out.println("\nМотоциклы:");
            TransportMethods.setTransportFactory(new MotoFactory());
            Transport transportYamaha = TransportMethods.createInstance("Yamaha",6);
            System.out.println(transportYamaha.getClass());
            Moto moto = (Moto) transportYamaha;
            System.out.println("Названия и цены мотоциклов " + moto.getMark() + " до изменений:");
            TransportMethods.printNames(moto);
            TransportMethods.printPrices(moto);
            moto.setModelName("Yamaha3","NewYamaha3");
            moto.setPriceModelByName("NewYamaha3", 3465.0);
            moto.addNewModelNamePrice("NewYamaha7",7780.0);
            moto.deleteModelByName("Yamaha2");
            moto.setMark("Yamaha*");
            System.out.println("Названия и цены мотоциклов " + moto.getMark() + " после изменений:");
            TransportMethods.printNames(moto);
            TransportMethods.printPrices(moto);
            String motoName = "NewYamaha3";
            double motoPrice = moto.getPriceModelByName(motoName);
            System.out.println("Цена " + motoName + " : " + motoPrice);
            double motoMean = TransportMethods.getArithmeticMean(moto);
            System.out.println("Среднее арифметическое цен мотоциклов: " + motoMean);


            System.out.println("\n-----Prototype-----");
            System.out.println("Автомобили:");
            System.out.println(auto.toString());
            Auto cloneAuto = (Auto) auto.clone();
            System.out.println("---Клон---");
            System.out.println(cloneAuto.toString());
            cloneAuto.setModelName("Lada1","NewLada1");
            System.out.println("Клон Auto изменен");
            System.out.println("---Оригинал---");
            System.out.println(auto.toString());
            System.out.println("---Клон---");
            System.out.println(cloneAuto.toString());

            System.out.println("\nМотоциклы");
            System.out.println(moto.toString());
            Moto cloneMoto = (Moto) moto.clone();
            System.out.println("---Клон---");
            System.out.println(cloneMoto.toString());
            moto.deleteModelByName("NewYamaha3");
            cloneMoto.addNewModelNamePrice("Yamaha10", 1324.0);
            cloneMoto.setPriceModelByName("Yamaha4", 2199.0);
            System.out.println("Клон Moto изменен");
            System.out.println("---Оригинал---");
            System.out.println(moto.toString());
            System.out.println("----Клон---");
            System.out.println(cloneMoto.toString());
        }
        catch (DuplicateModelNameException | ModelPriceOutOfBoundsException | NoSuchModelNameException e) {
            System.out.println(e.getMessage());
        }
    }
}