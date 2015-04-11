import java.awt.event.KeyListener;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class TronClient {
	
	int gridwidth;
	int gridheight;
	
	String username;
	String machineHostName;
	String userColor;
	String xStartPoint;
	String yStartPoint;
	
	Socket socket=null;
    BufferedReader in=null;
    PrintWriter out=null;
	
	ArrayList<String> players=new ArrayList<>();
	
	
	/**
	 * Constructeur de la classe TronClient
	 * @param serverHostName
	 * @param serverPort
	 */
	public TronClient(String serverHostName, String serverPort) {
		String address = serverHostName;
		int port=Integer.parseInt(serverPort);
		
		//chercher le nom de votre machine et le nom de l'utilisateur 
		this.username = System.getProperty("user.name");
		this.machineHostName=InetAddress.getLocalHost().getHostName();
		
		/************************************COMPOSANTES GRAPHIQUES - PARTIE 2*****************************************/
		
		//Établissez la socket de connection au serveur, et construisez les stream 
		//d'entrée et sortie pour communiquer avec le serveur
		try {
		      socket = new Socket(address,port);
		      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		      out = new PrintWriter(socket.getOutputStream());
		}
		catch (IOException e) {
			System.err.println("IOException pour ouvrir le Socket ou ses streams: "+e);
		    System.exit(1);
		}
		
		try { // TRY PROTOCOLE
		      if (socket==null || in==null || out == null) {
		        System.out.println("Pas de connection au serveur: socket="+socket +", socket input stream = "+in+
		                           ", socket output stream = "+out);
		        System.exit(1);
		      }
		      
		      
		      // Envoyez le nom d'utilisateur au serveur
		      out.println(username+"\n");
		      out.flush();
		  	
		      /*Lisez les deux lignes que le serveur vous envoie comme réponse, qui vont contenir 
		       * les dimensions de la grille virtuelle de jeu, convertissez-les en entier, et 
		       * mettez à jour les propriétés gridwidth et gridheight de votre classe.
		       */
		      String answer1=in.readLine();
		      String answer2=in.readLine();
		      this.gridwidth=Integer.parseInt(answer1);
		      this.gridheight=Integer.parseInt(answer2);
		      
		      

		}
		catch (IOException e) { // pour TRY PROTOCOLE
			System.err.println("Exception: I/O error trying to talk to server: "+ e);
		}
		
		/*****************************COMPOSANTES GRAPHIQUES - PARTIE 4**************************************/
		//appel à la méthode
		handleServerMessages();

	}
	
	/***************************************************PARTIE 3***********************************************/
	
	/**
	 * 
	 */
	private void handleServerMessages() {
		//boucle infinie
		while(true){
			try {
				String FirstLine = in.readLine();
				if(FirstLine.charAt(0)=='s'){
					//o que acontece
				}
				else if(FirstLine.charAt(0)=='+'){
					//o que acontece
				}
				if(FirstLine.charAt(0)=='R'){
					//o que acontece
				}
			/********************************fazer uma execao que presta, pfvr*******************************/
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}









	public static void main(String[] args){
		
		//on verifie s'il y a seulement 2 elements en args, si oui, on instancie un objet type TronClient
		if (args.length!=2) {
		      System.out.println("Usage: java Client <hostname> <port>"); 
		      System.exit(0);
		} else
			new TronClient(args[0],args[1]);
		
		  
	}
}