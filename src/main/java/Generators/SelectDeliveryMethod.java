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
public class SelectDeliveryMethod {
    String[] DeliveryMethods;
    Random random;
    
    public SelectDeliveryMethod(){
        random = new Random();
        DeliveryMethods = new String[] {"Почтой", "Курьером", "E-mail", "Факс"};
    }
    
    public String RandomDeliveryMethod(){
        return DeliveryMethods[random.nextInt(DeliveryMethods.length-1)];
    }


}


