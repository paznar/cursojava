/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import test.Person;



/**
 *
 * @author oracle
 */
public class XML_a_Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            JAXBContext jc = JAXBContext.newInstance(Person.class);
            
            Unmarshaller u = jc.createUnmarshaller();
            InputStream in = new FileInputStream("src/test/Person.xml");
            
            Person p = (Person)u.unmarshal(in);
            
            System.out.println("Name: " + p.getName());
        }
        catch(JAXBException | IOException ex){
            ex.printStackTrace();
        }
    }
}
