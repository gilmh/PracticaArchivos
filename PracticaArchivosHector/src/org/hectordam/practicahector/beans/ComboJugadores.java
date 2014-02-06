package org.hectordam.practicahector.beans;

import java.util.ArrayList;

import javax.swing.JComboBox;

import org.hectordam.practicahector.base.Jugador;

public class ComboJugadores extends JComboBox<String>{

	private ArrayList<Jugador> listaJugadores;
	
	/**
	 *  crea el vector
	 */
	public ComboJugadores(){
		super();
		
		listaJugadores = new ArrayList<Jugador>();
	}
	
	/**
	 *  asigna los datos del vector que recibe por parametro en el vector
	 * @param lista
	 */
	public void inicializar(ArrayList<Jugador> lista){		
		listaJugadores = lista;
	}
	
	/**
	 *  lista los datos del vector en el combobox
	 */
	public void listar(){
		
		// elimina los elementos del combobox
		this.removeAllItems();
		
		// si el vector esta vacio inserta el elemento en ele combobox
		if(listaJugadores.size() == 0){
			this.addItem("<No hay datos>");
			return;
		}
		
		// si el vector tienes datos inserta el primer elemento y el vector en el combobox
		this.addItem("<Selecciona>");
		
		for(Jugador jugador : listaJugadores){
			this.addItem(jugador.getUsuario());
		}
	}
	
	/**
	 *  devuelve el equipo seleccionado del comobox
	 * @return
	 */
	public Jugador jugadorSeleccionado(){
		
		// si el combobox esta vacio devuelve null
		if(this.getSelectedIndex() == -1 || this.getSelectedIndex() == 0){
			return null;
		}
		
		// si tiene elementos devuelve la posicion del vector menos 1 por el elemento inicial que hemos asignado que no pertenece al vector
		Jugador jugador = listaJugadores.get(this.getSelectedIndex() - 1);
		
		return jugador;
	}
	
}
