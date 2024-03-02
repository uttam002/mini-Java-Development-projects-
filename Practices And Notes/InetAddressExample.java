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
