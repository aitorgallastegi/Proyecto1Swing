package ventanas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DeporteDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.*;


public class VentanaManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	protected Component ventana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaManager frame = new VentanaManager();
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
	public VentanaManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(269, 80, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDelDeporte = new JLabel("Nombre del deporte");
		lblNombreDelDeporte.setBounds(39, 83, 168, 15);
		contentPane.add(lblNombreDelDeporte);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String deporteNuevo = textField.getText();
					int id_deporte = Integer.parseInt(textField_1.getText());
					DeporteDAO deporte = new DeporteDAO();
					Deporte a = new Deporte(id_deporte,deporteNuevo);
			        deporte.insert(a);
					JOptionPane.showMessageDialog(ventana, "Insertado correctamente.");
				}
				catch(Exception x) {
					JOptionPane.showMessageDialog(ventana, "ERROR no se ha insertado.");

				}
				
			}
		});
		btnInsertar.setBounds(166, 226, 117, 25);
		contentPane.add(btnInsertar);
	}
}
