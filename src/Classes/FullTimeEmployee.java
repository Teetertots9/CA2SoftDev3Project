
package Classes;

import java.util.Calendar;
import javax.persistence.*;

@Entity
@DiscriminatorValue( value="FT")
@PrimaryKeyJoinColumn(referencedColumnName="empid")

@SuppressWarnings("SerializableClass")

public class FullTimeEmployee extends Employee{
    private double salary;
    
    public FullTimeEmployee() {
        
    }
    
    public FullTimeEmployee(String name, Calendar c, double salary) {
        super(name,c);
        this.salary = salary;
        setType("FT");
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nSalary: " + salary + "\n";
    }
}
