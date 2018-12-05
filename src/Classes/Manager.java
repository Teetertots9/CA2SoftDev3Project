
package Classes;


import java.util.ArrayList;

import java.util.List;
import javax.persistence.*;

@Entity
@Table (name= "MANAGER")
@DiscriminatorColumn( name = "type")
@NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m order by m.mid")

@SequenceGenerator (name="mid_seq", initialValue=1, allocationSize=1)
@SuppressWarnings("SerializableClass")

public class Manager {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mid_seq")
    private int mid;
    private String name;    
    private double salary;
    
    @OneToMany(mappedBy = "m",cascade = CascadeType.ALL)  
    private List<Employee> elist = new ArrayList<>();
    
    public Manager() {
        
    }
    
    public void addEmployee(Employee e) {
        this.elist.add(e);
        e.setM(this);
    }
    
    public Manager(String name,double salary) {
        this.name = name;
        
        this.salary = salary;
    }
    
    public void setMId(int mId) {
        this.mid = mId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
      
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public int getMId() {
        return mid;
    }
    
    public String getName() {
        return name;
    }
 
    public double getSalary() {
        return salary;
    }
    
    public List<Employee> getElist() {
        return elist;
    }
    
    @Override
    public String toString() {
        return "Manager " 
                + "\nManager ID: " + mid 
                + "\nName: " + name
                + "\nSalary: " + salary + "\n";
    }
}
