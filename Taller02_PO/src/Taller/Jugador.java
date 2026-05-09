package Taller;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

	private String nombre;
	private ArrayList<String> medallas;
	private ArrayList<Pokemon> pokemons;

	public Jugador(String nombre, ArrayList<String> medallas, ArrayList<Pokemon> pokemonsJugador) { // Por si tiene partida guardada
		this.nombre = nombre;
		this.medallas = medallas;
		this.pokemons = pokemonsJugador;
	}

	public Jugador(String nombre) { //Por si comienza una nueva partida
		super();
		this.nombre = nombre;
		this.medallas = new ArrayList<>();
		this.medallas.add("none");
		this.pokemons = new ArrayList<>();
	}

	public void mostrarEquipo() {
		System.out.println("");
		System.out.println("Equipo actual:");

		if (pokemons.isEmpty()) {
			System.out.println("No tienes Pokémon");
			System.out.println("");
			return;
		}

		for (int i = 0; i < pokemons.size() && i < 6; i++) {

			Pokemon pokemon = pokemons.get(i);

			System.out.println((i + 1) + ") " + pokemon.getNombre() + " | " + pokemon.getTipo() + " | "
					+ "Stats totales: " + pokemon.getSumaStats());
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

		Scanner escribe = new Scanner(System.in);
		System.out.print("Ingrese su apodo de jugador: ");
		return escribe.nextLine();
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

	public void accesoPC() {

		Scanner escribe = new Scanner(System.in);
		int opcion = 0;
		while (opcion != 2) {
			System.out.println("");
			System.out.println("Bienvenido al PC");
			for (int i = 0; i < pokemons.size(); i++) {
				Pokemon p = pokemons.get(i);
				if (i < 6) {
					System.out.println((i + 1) + ") " + p.getNombre() + " | Equipo");
				} else {
					System.out.println((i + 1) + ") " + p.getNombre() + " | PC");
				}
			}
			System.out.println("");
			System.out.println("Que desea hacer??");
			System.out.println("");
			System.out.println("1) Cambiar Pokémon");
			System.out.println("2) Salir");
			System.out.print("Ingrese su opción: ");
			System.out.println("");
			opcion = escribe.nextInt();
			switch (opcion) {
			case 1:
				System.out.print("Seleccione el primer Pokémon: ");
				int pos1 = escribe.nextInt() - 1;
				System.out.print("Seleccione el segundo Pokémon: ");
				int pos2 = escribe.nextInt() - 1;
				if (pos1 < 0 || pos1 >= pokemons.size() || pos2 < 0 || pos2 >= pokemons.size()) {
					System.out.println("Posiciones inválidas.");
				} else {
					Pokemon aux = pokemons.get(pos1);
					pokemons.set(pos1, pokemons.get(pos2));
					pokemons.set(pos2, aux);
					System.out.println("Opción invalida, intente de nuevo");
				}
				break;
			case 2:
				return;
			default:
				System.out.println("Opción invalida, intente de nuevo");
			}
		}
	}

	public Pokemon elegirPokemonCombate() {
		Scanner escribe = new Scanner(System.in);
		System.out.println("");
		System.out.println("Elige un Pokémon:");
		int limite = Math.min(6, pokemons.size());
		for (int i = 0; i < limite; i++) {
			Pokemon p = pokemons.get(i);
			if (p.getEstado().equalsIgnoreCase("Vivo")) {
				System.out.println((i + 1) + ") " + p.getNombre() + " | " + p.getTipo());
			}
		}
		System.out.print("Ingrese opción: ");
		int opcion = escribe.nextInt() - 1;
		if (opcion < 0 || opcion >= limite) {
			System.out.println("Opción invalida, intente de nuevo");
			return null;
		}
		Pokemon elegido = pokemons.get(opcion);
		if (elegido.getEstado().equalsIgnoreCase("Derrotado")) {
			System.out.println("Ese Pokémon está derrotado.");
			return null;
		}
		return elegido;
	}

	public boolean tienePokemonsVivos() {
		int limite = Math.min(6, pokemons.size());
		for (int i = 0; i < limite; i++) {
			if (pokemons.get(i).getEstado().equalsIgnoreCase("Vivo")) {
				return true;
			}
		}
		return false;
	}

	public void curarPokemon() {
		for (Pokemon pokemon : pokemons) {
			pokemon.setEstado("Vivo");
		}
		System.out.println("");
		System.out.println("Todos los Pokémon fueron curados");
		System.out.println("");
	}

	public Pokemon obtenerPrimerPokemonVivo() {
		for (int i = 0; i < pokemons.size(); i++) {
			Pokemon pokemon = pokemons.get(i);
			if (pokemon.getEstado().equalsIgnoreCase("Vivo")) {
				return pokemon;
			}
		}

		return null;
	}
}