/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffGroup;

import Generators.PeopleGenerate;
import Parsers.JaxbParser;
import Staffs.Person;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Алексей
 */
@XmlSeeAlso(Person.class)
@XmlRootElement(name = "GroupPerson")
@XmlType(propOrder = {"persons"})
public class GroupPerson extends StaffGroup{
    private ArrayList<Person> persons = new ArrayList();
    PeopleGenerate PplG;
    
    public GroupPerson(){
        PplG = new PeopleGenerate();
        this.persons = new ArrayList();
    }
    @XmlElementWrapper
    public ArrayList<Person> getPersons(){
        return this.persons;
    }    
    public void setPersons(ArrayList<Person> persons){
        this.persons = persons;
    }
    
    public void RandomGroupPerson(int CountPerson) {        
        for(int i=0; i<=CountPerson; i++){
            PplG.RandomPerson().Save(persons);
        } 
            
    }
    
    @Override
    public void SaveToXML() throws JAXBException{
        JaxbParser parser = new JaxbParser();
        File file = new File("persons.xml");
        parser.saveObject(file,this);
    }
   
    
    
    
    
}
