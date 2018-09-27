package matrices.manager;

import matrices.entities.MatrizEntity;

/**
 * @author usuario
 * Clase manejadora de matrices
 */
public class MatrizManagerImpl implements MatrizManager {

	private MatrizEntity matriz;

	/** 
	 * Devuelve false si no se pudo hacer la actualizacion.<br/>
	 * Valores validos x, y, z: de 1 hasta la dimension de la matriz, inclusive.<br/>
	 * Valores validos w: de -109 hasta 109, inclusive.
	 **/
	@Override
	public boolean actualizarCelda(int x, int y, int z, int w, MatrizEntity matriz) {
		if(x < 1 || x > matriz.getDimension()
				|| y < 1 || y > matriz.getDimension()
				|| z < 1 || z > matriz.getDimension()
				|| w < -109 || w > 109) {
			System.out.println("Argumentos de actualizacion de matriz invalidos.");
			return false;
		}
		matriz.getMatriz()[x][y][z] = w;
		return true;
	}

	@Override
	public int sumarValores(int x1, int y1, int z1, int x2, int y2, int z2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MatrizEntity construirMatriz(int dimension) throws Exception {
		MatrizEntity matrizResponse = new MatrizEntity(dimension);
		this.matriz = matrizResponse;
		return matrizResponse;
	}

}
