***Write a client-server program using TCP or UDP where the client sends 10 numbers and server responds with the numbers in sorted order***

### Server Code Explanation:

1. **Import Required Libraries**:
   ```java
   import java.io.*;
   import java.net.*;
   import java.util.*;
   ```
   These imports are necessary for handling input/output operations, networking, and managing collections.

2. **Define the Server Class**:
   ```java
   public class Server {
   ```
   This defines a class named `Server`.

3. **Main Method**:
   ```java
   public static void main(String[] args) {
   ```
   This is the entry point of the server program.

4. **Create Server Socket**:
   ```java
   ServerSocket serverSocket = new ServerSocket(12345);
   ```
   This creates a server socket that listens on port `12345`.

5. **Accept Client Connection**:
   ```java
   Socket clientSocket = serverSocket.accept();
   ```
   This accepts a connection from a client and returns a socket object for communication with the client.

6. **Setup Input and Output Streams**:
   ```java
   BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
   PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
   ```
   These set up input and output streams to communicate with the client.

7. **Read Numbers from Client**:
   ```java
   List<Integer> numbers = new ArrayList<>();
   for (int i = 0; i < 10; i++) {
       String data = input.readLine();
       numbers.add(Integer.parseInt(data));
   }
   ```
   This loop reads 10 numbers sent by the client and adds them to a list.

8. **Sort Numbers**:
   ```java
   Collections.sort(numbers);
   ```
   This sorts the list of numbers in ascending order.

9. **Send Sorted Numbers to Client**:
   ```java
   for (int num : numbers) {
       output.println(num);
   }
   ```
   This loop sends each sorted number back to the client.

10. **Close Streams and Sockets**:
    ```java
    input.close();
    output.close();
    clientSocket.close();
    serverSocket.close();
    ```
    This closes all streams and sockets.

### Client Code Explanation:

1. **Import Required Libraries**:
   ```java
   import java.io.*;
   import java.net.*;
   ```
   These imports are necessary for handling input/output operations and networking.

2. **Define the Client Class**:
   ```java
   public class Client {
   ```
   This defines a class named `Client`.

3. **Main Method**:
   ```java
   public static void main(String[] args) {
   ```
   This is the entry point of the client program.

4. **Create Socket and Streams**:
   ```java
   Socket socket = new Socket("127.0.0.1", 12345);
   PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
   BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   ```
   This creates a socket and sets up input and output streams for communication with the server.

5. **Generate and Send Random Numbers**:
   ```java
   for (int i = 0; i < 10; i++) {
       int num = (int) (Math.random() * 100); // Generate a random number between 0 and 99
       output.println(num);
   }
   ```
   This loop generates 10 random numbers and sends them to the server.

6. **Receive Sorted Numbers from Server**:
   ```java
   System.out.println("Sorted numbers received from server:");
   for (int i = 0; i < 10; i++) {
       String response = input.readLine();
       System.out.println(response);
   }
   ```
   This loop receives and prints the sorted numbers sent by the server.

7. **Close Streams and Socket**:
   ```java
   output.close();
   input.close();
   socket.close();
   ```
   This closes all streams and the socket.

### How to Run:

1. Compile the Server and Client Java files:
   ```
   javac Server.java
   javac Client.java
   ```

2. Start the Server:
   ```
   java Server
   ```

3. Run the Client:
   ```
   java Client
   ```

You should see the server output indicating that it's running and receiving a connection from the client. The client will send 10 random numbers, and the server will respond with the sorted numbers.
