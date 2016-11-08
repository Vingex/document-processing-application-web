/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffGroup;

import Generators.DepartamentGeneration;
import Parsers.JaxbParser;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import Staffs.Departament;
import Staffs.Person;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElementWrapper;
/**
 *
 * @author Алексей
 */
@XmlSeeAlso(Departament.class)
@XmlRootElement(name = "GroupDepartament")
@XmlType(propOrder = {"departaments"})
public class GroupDepartament extends StaffGroup{
    ArrayList<Departament> departaments = new ArrayList();
    ArrayList<Person> persons = new ArrayList();
    DepartamentGeneration DepG;
    Random random;
    
    public GroupDepartament(ArrayList persons){
        this.persons = persons;
        DepG = new DepartamentGeneration();
        departaments = new ArrayList();
        random = new Random();
    }
    
    public GroupDepartament(){
        DepG = new DepartamentGeneration();
        departaments = new ArrayList();
        random = new Random();
    }


    @XmlElementWrapper
    public ArrayList getDepartaments(){
        return departaments;
    }    
    public void setDepartaments(ArrayList departaments){
        this.departaments = departaments;
    }
    
    public void RandomGroupDepartaments(int CountDepartaments) {        
        for(int i=0; i<=CountDepartaments; i++){
            DepG.RandomDepartament(persons.get(random.nextInt(persons.size()-1))).Save(departaments);
        } 
            
    }
    
    @Override
    public void SaveToXML() throws JAXBException{
        JaxbParser parser = new JaxbParser();
        File file = new File("departaments.xml");
        parser.saveObject(file,this);
    }
    
}
