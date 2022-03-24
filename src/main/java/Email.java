
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
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
public class Email {
    
    public static String subjectFormality = "Dear ";

    public String content = "";
    public String targetEmail = "";
    public String companyName = "";
    public String myName = "";
    public String jobTitle = "";
    public LocalDate dayToSend;
    
    private static final String path = "emails.json";

    @Override
    public String toString() {
        return "Email{targetEmail=" + targetEmail + ", companyName=" + companyName + ", myName=" + myName + ", jobTitle=" + jobTitle + '}';
    }
    
    
    
    public static void SaveEmails(LinkedList<Email> emails) throws IOException, CloneNotSupportedException {
        Gson gson = new Gson();
        gson.serializeNulls();
        
        String filePath = path;
        
        File file = new File(filePath);
        if (file.exists() == false) {
            file.createNewFile();
            System.out.println("Created new emails json file");
        }
        
        System.out.println(gson.toJson(emails));
        
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(emails, writer);
        }
        
    }
    
    public void Formalize(){
        this.content = "Dear " + this.companyName + " representitives," + '\n' + this.content +
                "\n-" + this.myName;
    }
    
    public static LinkedList<Email> GetEmails() throws FileNotFoundException{
        
        String filePath = path;
        Gson gson = new Gson();
        
        Reader reader = new FileReader(filePath);
        
        LinkedList<Email> emailList = gson.fromJson(reader,new TypeToken<LinkedList<Email>>(){}.getType());
        System.out.println("Loaded: ");
        for(Email email: emailList){
            System.out.println(email.toString());
        }
        System.out.println("Done Loading...");
        
        return emailList;
        
    }
}
