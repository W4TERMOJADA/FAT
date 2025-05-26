public class FileSystem {
    private FAT fat;
    private Directory root = new Directory("/");
    private Directory tmp;
    private ProcessManager pm = new ProcessManager();

    public FileSystem(int clusters) {
        fat = new FAT(clusters);
        tmp = new Directory("tmp");
        root.add(tmp);
    }

    public void showMeta() {
        System.out.println("=== Metadatos del sistema de ficheros ===");
        fat.show();
        System.out.println("Root entries: " + root.list());
    }

    public void createDir(String name, Directory parent) {
        Directory d = new Directory(name);
        fat.allocate(d);
        parent.add(d);
    }

    public void createFile(String name, String content, Directory parent) {
        File f = new File(name, content);
        fat.allocate(f);
        parent.add(f);
    }

    public void move(String name, Directory from, Directory to) {
        GenericFile<?> f = from.remove(name);
        to.add(f);
    }

    public void deleteDir(String name, Directory parent) {
        GenericFile<?> f = parent.remove(name);
        if (f instanceof Directory) {
            // free all clusters under directory
            freeAll((Directory) f);
        }
    }

    private void freeAll(Directory dir) {
        for (GenericFile<?> f : dir.list()) {
            if (f.startCluster > 0) {
                Cluster c = fat.getClusterById(f.startCluster);
                fat.freeChain(c);
            }
            if (f instanceof Directory) freeAll((Directory) f);
        }
    }

    public Directory getRoot() { return root; }
    public Directory getTmp() { return tmp; }
    public ProcessManager getPm() { return pm; }
}