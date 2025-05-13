
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
    }
	
}
