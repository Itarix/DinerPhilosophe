/**
 * @author: COUSIN Quentin
 * C2
 * @version: 21/02/2018
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DinerGUI extends JPanel
{

	private int nbPhil;
    private JFrame frame;
    private ArrayList<Baguette> listeBaguette ;
    private ArrayList<Philosophe> listePhilosophes ;

    public DinerGUI(int nbPhilosophe)
    {
        frame = new JFrame();
        frame.setTitle("les 5 Philosophes");
        frame.setSize(1000,800);
        frame.setLocation(50,50);

        nbPhil = nbPhilosophe;

        listeBaguette = new ArrayList<Baguette>();
        for(int i=0; i < nbPhilosophe ; i++)
        {
            listeBaguette.add(new Baguette(i+1));
        }


        listePhilosophes = new ArrayList<Philosophe>();
        for(int i=0; i<listeBaguette.size(); i++)
        {
            if (i == listeBaguette.size()-1)
            {
                listePhilosophes.add(new Philosophe(i+1,listeBaguette.get(0), listeBaguette.get(i)));
            }
            else
            {
                listePhilosophes.add(new Philosophe(i+1,listeBaguette.get(i), listeBaguette.get(i+1)));
            }
        }

        for (int i=0; i< listePhilosophes.size();i++)
        {
            listePhilosophes.get(i).start();
        }

        frame.add(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        while(true)
        {
            repaint();
        }
    }

    public void paintComponent(Graphics g)
    {
        int milieuX  = this.getWidth()/2; // millieu X du panel
        int milieuY  = this.getHeight()/2; // milieu Y du panel
        int endX, endY, startX, startY;
        int taillePhil = 40; //taille des cercles
        int size = 200; //taille des baguettes
        int nbPhilosophesCreer = 0;

        for ( int i = 0; i < nbPhil*2; i++ )
        {
            // Calcul du centre des cercles
            endX = milieuX + (int)((size)*Math.cos( (2*Math.PI/(nbPhil*2))*i ));
            endY = milieuY - (int)((size)*Math.sin( (2*Math.PI/(nbPhil*2))*i ));

            // On dessine le philosophe
            if (i % 2 == 0)
            {
                nbPhilosophesCreer++;
                if(listePhilosophes.get(nbPhilosophesCreer-1).getMange())
                {
                    g.setColor(Color.GREEN); // mange
                }
                else if (listePhilosophes.get(nbPhilosophesCreer-1).getPense())
                {
                    g.setColor(Color.ORANGE); // pense
                }
                else
                {
                    g.setColor(Color.RED); // autre etat (ne faisant rien)
                }

                g.fillOval( endX-taillePhil/2,endY-taillePhil/2, taillePhil,taillePhil ); // remplis le cercle
                g.drawOval( endX-taillePhil/2,endY-taillePhil/2, taillePhil,taillePhil ); // dessine le contour cercle
            }
            else // sinon on dessine une baguette
            {
                // Calcul du début de la baguette
                startX = milieuX + (int)((size/2)*Math.cos( (2*Math.PI/(nbPhil*2))*i ));
                startY = milieuY - (int)((size/2)*Math.sin( (2*Math.PI/(nbPhil*2))*i ));
                g.setColor(Color.RED);
                g.drawLine(startX,startY,endX,endY); // dessine une ligne

            }
        }

    }

	/*public static void main(String[] args)
	{
		System.out.println("Mettez le nombre de philosophe que vous voulez");
		Scanner sc = new Scanner(System.in);
		int nb = sc.nextInt();
		new DinerGUI(nb);
	}*/

}
