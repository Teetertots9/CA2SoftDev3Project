
package Classes;
import java.util.Calendar;
import javax.persistence.*;


@Entity
@Table(name = "CUSTOMER")
//@NamedQueries({
//@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
//@NamedQuery(name = "Customer.findCustomerbyEmpId", query = "SELECT c FROM Customer c WHERE c.empId = :empId")})

@SequenceGenerator(name="custnum_seq", initialValue=1, allocationSize=1)
@SuppressWarnings("SerializableClass")
public class Customer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="custnum_seq")
    private int custNum;
    private String name;
    private String address;
    @Temporal(TemporalType.DATE)
    private Calendar dateOfPurchase;
    private double priceOfPurchase;
    
    @ManyToOne()
    @JoinColumn(name = "empid")
    private Employee emp;
    
    public Customer() {
        
    }
    
    public Customer(String name, String address, Calendar c, double priceOfPurchase) {
       this.name = name;
       this.address = address;
       this.dateOfPurchase = c;
       this.priceOfPurchase = priceOfPurchase;
    }
    
    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setDateOfPurchase(Calendar c) {
        this.dateOfPurchase = c;
    }
    
    public void setPriceOfPurchase(double priceOfPurchase) {
        this.priceOfPurchase = priceOfPurchase;
    }
    
    public void setEmp(Employee emp) {
        this.emp = emp;
    }
    
    public int getCustNum() {
        return custNum;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public Employee getEmp() {
        return emp;
    }
    
    public Calendar getDateOfPurchase() {
        return dateOfPurchase;
    }
    
    public double getPriceOfPurchase() {
        return priceOfPurchase;
    }
    
    @Override
    public String toString() {
        String s = String.format( "Customer"
                + "\nCustomer Number: %1$d" 
                + "\nName: %2$s" 
                + "\nAddress: %3$s" 
                + "\nDate Of Purchase: %4$td %4$tb %4$tY" 
                + "\nPrice Of Purchase: %5$.2f", custNum, name, address, dateOfPurchase, priceOfPurchase);
        s += "\nEmployee ID: " + emp.getEmpId() + "\n";
        return s;
    }

}
