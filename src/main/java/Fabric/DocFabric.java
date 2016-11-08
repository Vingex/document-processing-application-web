/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabric;
import Converter.PersonConverter;
import java.util.Random;
import Generators.*;
import Documents.*;
import Exception.DocumentExistsException;
import Staffs.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;



/**
 *
 * @author Алексей
 */
public class DocFabric {
    int id;
    int idTask;
    int idIncoming;
    int idOutgoing;
    StringGenerator StrG;
    PeopleGenerate PplG;
    DateGenerator DtG;
    SelectDeliveryMethod SDM;
    NumberGenerate NmbG;
    Random random;
    ArrayList<Person> peopleIn; //внутрение представители
    ArrayList<Person> peopleOut; //внешние представители

    
    public DocFabric(ArrayList peopleIn, ArrayList peopleOut){
        id=0;
        idTask=1;
        idIncoming=1;
        idOutgoing=1;
        StrG = new StringGenerator();
        PplG = new PeopleGenerate();
        DtG = new DateGenerator();
        SDM = new SelectDeliveryMethod();
        NmbG = new NumberGenerate();
        this.peopleIn = peopleIn; 
        this.peopleOut = peopleOut;
        random = new Random();
    }
    
    public void GenerationDoc(String clas, ArrayList<Document> SaveDocs) throws DocumentExistsException{ //добавить проверки RegistrationNumber

        int identifier = id;
        String Name = StrG.NewName();
        String Text = StrG.NewText();
        Date date = DtG.RandomDate();
        Person Author = (Person) peopleIn.get(random.nextInt(peopleIn.size()-1));
        
        id++;
        
        switch(clas){
            case "Task":
            {
                int RegistrationNumber = idTask;//нужна проверка на занятость
                for(int i=0; i<SaveDocs.size(); i++){
                    if(SaveDocs.get(i).getClass().getName() == clas)
                        if(SaveDocs.get(i).RegistrationNumber == idTask)
                            throw new DocumentExistsException("Документ с таким регестрационным номером уже существует");
                }
                idTask++;
                
                Date DateIssueOrder=DtG.RandomDate();  
                GregorianCalendar gc = new GregorianCalendar(2016,12,12);
                Date DateExecutionTask = DtG.RandomDateGr(DateIssueOrder, gc);
            
                Person ResponsibleExecutor = (Person) peopleIn.get(random.nextInt(peopleIn.size()-1));  
                boolean signControl = true; 
                Person TaskController =(Person) peopleIn.get(random.nextInt(peopleIn.size()-1));
                
                Task tsk = new Task(identifier, Name, Text, RegistrationNumber, date, Author, DateIssueOrder, DateExecutionTask, ResponsibleExecutor, signControl, TaskController);
                tsk.Save(SaveDocs);
                break;
            }
            
            case "Incoming":
            {
                int RegistrationNumber = idIncoming;//нужна проверка на занятость
                for(int i=0; i<SaveDocs.size(); i++){
                    if(SaveDocs.get(i).getClass().getName() == clas)
                        if(SaveDocs.get(i).RegistrationNumber == idIncoming)
                            throw new DocumentExistsException("Документ с таким регестрационным номером уже существует");
                }
                idIncoming++;
                
                Person Sender=(Person) peopleOut.get(random.nextInt(peopleOut.size()-1));
                Person Addresser=(Person) peopleIn.get(random.nextInt(peopleIn.size()-1));
                long outgoingNumber=NmbG.RanomNumber();
                Date RegistrationDate=DtG.RandomDate(); 
                
                Incoming inc = new Incoming(identifier, Name, Text,RegistrationNumber,date,Author, Sender, Addresser, outgoingNumber, RegistrationDate);
                inc.Save(SaveDocs);
                break;
            }
            case "Outgoing":
            {
                int RegistrationNumber = idOutgoing;//нужна проверка на занятость                
                for(int i=0; i<SaveDocs.size(); i++){
                    if(SaveDocs.get(i).getClass().getName() == clas)
                        if(SaveDocs.get(i).RegistrationNumber == idOutgoing)
                            throw new DocumentExistsException("Документ с таким регестрационным номером уже существует");
                }
                idOutgoing++;
                
                Person Addresser = (Person) peopleOut.get(random.nextInt(peopleOut.size()-1));
                String DeliveryMethod = SDM.RandomDeliveryMethod();
                Outgoing otg = new Outgoing(identifier, Name, Text, RegistrationNumber,date,Author, Addresser, DeliveryMethod);
                otg.Save(SaveDocs);
                break;
            } 
            default:
                    break;
                    
                    
        }
                

    
    }
    
    public void Print(ArrayList<Document> SaveDocs){
        /*Collections.sort(peopleIn, (o1, o2)-> o1.Compare(o2));
        Collections.sort(peopleIn,(o1, o2) -> o1.Compare(o2));
        Collections.sort(SaveDocs,(o1, o2) -> o1.Compare(o2));*/
        for(int i=0; i<peopleIn.size()-1; i++){
            System.out.println(peopleIn.get(i).toString()); 
            for(int j=0; j<SaveDocs.size(); j++)
                if(peopleIn.get(i)==SaveDocs.get(j).Author){
                    SaveDocs.get(j).DocToString();
                }
                    
                    //
        }
    }
    
    public void SaveToJSON(ArrayList<Document> SaveDocs){
        
        Gson gson = new Gson();   
        /*Collections.sort(peopleIn,(o1, o2) -> o1.Compare(o2));
        Collections.sort(SaveDocs,(o1, o2) -> o1.Compare(o2));*/
        for(int i=0; i<peopleIn.size()-1; i++){
            gson = new Gson();
            String json = "";
            ArrayList<Document> Docs = new ArrayList<Document>();
            for(int j=0; j<SaveDocs.size(); j++)
                    if(peopleIn.get(i)==SaveDocs.get(j).Author){
                        json += SaveDocs.get(j).getClass().toString();
                        json += "\n";
                        json += gson.toJson(SaveDocs.get(j));
                        json += "\n";
                    } 
            /*for(int j=0; j<SaveDocs.size(); j++)
                    if(peopleIn.get(i)==SaveDocs.get(j).Author){
                        Docs.add(SaveDocs.get(j));
                    }            
            json += gson.toJson(Docs); */                
            try{
                FileWriter writer = new FileWriter("StaffsReports\\"+peopleIn.get(i).getSurname()+peopleIn.get(i).getName()+peopleIn.get(i).getPatronymic()+".json");  
                writer.write(json);  
                writer.close(); 
            }
            catch (IOException e) {  
                    e.printStackTrace();   
            }  
            

            

        }
    }
    

}
