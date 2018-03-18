/**
 * @author: COUSIN Quentin
 * C2
 * @version: 21/02/2018
 */

import java.util.concurrent.Semaphore;

public class Baguette
{
    private int id ;
    private Semaphore disponible= new Semaphore(1, true) ;


    public Baguette(int id)
    {
        this.id = id ;
    }

    public synchronized boolean prendBaguette()
    {
        return disponible.tryAcquire() ;
    }

    public synchronized void poserBaguette(int idPhilo) throws InterruptedException
    {
        System.out.println("Philosophe " + idPhilo + " a poser la baguette " + id) ;
        disponible.release() ;
    }
}