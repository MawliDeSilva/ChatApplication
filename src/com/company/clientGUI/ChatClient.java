package com.company.clientGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatClient {

    private JPanel panel1;
    private JTextField txtClient1;
    private JButton btnClient1;
    private JTextArea txtAClient1;
    private Client client;

    public ChatClient(Client client) {
        this.client = client;
        txtAClient1.append("Client is running .. ");
        btnClient1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                txtAClient1.append("\n" + txtClient1.getText());

                /*Client client=new Client();
                try {
                    client.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }*/

//                ChatClient chatclient=new ChatClient();

                String message=txtClient1.getText(); // read user input
                txtAClient1.append(message+"\n");
                txtClient1.setText("");

                try {
                    client.sendMessage(message);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                if(message.equals("exit")){
                    System.out.println("Client finished execution");
                    txtAClient1.append("Client finished execution...");
                }



            }
        });


    }

    public static void main(String[] args) throws IOException {
        Client client=new Client();
        try {
            client.start();

            ChatClient chatClient = new ChatClient(client);
            client.setData(chatClient.txtAClient1);
            JFrame frame = new JFrame("Chat Client");
            frame.setContentPane(chatClient.panel1);
            frame.setSize(300, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (IOException e1) {
            e1.printStackTrace();
        }






    }
}