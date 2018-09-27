package matrices.sei;

import org.junit.Test;

public class MatrizSeiTest {

	@Test
	public void executeTest() {
		MatrizSEI matrizSei = new MatrizSEI();
		String request = "UPDATE 2 2 2 4";
		matrizSei.execute(request);
	}
}
