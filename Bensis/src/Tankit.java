import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.JProgressBar;

public class Tankit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel labelBensa1;
	private JLabel labelBensa2;
	private JLabel labelBensa3;
	private JLabel lbl95Amount;
	private JLabel lbl97Amount;
	private JLabel lblDieselAmount;
	private JTextField textFieldE95;
	private JTextField textFieldE97;
	private JTextField textFieldDiesel;
	private JButton nappie95;
	private JButton nappiE97;
	private JButton nappiDiesel;
	private JButton nappiClear;
	private JLabel lblOhjaaKayttajaa;
	
	
	
	private JLabel lblKertooBensa;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmAsemanTankit;
	private JMenuItem menuLopetus;
	private JProgressBar progressBar;
	private JProgressBar progressBar2;
	private JProgressBar progressBar3;
	
	static String[] list = {"src/Files/Tilaukset.txt", "src/Files/BensaTankit.txt"};
	
	String E95 = "E95";
	String E97 = "E97";
	String Diesel = "Dieselii";
	private JLabel lblNewLabel_4;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tankit frame = new Tankit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tankit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tankit.class.getResource("/Pictures/gas station.png")));
		setTitle("Tankit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 534);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmAsemanTankit = new JMenuItem("Aseman tankit");
		mntmAsemanTankit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Aseman tankit paneeli aukeaa
				
			}
		});
		menuBar.add(mntmAsemanTankit);
		
		mntmNewMenuItem_1 = new JMenuItem("Hinnasto");
		menuBar.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem = new JMenuItem("Lisää myynti");
		menuBar.add(mntmNewMenuItem);
		
		menuLopetus = new JMenuItem("Lopetus");
		menuLopetus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Haluatko varmasti lopettaa", "Lopetus?", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						System.exit(0);
						//System.out.println("Ok painettu");
					}
					if (result == JOptionPane.NO_OPTION) {
						// System.out.println("No painettu");
					}
			}
		});
		menuBar.add(menuLopetus);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Varoitus tulee, jos on alle 200 litraa tankissa");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 328, 347, 20);
		contentPane.add(lblNewLabel_4);
		
		progressBar3 = new JProgressBar();
		progressBar3.setBackground(Color.WHITE);
		progressBar3.setForeground(Color.GREEN);
		progressBar3.setMaximum(5000);
		progressBar3.setBounds(235, 241, 140, 20);
		progressBar3.setValue(Integer.parseInt((lueMaara(3)))); // Saada funktiosta return String ja muutetaan luvuksi
		contentPane.add(progressBar3);
		
		progressBar2 = new JProgressBar();
		progressBar2.setBackground(Color.WHITE);
		progressBar2.setForeground(Color.GREEN);
		progressBar2.setMaximum(5000);
		progressBar2.setBounds(235, 177, 140, 20);
		progressBar2.setValue(Integer.parseInt((lueMaara(2)))); // Saada funktiosta return String ja muutetaan luvuksi
		contentPane.add(progressBar2);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.GREEN);
		progressBar.setMaximum(5000);
		progressBar.setBounds(235, 125, 140, 20);
		progressBar.setValue(Integer.parseInt((lueMaara(1)))); // Saada funktiosta return String ja muutetaan luvuksi
		contentPane.add(progressBar);
		
		lblNewLabel_3 = new JLabel("Tankin maximi kapasiteetti on 5000 litraa");
		lblNewLabel_3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(10, 291, 347, 32);
		contentPane.add(lblNewLabel_3);
		
		labelBensa1 = new JLabel("Bensiini E95");
		labelBensa1.setForeground(Color.WHITE);
		labelBensa1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		labelBensa1.setBounds(10, 125, 116, 20);
		contentPane.add(labelBensa1);
		
		labelBensa2 = new JLabel("Bensiini E97");
		labelBensa2.setForeground(Color.WHITE);
		labelBensa2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		labelBensa2.setBounds(10, 177, 116, 20);
		contentPane.add(labelBensa2);
		
		labelBensa3 = new JLabel("Diesel");
		labelBensa3.setForeground(Color.WHITE);
		labelBensa3.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		labelBensa3.setBounds(10, 236, 116, 20);
		contentPane.add(labelBensa3);
		
		lbl95Amount = new JLabel(lueMaara(1));
		lbl95Amount.setForeground(Color.WHITE);
		lbl95Amount.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lbl95Amount.setBounds(136, 125, 105, 20);
		contentPane.add(lbl95Amount);
		
		lbl97Amount = new JLabel(lueMaara(2));
		lbl97Amount.setForeground(Color.WHITE);
		lbl97Amount.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lbl97Amount.setBounds(136, 177, 105, 20);
		contentPane.add(lbl97Amount);
		
		lblDieselAmount = new JLabel(lueMaara(3));
		lblDieselAmount.setForeground(Color.WHITE);
		lblDieselAmount.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblDieselAmount.setBounds(136, 241, 105, 20);
		contentPane.add(lblDieselAmount);
		
		textFieldE95 = new JTextField();
		textFieldE95.setBackground(Color.WHITE);
		textFieldE95.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		textFieldE95.setColumns(10);
		textFieldE95.setBounds(399, 127, 140, 32);
		contentPane.add(textFieldE95);
		
		textFieldE97 = new JTextField();
		textFieldE97.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		textFieldE97.setColumns(10);
		textFieldE97.setBounds(399, 181, 140, 32);
		contentPane.add(textFieldE97);
		
		textFieldDiesel = new JTextField();
		textFieldDiesel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		textFieldDiesel.setColumns(10);
		textFieldDiesel.setBounds(399, 240, 140, 32);
		contentPane.add(textFieldDiesel);
		
		nappie95 = new JButton("Tilaa E95");
		nappie95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//E95 napin action
				try {
					String luku2 = textFieldE95.getText();
					String luku1 = lbl95Amount.getText();
					int intluku1 = Integer.parseInt(luku1);
					int intluku2  = Integer.parseInt(luku2);
					int yhteenlasku = intluku1 + intluku2;
					
					// Tulee varoitus, jos tankissa on alle 200 litraa
					bensaTarkista(yhteenlasku, E95);
					
					// Bensan määrä ei saa mennä yli 5000 litraa, eikä mennä negatiiviseksi
					if (yhteenlasku < 5000 && yhteenlasku > -1) 
					{
					progressBar.setValue(yhteenlasku); // Päivittyy progressBar
					progressBar.setForeground(Color.GREEN);
					
					String text = Integer.toString(yhteenlasku);
					lbl95Amount.setText(text);
					java.util.Date date = new java.util.Date();
					String tiedostoon = "E95 " + luku2 + " litraa " + date.toString();
				
					// Lokitiedostoon menee
					tulostaLokiin(tiedostoon, list[0]); // String text, file
					
					// Ylikirjoittaa nykyisen määrän bensaa tiedostoon
					tulostaTiedostoonLuku(yhteenlasku, 1); // tallennaUusiLuku(luku, mille riville kirjoitetaan)

					
					}
					if (yhteenlasku > 5000) 
					{
						JOptionPane.showMessageDialog(null, "Bensaa menee yli maximi kapasiteetin " + (yhteenlasku - 5000) + " litraa. "
								+ "Kokeile uudestaan lisätä pienempi määrä bensaa.");
					}
					if (yhteenlasku < 200) 
					{
						progressBar.setForeground(Color.RED);
					}
					// Bensaa määrä ei saa menna negatiiviseksi
					if (yhteenlasku < 0) 
					{
						JOptionPane.showMessageDialog(null, "Bensan määrä menee negatiiviseksi. Ota vähemmän bensaa tankista.");
						
					}
					
				}catch(Exception e1){
		            JOptionPane.showMessageDialog(null, "Syötä kokonaisluku");
				}	
				
			}
		});
		nappie95.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		nappie95.setBounds(572, 128, 184, 32);
		contentPane.add(nappie95);
		
		nappiE97 = new JButton("Tilaa E97");
		nappiE97.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String luku2 = textFieldE97.getText();
					String luku1 = lbl97Amount.getText();
					int intluku1 = Integer.parseInt(luku1);
					int intluku2  = Integer.parseInt(luku2);
					int yhteenlasku = intluku1 + intluku2;
					
					// Tulee varoitus, jos tankissa on alle 200 litraa
					bensaTarkista(yhteenlasku, E97);

					// Bensan määrä ei saa mennä yli 10 000 litraa, eikä mennä negatiiviseksi
					if (yhteenlasku < 5000 && yhteenlasku > -1) 
					{
					progressBar2.setValue(yhteenlasku); // Päivittyy progressBar
					progressBar2.setForeground(Color.GREEN);
					
					// Menee Tilaukset.txt
					String text = Integer.toString(yhteenlasku);
					lbl97Amount.setText(text);
					java.util.Date date = new java.util.Date();
					String tiedostoon = "E97 " + luku2 + " litraa " + date.toString();
					
					// Lokitiedostoon menee
					tulostaLokiin(tiedostoon, list[0]); // String text, file
					
					
					// Ylikirjoittaa nykyisen määrän bensaa tiedostoon
					tulostaTiedostoonLuku(yhteenlasku, 2); // tallennaUusiLuku(luku, mille riville kirjoitetaan)
					
					}
					// Bensan määrä ei saa mennä yli 5000 litraa
					if (yhteenlasku > 5000) 
					{
						JOptionPane.showMessageDialog(null, "Bensaa menee yli maximi kapasiteetin " + (yhteenlasku - 5000) + " litraa. Kokeile uudestaan lisätä pienempi määrä "
								+ "bensaa.");
					}

					if (yhteenlasku < 200) 
					{
						progressBar2.setForeground(Color.RED);
					}
					
					// Bensaa määrä ei saa menna negatiiviseksi
					if (yhteenlasku < 0) 
					{
						JOptionPane.showMessageDialog(null, "Bensan määrä menee negatiiviseksi. Ota vähemmän bensaa tankista.");
						
					}
					
				}catch(Exception e1){
		            JOptionPane.showMessageDialog(null, "Syötä kokonaisluku");
				}
				
			}
		});
		nappiE97.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		nappiE97.setBounds(574, 180, 184, 32);
		contentPane.add(nappiE97);
		
		nappiDiesel = new JButton("Tilaa Diesel");
		nappiDiesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					String luku2 = textFieldDiesel.getText();
					String luku1 = lblDieselAmount.getText();
					int intluku1 = Integer.parseInt(luku1);
					int intluku2  = Integer.parseInt(luku2);
					int yhteenlasku = intluku1 + intluku2;
					
					// Tulee varoitus, jos tankissa on alle 200 litraa
					bensaTarkista(yhteenlasku, Diesel);
		
					
					// Bensan määrä ei saa mennä yli 5000 litraa, eikä mennä negatiiviseksi
					if (yhteenlasku < 5000 && yhteenlasku > -1) 
					{
					progressBar3.setValue(yhteenlasku); // Päivittyy progressBar
					progressBar3.setForeground(Color.GREEN);
					
					String text = Integer.toString(yhteenlasku);
					lblDieselAmount.setText(text);
					
					java.util.Date date = new java.util.Date();
					
					
					String tiedostoon = "Diesel " + luku2 + " litraa " + date.toString();
					// System.out.println(tiedostoon);
					
					// Lokitiedostoon menee
					tulostaLokiin(tiedostoon, list[0]); // String text, file
					
					// Ylikirjoittaa nykyisen määrän bensaa tiedostoon
					tulostaTiedostoonLuku(yhteenlasku, 3); // tallennaUusiLuku(luku, mille riville kirjoitetaan)
					
					}
					if (yhteenlasku > 5000) // Bensan määrä ei saa mennä yli 5000 litraa
					{
						JOptionPane.showMessageDialog(null, "Bensaa menee yli maximi kapasiteetin " + (yhteenlasku - 5000) + " litraa. Kokeile uudestaan lisätä pienempi määrä "
								+ "bensaa.");
					}
					
					if (yhteenlasku < 200) 
					{
						progressBar3.setForeground(Color.RED);
					}
					
					// Bensan määrä ei saa menna negatiiviseksi
					if (yhteenlasku < 0) 
					{
						JOptionPane.showMessageDialog(null, "Bensan määrä menee negatiiviseksi. Ota vähemmän bensaa tankista.");
						
					}
				}catch(Exception e1){
					// Ei toimi, jos syöttää desimaaleja
		            JOptionPane.showMessageDialog(null, "Syötä kokonaisluku");
				}
				
			}
		});
		nappiDiesel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		nappiDiesel.setBounds(574, 239, 184, 28);
		contentPane.add(nappiDiesel);
		
		nappiClear = new JButton("Clear");
		nappiClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Asettaa tyhjää textFieldeille
				textFieldE95.setText(null);
				textFieldE97.setText(null);
				textFieldDiesel.setText(null);
			}
		});
		nappiClear.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		nappiClear.setBounds(572, 293, 184, 32);
		contentPane.add(nappiClear);
		
		lblOhjaaKayttajaa = new JLabel("Paina nappia tehdä tilaus");
		lblOhjaaKayttajaa.setForeground(Color.BLACK);
		lblOhjaaKayttajaa.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblOhjaaKayttajaa.setBounds(574, 74, 216, 32);
		contentPane.add(lblOhjaaKayttajaa);
		
		lblKertooBensa = new JLabel("Bensa:");
		lblKertooBensa.setForeground(Color.BLACK);
		lblKertooBensa.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblKertooBensa.setBounds(10, 84, 95, 20);
		contentPane.add(lblKertooBensa);
		
		lblNewLabel = new JLabel("Määrä tankissa");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblNewLabel.setBounds(98, 70, 133, 40);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Aseta määrä tilata");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(399, 74, 140, 32);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Varoitus tulee, jos on alle 200 litraa tankissa");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblNewLabel_2.setIcon(new ImageIcon(Tankit.class.getResource("/Pictures/Oil well.jpg")));
		lblNewLabel_2.setBounds(-27, -17, 960, 540);
		contentPane.add(lblNewLabel_2);
	}
	
	public void tulostaLokiin(String text, String filename) {
		// Funktion tarkoitus on kirjoittaa lokiin eli Tilaukset.txt tiedostoon
		try 
		{
			// Valinta true lopussa aiheuttaa sen, että ei ylikirjoita vaan jatketaan olemassa olevaa
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(text + "\n");
			fwriter.close();
			// System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Varoittaa, jos bensaa on alle 200 litraa
	public static void bensaTarkista(int bensaMaara, String bensa) 
	{
		if (bensaMaara < 200) 
		{
			JOptionPane.showMessageDialog(null, bensa + " on alle 200 litraa tankissa." + " Tankissa on " + bensaMaara + " litraa.");
		}
		
	}
	
	public static void tulostaTiedostoonLuku(int uusiLuku, int rivi) 
	{

        try 
        {
            // Ottaa koko rivin
            String line1 = Files.readAllLines(Paths.get(list[1])).get(0);
            String line2 = Files.readAllLines(Paths.get(list[1])).get(1);
            String line3 = Files.readAllLines(Paths.get(list[1])).get(2);

            // Splittaa stringin
            String split1 = (line1.split("= ")[1]);
            String split2 = (line2.split("= ")[1]);
            String split3 = (line3.split("= ")[1]);
            
            int e95 = Integer.parseInt(split1);
            int e97 = Integer.parseInt(split2);
            int diesel = Integer.parseInt(split3);

            try 
            {
            	if (rivi == 1) 
            	{
                    FileWriter fw = new FileWriter(list[1]);
                    fw.write("E95 = " + uusiLuku);
                    fw.write(System.lineSeparator());
                    fw.write("E98 = " + e97);
                    fw.write(System.lineSeparator());
                    fw.write("Diesel = " + diesel);
                    fw.close();
            	}
            	if (rivi == 2) 
            	{
                    FileWriter fw = new FileWriter(list[1]);
                    fw.write("E95 = " + e95);
                    fw.write(System.lineSeparator());
                    fw.write("E98 = " + uusiLuku);
                    fw.write(System.lineSeparator());
                    fw.write("Diesel = " + diesel);
                    fw.close();
            	}
            	if (rivi == 3) 
            	{
                    FileWriter fw = new FileWriter(list[1]);
                    fw.write("E95 = " + e95);
                    fw.write(System.lineSeparator());
                    fw.write("E97 = " + e97);
                    fw.write(System.lineSeparator());
                    fw.write("Diesel = " + uusiLuku);
                    fw.close();
            	}
            } catch (Exception e)
            {
            	JOptionPane.showMessageDialog(null, "Epäonnistui tallentamaan uuden bensanmäärän tiedostoon");
            }
           
            

        } catch (IOException e) 
        {
            System.out.println(e);
        }
	}
	
	public static String lueMaara(int bensatyyppi) 
	{
	// Returnaa tietyn bensan labelille
	
       
        try 
        {
            // Ottaa koko rivin
            String line1 = Files.readAllLines(Paths.get(list[1])).get(0);
            String line2 = Files.readAllLines(Paths.get(list[1])).get(1);
            String line3 = Files.readAllLines(Paths.get(list[1])).get(2);

            // Splittaa stringin
            String split1 = (line1.split("= ")[1]);
            String split2 = (line2.split("= ")[1]);
            String split3 = (line3.split("= ")[1]);
            
            // Returnaa E95, jos on 1
            if(bensatyyppi == 1) 
            {
            	return split1;
            }
            
            // Returnaa E97, jos on 2
            if(bensatyyppi == 2) 
            {
            	return split2;
            }
            
            // Returnaa Diesel, jos on 3
            if(bensatyyppi == 3) 
            {
            	return split3;
            }
           

        } catch (IOException e) 
        {
            System.out.println(e);
        }
		return null;
	}
}
