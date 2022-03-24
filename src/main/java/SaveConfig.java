
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ernest
 */
public class SaveConfig {
    private String myName;
    private String myEmail;
    private String myPhoneNumber;
    private String myGenericMessage;
    private String myPassword;
    private int daysTilSendValue;

    

    public static final String path = "SaveConfiguration.json";
    
    public SaveConfig(){
        
    }
    public SaveConfig(String myName, String myEmail, String myPassword, String myMessage, String myPhoneNumber, int daysTilSendValue) {
        this.myName = myName;
        this.myEmail = myEmail;
        this.myPhoneNumber = myPhoneNumber;
        this.myGenericMessage = myMessage;
        this.myPassword = myPassword;
        this.daysTilSendValue = daysTilSendValue;
    }
    public static void SaveConfiguration(SaveConfig config) throws IOException{
        Gson gson = new Gson();
        gson.serializeNulls();
        
        
        
        File file = new File(SaveConfig.path);
        if (file.exists() == false) {
            file.createNewFile();
            System.out.println("Created new SaveConfiguration json file");
        }
        
        System.out.println("Save Configuration toJson: " + gson.toJson(config));
        
        try (Writer writer = new FileWriter(SaveConfig.path)) {
            gson.toJson(config, writer);
        }
    }
    
    public static SaveConfig LoadConfiguration(String filePath) throws FileNotFoundException{
        //SaveConfig config = new SaveConfig();
        
        //String filePath = "C:\\Users\\Ernest\\Documents\\NetBeansProjects\\Job_email_responder\\emails\\emails.json";
        Gson gson = new Gson();
        
        Reader reader = new FileReader(filePath);
        
        SaveConfig config = gson.fromJson(reader,new TypeToken<SaveConfig>(){}.getType());
        System.out.println("Loaded Config");
        
        System.out.println(config == null);
        System.out.println(config.getMyName());        
        System.out.println(config.getMyEmail());
        
        return config;
    }

    public String getMyName() {
        return myName;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public String getMyPhoneNumber() {
        return myPhoneNumber;
    }

    public String getMyGenericMessage() {
        return myGenericMessage;
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }

    public void setMyPhoneNumber(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    public void setMyMessage(String myMessage) {
        this.myGenericMessage = myMessage;
    }
    
    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword;
    }

    public int getDaysTilSendValue() {
        return daysTilSendValue;
    }

    public void setDaysTilSendValue(int daysTilSendValue) {
        this.daysTilSendValue = daysTilSendValue;
    }
    
    
    
    
    
}
