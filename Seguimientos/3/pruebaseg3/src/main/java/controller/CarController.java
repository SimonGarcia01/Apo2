package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Car;
import structure.LinkedListCar;

import java.io.*;
import java.io.IOException;
import java.lang.reflect.Type;

public class CarController {

    private LinkedListCar cars;

    private File data;
    private File listJson;

    public void addCar(int id, String model){
        cars.add(new Car(id, model));
    }

    public CarController() {
        this.cars = new LinkedListCar();
        this.data = new File("D:\\AAUniversity\\Semestre 9\\APO 2\\pruebaSeg3\\pruebaseg3\\src\\main\\data");
        this.listJson = new File(data.getAbsolutePath() +  "\\cars.json");
    }

    public void createResources() throws IOException {
        if(!data.exists()){
            data.mkdir();

            if(!listJson.exists()){
                listJson.createNewFile();
            }
        }
    }

    public void save(){
        //Object that helps with serialization
        Gson gson = new Gson();

        //Format the arraylist into the gson object = json format
        String dataJson = gson.toJson(cars);

        try {
            //Initialize resources
            createResources();

            //Connect the information with the file where the info is going to be saved
            FileOutputStream fos = new FileOutputStream(this.listJson);

            //Define the object that writes the information
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            //Write information
            writer.write(dataJson);

            //Clean the buffer
            writer.flush();

            //close the buffer
            writer.close();

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void load(){
        Gson gson = new Gson();

        try {
            //To link or connect the information with the object
            FileInputStream fis = new FileInputStream(this.listJson);

            //Create a reader that is linked to the InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            //To read the information
            String line = "";
            String data = "";

            while((line = reader.readLine()) != null) {
                data += line;
            }

            reader.close();

            Type listType = new TypeToken<LinkedListCar>(){}.getType();

            cars = gson.fromJson(data, listType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public LinkedListCar getCars() {
        return cars;
    }

}
