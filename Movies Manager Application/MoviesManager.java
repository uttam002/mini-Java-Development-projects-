package emp;

import java.util.*;
import java.sql.*;

public class Movies {

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root@123");
    }

    public static void displayMovies() {
    	try (Connection con = getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM movies")) {

               System.out.printf("%-5s %-30s %-30s %-5s%n", "ID", "Title", "Director", "Year");
               System.out.println("---------------------------------------------------------------------------");
               while (rs.next()) {
                   System.out.printf("%-5d %-30s %-30s %-5d%n", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
               }
           } catch (Exception e) {
               System.out.println("Error: " + e.getMessage());
           }
    }

    public static void insertMovie(int id, String title, String director, int year) {
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO movies VALUES (?, ?, ?, ?)")) {

            pstmt.setInt(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, director);
            pstmt.setInt(4, year);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new movie is inserted successfully!");
                displayMovies();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteMovie(String title) {
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM movies WHERE title = ?")) {

            pstmt.setString(1, title);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The movie is deleted successfully!");
                displayMovies();
            } else {
                System.out.println("No such movie found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updateMovie(int id, String newTitle, String newDirector, int newYear) {
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement("UPDATE movies SET title = ?, director = ?, year = ? WHERE id = ?")) {

            pstmt.setString(1, newTitle);
            pstmt.setString(2, newDirector);
            pstmt.setInt(3, newYear);
            pstmt.setInt(4, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Movie information updated successfully!");
                displayMovies();
            } else {
                System.out.println("No such movie found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Display Movies");
            System.out.println("2. Insert Movie");
            System.out.println("3. Delete Movie");
            System.out.println("4. Update Movie");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayMovies();
                    break;
                case 2:
                    System.out.println("Enter movie ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter director:");
                    String director = scanner.nextLine();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    insertMovie(id, title, director, year);
                    break;
                case 3:
                    System.out.println("Enter title of the movie to delete:");
                    String titleToDelete = scanner.nextLine();
                    deleteMovie(titleToDelete);
                    break;
                case 4:
                    System.out.println("Enter ID of the movie to update:");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new title:");
                    String newTitle = scanner.nextLine();
                    System.out.println("Enter new director:");
                    String newDirector = scanner.nextLine();
                    System.out.println("Enter new year:");
                    int newYear = scanner.nextInt();
                    updateMovie(idToUpdate, newTitle, newDirector, newYear);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}
