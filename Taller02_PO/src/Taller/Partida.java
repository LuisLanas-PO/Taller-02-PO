package Taller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Partida {
	
	private Jugador jugador;
    private int medallas;
    private String gimnasioActual;
    private boolean partidaActiva;
    
    
	public Partida(Jugador jugador, int medallas, String gimnasioActual, boolean partidaActiva) { //constructo para cargar los datos guardados del txt o rellenarlos al comenzar una partida nueva
		super();
		this.jugador = jugador;
		this.medallas = medallas;
		this.gimnasioActual = gimnasioActual;
		this.partidaActiva = partidaActiva;
	}
	
	public static void continuarPartida() {
		System.out.println("1) Revisar equipo.");
		System.out.println("2) Salir a capturar.");
		System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
		System.out.println("4) Retar un gimnasio.");
		System.out.println("5) Desafío al Alto Mando.");
		System.out.println("6) Curar Pokémon.");
		System.out.println("7) Guardar.");
		System.out.println("8) Guardar y Salir.");
		
	}
	public static void nuevaPartida() {
		System.out.println("adios");
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int getMedallas() {
		return medallas;
	}
	public void setMedallas(int medallas) {
		this.medallas = medallas;
	}
	public String getGimnasioActual() {
		return gimnasioActual;
	}
	public void setGimnasioActual(String gimnasioActual) {
		this.gimnasioActual = gimnasioActual;
	}
	public boolean isPartidaActiva() {
		return partidaActiva;
	}
	public void setPartidaActiva(boolean partidaActiva) {
		this.partidaActiva = partidaActiva;
	}
    
    
}
