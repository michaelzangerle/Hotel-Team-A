/**
 * 
 */
package projekt.fhv.teama.view.invoice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JButton;

/**
 *  
 *
 * @author Team A
 * @version 1.1
 */
public class ViewInvoice extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInvoice frame = new ViewInvoice();
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
	public ViewInvoice() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnRechnungErstellen = new JTextPane();
		txtpnRechnungErstellen.setText("Rechnung erstellen");
		txtpnRechnungErstellen.setBounds(10, 44, 301, 387);
		contentPane.add(txtpnRechnungErstellen);
		
		JButton btnNewButton = new JButton("Schlie\u00DFen");
		btnNewButton.setBounds(321, 189, 373, 242);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DoRechnung");
		btnNewButton_1.setBounds(321, 44, 373, 143);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(this);
		setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 
		new ViewInvoice();		
	}
}
