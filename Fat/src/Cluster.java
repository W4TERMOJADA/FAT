
public class Cluster {
	
	//METADATA
	private Boolean A;
	private Boolean D; //crear posibilidad de dañado
	private int N;
	private Boolean E;
	
	//DATA
	private GenericFile genericFile;
	
	//Sistema de identificadores
	private static int nextId = 1; 
    private final int id;
    
    public Cluster() {
    	this.id=nextId++;
    	this.A = true;
    	this.N =-1;
    	this.D=false;
    }

	@Override
	public String toString() {	
		return "Cluster ID: " + id + " [A=" + A + ", D=" + D + ", N=" + N + ", genericFile=" + genericFile + "]";
	}
    
    
	
}
