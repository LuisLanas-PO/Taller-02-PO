package Taller;

import java.util.*;

public class Gimnasio {

	private int numero;
	private String lider;
	private String estado;
	private List<Pokemon> pokemons;

	public Gimnasio(int numero, String lider, String estado, List<Pokemon> pokemons) { //Cargar los datos de los lideres
		super();
		this.numero = numero;
		this.lider = lider;
		this.estado = estado;
		this.pokemons = pokemons;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public static void retarGimnasio(Jugador jugador, List<Gimnasio> gimnasios) {
		Scanner escribe = new Scanner(System.in);
		System.out.println("");
		System.out.println("A cuál líder deseas retar??");
		for (int i = 0; i < gimnasios.size(); i++) {
			Gimnasio gimnasio = gimnasios.get(i);
			String estado = "Sin derrotar";
			if (jugador.getMedallas().contains(gimnasio.getLider())) {
				estado = "Derrotado";
			}
			System.out.println((i + 1) + ") " + gimnasio.getLider() + " - Estado: " + estado);
		}
		System.out.println((gimnasios.size() + 1) + ") Volver al menú");
		System.out.print("Ingrese opción: ");
		int opcion = escribe.nextInt();
		if (opcion == gimnasios.size() + 1) {
			return;
		}
		if (opcion < 1 || opcion > gimnasios.size()) {
			System.out.println("Opción invalida, intente de nuevo");
			return;
		}
		Gimnasio gimnasio = gimnasios.get(opcion - 1);
		if (jugador.getMedallas().contains(gimnasio.getLider())) {
			System.out.println("Ese gimnasio ya fue derrotado");
			return;
		}
		if (!jugador.tienePokemonsVivos()) {
			System.out.println("");
			System.out.println("No tienes Pokémon disponibles para combatir");
			System.out.println("Todos tus Pokémon están derrotados");
			System.out.println("");
			return;
		}
		System.out.println("");
		System.out.println("Desafiando a " + gimnasio.getLider() + " !!");
		Pokemon actual = jugador.obtenerPrimerPokemonVivo();
		if (actual == null) {
			System.out.println("No tienes Pokémon disponibles");
			return;
		}
		for (Pokemon rival : gimnasio.getPokemons()) {

			boolean peleaTerminada = false;

			while (!peleaTerminada) {

				System.out.println("");
				System.out.println(jugador.getNombre() + " saca a " + actual.getNombre() + "!!");
				System.out.println(gimnasio.getLider() + " saca a " + rival.getNombre() + "!!");
				System.out.println("");

				System.out.println("1) Atacar");
				System.out.println("2) Cambiar Pokémon");
				System.out.println("3) Rendirse");

				int decision = escribe.nextInt();

				switch (decision) {

				case 1:
					boolean victoria = combatir(actual, rival);
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
					return;
				}
			}
		}
		jugador.getMedallas().add(gimnasio.getLider());
		lectorArchivos.guardarRegistros(jugador);
		System.out.println("Has derrotado a " + gimnasio.getLider() + " !!");
		System.out.println("");
	}

	public static boolean combatir(Pokemon p1, Pokemon p2) {
		double e1 = p1.getSumaStats();
		double e2 = p2.getSumaStats();
		int t1 = TablaTipos.obtenerIndiceTipo(p1.getTipo());
		int t2 = TablaTipos.obtenerIndiceTipo(p2.getTipo());
		double ef = TablaTipos.obtenerEfectividad(t1, t2);
		System.out.println(p1.getNombre() + " -> " + e1 + " puntos");
		System.out.println(p2.getNombre() + " -> " + e2 + " puntos");
		if (ef > 1) {
			System.out.println(p1.getNombre() + " es efectivo contra " + p2.getNombre() + "!");
			e1 *= 2;
			System.out.println("");
			System.out.println("Nuevo puntaje:");
			System.out.println(p1.getNombre() + " -> " + e1);
			System.out.println(p2.getNombre() + " -> " + e2);
		} else if (ef < 1) {
			System.out.println(p1.getNombre() + " no es efectivo contra " + p2.getNombre() + "!");
			e1 /= 2;
			System.out.println("");
			System.out.println("Nuevo puntaje:");
			System.out.println(p1.getNombre() + " -> " + e1);
			System.out.println(p2.getNombre() + " -> " + e2);
		}
		if (e1 >= e2) {
			p2.setEstado("Derrotado");
			return true;
		} else {
			p1.setEstado("Derrotado");
			return false;
		}
	}

}