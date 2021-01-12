import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton ButtonLogin;
	private JLabel lblTittle;
	private JLabel lblTaustakuva;
	
	private Tankit tankit = new Tankit();
	private static Scanner x;
	
	// Cryptatut salasanat ovat tässä tiedostossa
	String filename = "src/Files/kirjoitettutunnukset.txt";
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Pictures/gas station.png")));
		setTitle("Login");
		setBounds(100, 100, 683, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblUsername.setBounds(48, 47, 86, 17);
		contentPanel.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		lblPassword.setBounds(48, 100, 86, 17);
		contentPanel.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		usernameField.setColumns(10);
		usernameField.setBounds(156, 47, 139, 20);
		contentPanel.add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		passwordField.setBounds(156, 100, 139, 20);
		contentPanel.add(passwordField);
		
		ButtonLogin = new JButton("Login");
		ButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userIn = usernameField.getText(); // käyttäjä
				String passwordIn = passwordField.getText(); // salasana
				
			
                // Tarkistaa usernamen ja passwordin
                if (verifyLogin(userIn, passwordIn, filename) == true) 
                {
                	// System.out.println("Open new window");
                	Login.this.setVisible(false);
                	tankit.setVisible(true);
                	tankit.setResizable(false); // Ei voi muuttaa ikkunan kokoa
                }
                if (verifyLogin(userIn, passwordIn, filename) == false) // Jos on väärin username tai password tulee popup ikkuna
                {
                	JOptionPane.showMessageDialog(null, "Väärä salasana tai tunnus!");
                	
                }
				
			}
		});
		ButtonLogin.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 16));
		ButtonLogin.setBounds(156, 155, 89, 23);
		contentPanel.add(ButtonLogin);
		
		lblTittle = new JLabel("Login Page");
		lblTittle.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 21));
		lblTittle.setBounds(156, 0, 139, 36);
		contentPanel.add(lblTittle);
		
		lblTaustakuva = new JLabel("");
		lblTaustakuva.setIcon(new ImageIcon(Login.class.getResource("/Pictures/Route66.jpg")));
		lblTaustakuva.setBounds(-141, -40, 986, 555);
		contentPanel.add(lblTaustakuva);
	}
	
	// Tarkistaa onko username ja password samat kuin tekstitiedostossa
		public static boolean verifyLogin(String username, String password, String filepath) 
		{
			// Kertoa, jos löytyy oikea kirjautumis tunnus
			boolean found = false;
			String tempUsername = "";
			String tempPassword = "";
			
			String salasanaMD5 = crypt(password);
			
			try 
			{
				x = new Scanner(new File(filepath));
				x.useDelimiter("[,\n]"); // Pilkulla jaettu tiedostossa
				
				// Lukea koko rivi tiedostosta
				while (x.hasNext() && !found)
				{
					// Lue seuraava juttu ja pysähdy pilkkuun tai uuteen riviin
					tempUsername = x.next();
					tempPassword = x.next();
					
					
					// trim poistaa kaikki välilyönnit, jos on
					// Onko salasana oikein, jos oikein tulee true takaisin
					if (tempUsername.trim().equals(username.trim()) && (tempPassword.trim().equals(salasanaMD5.trim()))) 
					{
						// Tulee true, jos username ja password ovat samat.
						found = true;
						return true;
						
					}
				}
				x.close();
				// System.out.println(found);
			}
			catch (Exception e)
			{
				System.out.println("Error");
			}
			// System.out.println(false);
			return false;
			
		}
			
		
		// MD5 salaus
		public static String crypt(String str) {
	        if (str == null || str.length() == 0) {
	            throw new IllegalArgumentException("Kryptattu stringi ei saa olla tyhjä tai nollan pituinen");
	        }
	 
	        MessageDigest digester;
	        try {
	            digester = MessageDigest.getInstance("MD5");
	 
	            digester.update(str.getBytes());
	            byte[] hash = digester.digest();
	            StringBuffer hexString = new StringBuffer();
	            for (int i = 0; i < hash.length; i++) {
	                if ((0xff & hash[i]) < 0x10) {
	                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
	                } else {
	                    hexString.append(Integer.toHexString(0xFF & hash[i]));
	                }
	            }
	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return "";
	    }
}
