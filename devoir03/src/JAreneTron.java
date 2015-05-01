import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JComponent;



public class JAreneTron extends JComponent {
	
	int gridwidth, gridheight;
	ArrayList<TronPlayer> listeJoueurs;
	
	
	/**
	 * 
	 * @param w : width de l'arène
	 * @param h : height de l'arène
	 * @param listeDeJoueurs : ArrayList de TronPlayer contenant les différents joueurs actifs
	 */
	public JAreneTron(int w, int h, ArrayList<TronPlayer> listeDeJoueurs){
		
		this.gridwidth = w;
		this.gridheight = h;
		this.listeJoueurs = listeDeJoueurs;	
		
	}
	
	protected void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;		
		
		// Murs
		Rectangle box = new Rectangle(10, 10, this.getWidth()-20,this.getHeight()-25);
		g2.setColor(Color.WHITE);
		g2.draw(box);
		
		
		// Dessine les traces des joueurs
		for(int x =0; x<this.listeJoueurs.size(); x++){
			
			Trace t = this.listeJoueurs.get(x).trace; // trace du joueur
			g2.setColor(this.listeJoueurs.get(x).c);
			
			// Point de départ
			Rectangle depart = new Rectangle(this.listeJoueurs.get(x).pDX*this.gridwidth/this.getWidth(),
					this.listeJoueurs.get(x).pDY*this.gridheight/this.getHeight(), 5, 5); 
			g2.fillRect(this.listeJoueurs.get(x).pDX*this.gridwidth/this.getWidth(),
					this.listeJoueurs.get(x).pDY*this.gridheight/this.getHeight(), 5, 5);
			g2.draw(depart);
			
			// Trace dont la grandeur est proportionnelle à celle de la fenêtre
			for(int y=0; y+1 < t.longueur;y++){							
				g2.setColor(this.listeJoueurs.get(x).c);
				g2.drawLine(t.trace.get(y).coordonneeX*this.getWidth()/this.gridwidth,
						t.trace.get(y).coordonneeY*this.getHeight()/this.gridheight, 
						t.trace.get(y+1).coordonneeX*this.getWidth()/this.gridwidth, 
						t.trace.get(y+1).coordonneeY*this.getHeight()/this.gridheight);				
			}
		}		
	}	
}
