package Taller;

public class Partida {
	
	private Jugador jugador;
    private int medallas;
    private String gimnasioActual;
    private boolean partidaActiva;
    
    
	public Partida(Jugador jugador, int medallas, String gimnasioActual, boolean partidaActiva) {
		super();
		this.jugador = jugador;
		this.medallas = medallas;
		this.gimnasioActual = gimnasioActual;
		this.partidaActiva = partidaActiva;
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
