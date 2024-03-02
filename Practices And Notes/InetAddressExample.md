```java
import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            String host = "www.google.com";
            InetAddress address = InetAddress.getByName(host);
            System.out.println("IP address for " + host + ": " + address.getHostAddress());
            System.out.println("Is " + host + " reachable? " + address.isReachable(5000));
            System.out.println("Canonical host name: " + address.getCanonicalHostName());
            System.out.println("Is loopback address? " + address.isLoopbackAddress());
            System.out.println("Is multicast address? " + address.isMulticastAddress());
            byte[] rawBytes = address.getAddress();
            System.out.print("Raw IP address: ");
            for (byte b : rawBytes) {
                System.out.print((b & 0xFF) + ".");
            }
            System.out.println();
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### Explanation of the Code:

1. **Import Statements**:
   - `import java.net.*;`: This imports all classes from the `java.net` package, including the `InetAddress` class.

2. **Class Declaration**:
   - `public class InetAddressExample { ... }`: Defines a public class named `InetAddressExample`.

3. **Main Method**:
   - `public static void main(String[] args) { ... }`: The entry point of the program.

4. **Try-Catch Block**:
   - `try { ... } catch (UnknownHostException e) { ... } catch (Exception e) { ... }`: This block handles potential exceptions that may occur during execution, such as `UnknownHostException` and general exceptions.

5. **Retrieving IP Address**:
   - `InetAddress address = InetAddress.getByName(host);`: Retrieves the IP address associated with the specified host name (`www.google.com` in this case).

6. **Printing IP Address**:
   - `System.out.println("IP address for " + host + ": " + address.getHostAddress());`: Prints the retrieved IP address of the specified host.

7. **Checking Reachability**:
   - `System.out.println("Is " + host + " reachable? " + address.isReachable(5000));`: Checks if the specified host is reachable within the given timeout (5 seconds in this case).

8. **Canonical Host Name**:
   - `System.out.println("Canonical host name: " + address.getCanonicalHostName());`: Prints the canonical host name associated with the IP address.

9. **Loopback Address Check**:
   - `System.out.println("Is loopback address? " + address.isLoopbackAddress());`: Checks if the IP address is a loopback address.

10. **Multicast Address Check**:
    - `System.out.println("Is multicast address? " + address.isMulticastAddress());`: Checks if the IP address is a multicast address.

11. **Raw IP Address**:
    - `byte[] rawBytes = address.getAddress();`: Retrieves the raw IP address bytes.
    - `for (byte b : rawBytes) { System.out.print((b & 0xFF) + "."); }`: Prints the raw IP address in a human-readable format.

### Additional Methods with Examples:

#### `getHostName()` Method:
This method retrieves the host name corresponding to the IP address.

```java
System.out.println("Host name: " + address.getHostName());
```

#### `getAddress()` Method:
This method retrieves the raw IP address bytes in the form of an array.

```java
byte[] rawAddress = address.getAddress();
```
#### `getCanonicalHostName()` Method:
This method retrieves the fully qualified domain name (FQDN) for the IP address.

```java
System.out.println("Canonical host name: " + address.getCanonicalHostName());
```

#### `getLocalHost()` Method:
This method retrieves the `InetAddress` object that represents the localhost.

```java
InetAddress localHost = InetAddress.getLocalHost();
System.out.println("Local host name: " + localHost.getHostName());
System.out.println("Local host address: " + localHost.getHostAddress());
```

These are a few additional methods that can be useful when working with `InetAddress` objects in Java. They provide functionality to retrieve various information related to IP addresses and host names.
