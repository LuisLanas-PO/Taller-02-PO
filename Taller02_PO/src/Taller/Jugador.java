package Taller;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

    private String nombre;
    private ArrayList<String> medallas;
    private ArrayList<Pokemon> pokemons;
    
    public Jugador(String nombre, ArrayList<String> medallas, ArrayList<Pokemon> pokemonsJugador) { //Por si tiene partida guardada
        this.nombre = nombre;
        this.medallas = medallas;
        this.pokemons = pokemonsJugador;
    }
    
	public Jugador(String nombre) { //Por si comienza una nueva partida
		super();
		this.nombre = nombre;
	    this.medallas = new ArrayList<>();
	    this.pokemons = new ArrayList<>();
	}
	
	public void mostrarEquipo() {
		System.out.println("");
		System.out.println("Equipo actual:");
		
		if (pokemons.isEmpty()) {
	        System.out.println("No tienes Pokémon.");
	        System.out.println("");
	        return;
		}
		
		for (int i = 0; i < pokemons.size() && i < 6; i++) {

	        Pokemon pokemon = pokemons.get(i);

	        System.out.println((i + 1) + ") " + pokemon.getNombre() + " | " + pokemon.getTipo() + " | " + "Stats totales: " + pokemon.getSumaStats());
	    }
		System.out.println("");
	}
	
	public void agregarMedalla(String gimnasio) {
	    if (medallas.isEmpty() || (medallas.size() == 1 && medallas.contains("none"))) {
	        medallas.clear();
	    }
	    medallas.add(gimnasio);
	}
	
	public boolean tienePokemon(String nombre) {
	    for (Pokemon p : pokemons) {
	        if (p.getNombre().equalsIgnoreCase(nombre)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static String pedirNombre() {

	    Scanner sc = new Scanner(System.in);
	    System.out.print("Ingrese apodo: ");
	    return sc.nextLine();
	}
	
	public void agregarPokemon(Pokemon p) {
        pokemons.add(p);
    }
	
	public String getNombre() {
		return nombre;
	}
	public ArrayList<String> getMedallas() {
		return medallas;
	}

	public void setMedallas(ArrayList<String> medallas) {
		this.medallas = medallas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(ArrayList<Pokemon> equipo) {
		this.pokemons = equipo;
	}

	public static void accesoPC() {
		// TODO Auto-generated method stub
		
	}

	public void curarPokemon() {
		// TODO Auto-generated method stub
		
	}
    
    
}