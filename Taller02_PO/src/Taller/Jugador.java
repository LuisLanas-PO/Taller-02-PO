package Taller;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private ArrayList<Pokemon> equipo;
    
	public Jugador(String nombre, ArrayList<Pokemon> equipo) {
		super();
		this.nombre = nombre;
		this.equipo = equipo;
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