package matrices.ejecucion;

import org.junit.Test;

import matrices.manager.MatrizManagerImpl;
import matrices.utils.EjecucionDTO;
import matrices.utils.MatrizUtils;

public class PruebaDelCodigoTest {

	@Test
	public void pruebaCodigoDesdeArchivo() {
		EjecucionDTO response = MatrizUtils.cargarDesdeArchivo("EJECUCION.txt");
		MatrizManagerImpl manejadorMatrices = response.getMatrizManager();

		for (String request : response.getRequestList()) {
			System.out.println(manejadorMatrices.execute(request));
		}
	}
}
