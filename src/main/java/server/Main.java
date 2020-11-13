package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(44444);
        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new
                         InputStreamReader(socket.getInputStream()))) {
                String inputNumber;
                while ((inputNumber = in.readLine()) != null) {
                    long number = Long.parseLong(inputNumber);
                    long first = 0;
                    long second = 1;
                    for (int i = 0; i < number; i++) {
                        long result = second;
                        second = first + second;
                        first = result;
                    }
                    out.println("Рузультат: " + first);
                    if (inputNumber.equals("end")) {
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
