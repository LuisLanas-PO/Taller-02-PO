package Taller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class lectorArchivos {

	private static String REGISTROS = "Registros.txt";
	private static String HABITATS = "Habitats.txt";
	private static String POKEDEX = "Pokedex.txt";
	private static String GIMNASIOS = "Gimnasios.txt";
	private static String ALTO_MANDO = "AltoMando.txt";

	public static List<Pokemon> cargarPokedex() {
		List<Pokemon> pokedex = new ArrayList<>();
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
	
}