package org.hectordam.practicahector.beans;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hectordam.practicahector.base.Jugador;

public class TablaJugadores extends JTable{

	private ArrayList<Jugador> listaJugador;
	private DefaultTableModel modelo;
	
	public TablaJugadores(){
		super();
		
		listaJugador = new ArrayList<Jugador>();
	}
	
	/**
	 *  crea la tabla con una cabecera y asigna los datos del vector recibido por parametro al vector
	 * @param lista
	 */
	public void inicializar(ArrayList<Jugador> lista){
		
		String[] columnas = {"Usuario", "Correo Electronico", "Pais"};
		
		modelo = new DefaultTableModel(columnas, 0){
			@Override
			public boolean isCellEditable(int fila, int columna) {
				return false;
			}			
		};
		this.setModel(modelo);
		
		listaJugador = lista;
	}
	
	/**
	 *  rellena la tabla
	 */
	public void listar(){
		
		// elimina las filas de la tabla
		modelo.setNumRows(0);
		
		// escribe tantas filas como elementos tenga el vector y se insertan en la tabla
		for(Jugador jugador: listaJugador){
			
			Object[] fila = {jugador.getUsuario(), jugador.getCorreoElectronico(), jugador.getPais()};
			
			modelo.addRow(fila);
		}		
	}
	
	/**
	 *  rellena la tabla comparando con el filtro
	 * @param filtro
	 */
	public void listafiltrada(String filtro){
		
		// elimina las filas de la tabla
		modelo.setNumRows(0);
		
		// escribe tantas filas como elementos tenga el vector y se insertan en la tabla
		for(Jugador jugador: listaJugador){
			
			if(jugador.getUsuario().toLowerCase().contains(filtro.toLowerCase()) || jugador.getCorreoElectronico().toLowerCase().contains(filtro.toLowerCase()) || jugador.getPais().toLowerCase().contains(filtro.toLowerCase())){
				
				Object[] fila = {jugador.getUsuario(), jugador.getCorreoElectronico(), jugador.getPais()};
				
				modelo.addRow(fila);
			}
		}
	}
	
	/**
	 *  devuelve el equipo seleccionado en la tabla
	 * @return
	 */
	public Jugador jugadorSeleccionado(){
		
		// guarda el numero de la fila seleccionada
		int fila = this.getSelectedRow();
		
		// si no hay ningua fila devuelve null
		if(fila == -1){
			return null;
		}
		
		// guarda el nombre del usuario de la fila seleccionada
		String nombre = (String) this.getValueAt(fila, 0);
		
		// compara el nombre obtenido con cada posicion del vector y lo devuelve si existe
		Jugador jugador = null;
		for(int i = 0; i < listaJugador.size(); i++){
			jugador = listaJugador.get(i);
			if(jugador.getUsuario().equals(nombre)){
				return jugador;
			}
		}
		return null;
	}
	
	
}
