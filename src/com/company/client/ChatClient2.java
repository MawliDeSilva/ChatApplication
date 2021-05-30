package com.company.client;
import java.util.Scanner;

import java.io.IOException;

public class ChatClient2 {

    public static void main(String[] args) throws IOException {

        Client client=new Client();
        client.start();

        Scanner scanner = new Scanner(System.in); // create scanner object
        String message="";

        while(!message.equals("exit")) {
                message = scanner.nextLine(); // read user input
                client.sendMessage(message);
        }

        System.out.println("Client finished execution");

    }
}
