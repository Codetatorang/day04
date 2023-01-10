package day04;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;

public class Client {
    public static void main(String[]args) throws IOException{
        //Connect ot he server listening on port 3000
        //127.0.01 or localhost means my local computer
        Socket clientConn = new Socket("127.0.0.1", 3000);

        System.out.println("Connected to server on localhost:3000");

        //Console
        Console cons = System.console();
        String line = cons.readLine("What would like to uppercase? ");

        //Do something
        //Get the output stream to write to the server.
        OutputStream os = clientConn.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        
        // Writer wr = new OutputStreamWriter(os);
        // wr.write(line);
        // wr.flush();
        
        // get the input stream from the server
        InputStream is = clientConn.getInputStream();
        Reader r = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(r);
        String returnedString = br.readLine();
        System.out.printf("your message %s is converted into %s \n: ", line, returnedString);
        //Close connection
        clientConn.close();

    }
}
