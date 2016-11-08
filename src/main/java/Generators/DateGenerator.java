/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generators;

import java.util.Random;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author Алексей
 */
public class DateGenerator {
    Random random;
    
    public DateGenerator(){
        random = new Random();
    }
    
    public Date RandomDate(Date StartDate, Date EndDate){
        long millisec = ThreadLocalRandom.current().nextLong(StartDate.getTime(),EndDate.getTime());
        Date dt = new Date(millisec);
        return dt;
    }
    
    public Date RandomDateGr(Date StartDate, GregorianCalendar EndDate){
        long millisec = ThreadLocalRandom.current().nextLong(StartDate.getTime(),EndDate.getTimeInMillis());
        Date dt = new Date(millisec);
        return dt;
    }
        
    public Date RandomDate(){
        GregorianCalendar cl = new GregorianCalendar(2010,10,10);
        Date EndDate = new Date();
        Date StartDate = new Date(cl.getTimeInMillis());
        return RandomDate(StartDate,EndDate);
    }
}
