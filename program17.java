import java.util.*;

class Employee {
    public int EID;
    public String Ename;
    public String EAddress;
    public int ESalary;

    private static int Counter = 0;

    public Employee(String name, String address, int salary) {
        this.EID = ++Counter;
        this.Ename = name;
        this.EAddress = address;
        this.ESalary = salary;
    }

    void DisplayInfo() {
        System.out.printf("%-5d %-15s %-20s %-10d\n", EID, Ename, EAddress, ESalary);
    }
}

class JSPMRSCOEDBMS {
    public LinkedList<Employee> lobj;

    public JSPMRSCOEDBMS() {
        System.out.println("JSPM RSCOE DBMS started successfully...");
        lobj = new LinkedList<>();
    }

    protected void CloseDBMS() {
        System.out.println("Deallocating all resources of JSPM RSCOE DBMS...");
        lobj = null;
    }

    public void InsertIntoTable(String name, String address, int salary) {
        Employee eobj = new Employee(name, address, salary);
        lobj.add(eobj);
    }

    public void SelectStar() {
        if (lobj.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n----------------------------------------------------------");
        System.out.printf("%-5s %-15s %-20s %-10s\n", "EID", "Ename", "Eaddress", "Esalary");
        System.out.println("----------------------------------------------------------");
        for (Employee eref : lobj) {
            eref.DisplayInfo();
        }
        System.out.println("----------------------------------------------------------");
    }

    public void SelectSpecific(int ID) {
        boolean found = false;
        for (Employee eref : lobj) {
            if (eref.EID == ID) {
                eref.DisplayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found with EID: " + ID);
        }
    }

    public void SelectSpecific(String Name) {
        boolean found = false;
        for (Employee eref : lobj) {
            if (Name.equalsIgnoreCase(eref.Ename)) {
                eref.DisplayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found with Name: " + Name);
        }
    }

    public void DeleteFrom(int ID) {
        Iterator<Employee> itr = lobj.iterator();
        while (itr.hasNext()) {
            Employee eref = itr.next();
            if (eref.EID == ID) {
                itr.remove();
                System.out.println("Record deleted successfully.");
                return;
            }
        }
        System.out.println("Unable to delete. Employee ID not found.");
    }

    public void DeleteFrom(String Name) {
        Iterator<Employee> itr = lobj.iterator();
        while (itr.hasNext()) {
            Employee eref = itr.next();
            if (Name.equalsIgnoreCase(eref.Ename)) {
                itr.remove();
                System.out.println("Record deleted successfully.");
                return;
            }
        }
        System.out.println("Unable to delete. Employee name not found.");
    }

    public void AggregateSum() {
        if (lobj.isEmpty()) {
            System.out.println("No records available.");
            return;
        }
        int sum = 0;
        for (Employee eref : lobj) {
            sum += eref.ESalary;
        }
        System.out.println("Total Salary Sum: " + sum);
    }

    public void AggregateMax() {
        if (lobj.isEmpty()) {
            System.out.println("No records available.");
            return;
        }
        int max = Integer.MIN_VALUE;
        for (Employee eref : lobj) {
            if (eref.ESalary > max) {
                max = eref.ESalary;
            }
        }
        System.out.println("Maximum Salary: " + max);
    }

    public void AggregateMin() {
        if (lobj.isEmpty()) {
            System.out.println("No records available.");
            return;
        }
        int min = Integer.MAX_VALUE;
        for (Employee eref : lobj) {
            if (eref.ESalary < min) {
                min = eref.ESalary;
            }
        }
        System.out.println("Minimum Salary: " + min);
    }

    public void AggregateAvg() {
        if (lobj.isEmpty()) {
            System.out.println("No records available.");
            return;
        }
        int sum = 0;
        for (Employee eref : lobj) {
            sum += eref.ESalary;
        }
        System.out.println("Average Salary: " + (sum / lobj.size()));
    }

    public void AggregateCount() {
        System.out.println("Number of Employees: " + lobj.size());
    }

    public void UpdateEmployee(int ID, Scanner sobj) {
        boolean found = false;
        for (Employee eref : lobj) {
            if (eref.EID == ID) {
                found = true;
                System.out.println("Current Employee Data:");
                eref.DisplayInfo();

                int choice;
                do {
                    System.out.println("\nWhich field do you want to update?");
                    System.out.println("1. Name");
                    System.out.println("2. Address");
                    System.out.println("3. Salary");
                    System.out.println("4. Exit Update");
                    choice = sobj.nextInt();
                    sobj.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter new Name: ");
                            eref.Ename = sobj.nextLine();
                            break;
                        case 2:
                            System.out.print("Enter new Address: ");
                            eref.EAddress = sobj.nextLine();
                            break;
                        case 3:
                            System.out.print("Enter new Salary: ");
                            eref.ESalary = sobj.nextInt();
                            break;
                        case 4:
                            System.out.println("Exiting update menu.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } while (choice != 4);

                System.out.println("Record updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Employee ID not found.");
        }
    }
}

class program17{
    public static void main(String[] args) {
        System.out.println("-------- JSPM RSCOE Database Management System --------");
        Scanner sobj = new Scanner(System.in);
        JSPMRSCOEDBMS mobj = new JSPMRSCOEDBMS();

        while (true) {
            System.out.println("\n----------------------------------------------------------");
            System.out.println("Please select your choice:");
            System.out.println("1 : Insert new record");
            System.out.println("2 : Display all records");
            System.out.println("3 : Display record by EID");
            System.out.println("4 : Display record by Name");
            System.out.println("5 : Delete record by EID");
            System.out.println("6 : Delete record by Name");
            System.out.println("7 : Display Sum of salaries");
            System.out.println("8 : Display Average salary");
            System.out.println("9 : Display Minimum salary");
            System.out.println("10 : Display Maximum salary");
            System.out.println("11 : Display record count");
            System.out.println("12 : Update Employee record");
            System.out.println("13 : Help");
            System.out.println("14 : About");
            System.out.println("15 : Exit DBMS");
            System.out.println("----------------------------------------------------------");

            int choice = sobj.nextInt();
            sobj.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = sobj.nextLine();
                    System.out.print("Enter Employee Address: ");
                    String address = sobj.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    int salary = sobj.nextInt();
                    mobj.InsertIntoTable(name, address, salary);
                    break;
                case 2:
                    mobj.SelectStar();
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    mobj.SelectSpecific(sobj.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Employee Name: ");
                    mobj.SelectSpecific(sobj.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Employee ID: ");
                    mobj.DeleteFrom(sobj.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Employee Name: ");
                    mobj.DeleteFrom(sobj.nextLine());
                    break;
                case 7:
                    mobj.AggregateSum();
                    break;
                case 8:
                    mobj.AggregateAvg();
                    break;
                case 9:
                    mobj.AggregateMin();
                    break;
                case 10:
                    mobj.AggregateMax();
                    break;
                case 11:
                    mobj.AggregateCount();
                    break;
                case 12:
                    System.out.print("Enter Employee ID to update: ");
                    mobj.UpdateEmployee(sobj.nextInt(), sobj);
                    break;
                case 13:
                    System.out.println("This project implements a DBMS for employee records at JSPM RSCOE.");
                    System.out.println("It supports SQL-like operations using in-memory data structures.");
                    break;
                case 14:
                    System.out.println("Developed by Dnyanesh More, JSPM RSCOE. All rights reserved.");
                    break;
                case 15:
                    System.out.println("Thank you for using JSPM RSCOE DBMS.");
                    mobj.CloseDBMS();
                    sobj.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
