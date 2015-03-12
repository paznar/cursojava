package trader;

import java.text.DecimalFormat;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class StockMessageProducerBean {

    @Resource(mappedName = "jms/UpdateStockFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/UpdateStock")
    private Queue queue;
    @EJB
    private BrokerModel model;

    @Schedule(second = "0", minute = "*", hour = "*")
    public void updateStocks() {
        //uncomment to send an update only for ORCL stock
        try {
            Stock stock = model.getStock("ORCL");
            updateStock(stock);
        } catch (BrokerException be) {
            be.printStackTrace();
            return;
        }

        //uncomment to send an update for each stock
//        try {
//            Stock[] stocks = model.getAllStocks();
//            for (Stock stock : stocks) {
//                updateStock(stock);
//            }
//        } catch (BrokerException be) {
//            be.printStackTrace();
//            return;
//        }
    }

    public void updateStock(Stock stock) {
        double price = stock.getPrice();
        double percentChange = 0;
        switch ((int) (Math.random() * 10 + 1)) {
            case 1:
                percentChange = -0.10;
                break;
            case 2:
                percentChange = -0.05;
                break;
            case 3:
                percentChange = -0.02;
                break;
            case 4:
                percentChange = -0.01;
                break;
            case 5:
            case 6:
                percentChange = 0.01;
                break;
            case 7:
            case 8:
                percentChange = 0.02;
                break;
            case 9:
                percentChange = 0.05;
                break;
            case 10:
                percentChange = 0.10;
                break;
        }

        double newPrice = price + price * percentChange;
        if (newPrice <= 5) {
            newPrice = 135;
        } else if (newPrice >= 10000) {
            newPrice = 135;
        }
        DecimalFormat dFormat = new DecimalFormat("0.00");
        String text = stock.getSymbol() + "," + dFormat.format(newPrice);

        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            messageProducer.setTimeToLive(300000);
            TextMessage message = session.createTextMessage();

            message.setText(text);
            messageProducer.send(message);
            messageProducer.close();
            session.close();
            connection.close();
            System.out.println("Sent Message: " + text);
        } catch (JMSException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
