***Write a program that demonstrates one way communication in network programing.***

One-way communication in network programming typically involves sending data from a client to a server or vice versa without expecting a response. Below is a simple Java program demonstrating one-way communication where the client sends a message to the server, and the server prints the received message.

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

            // Read data from client
            String message = input.readLine();
            System.out.println("Message from client: " + message);

            // Close streams and sockets
            input.close();
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

            // Send message to server
            String message = "Hello, server!";
            output.println(message);
            System.out.println("Message sent to server: " + message);

            // Close output stream and socket
            output.close();
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

You should see the server output indicating that it's running and waiting for a connection. The client will then send a message to the server, which will print the received message. The communication between client and server is one-way as the server does not send any response back to the client.
