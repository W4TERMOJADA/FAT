public abstract class GenericFile<T> {
    protected String name;
    protected int startCluster;
    protected T content;

    public String getName() { return name; }
    public int getStartCluster() { return startCluster; }
    public abstract int getSize();
    @Override
    public String toString() { return name; }
}