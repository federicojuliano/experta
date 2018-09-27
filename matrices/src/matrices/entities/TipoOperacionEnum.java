package matrices.entities;

public enum TipoOperacionEnum {

	UPDATE("update"),
	
	QUERY("query"),
	
	OPERACION_NO_RECONOCIDA("operacion no reconocida");
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	TipoOperacionEnum(String operacion) {
		this.descripcion = operacion;
	}
	
}
