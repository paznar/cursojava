/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.parasoft.wsdl.calculator.*;

/**
 *
 * @author cta
 */
public class LanzadorCliente {
    
    public static void main(String[] args)
    {
        Calculator service = new Calculator();
        
        ICalculator port = service.getICalculator();
        
        Float resultado = port.add(0.5f, 0.5f);
        
        System.out.println(resultado);
    }
    
}
