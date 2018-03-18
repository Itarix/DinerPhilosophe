/**
 * @author: COUSIN Quentin
 * C2
 * @version: 21/02/2018
 */

/**
 * ATTENTION : Cette classe n'est pas utilisé pour que le programme fonctionne.
 * En effet cette classe fait planter le paintComponant du DinerPanel.
 * Je la laisse pourtant dans l'archive pour montrer que j'ai voulu faire un effort pour l'ihm en intégrant un JSpinner pour choisir un nombre
 * de Philosophe en mode GUI
 * Pour ne pas faire d'erreur, j'ai commenté le main de cette classe
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanceurDinerGUI extends JFrame implements ActionListener
{
	private static JSpinner jsp;
	private static SpinnerNumberModel snm;
	private static JButton bouton;

	public LanceurDinerGUI()
	{

		this.setTitle("Selection nb Philosophe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		snm = new SpinnerNumberModel(5, 2, 500, 1);
		jsp = new JSpinner(snm);
		bouton = new JButton("Valider");

		bouton.addActionListener(this);
		this.setLayout(new BorderLayout());

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(1,3));
		jPanel.add( new JLabel("Choisir le nombre de Philosophe"));
		jPanel.add(jsp);
		jPanel.add(bouton);


		this.add(jPanel);
		pack();
		this.setLocation(400,200);
		this.setVisible(true);
	}

	/*public static void main(String[] args) {
		new LanceurDinerGUI();
	}*/

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if ( e.getSource()== bouton)
		{
			this.dispose();
			new DinerGUI( (Integer)jsp.getValue() );
		}
	}
}