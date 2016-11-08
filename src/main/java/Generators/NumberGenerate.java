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
public class NumberGenerate {
    Random random;
    
    public NumberGenerate(){
        random = new Random();
    };
    public long RanomNumber(){
        long nmb = 0;
        for(int i=0; i<11; i++)
            nmb+=random.nextInt(9)*Math.pow(10, i);
        return nmb;
    } 
    
    

}
