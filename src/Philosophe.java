/**
 * @author: COUSIN Quentin
 * C2
 * @version: 21/02/2018
 */

public class Philosophe extends Thread
{
    private int id;
    private Baguette b1, b2;
    private boolean mange = false;
    private boolean pense = false;

    public Philosophe(int id, Baguette b1, Baguette b2)
    {
        this.id = id;
        this.b1 = b1;
        this.b2 = b2;
    }

    public void manger()
    {
		try
		{
			mange = true;
			System.out.println("Le philosophe " + id + " est entrain de manger \n");
			Thread.sleep(2000);
			mange = false;
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
    }

    public void reflechir()
    {
    	try {
			pense = true;
			System.out.println("Philosophe " + id + " commence à réfléchir \n ");
			Thread.sleep(2000);
			pense = false;
		} catch ( InterruptedException e)
		{
			e.printStackTrace();
		}
    }

    public boolean getMange()
    {
        return this.mange;
    }
    public boolean getPense() { return this.pense; }

    public void run()
    {
        while (true)
        {
            try
            {
				if(b1.prendBaguette())
				{
					if(b2.prendBaguette())
					{
						System.out.println("\nLe philosophe " + id + " a pris les baguettes");
						manger();

						b1.poserBaguette(id);
						b2.poserBaguette(id);
						Thread.sleep(2000);
					}
					else
					{
						System.out.println("Le philosophe " + id + " n'a pas pu prendre son autre baguette") ;
						b1.poserBaguette(id);
						reflechir();
					}
				}
				else
				{
					System.out.println("Le philosophe " + id + " n'a pas pu prendre les baguettes") ;
					reflechir();
				}
                Thread.sleep(2000);
            }
            catch (InterruptedException ie) {}
        }
    }
}