package trader;

import java.security.Principal;
import java.util.*;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.*;

@Local
@Stateless
@DeclareRoles({"admin","customer"})
public class BrokerModelImpl implements BrokerModel {

    @PersistenceContext 
    private EntityManager em;
    @Resource
    private SessionContext ctx;
//    private static BrokerModel instance = new BrokerModelImpl();
    
//    public static BrokerModel getInstance() {
//        return instance;
//    }

    /** Creates a new instance of BrokerModelImpl */
    public BrokerModelImpl() {
    
    }
    // Customer segment state change methods
    /**----------------------------------------------------------
     * Adds the Customer to the broker model
     */
    public void addCustomer(Customer cust)
            throws BrokerException 
    {
        try 
        {
            em.persist(cust);
        } 
        catch (EntityExistsException ex) 
        {
            throw new BrokerException("Duplicate Id : " + cust.getId());
        }
    }

    /**-------------------------------------------------------------
     * deletes the customer from the broker model
     */
    public void deleteCustomer(Customer cust)
            throws BrokerException 
    {
        String id = cust.getId();
        cust = em.find(Customer.class, id);

        if (cust == null) 
        {
            throw new BrokerException("Record for " + id + " not found");
        } 
        else 
        {
            em.remove(cust);
        }
    }

    /**-------------------------------------------------------------
     * Updates the customer in the broker model
     */
    public void updateCustomer(Customer cust)
            throws BrokerException 
    {
        Customer c = em.find(Customer.class, cust.getId());
        if (c == null) 
        {
            throw new BrokerException("Customer : " + cust.getId() + " not found");
        } 
        else 
        {
            try
            {
                em.merge(cust);
            }
            catch(OptimisticLockException ole)
            {
                throw new BrokerException("Record for " + cust.getId() + " has been modified since retrieval");
            }
        }
    }

    // Customer segment state query methods
    /**-------------------------------------------------------------
     * Given an id, returns the Customer from the model
     */
    public Customer getCustomer(String id)
            throws BrokerException 
    {
        Customer cust = em.find(Customer.class, id);
        if (cust != null) 
        {
            return cust;
        } 
        else 
        {
            throw new BrokerException("Customer : " + id + " not found");
        }
    }

    /**-------------------------------------------------------------
     * Returns all customers in the broker model
     */
    public Customer[] getAllCustomers()
            throws BrokerException 
    {
        Query query = em.createNativeQuery("SELECT * FROM CUSTOMER", Customer.class);
        List customers = query.getResultList();
        return (Customer[]) customers.toArray(new Customer[0]);
    }

    @RolesAllowed({"admin","customer"})
    public CustomerShare[] getAllCustomerShares(String customerId) throws BrokerException 
    {
        Principal principal = ctx.getCallerPrincipal();
        String name = principal.getName();
        
//        if(name.equalsIgnoreCase("guest") || name.equalsIgnoreCase("anonymous"))
//        {
//            throw new BrokerException("Not Logged In");
//        }
        if(!ctx.isCallerInRole("admin") && !(name.equals(customerId)))
        {            
            throw new BrokerException("No tienes permisos");
        }
        Query query = em.createNativeQuery("SELECT * FROM SHARES WHERE SSN = '" + customerId + "'", CustomerShare.class);
        List shares = query.getResultList();

        if (shares.size() == 0) 
        {
            throw new BrokerException("Shares for " + customerId + " not found");
        } 
        else 
        {
            return (CustomerShare[]) shares.toArray(new CustomerShare[0]);
        }
    }

    public void addCustomerShare(CustomerShare cs) throws BrokerException 
    {
        CustomerShare[] shares = getAllCustomerShares(cs.getCustomerId());
        for (int i = 0; i < shares.length; i++) 
        {
            if (cs.getStockSymbol().equals(shares[i].getStockSymbol())) 
            {
                throw new BrokerException("Duplicate Share : " + cs.getCustomerId() + " " + cs.getStockSymbol());
            }
        }
        em.persist(cs);
    }

    public void updateCustomerShare(CustomerShare cs) throws BrokerException 
    {
        CustomerShare share = em.find(CustomerShare.class, cs.getId());
        if (share == null) 
        {
            throw new BrokerException("Share : " + cs.getCustomerId() + " " + cs.getStockSymbol() + " not found.");
        } 
        else 
        {
            try
            {
                em.merge(cs);
            }
            catch(OptimisticLockException ole)
            {
                throw new BrokerException("Record for " + cs.getCustomerId() + " has been modified since retrieval");
            }
        }
    }

    public Stock[] getAllStocks() throws BrokerException 
    {
        Query query = em.createNativeQuery("SELECT * FROM STOCK", Stock.class);
        List stocks = query.getResultList();
        return (Stock[]) stocks.toArray(new Stock[0]);
    }

    public Stock getStock(String symbol) throws BrokerException 
    {
        Stock stock = em.find(Stock.class, symbol);
        if (stock == null) 
        {
            throw new BrokerException("Stock : " + symbol + " not found");
        } 
        else 
        {
            return stock;
        }
    }

    public void addStock(Stock stock) throws BrokerException 
    {
        try 
        {
            em.persist(stock);
        } 
        catch (EntityExistsException exe) 
        {
            throw new BrokerException("Duplicate Stock : " + stock.getSymbol());
        }
    }

    public void updateStock(Stock stock) throws BrokerException 
    {
        Stock s = em.find(Stock.class, stock.getSymbol());
        if (s == null) 
        {
            throw new BrokerException("Stock : " + stock.getSymbol() + " not found");
        } 
        else 
        {
            try
            {
                em.merge(s);
            }
            catch(OptimisticLockException ole)
            {
                throw new BrokerException("Record for " + stock.getSymbol() + " has been modified since retrieval");
            }
        }
    }

    public void deleteStock(Stock stock) throws BrokerException 
    {
        String id = stock.getSymbol();
        stock = em.find(Stock.class, id);
        if (stock == null) 
        {
            throw new BrokerException("Stock : " + stock.getSymbol() + " not found");
        } else 
        {
            em.remove(stock);
        }
    }
}
