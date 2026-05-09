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

	public static void desafioAltoMando(Jugador jugador, List<AltoMando> altoMando, List<Gimnasio> gimnasios) {
		for (Gimnasio g : gimnasios) {
			if (!jugador.getMedallas().contains(g.getLider())) {
				System.out.println("");
				System.out.println("Debes derrotar todos los gimnasios primero");
				return;
			}
		}
		Scanner escribe = new Scanner(System.in);
		for (AltoMando medalla : altoMando) {
			System.out.println("");
			System.out.println("Desafiando a " + medalla.getNombre() + " !!");
			if (!jugador.tienePokemonsVivos()) {
				System.out.println("");
				System.out.println("No tienes Pokémon disponibles para combatir");
				System.out.println("Todos tus Pokémon están derrotados");
				return;
			}
			Pokemon actual = jugador.obtenerPrimerPokemonVivo();
			if (actual == null) {
				System.out.println("No tienes Pokémon disponibles");
				return;
			}
			for (Pokemon rival : medalla.getPokemons()) {
				boolean peleaTerminada = false;
				while (!peleaTerminada) {
					System.out.println("");
					System.out.println("Tu Pokémon: " + actual.getNombre());
					System.out.println("Rival: " + rival.getNombre());
					System.out.println("1) Atacar");
					System.out.println("2) Cambiar Pokémon");
					System.out.println("3) Rendirse");
					int opcion = escribe.nextInt();
					switch (opcion) {
					case 1:
						boolean victoria = Gimnasio.combatir(actual, rival);
						if (!victoria) {
							actual.setEstado("Derrotado");
							if (!jugador.tienePokemonsVivos()) {
								System.out.println("");
								System.out.println("Te has quedado sin pokemons en tu equipo!");
								System.out.println("Volviendo al menu...");
								return;
							}
							System.out.println("");
							System.out.println("Tu Pokémon fue derrotado");
							System.out.println("1) Cambiar Pokémon");
							System.out.println("2) Rendirse");
							int respuesta = escribe.nextInt();
							if (respuesta == 1) {
								actual = jugador.elegirPokemonCombate();
								if (actual == null) {
									return;
								}
							} else {
								return;
							}
							continue;
						}
						peleaTerminada = true;
						break;
					case 2:
						actual = jugador.elegirPokemonCombate();
						if (actual == null) {
							return;
						}
						break;
					case 3:
						System.out.println("Te has rendido");
						return;
					default:
						System.out.println("Opción invalida, intente de nuevo");
					}
				}
			}
		}
		System.out.println("");
		System.out.println("¡Has derrotado al Alto Mando!");
	}

}