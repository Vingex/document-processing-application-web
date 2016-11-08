/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestServices;

import Documents.Document;
import Documents.Incoming;
import Documents.Outgoing;
import Documents.Task;
import StaffGroup.GroupPerson;
import Staffs.Person;
import XML.XMLStaffReader;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import Staffs.Person;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.PathParam;


/**
 * REST Web Service
 *
 * @author Алексей
 */
//@Path("/employees")
@Path("/employees")
public class RestEmployees {

    GroupPerson groupPerson;
    /*@Context
    private UriInfo context;*/

    public RestEmployees() {
    }
    
    
    /*@Produces({MediaType.APPLICATION_JSON})
    @Consumes({"application/json"})*/
    @GET 
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Person> getJson() throws JAXBException {
        XMLStaffReader reader  = new XMLStaffReader();
        groupPerson = (GroupPerson) reader.GetFromXML(GroupPerson.class, "C:\\Users\\Алексей\\Documents\\NetBeansProjects\\DocumentFactoryWeb\\persons.xml");
        ArrayList<Person> a = groupPerson.getPersons();
        return a;  }
    
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Document>  getXML(@PathParam("id") String id) throws JAXBException {

        int ID = Integer.parseInt(id);
        XMLStaffReader reader  = new XMLStaffReader();
        groupPerson = (GroupPerson) reader.GetFromXML(GroupPerson.class, "C:\\Users\\Алексей\\Documents\\NetBeansProjects\\DocumentFactoryWeb\\persons.xml");
        String path = "C:\\Users\\Алексей\\Documents\\NetBeansProjects\\DocumentFactoryWeb\\StaffsReports\\";
        for(int i=0; i<groupPerson.getPersons().size(); i++)
            if(groupPerson.getPersons().get(i).getidentifier()==ID)
            {
                path = path + groupPerson.getPersons().get(i).getSurname()+groupPerson.getPersons().get(i).getName()+groupPerson.getPersons().get(i).getPatronymic()+".json";
            }
        
            
        File f = new File(path);
        String textDoc = "";
        ArrayList<Document> Doc = new ArrayList<Document>();
        try{
            BufferedReader fin = new BufferedReader(new FileReader(f));            
            String line;
            Gson gson = new Gson(); 
            while (true){
                //textDoc+=line; 
                //Document doc = new Document();
                String line2 = fin.readLine();
                if(line2==null)
                    break;

                if(line2.equalsIgnoreCase("class Documents.Task")){
                    line = fin.readLine();
                    Task doc = gson.fromJson(line, Task.class);
                    Doc.add(doc);
                }                    
                if(line2.equalsIgnoreCase("class Documents.Incoming")){
                    line = fin.readLine();
                    Incoming doc = gson.fromJson(line, Incoming.class);
                    Doc.add(doc);
                }
                
                if(line2.equalsIgnoreCase("class Documents.Outgoing")){
                    line = fin.readLine();
                    Outgoing doc = gson.fromJson(line, Outgoing.class);
                    Doc.add(doc);
                }                              
            }
                           
        }
        catch(IOException e){           
        }
        return Doc;
    }
}
    
    

    
    
