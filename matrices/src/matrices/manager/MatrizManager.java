package matrices.manager;

import matrices.entities.MatrizEntity;

public interface MatrizManager {

	public boolean actualizarCelda(int x, int y, int z, int w, MatrizEntity matriz);
	
	public int sumarValores(int x1, int y1, int z1, int x2, int y2, int z2);
	
	public MatrizEntity construirMatriz(int dimension) throws Exception;
}
