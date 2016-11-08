/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documents;
import java.util.Date;
import Staffs.Person;
/**
 *
 * @author Алексей
 */
public class Incoming extends Document{
    public Person Sender;
    public Person Addresser;
    public long outgoingNumber;
    public Date RegistrationDate; 
    
    public  Incoming(int Identifier, String name, String text,int RegNumber,Date dat,Person author, Person sender, Person addresser, long outNumber, Date regDate){
        identifier = Identifier;
        Name = name;
        Text = text; //не уверен, что обычный стринг для текста подойдет
        RegistrationNumber = RegNumber;
        date = dat; 
        Author = author;  
        
        Sender = sender;
        Addresser = addresser;
        outgoingNumber = outNumber;
        RegistrationDate = regDate;
    }
    @Override
    public void DocToString(){
        System.out.println("    Входящий"+this.PreDocToString()); 
    };
}
