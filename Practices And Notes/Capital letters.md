***Write a client server program using TCP where client sends a string and server respond it with Capital letters.***

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

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Input stream to read data from client
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Output stream to send data to client
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read data from client
            String data = input.readLine();

            // Convert data to uppercase
            String uppercaseData = data.toUpperCase();

            // Send uppercase data back to client
            output.println(uppercaseData);

            // Close streams and sockets
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            output.println("hello");

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

Make sure to run the Server.java file first, then run the Client.java file. The client will send the string "hello" to the server, and the server will respond with the uppercase version of it.
