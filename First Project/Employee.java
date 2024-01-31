// Import necessary Java SQL classes for database connectivity
import java.sql.*;
// Import Scanner for user input
import java.util.Scanner;

public class Employee {

    // Create a Scanner object for user input
    private static final Scanner scanner = new Scanner(System.in);

    // Method to display data from the "employee" table
    public static void showData(Statement stmt) {
        try {
            // Execute SELECT query to fetch all records from the "employee" table
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            System.out.println();
            System.out.println("Employee Data:");
            // Loop through the result set and print employee details
            while (rs.next()) {
                System.out.print(rs.getString("employee_id") + " ");
                System.out.print(rs.getString("first_name") + " ");
                System.out.print(rs.getString("last_name") + " ");
                System.out.print(rs.getString("job_title") + " ");
                System.out.print(rs.getString("department") + " ");
                System.out.print(rs.getString("salary") + " ");
                System.out.print(rs.getString("hire_date") + " ");
                System.out.println();
            }
            System.out.println();
            System.out.println();
        } catch (Exception e) {
            // Print any exceptions that occur during data retrieval
            System.out.println(e.getMessage());
        }
    }

    // Method to insert new data into the "employee" table
    public static void insertData(Statement stmt) {
        try {
            // Prompt user for employee details
            System.out.print("Enter employee ID: ");
            int employee_id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter first name: ");
            String first_name = scanner.nextLine();

            System.out.print("Enter last name: ");
            String last_name = scanner.nextLine();

            System.out.print("Enter job title: ");
            String job_title = scanner.nextLine();

            System.out.print("Enter department: ");
            String department = scanner.nextLine();

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter hire date (YYYY-MM-DD): ");
            String hire_date = scanner.nextLine();

            // Execute INSERT query to add a new record to the "employee" table
            int ic = stmt.executeUpdate("INSERT INTO employee VALUES (" + employee_id + ",'" + first_name + "','" + last_name + "','" + job_title + "','" + department + "'," + salary + ",'" + hire_date + "')");

            // Check if data insertion was successful
            if (ic != 0) {
                System.out.println("Data inserted Successfully!");
            }
        } catch (Exception e) {
            // Print any exceptions that occur during data insertion
            System.out.println(e.getMessage());
        }
    }

    // Method to delete data from the "employee" table based on employee ID
    public static void deleteData(Statement stmt) {
        try {
            // Prompt user for employee ID to delete
            System.out.print("Enter employee ID to delete: ");
            int employee_id = scanner.nextInt();

            // Execute DELETE query to remove records from the "employee" table
            int ic = stmt.executeUpdate("DELETE FROM employee WHERE employee_id =" + employee_id);

            // Check if data deletion was successful
            if (ic != 0) {
                System.out.println("Data deleted Successfully!");
            }
        } catch (Exception e) {
            // Print any exceptions that occur during data deletion
            System.out.println(e.getMessage());
        }
    }

    // Method to update data in the "employee" table based on employee ID
    public static void updateData(Statement stmt) {
        try {
            // Prompt user for employee ID to update
            System.out.print("Enter employee ID to update: ");
            int employee_id = scanner.nextInt();
            int new_id = employee_id + 1;

            // Execute UPDATE query to modify records in the "employee" table
            int ic = stmt.executeUpdate("UPDATE employee SET employee_id = " + new_id + " WHERE employee_id = " + employee_id);

            // Check if data update was successful
            if (ic != 0) {
                System.out.println("Data updated Successfully!");
            }
        } catch (Exception e) {
            // Print any exceptions that occur during data update
            System.out.println(e.getMessage());
        }
    }

    // Main method where the execution of the program starts
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Prompt user for database connection details
            System.out.print("Enter URL for getConnection with DriverManager (e.g., jdbc:mysql://localhost:3306/your_database_name): ");
            String url = scanner.nextLine();

            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Establish a connection to the database
            Connection con1 = DriverManager.getConnection(url, username, password);
            // Create a Statement object for executing SQL queries
            Statement stmt = con1.createStatement();

            // Display existing employee data
            showData(stmt);
            // Insert new employee data
            insertData(stmt);
            // Display updated employee data
            showData(stmt);
            // Delete employee data
            deleteData(stmt);
            // Display updated employee data
            showData(stmt);
            // Update employee data
            updateData(stmt);
            // Display final updated employee data
            showData(stmt);

        } catch (Exception e) {
            // Print any exceptions that occur during program execution
            System.out.println(e.getMessage());
        } finally {
            // Close the Scanner to prevent resource leaks
            scanner.close();
        }
    }
}
