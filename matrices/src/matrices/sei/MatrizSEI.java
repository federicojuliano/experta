package matrices.sei;

import matrices.entities.TipoOperacionEnum;
import matrices.entities.TipoRespuesta;
import matrices.manager.MatrizManager;
import matrices.manager.MatrizManagerImpl;
import matrices.utils.MatrizUtils;

public class MatrizSEI {

	public String execute(String request) {
		
		String[] params = request.split(" ");
		TipoOperacionEnum tipoOperacion = MatrizUtils.determinarOperacion(params[0]);
		String respuesta = null;
		MatrizManagerImpl matrizManager;
		
		try {
			int dimensionMatriz = 0;
			matrizManager = new MatrizManagerImpl(dimensionMatriz);
		} catch (Exception e) {
			e.printStackTrace();
			return TipoRespuesta.ERROR.getDescripcion();
		}
		switch (tipoOperacion) {
		case QUERY:
			break;
		case UPDATE:
			boolean actualizacionOK = matrizManager.actualizarCelda(Integer.valueOf(params[1]), Integer.valueOf(params[2]), Integer.valueOf(params[3]), Integer.valueOf(params[4]));
			if(!actualizacionOK) {
				return TipoRespuesta.ERROR.getDescripcion();
			}
			break;
		default:
			return TipoRespuesta.ERROR.getDescripcion();
		}
		return respuesta;
	}
}
