/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author Administrador
 */
@ManagedBean(name="myBean")
@SessionScoped
public class MyBean {
    
    private int number;
    
    public MyBean () {
//        System.out.println("Creating managed Bean");
    }

    public int getNumber() {
//        System.out.println("Calling getNumber()"); 
        return number;
    }

    public void setNumber(int number) {
//        System.out.println("Calling setNumber()"); 
        this.number = number;
    }
    
}
