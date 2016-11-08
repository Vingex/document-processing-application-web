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
@XmlRootElement(name = "Depatament")
@XmlType(propOrder = {"fullName","shortName","head","phone"})
public class Departament extends Staff{    
    private String FullName;
    private String ShortName;
    private Person Head;
    private long Phone;
    
    public String getFullName(){
        return FullName;
    }    
    
    @XmlElement
    public void setFullName(String FullName){
        this.FullName=FullName;
    } 
    
    public String getShortName(){
        return ShortName;
    }
    
    @XmlElement
    public void setShortName(String ShortName){
        this.ShortName=ShortName;
    }
    
    public Person getHead(){
        return Head;
    }
    
    @XmlElement
    public void setHead(Person Head){
        this.Head=Head;
    }
    
    public long getPhone(){
        return Phone;
    }
    
    @XmlElement
    public void setPhone(long Phone){
        this.Phone=Phone;
    }
}
