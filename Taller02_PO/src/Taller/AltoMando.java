package Taller;

import java.util.*;

public class AltoMando {
	
	private int numero;
    private String nombre;
    private List<Pokemon> pokemons;
    
    public AltoMando(int numero, String nombre, List<Pokemon> pokemons) { //Constructor para cargar los datos de los Altos Mandos
        this.numero = numero;
        this.nombre = nombre;
        this.pokemons = pokemons;
    }

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	@Override
	public String toString() {
		return "AltoMando [numero=" + numero + ", nombre=" + nombre + ", pokemons=" + pokemons + "]";
	}

	public static void desafioAltoMando() {
		// TODO Auto-generated method stub
		
	}
    
}