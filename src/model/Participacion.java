package model;

public class Participacion {

	private int id_deportista;
	private int id_evento;
	private int id_equipo;
	private String edad;
	private String medalla;
	
	
	public Participacion(int id_deportista, int id_evento, int id_equipo, String edad, String medalla) {
		super();
		this.id_deportista = id_deportista;
		this.id_evento = id_evento;
		this.id_equipo = id_equipo;
		this.edad = edad;
		this.medalla = medalla;
	}
	
	
}
