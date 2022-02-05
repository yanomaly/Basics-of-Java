package Park;

import Park.AutoPark.APark;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new APark().menu();

//        APark a = new APark();
//        FileOutputStream outputStream = new FileOutputStream("project.ser");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(a);
//        objectOutputStream.close();
    }
}
