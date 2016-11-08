/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staffs;



import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author Алексей
 */
@XmlRootElement(name = "Staff")
@XmlType(propOrder = {"identifier"})
abstract public class Staff implements Documents.Storable{
    int identifier;   
    
    @XmlElement
    public int getidentifier(){
        return identifier;
    }      
    
    public void setidentifier(int identifier){
        this.identifier=identifier;
    } 
    
    
    @Override
    public void Save(ArrayList list){
        list.add(this);
    } 
}
