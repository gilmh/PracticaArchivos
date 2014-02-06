package org.hectordam.practicahector.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import org.hectordam.practicahector.base.*;
import org.hectordam.practicahector.beans.ComboJugadores;
import org.hectordam.practicahector.util.Constante;
import org.hectordam.practicahector.util.Fichero;
import org.hectordam.practicahector.util.Mensaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.toedter.calendar.JDateChooser;
import org.hectordam.practicahector.beans.TablaJugadores;
import org.hectordam.practicahector.beans.TablaBatallas;
import javax.swing.JMenuItem;
import org.hectordam.practicahector.beans.TablaPersonajes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana {

	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JTabbedPane tabbedPane;
	private JPanel panelJugador;
	private JPanel panelPersonaje;
	private JPanel panelBatalla;
	private JLabel lblNombre;
	private JLabel lblDireccion;
	private JLabel lblCiudad;
	private JLabel lblCif;
	private JLabel lblCodigoPostal;
	private JTextField txtPaisJugador;
	private JTextField txtCorreoJugador;
	private JTextField txtContrasenaJugador;
	private JTextField txtUsuarioJugador;
	private JScrollPane scrollPane;
	private JButton btCancelarJugador;
	private JButton btInsertarJugador;
	private JButton btNuevoJugador;
	private JButton btModificarJugador;
	private JButton btEliminarJugador;
	private JLabel lblNombre_1;
	private JLabel lblDescripcion;
	private JLabel lblFechaInicio;
	private JLabel lblFechaEntrega;
	private JLabel lblEmpresa;
	private JTextField txtNombrePersonaje;
	private JButton btNuevoPersonaje;
	private JButton btCancelarPersonaje;
	private JButton btInsertarPersonaje;
	private JScrollPane scrollPane_1;
	private JButton btModificarPersonaje;
	private JButton btEliminarPersonaje;
	private JLabel lblNombre_2;
	private JLabel lblApellido;
	private JLabel lblNacionalidad;
	private JLabel lblFechaNacimiento;
	private JLabel lblNewLabel;
	private JButton btInsertarBatalla;
	private JButton btNuevoBatalla;
	private JButton btCancelarBatalla;
	private JScrollPane scrollPane_2;
	private JButton btModificarBatalla;
	private JButton btEliminarBatalla;
	private JComboBox cbClasePersonaje;
	private JComboBox cbRazaPersonaje;
	private JTextField txtDuracionBatalla;
	private JTextField txtHistorialBatalla;
	private JDateChooser dateJugador;
	private JDateChooser datePersonaje;
	private JDateChooser dateBatalla;
	private TablaJugadores tablaJugadores;
	private TablaBatallas tablaBatallas;
	private JMenuItem menuItemGuardar;
	private JMenuItem menuItemGuardarComo;
	private TablaPersonajes tablaPersonajes;
	private ComboJugadores cbJugadorPersonaje;
	private ComboJugadores cbAtacanteBatalla;
	private ComboJugadores cbDefensorBatalla;
	private JLabel lblBuscar;
	private JTextField txtBuscarJugador;
	private JButton btLimpiarJugador;
	private JLabel label;
	private JTextField txtBuscarPersonaje;
	private JButton btLimpiarPersonaje;
	private JLabel label_1;
	private JTextField txtBuscarBatalla;
	private JButton btLimpiarBatalla;
	private JMenu mnExportar;
	private JMenuItem mntmJugadores;
	private JMenuItem mntmPersonaje;
	private JMenuItem mntmBatalla;
	private JLabel lbEstado;
	
	private String[] clases = {"<Selecciona>","Guerrero","Mago", "Paladin", "Picaro", "Nigromante", "Clerigo", "Druida", "Especialista", "Ingeniero", "Explorador"};
	private String[] razas = {"<Selecciona>", "Humano", "Elfo", "Enano", "Gnomo", "Goblin", "Licantropo", "Orco", "No-Muerto", "Nordico", "Lagarto"};
	
	private ArrayList<Jugador> jugadores;
	private ArrayList<Personaje> personajes;
	private ArrayList<Batalla> batallas;
	
	private boolean esNuevoJugador = true;
	private boolean esNuevoPersonaje = true;
	private boolean esNuevoBatalla = true;
	private boolean esTablaJugador = true;
	private boolean esTablaPersonaje = true;
	private boolean esTablaBatalla = true;
	private boolean esGuardar = true;
	
	private Jugador jugador;
	private Personaje personaje;
	private Batalla batalla;
	
	
	/**
	 * habilita y deshabilita las cajas de texto y botones precisos 
	 */
	private void nuevoJugador(){
		
		txtUsuarioJugador.setText("");
		txtUsuarioJugador.setEditable(true);
		txtContrasenaJugador.setText("");
		txtContrasenaJugador.setEditable(true);
		txtCorreoJugador.setText("");
		txtCorreoJugador.setEditable(true);
		txtPaisJugador.setText("");
		txtPaisJugador.setEditable(true);
		dateJugador.setEnabled(true);
		dateJugador.setDate(null);
		
		btNuevoJugador.setEnabled(false);
		btCancelarJugador.setEnabled(true);
		btInsertarJugador.setEnabled(true);
		btModificarJugador.setEnabled(false);
		btEliminarJugador.setEnabled(false);
		
		tablaJugadores.setEnabled(false);
		esTablaJugador = false;
		
		this.limpiarJugador();
		
	}
	
	/** 
	 * habilita y deshabilita las cajas de texto y botones precisos
	 */
	private void nuevoPersonaje(){
		
		txtNombrePersonaje.setText("");
		txtNombrePersonaje.setEditable(true);
		datePersonaje.setEnabled(true);
		datePersonaje.setDate(null);
		//cbRazaPersonaje.setEditable(true);
		cbRazaPersonaje.setEnabled(true);
		this.cbRazaPersonaje.setSelectedIndex(0);
		//cbClasePersonaje.setEditable(true);
		cbClasePersonaje.setEnabled(true);
		this.cbClasePersonaje.setSelectedIndex(0);
		//cbJugadorPersonaje.setEditable(true);
		cbJugadorPersonaje.setEnabled(true);
		cbJugadorPersonaje.setSelectedIndex(0);
		
		btNuevoPersonaje.setEnabled(false);
		btCancelarPersonaje.setEnabled(true);
		btInsertarPersonaje.setEnabled(true);
		btModificarPersonaje.setEnabled(false);
		btEliminarPersonaje.setEnabled(false);
		
		tablaPersonajes.setEnabled(false);
		esTablaPersonaje = false;
		
		this.limpiarPersonaje();
		
	}
	
	/**
	 *  habilita y deshabilita las cajas de texto y botones precisos
	 */
	private void nuevoBatalla(){
		
		dateBatalla.setEnabled(true);
		dateBatalla.setDate(null);
		txtHistorialBatalla.setText("");
		txtHistorialBatalla.setEditable(true);
		txtDuracionBatalla.setText("");
		txtDuracionBatalla.setEditable(true);
		//cbAtacanteBatalla.setEditable(true);
		cbAtacanteBatalla.setEnabled(true);
		cbAtacanteBatalla.setSelectedIndex(0);
		//cbDefensorBatalla.setEditable(true);
		cbDefensorBatalla.setEnabled(true);
		cbDefensorBatalla.setSelectedIndex(0);
		
		btNuevoBatalla.setEnabled(false);
		btCancelarBatalla.setEnabled(true);
		btInsertarBatalla.setEnabled(true);
		btModificarBatalla.setEnabled(false);
		btEliminarBatalla.setEnabled(false);
		
		tablaBatallas.setEnabled(false);
		esTablaBatalla = false;
		
		this.limpiarBatalla();
	}
	
	/**
	 *  habilita y deshabilita las cajas de texto y botones precisos
	 */
	private void cancelarJugador(){
		
		txtUsuarioJugador.setText("");
		txtUsuarioJugador.setEditable(false);
		txtContrasenaJugador.setText("");
		txtContrasenaJugador.setEditable(false);
		txtCorreoJugador.setText("");
		txtCorreoJugador.setEditable(false);
		txtPaisJugador.setText("");
		txtPaisJugador.setEditable(false);
		dateJugador.setEnabled(false);
		dateJugador.setDate(null);
		
		btNuevoJugador.setEnabled(true);
		btCancelarJugador.setEnabled(false);
		btInsertarJugador.setEnabled(false);
		
		tablaJugadores.setEnabled(true);
		esTablaJugador = true;
		esNuevoJugador = true;
	}
	
	/**
	 *  habilita y deshabilita las cajas de texto y botones precisos
	 */
	private void cancelarPersonaje(){
		
		txtNombrePersonaje.setText("");
		txtNombrePersonaje.setEditable(false);
		datePersonaje.setEnabled(false);
		cbRazaPersonaje.setEditable(false);
		cbRazaPersonaje.setEnabled(false);
		cbRazaPersonaje.setSelectedIndex(0);
		cbClasePersonaje.setEditable(false);
		cbClasePersonaje.setEnabled(false);
		cbClasePersonaje.setSelectedIndex(0);
		cbJugadorPersonaje.setEditable(false);
		cbJugadorPersonaje.setEnabled(false);
		cbJugadorPersonaje.setSelectedIndex(0);
		datePersonaje.setDate(null);
		
		btNuevoPersonaje.setEnabled(true);
		btCancelarPersonaje.setEnabled(false);
		btInsertarPersonaje.setEnabled(false);
		
		tablaPersonajes.setEnabled(true);
		esTablaPersonaje = true;
		esNuevoPersonaje = true;
	}
	
	/**
	 *  habilita y deshabilita las cajas de texto y botones precisos
	 */
	private void cancelarBatalla(){
		
		dateBatalla.setEnabled(false);
		dateBatalla.setDate(null);
		txtHistorialBatalla.setText("");
		txtHistorialBatalla.setEditable(false);
		txtDuracionBatalla.setText("");
		txtDuracionBatalla.setEditable(false);
		cbAtacanteBatalla.setEditable(false);
		cbAtacanteBatalla.setEnabled(false);
		cbAtacanteBatalla.setSelectedIndex(0);
		cbDefensorBatalla.setEditable(false);
		cbDefensorBatalla.setEnabled(false);
		cbDefensorBatalla.setSelectedIndex(0);
		
		btNuevoBatalla.setEnabled(true);
		btCancelarBatalla.setEnabled(false);
		btInsertarBatalla.setEnabled(false);
		
		tablaBatallas.setEnabled(true);
		esTablaBatalla = true;
		esNuevoBatalla = true;
	}
	
	/**
	 *  guarda los datos de las cajas en un objeto que se inserta en el vector
	 */
	private void insertarJugador(){
		
		// se comprueban los datos de las cajas de texto
		if(txtUsuarioJugador.getText().equals("") || txtContrasenaJugador.getText().equals("") || txtCorreoJugador.getText().equals("") || txtPaisJugador.getText().equals("") || dateJugador.getDate() == null){
			Mensaje.mensajeError("Los datos no son correctos, compruebalos");
		}
		else{
			// en el caso de que el jugador sea nuevo
			if(esNuevoJugador){
				// creamos el objeto, le guardamos los datos y lo insertamos en el vector
				Jugador jugador = new Jugador();
				
				jugador.setUsuario(txtUsuarioJugador.getText());
				jugador.setContrasena(txtContrasenaJugador.getText());
				jugador.setCorreoElectronico(txtCorreoJugador.getText());
				jugador.setPais(txtPaisJugador.getText());
				jugador.setFechaNacimiento(dateJugador.getDate());
					
				jugadores.add(jugador);
				
			}
			// en el caso de que el jugador sea para modificar
			else{
				
				this.jugador.setUsuario(txtUsuarioJugador.getText());
				this.jugador.setContrasena(txtContrasenaJugador.getText());
				this.jugador.setPais(txtPaisJugador.getText());
				this.jugador.setFechaNacimiento(dateJugador.getDate());
				this.jugador.setCorreoElectronico(txtCorreoJugador.getText());
				
			}
			
			// cambio la variable para indicar que hay datos para guardar y se notifica en la etiqueta
			esGuardar = false;
			this.menuItemGuardar.setEnabled(true);
			this.lbEstado.setText("Sin Guardar");
			
			cancelarJugador();
			
			// refresca los combos y la tabla
			this.cbJugadorPersonaje.listar();
			this.cbAtacanteBatalla.listar();
			this.cbDefensorBatalla.listar();
			tablaJugadores.listar();
		}
	}
	
	/**
	 *  guarda los datos de las cajas en el un objeto que se inserta en el vector
	 */
	private void insertarPersonaje(){
		
		// se comprueban los datos de las cajas de texto
		if(txtNombrePersonaje.getText().equals("") || datePersonaje.getDate() == null || cbClasePersonaje.getSelectedIndex() == 0 ||  cbRazaPersonaje.getSelectedIndex() == 0 || cbJugadorPersonaje.getSelectedIndex() == 0){
			Mensaje.mensajeError("Los datos no son correctos, compruebalos");
		}
		else{
			if(esNuevoPersonaje){
				// creamos el objeto, le guardamos los datos y lo insertamos en el vector
				Personaje personaje = new Personaje();
				
				personaje.setNombre(txtNombrePersonaje.getText());
				personaje.setClase((String) cbClasePersonaje.getSelectedItem());
				personaje.setRaza((String) cbRazaPersonaje.getSelectedItem());
				personaje.setUsuario(cbJugadorPersonaje.jugadorSeleccionado());
				personaje.setFechaCreacion(datePersonaje.getDate());
				
				personajes.add(personaje);
				
			}
			// En el caso de que el personaje sea para modificar
			else{
				
				//Personaje personaje = tablaPersonajes.personajeSeleccionado();
				
				this.personaje.setNombre(this.txtNombrePersonaje.getText());
				this.personaje.setFechaCreacion(this.datePersonaje.getDate());
				this.personaje.setClase((String) this.cbClasePersonaje.getSelectedItem());
				this.personaje.setRaza((String) this.cbRazaPersonaje.getSelectedItem());
				this.personaje.setUsuario(this.cbJugadorPersonaje.jugadorSeleccionado());
				
			}
			// cambio la variable para indicar que hay datos para guardar y se notifica en la etiqueta
			esGuardar = false;
			this.menuItemGuardar.setEnabled(true);
			this.lbEstado.setText("Sin Guardar");
			
			cancelarPersonaje();
			// refresca la tabla
			tablaPersonajes.listar();
		}
		
	}
	
	/**
	 *  guarda los datos de las cajas en el un objeto que se inserta en el vector
	 */
	private void insertarBatalla(){
		
		// se comprueban los datos de las cajas de texto
		if(txtHistorialBatalla.getText().equals("") || dateBatalla.getDate() == null || 
				txtDuracionBatalla.getText().equals("") || cbAtacanteBatalla.getSelectedIndex() == 0  || 
				cbDefensorBatalla.getSelectedIndex() == 0 || this.txtDuracionBatalla.getText().matches("[0-9]*") == false ||
				this.cbAtacanteBatalla.getSelectedIndex() == this.cbDefensorBatalla.getSelectedIndex()){
			
			Mensaje.mensajeError("Los datos no son correctos, compruebalos");
			
			
		}
		else{
			if(esNuevoBatalla){
				// creamos el objeto, le guardamos los datos y lo insertamos en el vector
				Batalla batalla = new Batalla();
				
				batalla.setFechaBatalla(dateBatalla.getDate());
				batalla.setDuracion(Integer.parseInt(txtDuracionBatalla.getText()));
				batalla.setHistorial(txtHistorialBatalla.getText());
				batalla.setUsuarioAtacante(cbAtacanteBatalla.jugadorSeleccionado());
				batalla.setUsuarioDefensor(cbDefensorBatalla.jugadorSeleccionado());
				
				batallas.add(batalla);
				
			}
			// En el caso de que la batalla sea para modificar
			else{
				
				//Batalla batalla = tablaBatallas.batallaSeleccionado();
				
				this.batalla.setDuracion(Integer.parseInt(this.txtDuracionBatalla.getText()));
				this.batalla.setFechaBatalla(this.dateBatalla.getDate());
				this.batalla.setHistorial(this.txtHistorialBatalla.getText());
				this.batalla.setUsuarioAtacante(this.cbAtacanteBatalla.jugadorSeleccionado());
				this.batalla.setUsuarioDefensor(this.cbDefensorBatalla.jugadorSeleccionado());
				
			}
			
			// cambio la variable para indicar que hay datos para guardar y se notifica en la etiqueta
			esGuardar = false;
			this.menuItemGuardar.setEnabled(true);
			this.lbEstado.setText("Sin Guardar");
			
			cancelarBatalla();
			// refresca la tabla
			tablaBatallas.listar();
		}
		
	}
	
	/**
	 *  habilita y deshabilita las cajas y botones precisos
	 */
	private void modificarJugador(){
		
		if(tablaJugadores.getSelectedRows().length > 1){
			Mensaje.mensajeError("Solo puedes seleccionar 1");
		}
		else{
			txtUsuarioJugador.setEditable(false);
			txtContrasenaJugador.setEditable(true);
			txtCorreoJugador.setEditable(true);
			txtPaisJugador.setEditable(true);
			dateJugador.setEnabled(true);
			
			btEliminarJugador.setEnabled(false);
			btModificarJugador.setEnabled(false);
			btInsertarJugador.setEnabled(true);
			btCancelarJugador.setEnabled(true);
			btNuevoJugador.setEnabled(false);
			
			tablaJugadores.setEnabled(false);
			esTablaJugador = false;
			esNuevoJugador = false;
			
			this.limpiarJugador();
		}
	}
	
	/**
	 *  habilita y deshabilita las cajas y botones precisos
	 */
	private void modificarPersonaje(){
		
		if(tablaJugadores.getSelectedRows().length > 1){
			Mensaje.mensajeError("Solo puedes seleccionar 1");
		}
		else{
			txtNombrePersonaje.setEditable(false);
			datePersonaje.setEnabled(true);
			//cbRazaPersonaje.setEditable(false);
			cbRazaPersonaje.setEnabled(true);
			//cbClasePersonaje.setEditable(true);
			cbClasePersonaje.setEnabled(true);
			//cbJugadorPersonaje.setEditable(true);
			cbJugadorPersonaje.setEnabled(true);
			
			btEliminarPersonaje.setEnabled(false);
			btModificarPersonaje.setEnabled(false);
			btInsertarPersonaje.setEnabled(true);
			btCancelarPersonaje.setEnabled(true);
			btNuevoPersonaje.setEnabled(false);
			
			tablaPersonajes.setEnabled(false);
			esTablaPersonaje = false;
			esNuevoPersonaje = false;
			
			this.limpiarPersonaje();
		}
	}
	
	/**
	 *  habilita y deshabilita las cajas y botones precisos
	 */
	private void modificarBatalla(){
		
		if(tablaJugadores.getSelectedRows().length > 1){
			Mensaje.mensajeError("Solo puedes seleccionar 1");
		}
		else{
			dateBatalla.setEnabled(true);
			txtHistorialBatalla.setEditable(true);
			txtDuracionBatalla.setEditable(true);
			//cbAtacanteBatalla.setEditable(false);
			cbAtacanteBatalla.setEnabled(false);
			//cbDefensorBatalla.setEditable(false);
			cbDefensorBatalla.setEnabled(false);
			
			btEliminarBatalla.setEnabled(false);
			btModificarBatalla.setEnabled(false);
			btInsertarBatalla.setEnabled(true);
			btCancelarBatalla.setEnabled(true);
			btNuevoBatalla.setEnabled(false);
			
			tablaBatallas.setEnabled(false);
			esTablaBatalla = false;
			esNuevoBatalla = false;
			
			this.limpiarBatalla();
		}
	}
	
	/**
	 *  elimina el equipo seleccionado en la tabla
	 */
	private void eliminarJugador(){
		// si hay varios seleccionados notifica el error
		if(tablaJugadores.getSelectedRows().length > 1){
			Mensaje.mensajeError("Solo puedes seleccionar 1");
		}
		else{
			int confirmar = Mensaje.mensajeConfirmar("Se borraran todos los datos relacionados con este jugador ¿Estas seguro?");
			
			if(confirmar == 0){
					
				// guarda el jugador que se a seleccionado en la tabla
				Jugador jugador = tablaJugadores.jugadorSeleccionado();
				
				Personaje personaje = null;
				// se recorre el vector y se eliminan los personajes relacionados con el jugador seleccionado en la tabla
				for(int i = this.personajes.size() - 1; i >= 0; i--){
					
					personaje = personajes.get(i);
					if(personaje.getUsuario().equals(jugador)){
						personajes.remove(personaje);
					}
				}
				
				Batalla batalla = null;
				// se recorre el vector y se eliminan las batallas relacionadas con el jugador seleccionado en la tabla
				for(int i = this.batallas.size() - 1; i >= 0; i--){
					
					batalla = batallas.get(i);
					if(batalla.getUsuarioAtacante().equals(jugador) || batalla.getUsuarioDefensor().equals(jugador)){
						batallas.remove(batalla);
					}
				}
				
				// elimina el jugador del vector
				jugadores.remove(jugador);
				
				// refresca la tabla y los combos
				tablaJugadores.listar();
				tablaPersonajes.listar();
				tablaBatallas.listar();
				this.cbJugadorPersonaje.listar();
				this.cbAtacanteBatalla.listar();
				this.cbDefensorBatalla.listar();
				
				cancelarJugador();
				
				// se cambia la variable de guardar y notifica en la etiqueta que hay cambios
				esGuardar = false;
				this.menuItemGuardar.setEnabled(true);
				this.lbEstado.setText("Sin Guardar");
				
				this.limpiarJugador();
			}
		}
	}
	
	/**
	 *  elimina el equipo seleccionado en la tabla
	 */
	private void eliminarPersonaje(){
		// si hay varios seleccionados notifica el error
		if(tablaJugadores.getSelectedRows().length > 1){
			Mensaje.mensajeError("Solo puedes seleccionar 1");
		}
		else{
			// guarda el jugador que se a seleccionado en la tabla
			Personaje personaje = tablaPersonajes.personajeSeleccionado();
			
			// elimina el jugador del vector
			personajes.remove(personaje);
			
			// refresca la tabla
			tablaPersonajes.listar();	
			
			cancelarPersonaje();
			
			// se cambia la variable de guardar y notifica en la etiqueta que hay cambios
			esGuardar = false;
			this.menuItemGuardar.setEnabled(true);
			this.lbEstado.setText("Sin Guardar");
			
			this.limpiarPersonaje();
		}
	}
	
	/**
	 *  elimina el equipo seleccionado en la tabla
	 */
	private void eliminarBatalla(){
		// si hay varios seleccionados notifica el error
		if(tablaJugadores.getSelectedRows().length > 1){
			Mensaje.mensajeError("Solo puedes seleccionar 1");
		}
		else{
			// guarda el jugador que se a seleccionado en la tabla
			Batalla batalla = tablaBatallas.batallaSeleccionado();
			
			// elimina el jugador del vector
			batallas.remove(batalla);
				
			// refresca la tabla
			tablaBatallas.listar();
			
			cancelarBatalla();
			
			// se cambia la variable de guardar y notifica en la etiqueta que hay cambios
			esGuardar = false;
			this.menuItemGuardar.setEnabled(true);
			this.lbEstado.setText("Sin Guardar");
			
			this.limpiarBatalla();
		}
	}
	
	/**
	 *  coloca los datos de la fila seleccionada de la tabla en sus respectivas cajas
	 */
	private void jugadorSeleccionado(){
		
		// si la tabla esta activa para poder seleccionar y coloca los datos en las cajas correspondientes
		if(esTablaJugador == true){
			this.jugador = tablaJugadores.jugadorSeleccionado();
			
			if(jugador == null){
				return;
			}
			
			txtUsuarioJugador.setText(jugador.getUsuario());
			txtContrasenaJugador.setText(jugador.getContrasena());
			txtCorreoJugador.setText(jugador.getCorreoElectronico());
			txtPaisJugador.setText(jugador.getPais());
			dateJugador.setDate(jugador.getFechaNacimiento());
			
			btEliminarJugador.setEnabled(true);
			btModificarJugador.setEnabled(true);
		}
	}
	
	/**
	 *  coloca los datos de la fila seleccionada de la tabla en sus respectivas cajas
	 */
	private void personajeSeleccionado(){
		
		// si la tabla esta activa para poder seleccionar y coloca los datos en las cajas correspondientes
		if(esTablaPersonaje == true){
			this.personaje = tablaPersonajes.personajeSeleccionado();
			
			if(personaje == null){
				return;
			}
			
			this.txtNombrePersonaje.setText(personaje.getNombre());
			this.datePersonaje.setDate(personaje.getFechaCreacion());
			this.cbClasePersonaje.setSelectedItem(personaje.getClase());
			this.cbRazaPersonaje.setSelectedItem(personaje.getRaza());
			this.cbJugadorPersonaje.setSelectedItem(personaje.getUsuario().getUsuario());
			
			btEliminarPersonaje.setEnabled(true);
			btModificarPersonaje.setEnabled(true);
		}
	}
	
	/**
	 *  coloca los datos de la fila seleccionada de la tabla en sus respectivas cajas
	 */
	private void batallaSeleccionado(){
		
		// si la tabla esta activa para poder seleccionar y coloca los datos en las cajas correspondientes
		if(esTablaBatalla == true){
			this.batalla = tablaBatallas.batallaSeleccionado();
			
			if(batalla == null){
				return;
			}
			
			this.txtHistorialBatalla.setText(batalla.getHistorial());
			this.txtDuracionBatalla.setText(Integer.toString(batalla.getDuracion()));
			this.dateBatalla.setDate(batalla.getFechaBatalla());
			this.cbAtacanteBatalla.setSelectedItem(batalla.getUsuarioAtacante().getUsuario());
			this.cbDefensorBatalla.setSelectedItem(batalla.getUsuarioDefensor().getUsuario());
			
			btEliminarBatalla.setEnabled(true);
			btModificarBatalla.setEnabled(true);
		}
	}
	
	/**
	 *  muestra en la tabla las filas en las que coincida el contenido de las caja de busqueda con los campos visibles de la tabla
	 */
	private void buscarJugador(){
		
		// guarda el contenido de la caja
		String filtro = this.txtBuscarJugador.getText();
		
		// muestra los datos iniciales de la tabla y desabilita el boton de limpiar
		if(filtro.length() < 1){
			this.btLimpiarJugador.setEnabled(false);
			this.tablaJugadores.listar();
		}
		// muestra las filas que van coincidiendo el contenido del filtro con alguno de sus campos
		else{
			this.btLimpiarJugador.setEnabled(true);
			this.tablaJugadores.listafiltrada(filtro);
		}
	}
	
	/**
	 *  muestra en la tabla las filas en las que coincida el contenido de las caja de busqueda con los campos visibles de la tabla
	 */
	private void buscarPersonaje(){
		
		// guarda el contenido de la caja
		String filtro = this.txtBuscarPersonaje.getText();
		
		// muestra los datos iniciales de la tabla y desabilita el boton de limpiar
		if(filtro.length() < 1){
			this.btLimpiarPersonaje.setEnabled(false);
			this.tablaPersonajes.listar();
		}
		// muestra las filas que van coincidiendo el contenido del filtro con alguno de sus campos
		else{
			this.btLimpiarPersonaje.setEnabled(true);
			this.tablaPersonajes.listaFiltrada(filtro);
		}
	}
	
	/**
	 *  muestra en la tabla las filas en las que coincida el contenido de las caja de busqueda con los campos visibles de la tabla
	 */
	private void buscarBatalla(){
		
		// guarda el contenido de la caja
		String filtro = this.txtBuscarBatalla.getText();
		
		// muestra los datos iniciales de la tabla y desabilita el boton de limpiar
		if(filtro.length() < 1){
			this.btLimpiarBatalla.setEnabled(false);
			this.tablaBatallas.listar();
		}
		// muestra las filas que van coincidiendo el contenido del filtro con alguno de sus campos
		else{
			this.btLimpiarBatalla.setEnabled(true);
			this.tablaBatallas.listaFiltrada(filtro);
		}
	}
	
	/**
	 *  limpia la caja de busqueda, deshabilita el limpiar y refresca la tabla a su estado inicial
	 */
	private void limpiarJugador(){
		this.txtBuscarJugador.setText("");
		tablaJugadores.listar();
		this.btLimpiarJugador.setEnabled(false);
	}
	
	/**
	 *  limpia la caja de busqueda, deshabilita el limpiar y refresca la tabla a su estado inicial
	 */
	private void limpiarPersonaje(){
		this.txtBuscarPersonaje.setText("");
		tablaPersonajes.listar();
		this.btLimpiarPersonaje.setEnabled(false);
	}
	
	/**
	 *  limpia la caja de busqueda, deshabilita el limpiar y refresca la tabla a su estado inicial
	 */
	private void limpiarBatalla(){
		this.txtBuscarBatalla.setText("");
		tablaBatallas.listar();
		this.btLimpiarBatalla.setEnabled(false);
	}
	
	/**
	 *  guarda los los vectores en sus archivos correspondientes
	 */
	private void guardarDatos(){
		
		// escribimos el vector el archivo correspondiente
		try {
			Fichero.escribirFichero(jugadores, Constante.RUTA_JUGADOR);
			Fichero.escribirFichero(personajes, Constante.RUTA_PERSONAJE);
			Fichero.escribirFichero(batallas, Constante.RUTA_BATALLA);
			
		} catch (IOException e) {
			e.printStackTrace();
			Mensaje.mensajeError("Error al escribir el fichero");
		}
		
		// cambia la variable que indica que no hay cambios
		esGuardar = true;
		this.menuItemGuardar.setEnabled(false);
		this.lbEstado.setText("Guardado");
	}
	
	/**
	 *  guarda los vectores en sus respectivos archivos en una ruta escogida por el usuario
	 */
	private void guardarComo(){
		
		JFileChooser fileChooser = new JFileChooser();
		int seleccion = fileChooser.showSaveDialog(null);
		 
		// en el caso de darle a guardar en la ruta deseada
		if (seleccion == JFileChooser.APPROVE_OPTION){
			File fichero = fileChooser.getSelectedFile();
		    
			  // escribimos el vector en el archivo correspondiente
			try {
				//se guarda cada vector en un archivo correspondiente
				 
				 Fichero.escribirFichero(jugadores, fichero.getAbsolutePath()+Constante.RUTA_JUGADOR);
				 Fichero.escribirFichero(personajes, fichero.getAbsolutePath()+Constante.RUTA_PERSONAJE);
				 Fichero.escribirFichero(batallas, fichero.getAbsolutePath()+Constante.RUTA_BATALLA);
				 
				/* guarda los vectores en un mismo archivo
				 * 
				 *	FileOutputStream file = new FileOutputStream(fichero.getAbsolutePath());
				 *	ObjectOutputStream serializador = new ObjectOutputStream(file);
				 *	
				 *	serializador.writeObject(this.jugadores);
				 *	serializador.writeObject(this.personajes);
				 *	serializador.writeObject(this.batallas);
				 *	
				 *	if(serializador != null){
				 *		serializador.close();
				 *	}
				 */
				 
			} catch (IOException e) {
				e.printStackTrace();
				Mensaje.mensajeError("Error al escribir el fichero");
			}
		 }
		
	}
	
	/**
	 *  confirma si hay datos para guardar y en tal caso avisa al usuario
	 */
	private void cerrarVentana(){
		
		if(esGuardar == false){
			int confirmar = Mensaje.mensajeConfirmar("¿Deseas salir y guardar?");
			if(confirmar == 0){
				guardarDatos();
			}
		}
		
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
		inicializar();
	}
	
	/**
	 *  crea los vectores, guarda en los vectores lod datos de los respectivos ficheros e inicializa las tablas y el combo
	 */
	private void inicializar(){
		
		// crea los vectores
		jugadores = new ArrayList<Jugador>();
		personajes = new ArrayList<Personaje>();
		batallas = new ArrayList<Batalla>();
		
		// lee los ficheros y guarda los datos en sus vectores correspondientes si existe el fichero
		try {
			if(new File(Constante.RUTA_JUGADOR).exists()){
				jugadores = (ArrayList) Fichero.leerFichero(Constante.RUTA_JUGADOR);
			}
			if(new File(Constante.RUTA_PERSONAJE).exists()){
				personajes = (ArrayList) Fichero.leerFichero(Constante.RUTA_PERSONAJE);
			}
			if(new File(Constante.RUTA_BATALLA).exists()){
				batallas = (ArrayList) Fichero.leerFichero(Constante.RUTA_BATALLA);
			}			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// inicializa los combos y tablas
		cbJugadorPersonaje.inicializar(jugadores);
		cbJugadorPersonaje.listar();
		cbAtacanteBatalla.inicializar(jugadores);
		cbAtacanteBatalla.listar();
		cbDefensorBatalla.inicializar(jugadores);
		cbDefensorBatalla.listar();
		
		tablaJugadores.inicializar(jugadores);
		tablaJugadores.listar();
		tablaPersonajes.inicializar(personajes);
		tablaPersonajes.listar();
		tablaBatallas.inicializar(batallas);
		tablaBatallas.listar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarVentana();
			}
		});
		frame.setBounds(100, 100, 500, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		lbEstado = new JLabel("Inicial");
		panel.add(lbEstado);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panelJugador = new JPanel();
		tabbedPane.addTab("Jugador", null, panelJugador, null);
		panelJugador.setLayout(null);
		
		lblNombre = new JLabel("Usuario: ");
		lblNombre.setBounds(10, 11, 100, 14);
		panelJugador.add(lblNombre);
		
		lblDireccion = new JLabel("Correo Electronico: ");
		lblDireccion.setBounds(10, 61, 100, 14);
		panelJugador.add(lblDireccion);
		
		lblCiudad = new JLabel("Pais: ");
		lblCiudad.setBounds(10, 86, 100, 14);
		panelJugador.add(lblCiudad);
		
		lblCif = new JLabel("Contrase\u00F1a: ");
		lblCif.setBounds(10, 36, 100, 14);
		panelJugador.add(lblCif);
		
		lblCodigoPostal = new JLabel("Fecha Nacimiento: ");
		lblCodigoPostal.setBounds(10, 111, 100, 14);
		panelJugador.add(lblCodigoPostal);
		
		txtPaisJugador = new JTextField();
		txtPaisJugador.setEditable(false);
		txtPaisJugador.setBounds(117, 83, 100, 20);
		panelJugador.add(txtPaisJugador);
		txtPaisJugador.setColumns(10);
		
		txtCorreoJugador = new JTextField();
		txtCorreoJugador.setEditable(false);
		txtCorreoJugador.setBounds(117, 58, 100, 20);
		panelJugador.add(txtCorreoJugador);
		txtCorreoJugador.setColumns(10);
		
		txtContrasenaJugador = new JTextField();
		txtContrasenaJugador.setEditable(false);
		txtContrasenaJugador.setBounds(117, 33, 100, 20);
		panelJugador.add(txtContrasenaJugador);
		txtContrasenaJugador.setColumns(10);
		
		txtUsuarioJugador = new JTextField();
		txtUsuarioJugador.setEditable(false);
		txtUsuarioJugador.setBounds(117, 8, 100, 20);
		panelJugador.add(txtUsuarioJugador);
		txtUsuarioJugador.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(227, 35, 250, 195);
		panelJugador.add(scrollPane);
		
		tablaJugadores = new TablaJugadores();
		tablaJugadores.addKeyListener(new KeyAdapter() {
			// elimina el jugador seleccionada pulsando suprimir
			@Override
			public void keyReleased(KeyEvent e) {
				if(tablaJugadores.jugadorSeleccionado() != null){
					if(e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
						eliminarJugador();
					}
				}
			}
		});
		tablaJugadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugadorSeleccionado();
			}
		});
		scrollPane.setViewportView(tablaJugadores);
		
		btCancelarJugador = new JButton("Cancelar");
		btCancelarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarJugador();
			}
		});
		btCancelarJugador.setEnabled(false);
		btCancelarJugador.setBounds(10, 170, 86, 23);
		panelJugador.add(btCancelarJugador);
		
		btInsertarJugador = new JButton("Insertar");
		btInsertarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarJugador();
			}
		});
		btInsertarJugador.setEnabled(false);
		btInsertarJugador.setBounds(120, 136, 86, 23);
		panelJugador.add(btInsertarJugador);
		
		btNuevoJugador = new JButton("Nuevo");
		btNuevoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoJugador();
			}
		});
		btNuevoJugador.setBounds(10, 136, 86, 23);
		panelJugador.add(btNuevoJugador);
		
		btModificarJugador = new JButton("Modificar");
		btModificarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarJugador();
			}
		});
		btModificarJugador.setEnabled(false);
		btModificarJugador.setBounds(227, 241, 107, 23);
		panelJugador.add(btModificarJugador);
		
		btEliminarJugador = new JButton("Eliminar");
		btEliminarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarJugador();
			}
		});
		btEliminarJugador.setEnabled(false);
		btEliminarJugador.setBounds(357, 241, 107, 23);
		panelJugador.add(btEliminarJugador);
		
		dateJugador = new JDateChooser();
		dateJugador.setEnabled(false);
		dateJugador.getCalendarButton().setEnabled(false);
		dateJugador.setBounds(116, 105, 101, 20);
		panelJugador.add(dateJugador);
		
		
		lblBuscar = new JLabel("Buscar: ");
		lblBuscar.setBounds(227, 12, 52, 14);
		panelJugador.add(lblBuscar);
		
		txtBuscarJugador = new JTextField();
		txtBuscarJugador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				buscarJugador();
			}
		});
		txtBuscarJugador.setBounds(278, 8, 111, 20);
		panelJugador.add(txtBuscarJugador);
		txtBuscarJugador.setColumns(10);
		
		btLimpiarJugador = new JButton("Limpiar");
		btLimpiarJugador.setEnabled(false);
		btLimpiarJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarJugador();
			}
		});
		btLimpiarJugador.setBounds(399, 7, 78, 23);
		panelJugador.add(btLimpiarJugador);
		
		panelPersonaje = new JPanel();
		tabbedPane.addTab("Personaje", null, panelPersonaje, null);
		panelPersonaje.setLayout(null);
		
		lblNombre_1 = new JLabel("Nombre: ");
		lblNombre_1.setBounds(10, 11, 75, 14);
		panelPersonaje.add(lblNombre_1);
		
		lblDescripcion = new JLabel("Fecha");
		lblDescripcion.setBounds(10, 36, 75, 14);
		panelPersonaje.add(lblDescripcion);
		
		lblFechaInicio = new JLabel("Clase: ");
		lblFechaInicio.setBounds(10, 61, 75, 14);
		panelPersonaje.add(lblFechaInicio);
		
		lblFechaEntrega = new JLabel("Raza:");
		lblFechaEntrega.setBounds(10, 86, 75, 14);
		panelPersonaje.add(lblFechaEntrega);
		
		lblEmpresa = new JLabel("Usuario:");
		lblEmpresa.setBounds(10, 111, 75, 14);
		panelPersonaje.add(lblEmpresa);
		
		txtNombrePersonaje = new JTextField();
		txtNombrePersonaje.setEditable(false);
		txtNombrePersonaje.setBounds(96, 8, 123, 20);
		panelPersonaje.add(txtNombrePersonaje);
		txtNombrePersonaje.setColumns(10);
		
		btNuevoPersonaje = new JButton("Nuevo");
		btNuevoPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoPersonaje();
			}
		});
		btNuevoPersonaje.setBounds(10, 136, 86, 23);
		panelPersonaje.add(btNuevoPersonaje);
		
		btCancelarPersonaje = new JButton("Cancelar");
		btCancelarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarPersonaje();
			}
		});
		btCancelarPersonaje.setEnabled(false);
		btCancelarPersonaje.setBounds(10, 170, 86, 23);
		panelPersonaje.add(btCancelarPersonaje);
		
		btInsertarPersonaje = new JButton("Insertar");
		btInsertarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersonaje();
			}
		});
		btInsertarPersonaje.setEnabled(false);
		btInsertarPersonaje.setBounds(116, 136, 86, 23);
		panelPersonaje.add(btInsertarPersonaje);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(229, 36, 248, 198);
		panelPersonaje.add(scrollPane_1);
		
		tablaPersonajes = new TablaPersonajes();
		tablaPersonajes.addKeyListener(new KeyAdapter() {
			// elimina el personaje seleccionada pulsando suprimir
			@Override
			public void keyReleased(KeyEvent e) {
				if(tablaPersonajes.personajeSeleccionado() != null){
					if(e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
						eliminarPersonaje();
					}
				}
			}
		});
		tablaPersonajes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				personajeSeleccionado();
			}
		});
		scrollPane_1.setViewportView(tablaPersonajes);
		
		btModificarPersonaje = new JButton("Modificar");
		btModificarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPersonaje();
			}
		});
		btModificarPersonaje.setEnabled(false);
		btModificarPersonaje.setBounds(238, 245, 105, 23);
		panelPersonaje.add(btModificarPersonaje);
		
		btEliminarPersonaje = new JButton("Eliminar");
		btEliminarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarPersonaje();
			}
		});
		btEliminarPersonaje.setEnabled(false);
		btEliminarPersonaje.setBounds(365, 245, 112, 23);
		panelPersonaje.add(btEliminarPersonaje);
		
		cbClasePersonaje = new JComboBox();
		cbClasePersonaje.setEnabled(false);
		cbClasePersonaje.setBounds(96, 57, 123, 22);
		for(int i=0 ; i < clases.length; i++){
			cbClasePersonaje.addItem(clases[i]);
		}
		panelPersonaje.add(cbClasePersonaje);
		
		cbRazaPersonaje = new JComboBox();
		cbRazaPersonaje.setEnabled(false);
		cbRazaPersonaje.setBounds(96, 82, 123, 22);
		for(int i=0 ; i < razas.length; i++){
			cbRazaPersonaje.addItem(razas[i]);
		}
		panelPersonaje.add(cbRazaPersonaje);
		
		datePersonaje = new JDateChooser();
		datePersonaje.setEnabled(false);
		datePersonaje.getCalendarButton().setEnabled(false);
		datePersonaje.setBounds(95, 30, 124, 20);
		panelPersonaje.add(datePersonaje);
		
		cbJugadorPersonaje = new ComboJugadores();
		cbJugadorPersonaje.setEnabled(false);
		cbJugadorPersonaje.setBounds(95, 107, 124, 22);
		panelPersonaje.add(cbJugadorPersonaje);
		
		label = new JLabel("Buscar: ");
		label.setBounds(229, 11, 49, 14);
		panelPersonaje.add(label);
		
		txtBuscarPersonaje = new JTextField();
		txtBuscarPersonaje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				buscarPersonaje();
			}
		});
		txtBuscarPersonaje.setColumns(10);
		txtBuscarPersonaje.setBounds(288, 8, 97, 20);
		panelPersonaje.add(txtBuscarPersonaje);
		
		btLimpiarPersonaje = new JButton("Limpiar");
		btLimpiarPersonaje.setEnabled(false);
		btLimpiarPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarPersonaje();
			}
		});
		btLimpiarPersonaje.setBounds(391, 7, 86, 23);
		panelPersonaje.add(btLimpiarPersonaje);
		
		panelBatalla = new JPanel();
		tabbedPane.addTab("Batalla", null, panelBatalla, null);
		panelBatalla.setLayout(null);
		
		lblNombre_2 = new JLabel("Duracion: ");
		lblNombre_2.setBounds(10, 36, 91, 14);
		panelBatalla.add(lblNombre_2);
		
		lblApellido = new JLabel("Historial: ");
		lblApellido.setBounds(10, 61, 91, 14);
		panelBatalla.add(lblApellido);
		
		lblNacionalidad = new JLabel("Fecha: ");
		lblNacionalidad.setBounds(10, 11, 91, 14);
		panelBatalla.add(lblNacionalidad);
		
		lblFechaNacimiento = new JLabel("Atacante: ");
		lblFechaNacimiento.setBounds(10, 86, 91, 14);
		panelBatalla.add(lblFechaNacimiento);
		
		lblNewLabel = new JLabel("Defensor: ");
		lblNewLabel.setBounds(10, 111, 91, 14);
		panelBatalla.add(lblNewLabel);
		
		btInsertarBatalla = new JButton("Insertar");
		btInsertarBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarBatalla();
			}
		});
		btInsertarBatalla.setEnabled(false);
		btInsertarBatalla.setBounds(111, 139, 86, 23);
		panelBatalla.add(btInsertarBatalla);
		
		btNuevoBatalla = new JButton("Nuevo");
		btNuevoBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoBatalla();
			}
		});
		btNuevoBatalla.setBounds(10, 139, 91, 23);
		panelBatalla.add(btNuevoBatalla);
		
		btCancelarBatalla = new JButton("Cancelar");
		btCancelarBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelarBatalla();
			}
		});
		btCancelarBatalla.setEnabled(false);
		btCancelarBatalla.setBounds(10, 171, 91, 23);
		panelBatalla.add(btCancelarBatalla);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(231, 36, 246, 201);
		panelBatalla.add(scrollPane_2);
		
		tablaBatallas = new TablaBatallas();
		tablaBatallas.addKeyListener(new KeyAdapter() {
			// elimina la batalla seleccionada pulsando suprimir
			@Override
			public void keyReleased(KeyEvent e) {
				if(tablaBatallas.batallaSeleccionado() != null){
					if(e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
						eliminarBatalla();
					}
				}
			}
		});
		tablaBatallas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				batallaSeleccionado();
			}
		});
		scrollPane_2.setViewportView(tablaBatallas);
		
		btModificarBatalla = new JButton("Modificar");
		btModificarBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarBatalla();
			}
		});
		btModificarBatalla.setEnabled(false);
		btModificarBatalla.setBounds(231, 248, 120, 23);
		panelBatalla.add(btModificarBatalla);
		
		btEliminarBatalla = new JButton("Eliminar");
		btEliminarBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarBatalla();
			}
		});
		btEliminarBatalla.setEnabled(false);
		btEliminarBatalla.setBounds(361, 248, 116, 23);
		panelBatalla.add(btEliminarBatalla);
		
		txtDuracionBatalla = new JTextField();
		txtDuracionBatalla.setEditable(false);
		txtDuracionBatalla.setBounds(98, 33, 123, 20);
		panelBatalla.add(txtDuracionBatalla);
		txtDuracionBatalla.setColumns(10);
		
		txtHistorialBatalla = new JTextField();
		txtHistorialBatalla.setEditable(false);
		txtHistorialBatalla.setBounds(98, 58, 123, 20);
		panelBatalla.add(txtHistorialBatalla);
		txtHistorialBatalla.setColumns(10);
		
		dateBatalla = new JDateChooser();
		dateBatalla.setEnabled(false);
		dateBatalla.getCalendarButton().setEnabled(false);
		dateBatalla.setBounds(98, 5, 123, 20);
		panelBatalla.add(dateBatalla);
		
		cbAtacanteBatalla = new ComboJugadores();
		cbAtacanteBatalla.setEnabled(false);
		cbAtacanteBatalla.setBounds(98, 82, 123, 22);
		panelBatalla.add(cbAtacanteBatalla);
		
		cbDefensorBatalla = new ComboJugadores();
		cbDefensorBatalla.setEnabled(false);
		cbDefensorBatalla.setBounds(98, 107, 123, 22);
		panelBatalla.add(cbDefensorBatalla);
		
		label_1 = new JLabel("Buscar: ");
		label_1.setBounds(231, 11, 49, 14);
		panelBatalla.add(label_1);
		
		txtBuscarBatalla = new JTextField();
		txtBuscarBatalla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				buscarBatalla();
			}
		});
		txtBuscarBatalla.setColumns(10);
		txtBuscarBatalla.setBounds(290, 8, 97, 20);
		panelBatalla.add(txtBuscarBatalla);
		
		btLimpiarBatalla = new JButton("Limpiar");
		btLimpiarBatalla.setEnabled(false);
		btLimpiarBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarBatalla();
			}
		});
		btLimpiarBatalla.setBounds(391, 7, 86, 23);
		panelBatalla.add(btLimpiarBatalla);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		menuItemGuardar = new JMenuItem("Guardar");
		menuItemGuardar.setEnabled(false);
		menuItemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarDatos();
			}
		});
		mnArchivo.add(menuItemGuardar);
		
		menuItemGuardarComo = new JMenuItem("Guardar Como");
		menuItemGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarComo();
			}
		});
		mnArchivo.add(menuItemGuardarComo);
		
		mnExportar = new JMenu("Exportar XML");
		menuBar.add(mnExportar);
		
		mntmJugadores = new JMenuItem("Jugador");
		mntmJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jugadores.size() > 0){
					Fichero.jugadorXML(jugadores, "jugador");
				}
				else{
					Mensaje.mensajeError("No hay jugadores");
				}
			}
		});
		mnExportar.add(mntmJugadores);
		
		mntmPersonaje = new JMenuItem("Personaje");
		mntmPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(personajes.size() > 0){
					Fichero.personajeXML(personajes, "personaje");
				}
				else{
					Mensaje.mensajeError("No hay personajes");
				}
			}
		});
		mnExportar.add(mntmPersonaje);
		
		mntmBatalla = new JMenuItem("Batalla");
		mntmBatalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(batallas.size() > 0){
					Fichero.batallaXML(batallas, "batalla");
				}
				else{
					Mensaje.mensajeError("No hay batallas");
				}
			}
		});
		mnExportar.add(mntmBatalla);
	}
}
