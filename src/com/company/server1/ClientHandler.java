package com.company.server1;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    private Socket client;
    private JTextArea data;

    public ClientHandler(Socket socket,JTextArea data ){
        this.client=socket;
        this.data=data;
    }

    @Override
    public void run() {
        try {
            //Thread.sleep(30000); //waits for 20 seconds before executing the rest of the code
            //Get data from client
            InputStream inputStream=client.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            //send
            DataOutputStream outputStream= new DataOutputStream(client.getOutputStream());

            //read data once
            /*String data=bufferedReader.readLine();
            System.out.println("Data received from client" + data);*/

            Scanner scanner=new Scanner(System.in);

            //continous reading of data from client
            String inputData;
            String reply;

            while((inputData=bufferedReader.readLine())!=null){

                System.out.println("Data from client :" + inputData);

//                reply=data;
//                outputStream.writeBytes(reply);

                switch(inputData){
                    case "Hello From the Client":
                        outputStream.writeBytes("Hello from the server..\n");
                        data.append("Hello from the server.. \n");
                        break;
                    case "How are you ?":
                        outputStream.writeBytes("I'm fine. How are you? \n");
                        data.append("I'm fine. How are you?\n");
                        break;
                    case "I'm fine":
                        outputStream.writeBytes("Okay.Good to know \n");
                        data.append("Okay.Good to know \n");
                        break;
                    case "Thank u":
                        outputStream.writeBytes("You are welcome \n");
                        data.append("You are welcome\n");
                        break;
                    default:
                        outputStream.writeBytes("I don't understand that \n");
                        data.append("I don't understand that\n");
                }

                if(inputData.equals("exit")){
                    outputStream.writeBytes("Bye\n");
                    data.append("Bye");
                    break;
                }

            }
            //receive data
            this.client.close();

        } catch ( IOException e) {
            e.printStackTrace();
        }
    }


}
