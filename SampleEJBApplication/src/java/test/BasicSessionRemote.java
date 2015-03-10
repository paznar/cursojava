/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Remote;

/**
 *
 * @author cta
 */
@Remote
public interface BasicSessionRemote {

    String getMessage();
    
}
