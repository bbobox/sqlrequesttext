package user_interafce;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Window extends JFrame {
	
	private static final long serialVersionUID = 8799814155423117081L;
	private BorderLayout layout;
	private CentralWidget cw;
	
	private Window() throws IOException
    {
		layout = new BorderLayout();
		cw = new CentralWidget();
        initUI();
    }
	private void initUI(){
		this.setLayout(layout);
		this.setTitle("Transducteur Langage Naturel ->Requette SQL");
	    // Taille de la frame
	    this.setSize(780, 500);
	    // Placer au centre de l'ecran
	    this.setLocationRelativeTo(null);
	    // Resizable ou non
	    this.setResizable(true);
        this.add(cw, BorderLayout.CENTER);
        // Action a la fermeture (croix)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setVisible(true);
	}

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					new Window();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

    
    
}