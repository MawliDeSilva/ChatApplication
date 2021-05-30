package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler  implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket){
        this.client=socket;
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

            //continuous reading of data from client
            String inputData;
            String reply;

            while((inputData=bufferedReader.readLine())!=null){

                System.out.println("Data from client :" + inputData);

                /*reply=scanner.nextLine();
                outputStream.writeBytes(reply);*/

                switch(inputData){
                    case "Hello From the Client":
                        outputStream.writeBytes("Hello from the server..\n");
                        break;
                    case "How are you ?":
                        outputStream.writeBytes("I'm fine. How are you? \n");
                        break;
                    case "I'm fine":
                        outputStream.writeBytes("Okay.Good to know \n");
                        break;
                    case "Thank u":
                        outputStream.writeBytes("You are welcome \n");
                        break;
                    default:
                        outputStream.writeBytes("I don't understand that \n");
                }

                if(inputData.equals("exit")){
                    outputStream.writeBytes("Bye\n");
                    break;
                }

                /*if(inputData.equals("bye")){
                    outputStream.writeBytes("Bye..\n");
                    break;
                }*/
            }
            //receive data
            this.client.close();

        } catch ( IOException e) {
            e.printStackTrace();
        }
    }


    //two ways to create a thread in java
    //1. Extend the class using thread Super class
    //2. Implement the class using runnable interface
}
