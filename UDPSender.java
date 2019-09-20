import java.net.*;
import java.util.Scanner;

public class UDPSender {
private final static int PACKETSIZE = 100 ;
	public static void main(String[] args) 
   {
	      // Check the arguments
	      if( args.length != 3 ) //increase to 3
	      {
	         System.out.println( "usage: java UDPSender host port" ) ;
	         return ;
	      }
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port         = Integer.parseInt( args[1] ) ;
		 int n         = Integer.parseInt( args[2] ) ;
	         socket = new DatagramSocket() ;
     
	         Scanner in;
	         in = new Scanner (System.in);
	         String message = null;
	         for (int i = 0; i < n; i++)
	         {
	        		 //System.out.println("Enter text to be sent, ENTER to quit ");
	        		 //message = in.nextLine();
				 message = "message" + (i+1);
	        		 byte [] data = message.getBytes() ;
	        		 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        		 socket.send( packet ) ;
				 
				 System.out.println("Waiting for ACK...");
				 packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);
				 recv_socket.receive(packet);
				System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()).trim() ) ;
	         } 
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

