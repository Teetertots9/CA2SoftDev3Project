/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import Classes.*;
import java.util.Scanner;

public class PersistenceOperations {

    Scanner in = new Scanner(System.in);
    EntityManagerFactory emf;
    EntityManager em;

    public PersistenceOperations() {
        emf = Persistence.createEntityManagerFactory("SDEV3CA2PUCOLLEGE");
        em = emf.createEntityManager();

      //  emf = Persistence.createEntityManagerFactory("SDEV3CA2PUHOME");
      //  em = emf.createEntityManager();
      
      //  emf = Persistence.createEntityManagerFactory("SDEV3CA2PUHOME2");
      //  em = emf.createEntityManager();
    }

    public void showAllManagers() {
        em.getTransaction().begin();

        TypedQuery<Manager> query
                = em.createNamedQuery("Manager.findAll", Manager.class);
        List<Manager> results = query.getResultList();

        for (Manager m : results) {
            System.out.println(m);
        }
        em.getTransaction().commit();
    }

    public void showAllEmployees(int mid) {

        em.getTransaction().begin();

        Manager m = em.find(Manager.class, mid);
        if (m != null) {

            List<Employee> elist = m.getElist();

            for (Employee e : elist) {
                System.out.println(e);
            }
        }

        em.getTransaction().commit();
    }

    public void showAllCustomers(int empId) {
        em.getTransaction().begin();

        Employee emp = em.find(Employee.class, empId);
        List<Customer> clist = emp.getClist();

        for (Customer c : clist) {
            System.out.println(c);
        }
        em.getTransaction().commit();
    }

    public void showAllPT() {
        em.getTransaction().begin();
        TypedQuery<PartTimeEmployee> query
                = em.createQuery("SELECT pt FROM PartTimeEmployee pt order by pt.empId",
                        PartTimeEmployee.class);
        List<PartTimeEmployee> results = query.getResultList();
        for (PartTimeEmployee pt : results) {
            System.out.println(pt);
        }

        em.getTransaction().commit();
    }

    public void showAllFT() {
        em.getTransaction().begin();
        TypedQuery<FullTimeEmployee> query
                = em.createQuery("SELECT ft FROM FullTimeEmployee ft order by ft.empId",
                        FullTimeEmployee.class);
        List<FullTimeEmployee> results = query.getResultList();
        for (FullTimeEmployee ft : results) {
            System.out.println(ft);
        }

        em.getTransaction().commit();
    }

    public Manager findManager(int id) {
        Manager m = em.find(Manager.class, id);
        if (m == null) {
            System.out.println("Not Found");
        }
        return m;
    }

    public Employee findEmployee(int id) {
        Employee d = em.find(Employee.class, id);
        if (d == null) {
            System.out.println("Not found");
        }
        return d;
    }
    
    public Customer findCustomer(int id) {
        Customer c = em.find(Customer.class, id);
        if (c == null) {
            System.out.println("Not Found");
        }
        return c;
    }

    public void deleteEmployee(int empid, int mid) {
        Manager m = em.find(Manager.class, mid);
        Employee e = em.find(Employee.class, empid);
        em.getTransaction().begin();
        em.remove(e);
        m.getElist().remove(e);
        em.getTransaction().commit();
        System.out.println("Employee Deleted");
    }

    public void deleteManager(int mid) {
        Manager m = em.find(Manager.class, mid);
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
        System.out.println("Manager Deleted");
    }

    public void deleteCustomer(int cid, int empid) {
        Customer c = em.find(Customer.class, cid);
        Employee e = em.find(Employee.class, empid);
        em.getTransaction().begin();
        em.remove(c);
        e.getClist().remove(c);
        em.getTransaction().commit();
        System.out.println("Customer Deleted");

    }

    public void addManager(String name, double salary) {
        em.getTransaction().begin();
        Manager m1 = new Manager(name, salary);
        em.persist(m1);
        em.getTransaction().commit();

    }

    public void addFTEmployee(String name, Calendar sdate, double salary, Manager m) {
        em.getTransaction().begin();
        FullTimeEmployee ft1 = new FullTimeEmployee(name, sdate, salary);
        m.addEmployee(ft1);
        em.persist(ft1);
        em.getTransaction().commit();
    }

    public void addPTEmployee(String name, Calendar sdate, double hours, double rate, Manager m) {
        em.getTransaction().begin();
        PartTimeEmployee pt1 = new PartTimeEmployee(name, sdate, hours, rate);
        m.addEmployee(pt1);
        em.persist(pt1);
        em.getTransaction().commit();
    }

    public void addCustomer(Employee e, Customer c) {
        em.getTransaction().begin();
        e.addCustomer(c);
        em.getTransaction().commit();
    }
    
    public void updateManager(int mid, String name, double salary) {
        em.getTransaction().begin();
        Manager m = em.find(Manager.class, mid);
        m.setName(name);
        m.setSalary(salary);
        em.getTransaction().commit();
        System.out.println("Manager Updated");
    }
    
    public void updateEmployee(int mid, int empid, String type, String name, Calendar date, double salary, double rate, double hours){
        em.getTransaction().begin();
        Manager m = em.find(Manager.class, mid);
        if(m != null) { 
            if (type.equals("FT")) {
                FullTimeEmployee emp = em.find(FullTimeEmployee.class, empid);
                emp.setName(name);
                emp.setDateEmployed(date);
                emp.setSalary(salary);
            } else if (type.equals("PT")){
                PartTimeEmployee emp = em.find(PartTimeEmployee.class, empid);
                emp.setName(name);
                emp.setDateEmployed(date);
                emp.setRateOfPay(rate);
                emp.setHoursWorked(hours);
            }
        }
        em.getTransaction().commit();
        System.out.println("Employee Updated");
    }
    
    public void updateCustomer(int empid, int custNum, String name, String address, Calendar date, double price) {
        em.getTransaction().begin();
        Employee emp = em.find(Employee.class, empid);
        if(emp!=null) {
            Customer c = em.find(Customer.class, custNum);
            c.setName(name);
            c.setAddress(address);
            c.setDateOfPurchase(date);
            c.setPriceOfPurchase(price);
        }
        em.getTransaction().commit();
        System.out.println("Customer Updated");
    }

    public void close() {
        em.close();
        emf.close();
    }

}
