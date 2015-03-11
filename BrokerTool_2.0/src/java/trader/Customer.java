package trader;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
public class Customer implements Serializable {

    @Id 
    @Column(name = "SSN") 
    private String id;
    @Column(name = "CUST_NAME") 
    private String name;
    @Column(name = "ADDRESS") 
    private String addr;
    @Version
    @Column (name = "VERSION")
    private int version = 1;
    
    // Constructors    
    public Customer(String id, String name, String addr, int version) {
        this(id, name, addr);
        this.version = version;
    }
    public Customer(String id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public Customer(String id) {
        this(id, null, null);
    }

    public Customer() {
        this(null, null, null);
    }

    // Accesser methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    // Mutator methods - note you cannot change the id
    public void setName(String newName) {
        name = newName;
    }

    public void setAddr(String newAddr) {
        addr = newAddr;
    }

    public String toString() {
        return "Customer:  " + id + "  " + name + "  " + addr;
    }
    
    public int getVersion() {
        return version;
    }
    
    public void setVersion(int version) {
        this.version = version;
    }
}

