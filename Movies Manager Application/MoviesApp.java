import java.util.Scanner;

public class MoviesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDAO movieDAO = new MovieDAO();

        while (true) {
            // Displaying menu options
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
                    movieDAO.displayMovies();
                    break;
                case 2:
                    // Taking inputs for inserting a new movie
                    movieDAO.insertMovie();
                    break;
                case 3:
                    // Taking input for deleting a movie
                    movieDAO.deleteMovie();
                    break;
                case 4:
                    // Taking inputs for updating a movie
                    movieDAO.updateMovie();
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
