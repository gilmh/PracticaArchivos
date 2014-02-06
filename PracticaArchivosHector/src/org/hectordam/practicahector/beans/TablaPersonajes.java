package org.hectordam.practicahector.beans;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hectordam.practicahector.base.Jugador;
import org.hectordam.practicahector.base.Personaje;

public class TablaPersonajes extends JTable{

	private ArrayList<Personaje> listaPersonaje;
	private DefaultTableModel modelo;
	
	public TablaPersonajes(){
		super();
		
		listaPersonaje = new ArrayList<Personaje>();
	}
	
	/**
	 *  crea la tabla con una cabecera y asigna los datos del vector recibido por parametro al vector
	 * @param lista
	 */
	public void inicializar(ArrayList<Personaje> lista){
		
		String[] columna = {"Nombre", "Clase", "Raza"};
		
		modelo = new DefaultTableModel(columna, 0){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.setModel(modelo);
		
		listaPersonaje = lista;
	}
	
	/**
	 *  rellena la tabla
	 */
	public void listar(){
		
		// elimina las filas de la tabla
		modelo.setNumRows(0);
		
		// escribe tantas filas como elementos tenga el vector y se insertan en la tabla
		for(Personaje personaje: listaPersonaje){
			
			Object[] fila = {personaje.getNombre(), personaje.getClase(), personaje.getRaza()};
			
			modelo.addRow(fila);
		}
	}
	
	/**
	 *  rellena la tabla comparando con el filtro
	 * @param filtro
	 */
	public void listaFiltrada(String filtro){
		
		// elimina las filas de la tabla
		modelo.setNumRows(0);
		
		// escribe tantas filas como elementos tenga el vector y se insertan en la tabla
		for(Personaje personaje: listaPersonaje){
			
			if(personaje.getNombre().toLowerCase().contains(filtro.toLowerCase()) || personaje.getClase().toLowerCase().contains(filtro.toLowerCase()) || personaje.getRaza().toLowerCase().contains(filtro.toLowerCase())){
				
				Object[] fila = {personaje.getNombre(), personaje.getClase(), personaje.getRaza()};
			
				modelo.addRow(fila);
			}
		}
		
	}
	
	/**
	 *  devuelve el equipo seleccionado en la tabla
	 * @return
	 */
	public Personaje personajeSeleccionado(){
		
		// guarda el numero de la fila seleccionada
		int fila = this.getSelectedRow();
		
		// si no hay ningua fila devuelve null
		if(fila == -1){
			return null;
		}
		
		// guarda el nombre del usuario de la fila seleccionada
		String nombre = (String) this.getValueAt(fila, 0);
		
		// compara el nombre obtenido con cada posicion del vector y lo devuelve si existe
		Personaje personaje = null;
		for(int i=0; i < listaPersonaje.size(); i++){
			
			personaje = listaPersonaje.get(i);
			if(personaje.getNombre().equals(nombre)){
				return personaje;
			}
		}
		return null;
	}
	
}
