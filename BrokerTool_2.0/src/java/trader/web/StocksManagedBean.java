/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trader.web;

import javax.ejb.EJB;
import trader.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Hyaku Nin Giri
 */
@ManagedBean(name = "stocks")
@RequestScoped
public class StocksManagedBean {

    @EJB private BrokerModel model;
//    private BrokerModel model = BrokerModelImpl.getInstance();
    /**
     * Creates a new instance of StocksManagedBean
     */
    public StocksManagedBean() {
    }
    
    public Stock[] getAllStocks() {
        
        Stock [] stocks = null;
        try 
        {
            stocks = model.getAllStocks();
        } 
        catch (BrokerException be) 
        {
            return null;
        }
        return stocks;
    }
    
}
