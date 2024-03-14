***Explain Socket, ServerSocket, InetAddress classes. Write a java program to find an IP address of the machine on which the program runs***

### 1. Socket Class:
The `Socket` class represents a client-side endpoint for communication with a server. It encapsulates the connection to a remote host over a network and provides methods for sending and receiving data through input/output streams.

### 2. ServerSocket Class:
The `ServerSocket` class represents a server-side endpoint that waits for incoming client connections. It listens for client connection requests on a specific port and, upon accepting a connection, creates a new `Socket` object through which the server communicates with the client.

### 3. InetAddress Class:
The `InetAddress` class represents an IP address, whether it's an IPv4 or IPv6 address. It provides methods for converting between domain names and IP addresses, as well as getting the hostname and canonical hostname associated with an IP address.

Now, let's write a Java program to find the IP address of the machine on which the program runs using the `InetAddress` class:

```java
import java.net.*;

public class IPAddressFinder {
    public static void main(String[] args) {
        try {
            // Get the local host InetAddress object
            InetAddress localhost = InetAddress.getLocalHost();

            // Print the IP address
            System.out.println("IP Address of this machine: " + localhost.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Error: Unable to determine the IP address of this machine.");
            e.printStackTrace();
        }
    }
}
```

In this program:

- We import the `java.net` package to access networking-related classes.
- We use the `getLocalHost()` method of the `InetAddress` class to obtain an `InetAddress` object representing the local host (the machine on which the program is running).
- We then use the `getHostAddress()` method to retrieve and print the IP address of the local host.
- If an exception occurs during the process (such as if the IP address cannot be determined), we catch and handle the exception accordingly.

When you run this program, it will print out the IP address of the machine on which it is executed.
