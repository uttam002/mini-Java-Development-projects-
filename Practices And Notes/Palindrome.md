***Write a client server program using TCP where client sends a string and server checks whether that string is palindrome or not and responds with appropriate message.***

**Server code (Server.java):**

```java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Create server socket
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running...");

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                // Input stream to read data from client
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Output stream to send data to client
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read data from client
                String data = input.readLine();

                // Check if the string is a palindrome
                boolean isPalindrome = checkPalindrome(data);

                // Send appropriate message back to client
                if (isPalindrome) {
                    output.println("The string is a palindrome.");
                } else {
                    output.println("The string is not a palindrome.");
                }

                // Close streams and sockets
                input.close();
                output.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to check if a string is palindrome
    private static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

**Client code (Client.java):**

```java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Create socket to connect to server
            Socket socket = new Socket("127.0.0.1", 12345);

            // Output stream to send data to server
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Input stream to read data from server
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send data to server
            String message = "madam";
            output.println(message);

            // Receive response from server
            String response = input.readLine();
            System.out.println("Server response: " + response);

            // Close streams and socket
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
