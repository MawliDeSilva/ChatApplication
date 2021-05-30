package com.company.clientGUI;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {

    private DataOutputStream outputStream;
    private BufferedReader bufferedReader;
    private JTextArea data;

    public void start() throws IOException {
        System.out.println("Client is running");
        Socket socket = new Socket("localhost", 6000);

        this.outputStream=new DataOutputStream(socket.getOutputStream());
        InputStream inputStream= socket.getInputStream();
        this.bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
    }

    public void sendMessage(String message) throws IOException{
        System.out.println("Client says :"+ message);
        this.outputStream.writeBytes(message+"\n");
//        this.data.append(message);
        String dataFromServer=this.bufferedReader.readLine();
        System.out.println("server says : " +dataFromServer);
        this.data.append("server says : " +dataFromServer+"\n");

    }


    public JTextArea getData() {
        return data;
    }

    public void setData(JTextArea data) {
        this.data = data;
    }
}
