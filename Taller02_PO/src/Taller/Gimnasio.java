package Taller;

import java.util.*;

public class Gimnasio {
	
	private int numero;
    private String lider;
    private String estado;
    private List<Pokemon> pokemons;
    
	public Gimnasio(int numero, String lider, String estado, List<Pokemon> pokemons) { //Cargar los datos de los lideres
		super();
		this.numero = numero;
		this.lider = lider;
		this.estado = estado;
		this.pokemons = pokemons;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getLider() {
		return lider;
	}
	public void setLider(String lider) {
		this.lider = lider;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public static void retarGimnasio() {
		// TODO Auto-generated method stub
		
	}
	
}