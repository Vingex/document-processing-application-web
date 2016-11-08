/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffGroup;

import Generators.OrganizationGenerate;
import Parsers.JaxbParser;
import Staffs.Departament;
import Staffs.Organization;
import Staffs.Person;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Алексей
 */
@XmlSeeAlso(Organization.class)
@XmlRootElement(name = "GroupOrganization")
@XmlType(propOrder = {"organizations"})
public class GroupOrganization extends StaffGroup{
    ArrayList<Departament> organizations = new ArrayList();
    ArrayList<Person> persons = new ArrayList();
    OrganizationGenerate OrgG;
    Random random;
    
    public GroupOrganization(ArrayList persons){
        this.persons = persons;
        OrgG = new OrganizationGenerate();
        organizations = new ArrayList();
        random = new Random();
    }
    
    public GroupOrganization(){
        OrgG = new OrganizationGenerate();
        organizations = new ArrayList();
        random = new Random();
    }


    @XmlElementWrapper
    public ArrayList getOrganizations(){
        return organizations;
    }    
    public void setOrganizations(ArrayList organizations){
        this.organizations = organizations;
    }
    
    public void RandomGroupOrganizations(int CountOrganizations) {        
        for(int i=0; i<=CountOrganizations; i++){
            OrgG.RandomOrganization(persons.get(random.nextInt(persons.size()-1))).Save(organizations);
        } 
            
    }
    
    @Override
    public void SaveToXML() throws JAXBException{
        JaxbParser parser = new JaxbParser();
        File file = new File("organizations.xml");
        parser.saveObject(file,this);
    }
    
    
}
