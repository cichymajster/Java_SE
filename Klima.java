package klima;
// ctr+shift+o dodaje auto
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Klima extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	GridBagConstraints gbc = new GridBagConstraints();	
	JLabel TP_Text_Title;

	public Klima(){
		//Define main window
		setSize (600,500);
		setTitle ("Rejestr klimatyzacji");
		
		//Define layout
		setLayout(new GridBagLayout());

		//Text display
		JLabel TP_Text_Title = new JLabel("Rejestr Klimatyzacji");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(TP_Text_Title, gbc); 
		
		JLabel TP_Text_Data = new JLabel("Data");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(TP_Text_Data, gbc); 
		
		JLabel TP_Text_Nr = new JLabel("Nr rejestracyjny");
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(TP_Text_Nr, gbc); 
		
		JLabel TP_Text_Uslugi = new JLabel("Zastosowane dzia³anie");
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(TP_Text_Uslugi, gbc); 
		
		JLabel TP_Text_StanWprzed = new JLabel("Stan wagi przed");
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(TP_Text_StanWprzed, gbc); 
		
		JLabel TP_Text_StanWpo = new JLabel("Stan wagi po");
		gbc.gridx = 0;
		gbc.gridy = 5;
		add(TP_Text_StanWpo, gbc); 
		
		//Add text-field
		JTextField T_Data = new JTextField(20);
		//Set parametrs from data()
		T_Data.setText(data());
		//
		T_Data.setSize(300, 20);
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(T_Data, gbc);
		
		JTextField T_Nr = new JTextField(20);
		T_Nr.setSize(300, 20);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(T_Nr, gbc);
		
		JTextField T_Uslugi = new JTextField(20);
		T_Uslugi.setSize(300, 20);
		gbc.gridx = 2;
		gbc.gridy = 3;
		add(T_Uslugi, gbc);
		
		JTextField T_StanWprzed = new JTextField(20);
		T_StanWprzed.setSize(300, 20);
		gbc.gridx = 2;
		gbc.gridy = 4;
		add(T_StanWprzed, gbc);
		
		JTextField T_StanWpo = new JTextField(20);
		T_StanWpo.setSize(300, 20);
		gbc.gridx = 2;
		gbc.gridy = 5;
		add(T_StanWpo, gbc);
	
		//Add button
		JButton B_Dodaj = new JButton("Dodaj do rejestru");
		gbc.gridx = 2;
		gbc.gridy = 6;
		add(B_Dodaj, gbc);
		
		//Crate and check file
		File f = new File("baza.txt");
		if(!f.exists() && !f.isDirectory()) { 
			System.out.println("plik istnieje");
			try{
			    PrintWriter baza = new PrintWriter("baza.txt", "UTF-8");
			    baza.close();
			} catch (IOException e) {
			   // do something
			}
			
		}
		
		//Obsluga zdarzen 
		T_Data.addMouseListener(new MouseAdapter()
	    {
	        public void mouseClicked(MouseEvent e)
	        {
	        	 T_Data.setText("");
	        }
	    });
		
		
		B_Dodaj.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e)
	        {
	        	String newLine = System.getProperty("line.separator");
	        	String  d_Data = T_Data.getText();
	        	String  d_Nr = T_Nr.getText();
	        	String  d_Uslugi = T_Uslugi.getText();
	        	int  d_StanWprzed = Integer.parseInt(T_StanWprzed.getText());
	        	int  d_StanWpo= Integer.parseInt(T_StanWpo.getText());

System.out.println(d_Data+newLine+d_Nr+newLine+d_Uslugi+newLine+d_StanWprzed+newLine+d_StanWpo);
	        }
	    });
		
		

	}

	//Podaje aktualna date
	public static String data(){
		Date Adata = new Date();
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
		String Data = dataFormat.format(Adata);	
		return(Data);
	}




	

	public static void main(String[] args) {
		Klima window = new Klima();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		//System.out.println(data());
		
	}
/*
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String Write_Nr = Write_Nr.getTex(T_Nr);
	}
	
	*/

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
