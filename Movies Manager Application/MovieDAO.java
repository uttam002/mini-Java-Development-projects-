import java.sql.*;
import java.util.Scanner;

public class MovieDAO {
    private Scanner scanner = new Scanner(System.in);

    public void displayMovies() {
        try (Connection con = DatabaseManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM movies")) {

            while (rs.next()) {
                System.out.print(rs.getString(1) + '\t');
                System.out.print(rs.getString(2) + '\t');
                System.out.print(rs.getString(3) + '\t');
                System.out.print(rs.getString(4) + '\t');
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void insertMovie() {
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO movies VALUES (?, ?, ?, ?)")) {

            System.out.println("Enter movie ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter title:");
            String title = scanner.nextLine();
            System.out.println("Enter director:");
            String director = scanner.nextLine();
            System.out.println("Enter year:");
            int year = scanner.nextInt();

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

    public void deleteMovie() {
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM movies WHERE title = ?")) {

            System.out.println("Enter title of the movie to delete:");
            String titleToDelete = scanner.nextLine();

            pstmt.setString(1, titleToDelete);

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

    public void updateMovie() {
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement("UPDATE movies SET title = ?, director = ?, year = ? WHERE id = ?")) {

            System.out.println("Enter ID of the movie to update:");
            int idToUpdate = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter new title:");
            String newTitle = scanner.nextLine();
            System.out.println("Enter new director:");
            String newDirector = scanner.nextLine();
            System.out.println("Enter new year:");
            int newYear = scanner.nextInt();

            pstmt.setString(1, newTitle);
            pstmt.setString(2, newDirector);
            pstmt.setInt(3, newYear);
            pstmt.setInt(4, idToUpdate);

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
}
