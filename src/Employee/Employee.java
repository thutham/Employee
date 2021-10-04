package Employee;

public class Employee {
    public String id;
    public String role;
    public int bonus;
    public int salary;
    public double dayOff;
    public double realSalary;

    double days = 26;

    // constructor
    public Employee(String id, String role, int bonus, int salary, double dayOff) {
        this.id = id;
        this.role = role;
        this.bonus = bonus;
        this.salary = salary;
        this.dayOff = dayOff;
    };

    public void calculateSalary(double revenue) {

        if (role.equals("Intern")) {
            realSalary = salary + bonus;

        }
        else if (role.equals("IT")) {
            realSalary = salary * (days - dayOff) + bonus;

        }
        else if (role.equals("Sale")) {
            realSalary = salary * 1 / 100 * revenue + bonus;

        }
        else {
            realSalary = salary * (days - dayOff);
        }
    };
}
