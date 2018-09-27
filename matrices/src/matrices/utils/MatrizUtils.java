package matrices.utils;

import matrices.entities.TipoOperacionEnum;

public class MatrizUtils {

	public TipoOperacionEnum determinarOperacion(String operacionString) {
		for (TipoOperacionEnum tipoOperacion : TipoOperacionEnum.values()) {
			if(tipoOperacion.getDescripcion().equals(operacionString)) {
				return tipoOperacion;
			}
		}
		System.out.println("Tipo de operacion no reconocida.");
		return null;
	}
}
