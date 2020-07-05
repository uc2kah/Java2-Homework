package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int SERVER_PORT = 443;
    private static final String END_MESSAGE = "/end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Socket socket;

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread recieve = new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        System.out.println("Received: " + str);
                        if (str.equalsIgnoreCase(END_MESSAGE)) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Thread send = new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            recieve.start();
            send.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}