import java.net.*;

public class URLExample {
    public static void main(String[] args) {
        try {
            // Create a URL object representing a webpage
            URL url = new URL("https://www.example.com/index.html?query=java");

            // Display various components of the URL
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());

            // Open a connection to the URL and read from it
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the content of the webpage
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer content = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            // Display the content of the webpage
            System.out.println("Content of the webpage:");
            System.out.println(content.toString());

            // Disconnect the connection
            connection.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading from URL: " + e.getMessage());
        }
    }
}
