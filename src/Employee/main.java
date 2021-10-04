package Employee;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        List<Employee> listEmployee = new ArrayList<Employee>();
        int revenue;

        Scanner in = new Scanner(System.in);
        System.out.println("Nhap nhap doanh so: ");
        revenue = in.nextInt();
        in.close();

        // --- Đọc file --- //
        try {
            File myObj = new File("../Employee/src/Employee/data.txt");
            Scanner myReader = new Scanner(myObj);

            // Kiểm tra xem hàng tiếp theo còn text không
            while (myReader.hasNextLine()) {
                // Đọc file ở một dòng
                String data = myReader.nextLine();

                // Lấy các phần tử chia ra bởi dấu " "
                String[] result = data.split(" ");
                // System.out.println(result);

                String id = result[0];
                String role = result[1];
                int bonus = Integer.parseInt(result[2]);
                int salary = Integer.parseInt(result[3]);
                double dayOff = Double.parseDouble(result[4]);

                // Tạo một nhân viên
                Employee employee = new Employee(id, role, bonus, salary, dayOff);
                employee.calculateSalary(revenue);

                // Add nhân viên vào List nhân viên
                listEmployee.add(employee);
            }

            myReader.close();
        } catch (Exception e) {
            System.out.println("Read file error");
        }

        // --- Tạo file --- //
        try {
            File myObj = new File("result.txt");

            if (myObj.createNewFile()) {
                // Chưa tồn tại
                System.out.println("File created: " + myObj.getName());
            } else {
                // Đã tồn tại
                System.out.println("File already exists.");
            }

        } catch (Exception e) {
            System.out.println("Create file error");
        }

        // --- Ghi file --- //
        try {
            FileWriter myWriter = new FileWriter("result.txt");

            listEmployee.forEach(employee -> {

                try {

                    // Ghi ra dòng + xuống hàng vào file
                    myWriter.write(employee.id + ": " + employee.realSalary + " " + employee.salary + System.getProperty("line.separator"));

                } catch (Exception e) {
                    System.out.println("Write file error");
                }

            });

            myWriter.close();
            System.out.println("Write succeed!");
        } catch (Exception e) {
            System.out.println("Write file error");
        }
    }
}
