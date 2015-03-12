/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trader;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author cta
 */
@MessageDriven(mappedName = "jms/UpdateStock", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class UpdateStockBean implements MessageListener {
    
    @EJB private BrokerModel model;
    public UpdateStockBean() {
    }
    
    @Override
    public void onMessage(Message message) 
    {
        try 
        {
            TextMessage textMsg = (TextMessage)message;
            String text = textMsg.getText();
            System.out.println("Recieved Message: " + text);
            String[] strings = text.split(",");
            String symbol = strings[0];
            double price = Double.parseDouble(strings[1]);
            Stock stock = model.getStock(symbol);
            stock.setPrice(price);
            model.updateStock(stock);
        } 
        catch (Exception e) 
        {
            System.out.println("Exception in UpdateStockBean: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
