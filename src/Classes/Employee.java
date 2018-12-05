
package Classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name= "EMPLOYEE")
@Inheritance( strategy = InheritanceType.JOINED)
@DiscriminatorColumn( name = "type")

@SequenceGenerator (name="empid_seq", initialValue=1, allocationSize=1)
@SuppressWarnings("SerializableClass")
public class Employee {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="empid_seq")
    private int empId;
    private String name;
    private String type;
    @Temporal(TemporalType.DATE)
    private Calendar dateEmployed;
    
    @ManyToOne()
    @JoinColumn(name = "mid")
    private Manager m;
    
    
    @OneToMany(mappedBy = "emp",cascade = CascadeType.ALL)  
    private List<Customer> clist = new ArrayList<>();
    
    public Employee() {
        
    }
    
    public Employee(String name, Calendar c) {
        this.name = name;
        this.dateEmployed = c;
    }
    
    public void addCustomer(Customer c) {
        this.clist.add(c);
        c.setEmp(this);
    }
    
    public int getEmpId() {
        return empId;
    }
    
    public String getName() {
        return name;
    }
    
    public Calendar getDateEmployed() {
        return dateEmployed;
    }
    
    public Manager getM() {
        return m;
    }
    public String getType(){
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDateEmployed(Calendar c) {
        this.dateEmployed = c;
    }
    
    public void setM(Manager m) {
        this.m = m;
    }
    
    public List<Customer> getClist() {
        return clist;
    }
    
    @Override
    public String toString() {
        String s = String.format("Employee \nEmployee ID: %1$d"   
                + "\nName: %2$s"  
                + "\nDate Employeed: %3$td %3$tb %3$tY", empId, name, dateEmployed);
        s += "\nManager ID: " + m.getMId();
        return s;
    }
}
