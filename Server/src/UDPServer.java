
// Simple UDP File Transfer Server


import java.io.*;

import java.net.*;


class UDPServer

{

    private static DatagramSocket serverSocket;


    public static void main(String args[]) throws Exception

    {

        /*

        InetAddress IPAddress = InetAddress.getByName(args[0]);

        int port =Integer.parseInt(args[1]);

        String filePath="\\output.dat";

         */


        serverSocket = new DatagramSocket(15200);

        FileOutputStream fos = new FileOutputStream(new File("D:\\output.txt"));

        byte[] buffer = new byte[500];


        try

        {

            do

            {

                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

                serverSocket.receive(receivePacket);

                //String sentence = new String( receivePacket.getData());

                //System.out.println("RECEIVED: " + sentence);

                buffer =receivePacket.getData();

                fos.write(buffer);

                //bos.write(receivePacket.getData());

                //Arrays.fill( buffer, (byte)0);

            }while(buffer[0]!=(byte)-1);



            serverSocket.close();

            if ( fos != null )

                fos.close();

            System.out.println("Done !");

        }

        catch ( Exception e)

        {

            System.out.println(e);    


        }

    }

}

