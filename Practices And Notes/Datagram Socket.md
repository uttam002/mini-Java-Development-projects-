***What is Datagram Socket? Explain it with the help of example.give smallest code***

A DatagramSocket in Java is a mechanism for sending and receiving network packets using the User Datagram Protocol (UDP). Unlike TCP, which provides a reliable, ordered, and error-checked connection between applications, UDP is a connectionless protocol that offers best-effort delivery of packets. Datagram sockets are often used in scenarios where low overhead and real-time communication are more important than guaranteed delivery.

Here's a simple example of how to create a DatagramSocket in Java:

```java
import java.net.*;

public class DatagramSocketExample {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket object bound to any available port
            DatagramSocket socket = new DatagramSocket();

            // Specify the destination address and port to send the datagram packet
            InetAddress destinationAddress = InetAddress.getByName("127.0.0.1");
            int destinationPort = 12345;

            // Create a message to be sent as a byte array
            String message = "Hello, DatagramSocket!";
            byte[] sendData = message.getBytes();

            // Create a DatagramPacket with the message, destination address, and port
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, destinationAddress, destinationPort);

            // Send the DatagramPacket through the DatagramSocket
            socket.send(packet);

            System.out.println("Message sent: " + message);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

In this example:
- We create a DatagramSocket object without specifying a port, so it will be bound to any available port on the local machine.
- We specify the destination address (`127.0.0.1` in this case, which is the localhost) and port (`12345`) where the datagram packet will be sent.
- We create a message as a string and convert it to a byte array.
- We create a DatagramPacket containing the message, destination address, and port.
- We send the DatagramPacket through the DatagramSocket.
- Finally, we close the socket.

This example demonstrates sending a message using a DatagramSocket. However, to receive messages, you would need to create another DatagramSocket and listen on a specific port for incoming packets.
