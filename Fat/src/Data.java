import java.util.List;

public class Data {
	
	private List<dataCluster> clusters;

	public void setClusters(int numClusters) {
		for(int i = 0; i<numClusters; i++) {
			createCluster();
		}
	}

}
