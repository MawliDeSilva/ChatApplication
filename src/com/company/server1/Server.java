package com.company.server1;

import com.company.server1.ClientHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private JPanel panel1;
    private JTextArea txtAServer;
    private JTextField txtServer;
    private JButton btnServer;

    public Server(){
        txtAServer.append("Server is running .. \n");
        btnServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtAServer.append("\n"+txtServer.getText());
                txtServer.setText("");
                System.out.println("Server is running");

            }
        });

    }

    public static void main(String[] args) throws IOException, InterruptedException { // main thread
        Server server = new Server();
        JFrame frame = new JFrame("Server");
        frame.setContentPane(server.panel1);
        frame.setSize(300,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
        frame.setVisible(true);

        // write your code here

        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server socket created");

//        Server server=new Server();

        String data=server.txtServer.getText();

        while (true) {
            //server is running forever

            Socket client = serverSocket.accept();// wait until a client connects
            System.out.println("Server accepted a client");
            com.company.server1.ClientHandler clientHandler = new ClientHandler(client,server.txtAServer);
            Thread thread = new Thread(clientHandler);
            thread.start();

        }

        //send some data to client
        /*DataOutputStream outputStream= new DataOutputStream(client.getOutputStream());
        outputStream.writeBytes("Hello from server...\n");*/

        //inputStream and outputstream


    }

}
