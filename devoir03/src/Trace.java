import java.util.*;

public class Trace {
	
	public TronPlayer joueur;
	public int positionX, positionY;
	public List<Point> trace;
	
	/** Méthodes pour retourner la dernière position du joueur
	 * @return positionX : retourne la position horizontale
	 * @return positionY : retourne la position verticale
	 */
	public int getPosX(){return this.positionX;}
	public int getPosY(){return this.positionY;}
	
	
	
	
	/** Constructeur de la trace pour un joueur j
	 * @param j : joueur auquel la trace appartient
	 * @param initialX : coordonnée horizontale de départ du joueur
	 * @param initialY : coordonnée verticale de départ du joueur
	 */
	public Trace(TronPlayer j, int initialX, int initialY){
		
		this.joueur = j;
		this.positionX = initialX;
		this.positionY = initialY;
		
		Point p = new Point(initialX, initialY); // nouveau point servant de point de départ pour la trace
		this.trace = new LinkedList<Point>();
		this.trace.add(p);	
	}
	

	
	/** Méthode pour allonger la trace
	 * @param direction : input du joueur donnant la direction de déplacement
	 */
	public void allonge(char direction) {
		
		int x, y;
		Point nouveauPoint;
		
		switch(direction){
			case 'w': // direction vers le haut
				x = this.getPosX();
				y = this.getPosY() - 1;
				nouveauPoint = new Point(x, y);
				this.trace.add(nouveauPoint);
			case 'a': // direction vers la gauche
				x = this.getPosX() - 1;
				y = this.getPosY();
				nouveauPoint = new Point(x, y);
				this.trace.add(nouveauPoint);
			case 's': // direction vers le bas
				x = this.getPosX();
				y = this.getPosY() + 1;
				nouveauPoint = new Point(x, y);
				this.trace.add(nouveauPoint);
			case'd': // direction vers la droite
				x = this.getPosX() + 1;
				y = this.getPosY();
				nouveauPoint = new Point(x, y);
				this.trace.add(nouveauPoint);
			default:
				System.out.println("commande invalide");
		}
	}

}