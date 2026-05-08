package Taller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
		
		Scanner escribe  = new Scanner(System.in);
		
		List<Pokemon> pokedex = lectorArchivos.cargarPokedex();
		Jugador jugador = lectorArchivos.cargarRegistros(pokedex);
		System.out.println("Bienvenido " + jugador.getNombre() + "!!");
		System.out.println("");
		
		int opcion = -1;
		
		while (opcion != 8) {
			
			System.out.println("1) Revisar equipo.");
			System.out.println("2) Salir a capturar.");
			System.out.println("3) Acceso al PC (cambiar Pokémon del equipo).");
			System.out.println("4) Retar un gimnasio.");
			System.out.println("5) Desafio al Alto Mando.");
			System.out.println("6) Curar Pokémon.");
			System.out.println("7) Guardar.");
			System.out.println("8) Guardar y Salir.");
			System.out.print("Ingrese su opción: ");
			
			opcion = escribe.nextInt();
			
			if (opcion == 8) {
				lectorArchivos.guardarRegistros(jugador);
				System.out.println("");
				System.out.println("Nos vemos entrenador...");
				System.out.println("");
				break;
			}
			
			switch (opcion) {
			case 1:
				jugador.mostrarEquipo();
				break;
			case 2:
				salirCapturar(jugador, pokedex);
				break;
			case 3:
				jugador.accesoPC();
				break;
			case 4:
				Gimnasio.retarGimnasio();
				break;
			case 5:
				AltoMando.desafioAltoMando();
				break;
			case 6:
				jugador.curarPokemon();
				break;
			case 7:
				lectorArchivos.guardarRegistros(jugador);
				break;
			default:
				System.out.println("Opción invalida, intente de nuevo");
				System.out.println("");
			}
			
		}
		
	}

	private static void salirCapturar(Jugador jugador, List<Pokemon> pokedex) {
		Scanner escribe = new Scanner(System.in);
		
		System.out.println("");
	    System.out.println("Zonas disponibles:");
	    System.out.println("1) Lago");
	    System.out.println("2) Cueva");
	    System.out.println("3) Montaña");
	    System.out.println("4) Bosque");
	    System.out.println("5) Prado");
	    System.out.println("6) Mar");
	    System.out.println("7) Volver al menu.");

	    System.out.print("Seleccione zona: ");

	    int opcion = escribe.nextInt();
	    escribe.nextLine();
	    
	    if (opcion == 7) {
	    	return;
	    }

	    String habitat = "";

	    switch (opcion) {

	    case 1:
	        habitat = "Lago";
	        break;

	    case 2:
	        habitat = "Cueva";
	        break;

	    case 3:
	        habitat = "Montaña";
	        break;

	    case 4:
	        habitat = "Bosque";
	        break;

	    case 5:
	        habitat = "Prado";
	        break;

	    case 6:
	        habitat = "Mar";
	        break;

	    default:
	        System.out.println("Zona inválida.");
	        System.out.println("");
	        return;
	    }
	    
	    ArrayList<Pokemon> posibles = new ArrayList<>();

	    for (Pokemon pokemon : pokedex) {

	        if (pokemon.getHabitat().equalsIgnoreCase(habitat) && !jugador.tienePokemon(pokemon.getNombre())) {
	            posibles.add(pokemon);
	        }
	    }

	    if (posibles.isEmpty()) {

	    	System.out.println("No quedan Pokémon por capturar en esta zona.");
	        return;
	    }

	    Random random = new Random();

	    Pokemon encontrado = posibles.get(random.nextInt(posibles.size()));
	    
	    System.out.println("");
	    System.out.println("Oh!! Ha aparecido un increible " + encontrado.getNombre() + "!!");
	    System.out.println("Que deseas hacer?");
	    System.out.println("");
	    
	    System.out.println("1) Capturar");
	    System.out.println("2) Huir");
	    System.out.println("");
	    System.out.print("Ingrese su opción: ");
	    int decision = escribe.nextInt();

	    if (decision == 1) {

	        boolean espacioEquipo = jugador.getPokemons().size() < 6;

	        jugador.agregarPokemon(encontrado);

	        lectorArchivos.guardarRegistros(jugador);

	        System.out.println(encontrado.getNombre() + " capturado con éxito!!");

	        if (espacioEquipo) {
	            System.out.println(encontrado.getNombre() + " ha sido agregado a tu equipo!");
	            System.out.println("");
	        } else {
	            System.out.println(encontrado.getNombre() + " fue enviado al PC.");
	            System.out.println("");
	        }

	    } else {
	        System.out.println("Has huido.");
	    }

	}

	public static void nuevaPartida() {
		String nombre = Jugador.pedirNombre();
		Jugador jugadorNuevo = new Jugador(nombre);
		lectorArchivos.limpiarRegistros(jugadorNuevo);
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
