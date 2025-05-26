
public class File extends GenericFile<String> {
    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }
    @Override
    public int getSize() { return content.length(); }
}
