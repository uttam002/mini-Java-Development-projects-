**Step 1:** Copy the server code into a file named `TCPServer.java`.

**Step 2:** Copy the client code into a file named `TCPClient.java`.

**Step 3:** Compile both files. Open a terminal or command prompt, navigate to the directory containing the files, and execute the following commands:

```bash
javac TCPServer.java
javac TCPClient.java
```

**Step 4:** Run the server. In the same terminal or command prompt, execute:

```bash
java TCPServer
```

**Step 5:** Now, run the client. Open another terminal or command prompt window, navigate to the same directory, and execute:

```bash
java TCPClient
```

**Step 6:** After executing the client, you should see the server outputting "Server waiting for client connection...". The client will connect to the server, send the list of numbers, and print the server response, which will be the sum of the numbers sent.

**Step 7:** You can modify the numbers array in the client code with any list of numbers you want to send to the server. Just make sure to recompile the client code (`TCPClient.java`) after making any changes, and then rerun the client.

That's it! You have successfully run a client-server program using TCP sockets in Java.



Certainly! Below is an explanation of the provided client-server program step by step:

### Server (TCPServer.java):

1. **Imports**:
    ```java
    import java.io.*;
    import java.net.*;
    ```
    - These lines import the necessary classes for input/output operations and networking in Java.

2. **Main Method**:
    ```java
    public static void main(String[] args) {
        try {
            // Create a server socket on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for client...");
            
            // Accept incoming connections from clients
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");
            
            // Set up input/output streams for communication with the client
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
            
            // Read the string of numbers sent by the client
            String numbersString = inFromClient.readLine();
            // Split the string into an array of numbers
            String[] numbersArray = numbersString.split(",");
            int sum = 0;
            
            // Calculate the sum of numbers in the array
            for (String numStr : numbersArray) {
                sum += Integer.parseInt(numStr);
            }
            
            // Send the sum back to the client
            outToClient.writeInt(sum);
            
            // Close the client socket and server socket
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    ```
    - This is the main method where the server starts listening for incoming connections from clients on port 12345.
    - Once a client connects, it sets up input and output streams to communicate with the client.
    - It reads a string of numbers from the client, calculates the sum, sends it back to the client, and then closes the connection.

### Client (TCPClient.java):

1. **Imports**:
    ```java
    import java.io.*;
    import java.net.*;
    ```
    - Similar to the server, these lines import necessary classes for input/output operations and networking in Java.

2. **Main Method**:
    ```java
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server running on localhost and port 12345
            Socket clientSocket = new Socket("localhost", 12345);

            // Set up input/output streams for communication with the server
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Prompt the user to enter a list of numbers
            System.out.print("Enter numbers separated by commas: ");
            String numbersString = inFromUser.readLine();

            // Send the list of numbers to the server
            outToServer.writeBytes(numbersString + '\n');

            // Read the sum sent by the server
            int sum = Integer.parseInt(inFromServer.readLine());
            System.out.println("Sum received from server: " + sum);

            // Close the client socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    ```
    - This is the main method where the client connects to the server running on localhost (the same machine) on port 12345.
    - It sets up input and output streams for communication with the server.
    - The user is prompted to enter a list of numbers which is then sent to the server.
    - The client then reads the sum sent by the server and prints it.
    - Finally, the client closes the connection.

### Instructions:

1. **Compilation**:
   - Compile both `TCPServer.java` and `TCPClient.java` using `javac`.

2. **Execution**:
   - Run `TCPServer` first, then run `TCPClient`.
   - The server will wait for a client to connect.
   - The client will prompt the user to enter a list of numbers and then display the sum sent back by the server.
