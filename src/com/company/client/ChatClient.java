package com.company.client;

import java.io.IOException;

public class ChatClient {

    public static void main(String[] args) throws IOException {

        Client client=new Client();
        client.start();

        client.sendMessage("Hello");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine");
        client.sendMessage("Thank u");
        client.sendMessage("exit");

        System.out.println("Client finished execution");

    }







}
