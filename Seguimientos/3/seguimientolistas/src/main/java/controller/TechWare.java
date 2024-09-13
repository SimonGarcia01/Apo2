package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Product;
import structure.Delivery;

import java.io.*;
import java.io.IOException;
import java.lang.reflect.Type;

public class TechWare {

    private Delivery products;

    private File data;
    private File listJson;

    public void addProduct(String name, double price, int quantity){
        products.add(new Product(name, price, quantity));
    }

    public TechWare() {
        this.products = new Delivery();
        this.data = new File("C:\\Users\\1006231911\\Documents\\seguimientolistas-g3-SimonGarcia01\\seguimientolistas\\src\\main\\data");
        this.listJson = new File(data.getAbsolutePath() +  "\\inventario.json");
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
        String dataJson = gson.toJson(products);

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

            Type listType = new TypeToken<Delivery>(){}.getType();

            products = gson.fromJson(data, listType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Delivery getproducts() {
        return products;
    }

}