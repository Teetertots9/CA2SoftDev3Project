
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Database.*;
import java.util.Calendar;
import java.util.Scanner;
import Classes.*;

public class TestDB {

    PersistenceOperations po = new PersistenceOperations();
    Scanner in = new Scanner(System.in);
    String bufferSt = "";
    int befferInt = 0;
    double bufferDou = 0.0;

    public static void main(String[] args) {
        TestDB test1 = new TestDB();
        Scanner in = new Scanner(System.in);
        String bufferSt = "";
        int befferInt = 0;
        double bufferDou = 0.0;
        EmployeeOperations eo = new EmployeeOperations();
        eo.openDB();
        eo.dropCustomerSequence();
        eo.dropEmployeeSequence();
        eo.dropManagerSequence();
        eo.dropPTEmployeeTable();
        eo.dropFTEmployeeTable();
        eo.dropCustomerTable();
        eo.dropEmployeeTable();
        eo.dropManagerTable();
        eo.createManagerSequence();
        eo.createEmployeeSequence();
        eo.createCustomerSequence();
        eo.createManagerTable();
        eo.createEmployeetable();
        eo.createCustomerTable();
        eo.createFTtable();
        eo.createPTtable();

        eo.fillTables();
        System.out.println("");
//ALGORITHM        
        while (true) {
            System.out.println("Press 1 to view an entity");
            System.out.println("Press 2 to update an entity");
            System.out.println("Press 3 to add an entity");
            System.out.println("Press 4 to delete an entity");
            System.out.println("Press 0 to quit");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                //View Choice
                case 1:
                    System.out.println("VIEWS");
                    System.out.println("Press 1 to view Managers");
                    System.out.println("Press 2 to view an Employee");
                    System.out.println("Press 3 to view a Customer");
                    System.out.println("Press 0 to quit");
                    int choice1 = in.nextInt();
                    in.nextLine();
                    switch (choice1) {
                        case 1:
                            test1.viewManagers();
                            break;
                        case 2:
                            test1.viewEmployees();
                            break;
                        case 3:
                            test1.viewCustomers();
                            break;
                        case 0:
                            break;
                    }
                    break;
                //Update Choice
                case 2:
                    System.out.println("UPDATES");
                    System.out.println("Press 1 to update Managers");
                    System.out.println("Press 2 to update an Employee");
                    System.out.println("Press 3 to update a Customer");
                    System.out.println("Press 0 to quit");
                    int choice2 = in.nextInt();
                    in.nextLine();
                    switch (choice2) {
                        case 1:
                            test1.updateManager();
                            break;
                        case 2:
                            test1.updateEmployee();
                            break;
                        case 3:
                            test1.updateCustomer();
                            break;
                        case 0:
                            break;
                    }
                    break;
                //Add Choice
                case 3:
                    System.out.println("ADDS");
                    System.out.println("Press 1 to add Managers");
                    System.out.println("Press 2 to add an Employee");
                    System.out.println("Press 3 to add a Customer");
                    System.out.println("Press 0 to quit");
                    int choice3 = in.nextInt();
                    in.nextLine();
                    switch (choice3) {
                        case 1:
                            test1.addManager();
                            break;
                        case 2:
                            test1.addEmployee();
                            break;
                        case 3:
                            test1.addCustomer();
                            break;
                        case 0:
                            break;
                    }
                    break;
                //Delete Choice
                case 4:
                    System.out.println("DELETES");
                    System.out.println("Press 1 to delete Managers");
                    System.out.println("Press 2 to delete an Employee");
                    System.out.println("Press 3 to delete a Customer");
                    System.out.println("Press 0 to quit");
                    int choice4 = in.nextInt();
                    in.nextLine();
                    switch (choice4) {
                        case 1:
                            test1.deleteManager();
                            break;
                        case 2:
                            test1.deleteEmployee();
                            break;
                        case 3:
                            test1.deleteCustomer();
                            break;
                        case 0:
                            break;
                    }
                    break;
                //Exit Choice
                case 0:

                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
                    break;
            }
        }

    }
//METHODS
    //VIEWS

    public void viewManagers() {
        po.showAllManagers();
        System.out.println("");
    }

    public void viewEmployees() {
        System.out.println("Please enter the id of the manager who's employees you wish to view");
        int midIn = in.nextInt();
        in.nextLine();
        po.showAllEmployees(midIn);
        System.out.println("");
    }

    public void viewCustomers() {
        System.out.println("Please enter the id of the Employee who's customers you wish to view");
        int empidIn = in.nextInt();
        in.nextLine();
        po.showAllCustomers(empidIn);
        System.out.println("");
    }

    //UPDATES
    public void updateManager() {
        System.out.println("Please enter the ID of the manager you wish to update");
        int mid2 = in.nextInt();
        in.nextLine();
        Manager m0 = po.findManager(mid2);
        if (m0 != null) {
            System.out.println("Please enter the manager's name");
            String mName1 = in.nextLine();
            System.out.println("Please eneter the manager's salary");
            double mSalary1 = in.nextDouble();
            in.nextLine();
            po.updateManager(mid2, mName1, mSalary1);
        }
    }

    public void updateEmployee() {
        System.out.println("Please enter the ID of the Mangager of the the Employee you wish to update");
        int mid3 = in.nextInt();
        in.nextLine();
        Manager m9 = po.findManager(mid3);
        if (m9 != null) {
            System.out.println("Please enter the ID of the employee you wish to update");
            int empid2 = in.nextInt();
            in.nextLine();
            Employee emp0 = po.findEmployee(empid2);
            if (emp0 != null) {
                System.out.println("please enter the name of the employee");
                String name = in.nextLine();
                System.out.println("Please enter the start year of "
                        + "the employee");
                int year = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the start month of "
                        + "the employee");
                int month = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the start day of "
                        + "the employee");
                int day = in.nextInt();
                in.nextLine();
                Calendar sdate = Calendar.getInstance();
                sdate.set(year, month, day);

                if (emp0.getType().equals("FT")) {
                    System.out.println("Pleaes enter the salary for this employee");
                    double sal = in.nextDouble();
                    po.updateEmployee(mid3, empid2, emp0.getType(), name, sdate, sal, bufferDou, bufferDou);
                } else if (emp0.getType().equals("PT")) {
                    System.out.println("Pleaes enter the rate for this employee");
                    double rate = in.nextDouble();
                    System.out.println("Pleaes enter the hrs for this employee");
                    double hrs = in.nextDouble();
                    po.updateEmployee(mid3, empid2, emp0.getType(), name, sdate, bufferDou, rate, hrs);
                }
            }
        }
    }

    public void updateCustomer() {
        System.out.println("Please enter the ID of the Employee who's Customer you wish to change");
        int empid3 = in.nextInt();
        in.nextLine();
        Employee emp9 = po.findEmployee(empid3);
        if (emp9 != null) {
            System.out.println("Please enter the ID of the customer you wish to update");
            int custID = in.nextInt();
            in.nextLine();
            Customer c1 = po.findCustomer(custID);
            if (c1 != null) {
                System.out.println("Please enter the name of the Customer");
                String cname1 = in.nextLine();
                System.out.println("Please enter the Customer address");
                String address1 = in.nextLine();
                System.out.println("Please enter the year of "
                        + "the purchase");
                int year = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the month of "
                        + "the purchase");
                int month = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the day of "
                        + "the purchase");
                int day = in.nextInt();
                in.nextLine();
                Calendar pdate = Calendar.getInstance();
                pdate.set(year, month, day);
                System.out.println("Please enter the price of the purchase");
                double price = in.nextDouble();
                in.nextLine();
                po.updateCustomer(empid3, custID, cname1, address1, pdate, price);
            }
        }
    }

    //ADDS
    public void addManager() {
        System.out.println("Please enter the manager's name");
        String mName = in.nextLine();
        System.out.println("Please eneter the manager's salary");
        double mSalary = in.nextDouble();
        in.nextLine();
        po.addManager(mName, mSalary);
        System.out.println("Manager added");
    }

    public void addEmployee() {
        System.out.println("Please enter the ID for the manager of the Employee");
        int mId1 = in.nextInt();
        in.nextLine();
        Manager m1 = po.findManager(mId1);
        if (m1 != null) {

            System.out.println("please enter the name of employee "
                    + "you wish to add");
            String name = in.nextLine();
            System.out.println("Please enter the start year of "
                    + "the employee");
            int year = in.nextInt();
            in.nextLine();
            System.out.println("Please enter the start month of "
                    + "the employee");
            int month = in.nextInt();
            in.nextLine();
            System.out.println("Please enter the start day of "
                    + "the employee");
            int day = in.nextInt();
            in.nextLine();
            Calendar sdate = Calendar.getInstance();
            sdate.set(year, month, day);

            System.out.println("please enter the employee type");
            String type = in.nextLine();
            if (type.equals("FT")) {
                System.out.println("Pleaes enter the salary for this employee");
                double sal = in.nextDouble();
                po.addFTEmployee(name, sdate, sal, m1);
            } else if (type.equals("PT")) {
                System.out.println("Pleaes enter the rate for this employee");
                double rate = in.nextDouble();
                System.out.println("Pleaes enter the hrs for this employee");
                double hrs = in.nextDouble();
                po.addPTEmployee(name, sdate, hrs, rate, m1);
            }
        }
    }

    public void addCustomer() {
        System.out.println("Please enter the id for the employee you wish to add a customer to");
        int id = in.nextInt();
        in.nextLine();
        Employee e = po.findEmployee(id);
        if (e != null) {
            System.out.println("Please enter the name of the Customer");
            String cname = in.nextLine();
            System.out.println("Please enter the Customer address");
            String address = in.nextLine();
            System.out.println("Please enter the year of "
                    + "the purchase");
            int year = in.nextInt();
            in.nextLine();
            System.out.println("Please enter the month of "
                    + "the purchase");
            int month = in.nextInt();
            in.nextLine();
            System.out.println("Please enter the day of "
                    + "the purchase");
            int day = in.nextInt();
            in.nextLine();
            Calendar pdate = Calendar.getInstance();
            pdate.set(year, month, day);
            System.out.println("Please enter the price of the purchase");
            double price = in.nextDouble();
            in.nextLine();
            Customer c = new Customer(cname, address, pdate, price);
            c.setEmp(e);
            po.addCustomer(e, c);
        }
    }

    //DELETES
    public void deleteManager() {
        System.out.println("Please enter the id of the manager you wish to delete");
        int midd = in.nextInt();
        Manager md = po.findManager(midd);
        if (md != null) {
            po.deleteManager(midd);
        }
    }

    public void deleteEmployee() {
        System.out.println("Please enter the id of the manager who's employee you wish to delete");
        int mid1 = in.nextInt();
        Manager m = po.findManager(mid1);
        if (m != null) {
            System.out.println("Please enter the id of the employee you wish to delete");
            int eid = in.nextInt();
            in.nextLine();
            po.deleteEmployee(eid, mid1);
        }
    }

    public void deleteCustomer() {
        System.out.println("Please enter the id of the employee who's customer you wish to delete");
        int empid1 = in.nextInt();
        Employee emp1 = po.findEmployee(empid1);
        if (emp1 != null) {
            System.out.println("Please enter the id of the customer you wish to delete");
            int cid = in.nextInt();
            in.nextLine();
            po.deleteCustomer(cid, empid1);
        }
    }
    //EXIT
    public void close() {
        po.close();
    }
}
