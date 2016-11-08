/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generators;

import Staffs.Organization;
import Staffs.Person;

/**
 *
 * @author Алексей
 */
public class OrganizationGenerate {
    StringGenerator StrG;
    NumberGenerate NmbG;
    int id;
    
    public OrganizationGenerate(){
        StrG = new StringGenerator();
        NmbG = new NumberGenerate();
        id=0;
    }
    
    public Organization RandomOrganization(Person head){
        Organization organization = new Organization();
        organization.setFullName(StrG.NewString(7));
        organization.setShortName(StrG.NewString(3));
        organization.setPhone(NmbG.RanomNumber());
        organization.setHead(head);
        organization.setidentifier(id);
        id++;
        return organization;             
        
    }
}
