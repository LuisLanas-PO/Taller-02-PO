//Angello Ponce ; 22025486-0 / Luis Lanas ;219609620
package Taller;
import java.util.*;

public class Taller02_PO {

	static Scanner escribe = new Scanner(System.in);

	public static void main(String[] args) {

		menuPrincipal();
	}

	private static void menuPrincipal() {

		int opcion = 0;
		do {
			System.out.println("1) Continuar");
			System.out.println("2) Nueva Partida");
			System.out.println("3) Salir");
			System.out.print(">> ");

			if (escribe.hasNextInt()) {

				opcion = escribe.nextInt();
				escribe.nextLine();

				switch (opcion) {
				case 1:
					opContinuar();
					break;
				case 2:
					opNuevaPartida();
					break;
				case 3:
					System.out.println("Nos vemos pronto entonces!!");
					break;
				default:
					System.out.println("Error, ingrese un número válido");
					break;
				}
			} else {
				System.out.println("Error, ingrese un caracter válido (números enteros entre 1 y 3): ");
				escribe.next();
			}

		} while (opcion != 3);

	}

	private static void opNuevaPartida() {
		// TODO Auto-generated method stub
		
	}

	private static void opContinuar() {
		// TODO Auto-generated method stub
		
	}

}
