package matrices.utils;

import org.junit.Assert;
import org.junit.Test;

import matrices.entities.TipoOperacionEnum;

public class MatrizUtilsTest {

	@Test
	public void determinarOperacionMinusculaTest() {
		String operacionString = "query";
		TipoOperacionEnum operacion = MatrizUtils.determinarOperacion(operacionString);
		Assert.assertEquals(operacion.getDescripcion(), operacionString);
	}
	
	@Test
	public void determinarOperacionMayusculaTest() {
		String operacionString = "UPDATE";
		TipoOperacionEnum operacion = MatrizUtils.determinarOperacion(operacionString);
		Assert.assertEquals(operacion.getDescripcion(), operacionString.toLowerCase());
	}
}
