package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import DAO.DeporteDAO;
import DAO.DeportistaDAO;
import DAO.EquipoDAO;
import DAO.OlimpiadaDAO;
import model.Deportista;
import model.*;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventana2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable table;
	
	DeportistaDAO deportista = new DeportistaDAO();
	DeporteDAO deporte = new DeporteDAO();
	EquipoDAO equipo = new EquipoDAO();
	OlimpiadaDAO olimpiada = new OlimpiadaDAO();
	ArrayList<Object[]> data = new ArrayList<>();
	String columnasDeportista[] = {"Nombre", "Sexo", "Peso", "Altura"};
	String columnasDeporte[] = {"Nombre"};
	String columnasEquipo[] = {"Nombre", "Iniciales"};
	String columnasOlimpiada[] = {"Nombre","Año","Temporada","Ciudad"};
	DefaultTableModel modelo = new DefaultTableModel(columnasDeportista,0);
	private JTextField txtNombreDeporte;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 frame = new Ventana2();
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
	public Ventana2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscarPor = new JLabel("Buscar por");
		lblBuscarPor.setBounds(31, 12, 88, 15);
		contentPane.add(lblBuscarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Deporte", "Deportista", "Equipo", "Evento", "Olimpiada", "Participacion"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(137, 7, 132, 24);
		String eleccion = comboBox.getSelectedItem().toString();
		contentPane.add(comboBox);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(306, 10, 114, 19);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 63, 315, 154);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		
		table.setToolTipText("prueba");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 38, 141, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (eleccion.equals("Deportista")){
					
				}
			}
		});
		
		btnAgregar.setBounds(54, 227, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(153, 227, 102, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(279, 227, 89, 23);
		contentPane.add(btnEliminar);
		
		
		
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String eleccion = comboBox.getSelectedItem().toString();
				lblNewLabel.setText(comboBox.getSelectedItem().toString());
				
				
				if (eleccion.equals("Deportista")){
					try {
						
						cargarDeportista();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (eleccion.equals("Deporte")){
					try {
						cargarDeporte();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (eleccion.equals("Equipo")){
					try {
						cargarEquipo();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if (eleccion.equals("Olimpiada")){
					try {
						cargarOlimpiada();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
								
	}
	private void cargarDeportista() throws SQLException {
		modelo.setColumnIdentifiers(columnasDeportista);
		this.data = deportista.read();
		modelo.setNumRows(0);
		for (Object[] dato : this.data) {
			this.modelo.addRow(dato);					
		}
		table.setModel(modelo);
		
		txtNombreDeporte = new JTextField();
		txtNombreDeporte.setBounds(198, 333, 171, 20);
		contentPane.add(txtNombreDeporte);
		txtNombreDeporte.setColumns(10);
		//txtNombreDeporte.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Deporte");
		lblNewLabel_1.setBounds(37, 336, 114, 14);
		contentPane.add(lblNewLabel_1);
	}
	private void cargarDeporte() throws SQLException {
		modelo.setColumnIdentifiers(columnasDeporte);
		this.data = deporte.read();
		modelo.setNumRows(0);
		for (Object[] dato : this.data) {
			this.modelo.addRow(dato);					
		}
		table.setModel(modelo);
	}
	private void cargarEquipo() throws SQLException {
		modelo.setColumnIdentifiers(columnasEquipo);
		this.data = equipo.read();
		modelo.setNumRows(0);
		for (Object[] dato : this.data) {
			this.modelo.addRow(dato);					
		}
		table.setModel(modelo);
	}
	private void cargarOlimpiada() throws SQLException {
		modelo.setColumnIdentifiers(columnasOlimpiada);
		this.data = olimpiada.read();
		modelo.setNumRows(0);
		for (Object[] dato : this.data) {
			this.modelo.addRow(dato);					
		}
		table.setModel(modelo);
	}
}
