/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import Parsers.JaxbParser;
import java.io.File;
import javax.xml.bind.JAXBException;
import StaffGroup.*;
/**
 *
 * @author Алексей
 */
public class XMLStaffReader {
    
    public StaffGroup GetFromXML(Class clas, String file) throws JAXBException{
        JaxbParser parser = new JaxbParser();
        File file_ = new File(file);

        return (StaffGroup) parser.getObject(file_, clas);
    }
}
