import java.awt.Color;

public class TronPlayer {
	
	public String nomU, nomM; // nom utilisateur et nom machine
	public Color c; // couleur du joueur
	public int pDX, pDY; // position de départ du joueur
	
	
	/** Constructeur pour le joueur
	 * 
	 * @param nomUtilisateur : nom de l'utilisateur
	 * @param nomMachine : nom de la machine
	 * @param couleur : couleur du joueur
	 * @param positionDepartX : coordonnée horizontale de de la position initial du joueur
	 * @param positionDepartY : coordonnée verticale de de la position initial du joueur
	 */
	public TronPlayer(String nomUtilisateur, String nomMachine, Color couleur, int positionDepartX, int positionDepartY){
		
		this.nomU = nomUtilisateur;
		this.nomM = nomMachine;
		this.c = couleur;
		this.pDX = positionDepartX;
		this.pDY = positionDepartY;	
	}
	

}
