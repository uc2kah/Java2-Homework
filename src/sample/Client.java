package sample;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 443;
    private static final String END_MESSAGE = "/end";

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            System.out.println("Open connection. Thread: " + Thread.currentThread().getName());
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка соединения с сервером. ");
        }
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        Thread recieve = new Thread(() -> {
            System.out.println("Processing connection. Thread: " + Thread.currentThread().getName());
            try {
                while (true) {
                    String strFromServer = in.readUTF();
                    if (strFromServer.equalsIgnoreCase(END_MESSAGE)) {
                        break;
                    }
                    System.out.println("Recieved message: " + strFromServer);
                }
            } catch (Exception e) {
                System.out.println("Соединение не доступно");
                e.printStackTrace();
            }
        });
        Thread send = new Thread(() -> {
            while(true)
            {
                try {
                    out.writeUTF(scanner.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        recieve.start();
        send.start();
    }

    public static void main(String... args) {
        System.out.println("In main. Thread: " + Thread.currentThread().getName());
        System.out.println("Create client. Thread: " + Thread.currentThread().getName());
        new Client();
    }
}