
public class TronServer {

	

	public static void main(String[] args){
		
		int serverPort;
		int clocktick;
		int gridwidth;
		int gridheight;
		
		//on verifie s'il y a seulement 4 elements en args		
		if (args.length!=4) {	     
			System.out.println("Usage: java TronServeur <serverport> <clocktick> <gridwidth> <gridheight>"); 	     
			System.exit(0);	
		} else{	
			serverPort = Integer.parseInt(args[0]);	
			clocktick = Integer.parseInt(args[1]);		
			gridwidth = Integer.parseInt(args[2]);		
			gridheight = Integer.parseInt(args[3]);		
		}
		
		
	}
}
