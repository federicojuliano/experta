package matrices.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import matrices.entities.TipoOperacionEnum;
import matrices.manager.MatrizManagerImpl;

public final class MatrizUtils {

	public static TipoOperacionEnum determinarOperacion(String operacionString) {
		for (TipoOperacionEnum tipoOperacion : TipoOperacionEnum.values()) {
			if(tipoOperacion.getDescripcion().equalsIgnoreCase(operacionString)) {
				return tipoOperacion;
			}
		}
		System.out.println("Tipo de operacion no reconocida.");
		return TipoOperacionEnum.OPERACION_NO_RECONOCIDA;
	}
	
	public static EjecucionDTO cargarDesdeArchivo(String nombreArchivo) {
		
		EjecucionDTO response = new EjecucionDTO();
		
		File file = new File(nombreArchivo);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			
			int dimensionMatriz = Integer.valueOf(sc.nextLine());
			response.setMatrizManager(new MatrizManagerImpl(dimensionMatriz));
			
			while(sc.hasNextLine()) {
				String request = sc.nextLine();
				response.getRequestList().add(request);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sc != null) {
				sc.close();
			}
		}
		return response;
	}
}
