/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documents;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import Staffs.Person;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Алексей
 */
@XmlRootElement
abstract public class Document implements Comparable, Storable {
    public int identifier;
    public String Name;
    public String Text; //не уверен, что обычный стринг для текста подойдет
    public int RegistrationNumber;
    public Date date; 
    public Person Author;  
    
    @Override
    public int Compare(Document doc){ 

        if(RegistrationNumber!=doc.RegistrationNumber)
            if(RegistrationNumber>doc.RegistrationNumber)
                return 1;
            else
                return -1;
        else
            return date.compareTo(doc.date);

            
    }
    @Override
    public void Save(ArrayList list){
        list.add(this);
    }    
    public void DocToString(){};
    
    public String PreDocToString(){
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        return " №"+RegistrationNumber+" от "+format1.format(date) +". "+ Name;
    }
    
}
