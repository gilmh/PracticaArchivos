package org.hectordam.practicahector.beans;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hectordam.practicahector.base.Batalla;

public class TablaBatallas extends JTable{

	private ArrayList<Batalla> listaBatalla;
	private DefaultTableModel modelo;
	
	public TablaBatallas(){
		super();
		
		listaBatalla = new ArrayList<Batalla>();
	}
	
	/**
	 *  crea la tabla con una cabecera y asigna los datos del vector recibido por parametro al vector
	 * @param lista
	 */
	public void inicializar(ArrayList<Batalla> lista){
		
		String[] columna = {"Atacante", "Defensor", "Fecha"};
		
		modelo = new DefaultTableModel(columna, 0){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.setModel(modelo);
		
		listaBatalla = lista;
	}
	
	/**
	 *  rellena la tabla
	 */
	public void listar(){
		
		DateFormat formateadorFechas = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
		
		// elimina las filas de la tabla
		modelo.setNumRows(0);
		
		// escribe tantas filas como elementos tenga el vector y se insertan en la tabla
		for(Batalla batalla: listaBatalla){
			
			Object[] fila = {batalla.getUsuarioAtacante().getUsuario(), batalla.getUsuarioDefensor().getUsuario(), formateadorFechas.format(batalla.getFechaBatalla())};
			
			modelo.addRow(fila);
		}
	}
	
	/**
	 *  rellena la tabla comparando con el filtro
	 * @param filtro
	 */
	public void listaFiltrada(String filtro){
		
		DateFormat formateadorFechas = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
		
		// elimina las filas de la tabla
		modelo.setNumRows(0);
		
		// escribe tantas filas como elementos tenga el vector y se insertan en la tabla
		for(Batalla batalla: listaBatalla){
			
			if(formateadorFechas.format(batalla.getFechaBatalla()).contains(filtro.toLowerCase()) || 
					batalla.getUsuarioAtacante().getUsuario().toLowerCase().contains(filtro.toLowerCase()) || 
					batalla.getUsuarioDefensor().getUsuario().toLowerCase().contains(filtro.toLowerCase())){
				
				Object[] fila = {batalla.getUsuarioAtacante().getUsuario(), batalla.getUsuarioDefensor().getUsuario(), formateadorFechas.format(batalla.getFechaBatalla())};
				
				modelo.addRow(fila);
			}
		}
		
	}
	
	/**
	 *  devuelve el equipo seleccionado en la tabla
	 * @return
	 */
	public Batalla batallaSeleccionado(){
		
		// guarda el numero de la fila seleccionada
		int fila = this.getSelectedRow();
		
		// si no hay ningua fila devuelve null
		if(fila == -1){
			return null;
		}
		
		// guarda los nombres de los usuarios de la fila seleccionada
		String nombre1 = (String) this.getValueAt(fila, 0);
		String nombre2 = (String) this.getValueAt(fila, 1);
		
		// compara el nombre obtenido con cada posicion del vector y lo devuelve si existe
		Batalla batalla;
		for(int i = 0; i < listaBatalla.size(); i++){
			
			batalla = listaBatalla.get(i);
			if(batalla.getUsuarioAtacante().getUsuario().equals(nombre1) && batalla.getUsuarioDefensor().getUsuario().equals(nombre2)){
				return batalla;
			}
		}
		return null;
	}
	
}
