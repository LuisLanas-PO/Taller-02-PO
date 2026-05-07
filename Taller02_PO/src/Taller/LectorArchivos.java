package Taller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivos {

	private static String REGISTROS = "Registros.txt";
	private static String HABITATS = "Habitats.txt";
	private static String POKEDEX = "Pokedex.txt";
	private static String GIMNASIOS = "Gimnasios.txt";
	private static String ALTO_MANDO = "AltoMando.txt";

	public static List<Pokemon> cargarPokedex(List<Pokemon> pokedex) {
		try (BufferedReader br = new BufferedReader(new FileReader(POKEDEX))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.trim().isEmpty())
					continue;
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String habitat = partes[1];
				double porcentaje = Double.parseDouble(partes[2]);
				int vida = Integer.parseInt(partes[3]);
				int ataque = Integer.parseInt(partes[4]);
				int defensa = Integer.parseInt(partes[5]);
				int ataqueEsp = Integer.parseInt(partes[6]);
				int defensaEsp = Integer.parseInt(partes[7]);
				int velocidad = Integer.parseInt(partes[8]);
				String tipo = partes[9];
				pokedex.add(new Pokemon(nombre, habitat, porcentaje, vida, ataque, defensa, ataqueEsp, defensaEsp,velocidad,tipo));
			}		
		} catch (IOException e) {
			System.out.println("Error al leer Pokedex.txt: " + e.getMessage());
		}
		return pokedex;
	}
	
	public static List<Gimnasio> cargarGimnasios() {
        List<Gimnasio> gimnasios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(GIMNASIOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(";");

                int numero = Integer.parseInt(datos[0]);
                String lider = datos[1];
                String estado = datos[2];
                int cantPokemon = Integer.parseInt(datos[3]);

                List<Pokemon> pokemons = new ArrayList<>();
                for (int i = 0; i < cantPokemon; i++) {
                    pokemons.add(new Pokemon(datos[4 + i]));
                }

                gimnasios.add(new Gimnasio(numero, lider, estado, pokemons));
            }
        } catch (IOException e) {
            System.out.println("Error al leer Gimnasios.txt: " + e.getMessage());
        }
        return gimnasios;
    }
	
	public static List<AltoMando> cargarAltoMando() {
        List<AltoMando> altoMando = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ALTO_MANDO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");

                int numero = Integer.parseInt(partes[0]);
                String nombre = partes[1];

                List<Pokemon> pokemons = new ArrayList<>();
                for (int i = 2; i < partes.length; i++) {
                    pokemons.add(new Pokemon(partes[i]));
                }

                altoMando.add(new AltoMando(numero, nombre, pokemons));
            }
        } catch (IOException e) {
            System.out.println("Error al leer AltoMando.txt: " + e.getMessage());
        }
        return altoMando;
    }
	
	public static Jugador cargarRegistros(List<Pokemon> pokedex) {
	    try (BufferedReader br = new BufferedReader(new FileReader(REGISTROS))) {

	        String primeraLinea = br.readLine();
	        if (primeraLinea == null || primeraLinea.trim().isEmpty()) return null;

	        String[] datosCuenta = primeraLinea.split(";");
	        String nombre = datosCuenta[0];
	        int medallas = Integer.parseInt(datosCuenta[1]);

	        ArrayList<Pokemon> pokemonsJugador = new ArrayList<>();
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            if (linea.trim().isEmpty()) continue;
	            String[] datos = linea.split(";");
	            String nombrePokemon = datos[0];
	            String estado = datos[1];

	            Pokemon encontrado = buscarEnPokedex(nombrePokemon, pokedex);
	            if (encontrado != null) {
	                encontrado.setEstado(estado);
	                pokemonsJugador.add(encontrado);
	            }
	        }

	        return new Jugador(nombre, medallas, pokemonsJugador);
	    } catch (IOException e) {
	        System.out.println("Error al leer Registros.txt: " + e.getMessage());
	        return null;
	    }
	}

	private static Pokemon buscarEnPokedex(String nombre, List<Pokemon> pokedex) {
        for (Pokemon p : pokedex) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return new Pokemon(p.getNombre(), p.getHabitat(), p.getPorcentajeAparicion(),
                                   p.getVida(), p.getAtaque(), p.getDefensa(),
                                   p.getAtaqueEspecial(), p.getDefensaEspecial(),
                                   p.getVelocidad(), p.getTipo());
            }
        }
        System.out.println("Advertencia: Pokémon '" + nombre + "' no encontrado en la Pokédex.");
        return null;
    }
	
}