/**
 * @author: COUSIN Quentin
 * C2
 * @version: 21/02/2018
 */

import java.util.ArrayList;
import java.util.Scanner;

public class DinerCUI
{
    public DinerCUI(int nbConvives)
    {
    	int nb = nbConvives;

        ArrayList<Baguette> listeBaguette ;
        ArrayList<Philosophe> listePhilosophes ;

        listeBaguette = new ArrayList<Baguette>();
        for(int i=0; i < nb ; i++)
        {
            listeBaguette.add(new Baguette(i+1)); // boucle qui crée toutes les baguettes
        }

        listePhilosophes = new ArrayList<Philosophe>();
        for(int i=0; i<listeBaguette.size(); i++)
        {
            if (i == listeBaguette.size()-1)
            {
                listePhilosophes.add(new Philosophe(i+1,listeBaguette.get(0), listeBaguette.get(i) ) );
            }
            else
            {
                listePhilosophes.add(new Philosophe(i+1,listeBaguette.get(i), listeBaguette.get(i+1) ) );
            }
        }

        for (int i=0; i< listePhilosophes.size();i++)
        {
            listePhilosophes.get(i).start(); // boucle qui lance tout les philosophes
        }
    }

    /*public static void main(String[] arg)
    {
		System.out.println("Saisir le nombre de Philosophes : ");
		Scanner sc = new Scanner (System.in);
		int nbConvives = sc.nextInt() ;

        new DinerCUI(nbConvives) ;
    }*/
}