import java.util.List;

public class Fat {
	
	private List<Cluster> clusters;
	
	public Fat(int numClusters) {
		for(int i = 0; i<numClusters; i++) {
			createCluster(numClusters);
		}
	}
	
	private static void createCluster(int numClusters) {
		Cluster cluster = new Cluster();
	}

}
