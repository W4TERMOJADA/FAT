
import java.util.*;

public class Directory extends GenericFile<List<GenericFile<?>>> {
    private Map<String, GenericFile<?>> entries = new LinkedHashMap<>();

    public Directory(String name) {
        this.name = name;
        this.content = new ArrayList<>();
    }

    public void add(GenericFile<?> f) {
        entries.put(f.getName(), f);
        content.add(f);
    }
    public GenericFile<?> remove(String name) {
        GenericFile<?> f = entries.remove(name);
        content.remove(f);
        return f;
    }
    public GenericFile<?> get(String name) { return entries.get(name); }
    public Collection<GenericFile<?>> list() { return entries.values(); }
    @Override
    public int getSize() { return entries.size(); }
}

