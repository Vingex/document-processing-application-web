/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generators;

import java.util.Random;

/**
 *
 * @author Алексей
 */
public class StringGenerator {
    String[] words;
    int countWrds;
    Random random;
    
    public StringGenerator(){
        random = new Random();
        words = new String[] {"advantage","agenda","bill","change","competition","costs","deadline","decision","delivery","difference","employee","environment","experience","factory","goal","guarantee","industry","inventory","limit","market","objective","option","payment","possibility","product","promotion","refund","report","retailer","salary","share","success","support","turnover","advertise","apology","brand","commission","competitor","creditor","debt","decrease","department","disadvantage","employer","equipment","explanation","fall","goods","improvement","instructions","invoice","loss","message","offer","order","penalty","preparation","production","purchase","reminder","responsibility","rise","sales","signature","suggestion","target","advice","authorization","budget","comparison","confirmation","customer","debtor","deficit","description","distribution","enquiry","estimate","facilities","feedback","growth","increase","interest","knowledge","margin","mistake","opinion","output","permission","price","profit","reduction","repairs","result","risk","schedule","stock","supply","transport"};
        //временное решение, после прикрутки JAXB прикрутить считывание с XML
        countWrds = words.length;
    }
    public String NewString(int CountWords){
        String name = "";
        for(int i=0; i<CountWords; i++){
            name+=words[random.nextInt(countWrds-1)];
            name+=" ";
        }
        return name;
    }
    
    public String NewName(){
        String str = NewString(2+random.nextInt(3));
        return str;
    }
    
    public String NewText(){
        return NewString(random.nextInt(20)+5);
    }

}
