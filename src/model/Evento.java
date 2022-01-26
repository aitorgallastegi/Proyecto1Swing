package model;

public class Evento {

	private int id;
	private String nombre;
	private int id_olimpiada;
	private int id_deporte;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId_olimpiada() {
		return id_olimpiada;
	}
	public void setId_olimpiada(int id_olimpiada) {
		this.id_olimpiada = id_olimpiada;
	}
	public int getId_deporte() {
		return id_deporte;
	}
	public void setId_deporte(int id_deporte) {
		this.id_deporte = id_deporte;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + id_deporte;
		result = prime * result + id_olimpiada;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (id != other.id)
			return false;
		if (id_deporte != other.id_deporte)
			return false;
		if (id_olimpiada != other.id_olimpiada)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", id_olimpiada=" + id_olimpiada + ", id_deporte="
				+ id_deporte + "]";
	}
	
	
	
}
