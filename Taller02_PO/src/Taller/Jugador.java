package Taller;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private ArrayList<Pokemon> equipo;
    
	public Jugador(String nombre, ArrayList<Pokemon> equipo) { //Por si tiene partida guardada
		super();
		this.nombre = nombre;
		this.equipo = equipo;
	}
	
	public Jugador(String nombre) { //Por si comienza una nueva partida
		super();
		this.nombre = nombre;
		this.equipo = new ArrayList<>();
	}
	
	public static void mostrarEquipo() {
		System.out.println("Equipo actual:");
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