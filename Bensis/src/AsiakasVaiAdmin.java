
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class AsiakasVaiAdmin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private Login login = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AsiakasVaiAdmin dialog = new AsiakasVaiAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AsiakasVaiAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AsiakasVaiAdmin.class.getResource("/Pictures/gas station.png")));
		setTitle("Asiakas vai Admin");
		setBounds(100, 100, 604, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setResizable(false); // Ei voi muuttaa ikkunan kokoa
		{
			JButton nappiAsiakas = new JButton("Asiakas");
			nappiAsiakas.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 15));
			nappiAsiakas.setBounds(148, 123, 121, 39);
			contentPanel.add(nappiAsiakas);
		}
		{
			JButton nappiAdmin = new JButton("Admin");
			nappiAdmin.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 15));
			nappiAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                	AsiakasVaiAdmin.this.setVisible(false);
                	login.setVisible(true);
                	login.setResizable(false);
				}
			});
			nappiAdmin.setBounds(312, 123, 113, 39);
			contentPanel.add(nappiAdmin);
		}
		{
			JLabel lblTervetuloa = new JLabel("Tervetuloa Bensa-asemalle");
			lblTervetuloa.setForeground(Color.WHITE);
			lblTervetuloa.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 27));
			lblTervetuloa.setBounds(111, 28, 385, 62);
			contentPanel.add(lblTervetuloa);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(AsiakasVaiAdmin.class.getResource("/Pictures/gas station2.png")));
			lblNewLabel_1.setBounds(-236, -29, 986, 555);
			contentPanel.add(lblNewLabel_1);
		}
	}

}
