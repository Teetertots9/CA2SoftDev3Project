
package Classes;
import java.util.Calendar;
import javax.persistence.*;

@Entity
@DiscriminatorValue("PT")
@PrimaryKeyJoinColumn(referencedColumnName= "empid")

@SuppressWarnings("SerializableClass")

public class PartTimeEmployee extends Employee{
    
    private double rate;
    private double hours;
    
    public PartTimeEmployee() {
        
    }
    
    public PartTimeEmployee(String name, Calendar c, double rateOfPay, double hoursWorked) {
        super(name,c);
        this.rate = rateOfPay;
        this.hours = hoursWorked;
        setType("PT");
    }
    
    public double getHoursWorked() {
        return hours;
    }
    
    public double getRateOfPay() {
        return rate;
    }
    
    public void setRateOfPay(double rateOfPay) {
        this.rate = rateOfPay;
    }
    
    public void setHoursWorked(double hoursWorked) {
        this.hours = hoursWorked;
    }
    
    public double calcPay() {
        return hours * rate;
        
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nHours Worked: " + hours
                + "\nRate of Pay: " + rate
                + "\nTotal Pay: " + calcPay() + "\n";
    }
}
