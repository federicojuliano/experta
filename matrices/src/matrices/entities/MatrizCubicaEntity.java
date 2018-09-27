package matrices.entities;

public class MatrizCubicaEntity {

	private int[][][] matriz;
	
	private int dimension;
	
	public int getDimension() {
		return dimension;
	}

	public int[][][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][][] matriz) {
		this.matriz = matriz;
	}

	public MatrizCubicaEntity(int dimension) throws Exception {
		if(dimension >100 || dimension < 1) {
			throw new Exception();
		}
		this.dimension = dimension;
		this.matriz = new int[dimension][dimension][dimension];
	}
}