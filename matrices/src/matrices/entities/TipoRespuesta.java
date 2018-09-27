package matrices.entities;

public enum TipoRespuesta {

	SUCCESS("SUCCESS"),
	
	ERROR("ERROR");
	
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	TipoRespuesta(String descripcion){
		this.descripcion = descripcion;
	}
}
