public class Cluster {
    private Boolean A; // Available
    private Boolean D; // Damaged
    private int N;     // Next cluster pointer
    private GenericFile<?> genericFile;
    private static int nextId = 1;
    private final int id;

    public Cluster() {
        this.id = nextId++;
        this.A = true;
        this.D = false;
        this.N = -1;
    }
    
    public int getId() { return id; }
    public Boolean isAvailable() { return A; }
    public void setAvailable(Boolean a) { A = a; }
    public Boolean isDamaged() { return D; }
    public int getNext() { return N; }
    public void setNext(int n) { N = n; }
    public GenericFile<?> getFile() { return genericFile; }
    public void setFile(GenericFile<?> f) { genericFile = f; }

    @Override
    public String toString() {
        return "Cluster ID: " + id + " [A=" + A + ", D=" + D + ", N=" + N + ", file=" +
               (genericFile != null ? genericFile.getName() : "null") + "]";
    }
}
