/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Stateless;

/**
 *
 * @author cta
 */
@Stateless
public class BasicSession implements BasicSessionRemote {
    
    @Override
    public String getMessage() 
    {
        return "Hello EJB World";
    }
}
