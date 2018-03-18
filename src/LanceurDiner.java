import java.util.Scanner;

public class LanceurDiner
{
	public static void main(String[] args)
	{
		System.out.println("Saisissez le nombre de philosophes :");
		Scanner sc = new Scanner(System.in);
		int nb = sc.nextInt();

		System.out.println("Saisissez le mode Console (CUI) OU Graphique (GUI) : ");
		Scanner scIhm = new Scanner(System.in);
		String ihm = scIhm.next();

		if ( ihm.equalsIgnoreCase("CUI") ) new DinerCUI(nb);
		else if (ihm.equalsIgnoreCase("GUI")) new DinerGUI(nb);
	}
}