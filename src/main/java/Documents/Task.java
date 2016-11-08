/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documents;

import Staffs.Person;
import java.util.Date;

/**
 *
 * @author Алексей
 */
public class Task extends Document {
    public Date DateIssueOrder;    
    public Date DateExecutionTask;    
    public Person ResponsibleExecutor ;     
    public boolean signControl; 
    public Person TaskController; 
    
    public  Task(int Identifier, String name, String text,int RegNumber,Date dat,Person author, Date DIssueOrder, Date DExecutionTask, Person ResponsExecutor, boolean sControl, Person TController ){
        identifier = Identifier;
        Name = name;
        Text = text; //не уверен, что обычный стринг для текста подойдет
        RegistrationNumber = RegNumber;
        date = dat; 
        Author = author; 
        
        DateIssueOrder = DIssueOrder;
        DateExecutionTask = DExecutionTask;
        ResponsibleExecutor = ResponsExecutor;
        signControl=sControl;
        TaskController = TController;

        
    }
    
    @Override
    public void DocToString(){
        System.out.println("    Поручение"+ this.PreDocToString()); 
    };
}
