/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generators;

import Staffs.Departament;
import Staffs.Person;
/**
 *
 * @author Алексей
 */
public class DepartamentGeneration {
    StringGenerator StrG;
    NumberGenerate NmbG;
    int id;
    
    public DepartamentGeneration(){
        StrG = new StringGenerator();
        NmbG = new NumberGenerate();
        id = 0;
        
    }
    
    public Departament RandomDepartament(Person head){
        Departament departament = new Departament();
        departament.setidentifier(id);
        departament.setFullName(StrG.NewString(7));
        departament.setShortName(StrG.NewString(3));
        departament.setPhone(NmbG.RanomNumber());
        departament.setHead(head);
        id++;
        return departament;             
        
    }
    
}
