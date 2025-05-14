import java.util.ArrayList;
import java.util.List;

public class Fat {
	
	private List<Cluster> clusters = new ArrayList<Cluster>();
	
	public Fat(int numClusters) {
		for(int i = 0; i<numClusters; i++) {
			createCluster(numClusters);
		}
	}
	
	private void createCluster(int numClusters){
		Cluster cluster = new Cluster();
		clusters.add(cluster);
	}

	public void showClusters() {
		System.out.println("Clusters: " + clusters);		
	}

}
