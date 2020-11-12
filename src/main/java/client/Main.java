package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 44444);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String number;
            while (true) {
                System.out.println("Введите число для получения числа Фиббоначи...");
                number = scanner.nextLine();
                out.println(number);
                if ("end".equals(number)) break;
                System.out.println("Ответ от сервера: " + in.readLine());
            }
        }
    }
}
