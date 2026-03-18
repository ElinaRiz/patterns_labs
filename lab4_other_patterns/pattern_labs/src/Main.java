import exception.DuplicateModelNameException;
import pattern.dao.*;
import pattern.factory.MotoFactory;
import transport.Transport;
import transport.TransportMethods;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("---Автомобили---");
            Transport auto = TransportMethods.createInstance("Lada", 5);

            String fileTextAuto = "text_auto";
            TransportDAO textDAO = new TextTransportDAO();
            textDAO.writeTransport(auto, fileTextAuto);
            Transport textAuto = textDAO.readTransport(fileTextAuto);
            System.out.println("Из текстового файла: \n" + textAuto.toString());

            String fileSerializedAuto = "serialized_auto";
            TransportDAO serializedDAO = new SerializedTransportDAO();
            serializedDAO.writeTransport(auto, fileSerializedAuto);
            Transport serializedAuto = serializedDAO.readTransport(fileSerializedAuto);
            System.out.println("Из сериализованного файла: \n" + serializedAuto.toString());

            System.out.println("\n---Мотоциклы---");
            TransportMethods.setTransportFactory(new MotoFactory());
            Transport moto = TransportMethods.createInstance("Yamaha",6);

            String fileTextMoto = "text_moto";
            textDAO.writeTransport(moto, fileTextMoto);
            Transport textMoto = textDAO.readTransport(fileTextMoto);
            System.out.println("Из текстового файла: \n" + textMoto.toString());

            String fileSerializedMoto = "serialized_moto";
            serializedDAO.writeTransport(moto, fileSerializedMoto);
            Transport serializedMoto = serializedDAO.readTransport(fileSerializedMoto);
            System.out.println("Из сериализованного файла: \n" + serializedMoto.toString());
        } catch (IOException | ClassNotFoundException | DuplicateModelNameException e) {
            e.printStackTrace();
        }
    }
}