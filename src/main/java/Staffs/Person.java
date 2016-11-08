/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staffs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Алексей
 */
@XmlRootElement(name = "Person")
@XmlType(propOrder = {"name","surname","patronymic","position"})
public class Person extends Staff {
    private String Name;
    private String Surname;
    private String Patronymic;
    private String Position;
    
    @XmlElement
    public String getName(){
        return Name;
    }
    
    public void setName(String Name){
        this.Name=Name;
    } 
    
    public String getSurname(){
        return Surname;
    }
    
    @XmlElement
    public void setSurname(String Surname){
        this.Surname=Surname;
    }
    
    public String getPatronymic(){
        return Patronymic;
    }
    
    @XmlElement
    public void setPatronymic(String Patronymic){
        this.Patronymic=Patronymic;
    }
    
    public String getPosition(){
        return Position;
    }
    
    @XmlElement
    public void setPosition(String Position){
        this.Position=Position;
    }
    
    public int Compare(Person person){
        String pers0 = this.getSurname()+" "+this.getName()+" " + this.getPatronymic();
        String pers1 = person.getSurname()+" "+person.getName()+" " + person.getPatronymic();
        return pers0.compareTo(pers1);
    }
    
    public String toString(){
        return this.getSurname()+" "+this.getName()+" " + this.getPatronymic();
    }
            
}
