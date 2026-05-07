package Taller;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int medallas;
    private ArrayList<Pokemon> equipo;
    
	public Jugador(String nombre, int medallas ,ArrayList<Pokemon> pokemonsJugador) { //Por si tiene partida guardada
		super();
		this.nombre = nombre;
		this.medallas = medallas;
		this.equipo = pokemonsJugador;
	}
	
	public Jugador(String nombre) { //Por si comienza una nueva partida
		super();
		this.nombre = nombre;
		this.medallas = 0;
		this.equipo = new ArrayList<>();
	}
	
	public static void mostrarEquipo() {
		System.out.println("Equipo actual:");
		for (Pokemon pokemon : equipo) {
	        System.out.println(pokemon.getNombre());
	    }
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Pokemon> getEquipo() {
		return equipo;
	}
	public void setEquipo(ArrayList<Pokemon> equipo) {
		this.equipo = equipo;
	}
    
    
}