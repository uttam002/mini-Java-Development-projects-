***Write a program that demonstrates Two way communication in network programing.***

Below is a Java program demonstrating two-way communication in network programming. In this program, the client sends a message to the server, and the server responds with a modified version of the message.

### Server Code (Server.java):

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
            String message = input.readLine();
            System.out.println("Message from client: " + message);

            // Modify the message
            String modifiedMessage = message.toUpperCase();

            // Send modified message back to client
            output.println(modifiedMessage);
            System.out.println("Modified message sent to client: " + modifiedMessage);

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

### Client Code (Client.java):

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

            // Send message to server
            String message = "Hello, server!";
            output.println(message);
            System.out.println("Message sent to server: " + message);

            // Receive response from server
            String response = input.readLine();
            System.out.println("Response from server: " + response);

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

### How to Run:

1. Compile both `Server.java` and `Client.java` files:
   ```
   javac Server.java
   javac Client.java
   ```

2. Start the server by running the `Server` class:
   ```
   java Server
   ```

3. Run the client by executing the `Client` class:
   ```
   java Client
   ```

You should see the server output indicating that it's running and waiting for a connection. The client will then send a message to the server, which will respond with a modified version of the message. Both client and server are actively communicating with each other, demonstrating two-way communication in network programming.
