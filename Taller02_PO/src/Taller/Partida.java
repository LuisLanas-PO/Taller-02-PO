package Taller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		List<Pokemon> pokedex = new ArrayList<>();
		LectorArchivos.cargarPokedex(pokedex);
		LectorArchivos.cargarRegistros(pokedex);
	}

	public static void nuevaPartida() {
		Scanner respuesta = new Scanner(System.in);
		System.out.print("Ingrese su nombre: ");
		String nombre = respuesta.nextLine();
		Jugador jugador = new Jugador(nombre);
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
