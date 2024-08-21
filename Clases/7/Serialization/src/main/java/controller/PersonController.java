package controller;

import com.google.gson.Gson;
import model.Person;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class PersonController {

    private ArrayList<Person> people;

    private File data;
    private File listJson;

    public PersonController() {
        this.people = new ArrayList<>();

        File projectDir = new File(System.getProperty("user.dir"));

        this.data = new File(projectDir + "\\src\\main\\data");

        this.listJson = new File(data.getAbsolutePath() + "\\people.json");
    }

    public void createResources() throws IOException {
        if(!data.exists()){
            data.mkdir();

            if(!listJson.exists()){
                listJson.createNewFile();
            }
        }
    }

    public void createPerson(String name, int age, String id){
        Person person = new Person(name, age, id);
        people.add(person);
    }

    public void clearList(){
        people.removeAll(people);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void save(){
        //Object that helps with serialization
        Gson gson = new Gson();

        //Format the arraylist into the gson object = json format
        String dataJson = gson.toJson(people);
        //System.out.println(dataJson);

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
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
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

            people = gson.fromJson(data, ArrayList.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
