/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb.examples;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import test.Person;



/**
 *
 * @author oracle
 */
public class Java_a_XML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            Person p = new Person();
            p.setName("Carlos");
            
            JAXBContext jc = JAXBContext.newInstance(Person.class);
            
            Marshaller m = jc.createMarshaller();
            OutputStream out = new FileOutputStream("src/test/New-Person.xml");
            
            m.marshal(p,out);
            
        }
        catch(JAXBException | IOException ex){
            ex.printStackTrace();
        }
    }
}
