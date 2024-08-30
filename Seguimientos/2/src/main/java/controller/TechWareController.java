package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.TechProductAmountPriceComparator;
import model.TechWare;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class TechWareController {

    private ArrayList<TechWare> inventory;
    private File data;
    private File listJson;

    public TechWareController() {
        this.inventory = new ArrayList<TechWare>();
        this.data = new File("C:\\Users\\1006231911\\Documents\\ordenamiento-serializacion-SimonGarcia01\\src\\main\\data");
        this.listJson = new File(data.getAbsolutePath() + "\\Inventory.json");
    }

    public void insertionSort(TechProductAmountPriceComparator comparator){
        int n = this.inventory.size();
        for(int i = 1; i < n; i++){
            TechWare current = this.inventory.get(i);
            int j = i - 1;
            while(j >= 0 && comparator.compare(current,this.inventory.get(j)) < 0){
                this.inventory.set(j + 1, this.inventory.get(j));
                j--;
            }
            this.inventory.set(j + 1, current);
        }
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
        Gson gson = new Gson();

        String dataJson = gson.toJson(inventory);

        try{
            createResources();

            FileOutputStream fos = new FileOutputStream(this.listJson);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            writer.write(dataJson);

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e){
            System.err.println("File was not found.");
        } catch (IOException e) {
            System.err.println("Input Output Exception.");
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

            Type listType = new TypeToken<ArrayList<TechWare>>(){}.getType();

            inventory = gson.fromJson(data, listType);

        } catch (FileNotFoundException e) {
            System.err.println("File was not found.");
        } catch (IOException e) {
            System.err.println("Input Output Exception.");
        }
    }


    public void addTech(String productName, double price, int amount){
        inventory.add(new TechWare(productName, price, amount));
    }

    public ArrayList<TechWare> getInventory() {
        return inventory;
    }



}
