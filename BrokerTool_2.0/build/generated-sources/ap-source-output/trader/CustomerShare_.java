package trader;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2015-03-11T12:22:45")
@StaticMetamodel(CustomerShare.class)
public class CustomerShare_ { 

    public static volatile SingularAttribute<CustomerShare, Integer> id;
    public static volatile SingularAttribute<CustomerShare, String> stockSymbol;
    public static volatile SingularAttribute<CustomerShare, String> customerId;
    public static volatile SingularAttribute<CustomerShare, Integer> quantity;
    public static volatile SingularAttribute<CustomerShare, Integer> version;

}