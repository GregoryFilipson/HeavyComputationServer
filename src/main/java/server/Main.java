package server;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

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
                    int number = Integer.parseInt(inputNumber);
                    int first = 0;
                    int second = 1;
                    for (int i = 0; i < number; i++) {
                        int result = second;
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
