package matrices.utils;

import java.util.ArrayList;
import java.util.List;

import matrices.manager.MatrizManagerImpl;

public class EjecucionDTO {

	private MatrizManagerImpl matrizManager;
	
	public List<String> getRequestList() {
		return requestList;
	}

	public void setRequestList(List<String> requestList) {
		this.requestList = requestList;
	}

	private List<String> requestList = new ArrayList<>();

	public MatrizManagerImpl getMatrizManager() {
		return matrizManager;
	}

	public void setMatrizManager(MatrizManagerImpl matrizManager) {
		this.matrizManager = matrizManager;
	}

}
