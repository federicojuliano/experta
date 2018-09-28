package matrices.manager;

import matrices.entities.MatrizCubicaEntity;
import matrices.entities.TipoOperacionEnum;
import matrices.entities.TipoRespuesta;
import matrices.utils.MatrizUtils;

/**
 * @author usuario Clase manejadora de matrices
 */
public class MatrizManagerImpl implements MatrizManager {

	private MatrizCubicaEntity matriz;

	/**
	 * Constructor parametrizado, recibe la dimension de la matriz
	 * 
	 * @param dimensionMatriz
	 * @throws Exception
	 */
	public MatrizManagerImpl(int dimensionMatriz) throws Exception {
		construirMatriz(dimensionMatriz);
	}
	
	private void construirMatriz(int dimension) throws Exception {
		this.matriz = new MatrizCubicaEntity(dimension);
		return;
	}

	/** Ejemplos de request:<br/>
	 * UPDATE 2 2 2 55 <br/>
	 * QUERY 1 1 1 2 2 2
	 * @param request
	 * @return
	 */
	public String execute(String request) {

		request = request.toUpperCase();
		String[] params = request.split(" ");
		TipoOperacionEnum tipoOperacion = MatrizUtils.determinarOperacion(params[0]);

		switch (tipoOperacion) {
		case QUERY:
			int resultadoSuma = this.sumarValores(Integer.valueOf(params[1]), Integer.valueOf(params[2]), Integer.valueOf(params[3]), Integer.valueOf(params[4]), Integer.valueOf(params[5]), Integer.valueOf(params[6]));
			return request + " -> " + TipoRespuesta.SUCCESS.getDescripcion() + " / " + resultadoSuma;
		case UPDATE:
			boolean actualizacionOK = this.actualizarCelda(Integer.valueOf(params[1]), Integer.valueOf(params[2]), Integer.valueOf(params[3]), Integer.valueOf(params[4]));
			if (!actualizacionOK) {
				return request + " -> " + TipoRespuesta.ERROR.getDescripcion();
			}
			return request + " -> " + TipoRespuesta.SUCCESS.getDescripcion();
		default:
			return request + " -> " + TipoRespuesta.ERROR.getDescripcion();
		}
	}

	/**
	 * Devuelve false si no se pudo hacer la actualizacion.<br/>
	 * Valores validos x, y, z: de 1 hasta la dimension de la matriz,
	 * inclusive.<br/>
	 * Valores validos w: de -109 hasta 109, inclusive.
	 **/
	@Override
	public boolean actualizarCelda(int x, int y, int z, int w) {
		if (x < 1 || x > matriz.getDimension() || y < 1 || y > matriz.getDimension() || z < 1
				|| z > matriz.getDimension() || w < -109 || w > 109) {
			System.out.println("Argumentos de actualizacion de celda invalidos.");
			return false;
		}
		matriz.getMatriz()[x-1][y-1][z-1] = w;
		return true;
	}

	@Override
	public int sumarValores(int x1, int y1, int z1, int x2, int y2, int z2) {
		int suma = 0;
		boolean matStart = true;
		boolean fiStart = true;
		boolean coStart = true;
		for(int mat = 0 ; mat <= this.getMatriz().getDimension() ; mat++) {
			if(matStart) {
				mat = x1;
				matStart = false;
			}
			for(int fi = 1 ; fi <= this.getMatriz().getDimension() ; fi++) {
				if(fiStart) {
					fi = y1;
					fiStart = false;
				}
				for(int co = 1 ; co <= this.getMatriz().getDimension() ; co++) {
					if(coStart) {
						co = z1;
						coStart = false;
					}
					suma += this.getMatriz().getMatriz()[mat-1][fi-1][co-1];
					if(mat == x2 && fi == y2 && co == z2) {
						return suma;
					}
				}
			}
		}
		return suma;
	}

	public MatrizCubicaEntity getMatriz() {
		return matriz;
	}

}
