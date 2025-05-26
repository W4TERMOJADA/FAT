import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class FAT {
    private List<Cluster> clusters;
    public FAT(int num) {
        clusters = new ArrayList<>(num);
        for (int i = 0; i < num; i++) clusters.add(new Cluster());
    }
    public void show() { clusters.forEach(System.out::println); }
    public Cluster allocate(GenericFile<?> f) {
        for (Cluster c : clusters) {
            if (c.isAvailable() && !c.isDamaged()) {
                c.setAvailable(false);
                c.setFile(f);
                f.startCluster = c.getId();
                return c;
            }
        }
        throw new RuntimeException("No free clusters");
    }
    public void freeChain(Cluster c) {
        while (c != null && !c.isAvailable()) {
            c.setAvailable(true);
            c.setFile(null);
            int next = c.getNext();
  
          c.setNext(-1);
            c = next > 0 ? getClusterById(next) : null;
        }
    }
    public Cluster getClusterById(int id) {
        return clusters.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}