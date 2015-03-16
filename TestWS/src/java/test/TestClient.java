/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.me.calculator.CalculatorWS;
import org.me.calculator.CalculatorWSService;

/**
 *
 * @author oracle
 */
public class TestClient {
    
    public static void main(String[] args){
    
        CalculatorWSService service = new CalculatorWSService();
        
        CalculatorWS port = service.getCalculatorWSPort();
        int s = port.add(23, 42);
        System.out.println(s);
    }
    
}
