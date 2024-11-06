package marcoDomingues.simpleWebServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    protected void start() {
        ServerSocket s;

        System.out.println("Webserver starting up on port 8085");
        System.out.println("(press ctrl-c to exit)");
        try {
            //main server socket
            s = new ServerSocket(8085);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return;
        }

        System.out.println("Wanting for connection");
        // for (; ; ) {

        while (true) {
            try {
                //wait for connection
                Socket remote = s.accept();

                //remote is connected to the socket
                System.out.println("Connection, sending data.");
                BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
                PrintWriter out = new PrintWriter(remote.getOutputStream());

                //read the data sent.
                //stop reading once a blank line is hit.
                String str = ".";
                while (!str.equals(""))
                    str = in.readLine();

                //Send response
                //Send Headers

                out.println("HTTP/1.0 200 OK");
                out.println("Content-Type: text/html;charset=UTF-8");
                out.println("Server: Bot");

                //this blank line signals the end of the headers
                out.println("");

                //send the HTML page
                out.println("<H1>Welcome to my Site</H1>");
                out.println("<H1>è uma pequena merda, mas... dá</H3>");
                out.println("<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>");
                out.flush();


                remote.close();
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
