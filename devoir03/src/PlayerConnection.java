import java.io.*;
import java.net.*;


public class PlayerConnection extends Thread {

	boolean isPartieEnCours;
	int gridwidth; 
	int gridheight;
	
	private Socket clientSocket;
	private BufferedReader in;
	private PrintWriter out;
	
	/**
	 * Constructeur de la classe qui Établissez la socket de connection, et construisez les stream 
	 * d'entrée et sortie pour communiquer
	 * @param clientSocket
	 * @throws ConnectionException
	 */
	 public PlayerConnection(Socket clientSocket, int gridwidth, int gridheight) throws ConnectionException {
		 this.clientSocket = clientSocket;
		 this.gridwidth=gridwidth;
		 this.gridheight=gridheight;
		 
		 
		 try {
			 in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		     out = new PrintWriter(clientSocket.getOutputStream());
		 }
		 catch (IOException e) {
			 System.err.println("Exception en ouvrant les streams du client: " + e);
		     throw new ConnectionException(e);
		 }
	 }
	 
	 /*************************************nao sei se tem que usar esse trem nao*********************************/
	 protected void finalize() {
		 try {
			 // cleanup
		     out.close();
		     in.close();
		     clientSocket.close();
		 }
		 catch (IOException e) {
			 System.err.println("IOException en fermant les stream et le socket client" + e);
		 }
	 }

	@Override
	public void run() {
		
		try {
			//Lit le username du joueur evoyé par le client
			String login = in.readLine();
			
			//découvrir le nom de machine du client
			String nom_de_machine = clientSocket.getInetAddress().getHostName();
			
			//
			
			
			
			
			
			/********************************fazer uma execao que presta, pfvr*******************************/	
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
		
	}
}







class ConnectionException extends Exception { 
	  Exception e;
	  ConnectionException(Exception e) { this.e = e; }
	  ConnectionException(String msg) { super(msg); e=this; }
	}
