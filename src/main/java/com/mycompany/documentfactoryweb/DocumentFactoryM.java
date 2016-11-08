/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.documentfactoryweb;

import java.util.ArrayList;
import Documents.*;
import Exception.DocumentExistsException;
import Fabric.DocFabric;
import java.util.Random;
import Staffs.*;
import Parsers.JaxbParser;
import java.io.File;
import javax.xml.bind.JAXBException;
import XML.*;
import StaffGroup.*;
import javax.ws.rs.Path;

/**
 *
 * @author Алексей
 */
public class DocumentFactoryM {
    

    public static void main(String[] args) throws DocumentExistsException, JAXBException {
        XMLStaffReader reader  = new XMLStaffReader();
        GroupPerson groupPerson = (GroupPerson) reader.GetFromXML(GroupPerson.class, "persons.xml"); //считывание элементов организационной структуры с XML
        GroupPerson groupPersonOut = (GroupPerson) reader.GetFromXML(GroupPerson.class, "personsOut.xml");
        GroupDepartament Departaments = (GroupDepartament) reader.GetFromXML(GroupDepartament.class, "departaments.xml");
        GroupOrganization Organizations = (GroupOrganization) reader.GetFromXML(GroupOrganization.class, "organizations.xml");
        
        ArrayList<Document> SaveDocs = new ArrayList<Document>();
        DocFabric DFabric = new DocFabric(groupPerson.getPersons(), groupPersonOut.getPersons());
        String[] strClass = new String[]{"Task", "Incoming", "Outgoing"};
        Random random = new Random();
        int countDoc = 100; //количество генерируемых документов
        for(int i=0; i<countDoc; i++){
            String clas1 = strClass[random.nextInt(strClass.length)];
            DFabric.GenerationDoc(clas1, SaveDocs);
        }
        
        
        DFabric.Print(SaveDocs);
        DFabric.SaveToJSON(SaveDocs);

    }

}
