
// Simple UDP File Transfer Server


import java.io.*;
import java.net.*;


class UDPServer

{
	private DatagramSocket serverSocket;
	private int port;



	public UDPServer(int parseInt) {
		port = parseInt;

	}

	public void receiveFile() throws IOException 
	{
		//RunTCP();
		
		serverSocket = new DatagramSocket(port);

		FileOutputStream fos = new FileOutputStream(new File("D:\\output.dat"));
		
		
		byte[] buffer = new byte[500];
		
		long startTime = 0;
		try
		{
			do
			{

				DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
				
				System.out.println("Server Waiting");
				startTime = System.currentTimeMillis();

				serverSocket.receive(receivePacket);

				fos.write(buffer);

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
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Running Time : "+totalTime + "milli soconds"); 
	}
	
	private void RunTCP() throws IOException
	{
		// TODO Auto-generated method stub
		ServerSocket TCPSocket = new ServerSocket(port);
		FileOutputStream fos = new FileOutputStream(new File("D:\\output.txt"));
		long startTime = 0;
		byte[] buffer = new byte[500];

		try
		{
			Socket socket = TCPSocket.accept();
			do
			{
				
				System.out.println("Server has Connected");
				startTime = System.currentTimeMillis();
				DataInputStream  input = new DataInputStream(socket.getInputStream());
				
				input.read(buffer);
				
				fos.write(buffer);
			}
			while(buffer[0] != (byte)-1);
			
			TCPSocket.close();

			if ( fos != null )
				fos.close();

			System.out.println("Done !");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Running Time : "+totalTime + "milli soconds");
	}
}
