import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        FileSystem fs = new FileSystem(10);
        ProcessManager pm = fs.getPm();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENÚ GENÉRICO ---");
            System.out.println("1. Mostrar metadatos del sistema de ficheros");
            System.out.println("2. Crear directorio");
            System.out.println("3. Crear archivo");
            System.out.println("4. Mover archivo");
            System.out.println("5. Eliminar directorio");
            System.out.println("6. Listar procesos en ejecución");
            System.out.println("7. Lanzar proceso");
            System.out.println("8. Matar proceso");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    fs.showMeta();
                    break;
                case 2:
                    System.out.print("Nombre de nuevo directorio: ");
                    String dirName = scanner.nextLine();
                    System.out.print("Directorio padre ('/' o 'tmp'): ");
                    String parentName = scanner.nextLine();
                    if ("tmp".equals(parentName)) {
                        fs.createDir(dirName, fs.getTmp());
                    } else {
                        fs.createDir(dirName, fs.getRoot());
                    }
                    System.out.println("Directorio '" + dirName + "' creado.");
                    break;
                case 3:
                    System.out.print("Nombre de archivo: ");
                    String fileName = scanner.nextLine();
                    System.out.print("Contenido de archivo: ");
                    String content = scanner.nextLine();
                    System.out.print("Directorio destino ('/' o 'tmp'): ");
                    String targetDir = scanner.nextLine();
                    if ("tmp".equals(targetDir)) {
                        fs.createFile(fileName, content, fs.getTmp());
                    } else {
                        fs.createFile(fileName, content, fs.getRoot());
                    }
                    System.out.println("Archivo '" + fileName + "' creado.");
                    break;
                case 4:
                    System.out.print("Nombre de archivo a mover: ");
                    String moveName = scanner.nextLine();
                    System.out.print("Directorio origen ('/' o 'tmp'): ");
                    String src = scanner.nextLine();
                    System.out.print("Directorio destino ('/' o 'tmp'): ");
                    String dest = scanner.nextLine();
                    Directory from = "tmp".equals(src) ? fs.getTmp() : fs.getRoot();
                    Directory to = "tmp".equals(dest) ? fs.getTmp() : fs.getRoot();
                    fs.move(moveName, from, to);
                    System.out.println("Archivo '" + moveName + "' movido.");
                    break;
                case 5:
                    System.out.print("Nombre de directorio a eliminar: ");
                    String delDir = scanner.nextLine();
                    System.out.print("Directorio padre ('/' o 'tmp'): ");
                    String delParent = scanner.nextLine();
                    Directory parent = "tmp".equals(delParent) ? fs.getTmp() : fs.getRoot();
                    fs.deleteDir(delDir, parent);
                    System.out.println("Directorio '" + delDir + "' eliminado.");
                    break;
                case 6:
                    pm.list();
                    break;
                case 7:
                    System.out.print("Nombre del proceso a lanzar: ");
                    String procName = scanner.nextLine();
                    System.out.print("Intervalo de borra tmp (ms, 0=ninguno): ");
                    int interval = Integer.parseInt(scanner.nextLine());
                    if (interval > 0) {
                        pm.launch(procName, new Borrador(fs.getTmp()));
                    } else {
                        pm.launch(procName, () -> {
                            try { Thread.sleep(Long.MAX_VALUE); } catch (InterruptedException ignored) {}
                        });
                    }
                    System.out.println("Proceso '" + procName + "' lanzado.");
                    break;
                case 8:
                    System.out.print("Nombre del proceso a matar: ");
                    String killName = scanner.nextLine();
                    pm.kill(killName);
                    System.out.println("Proceso '" + killName + "' matado.");
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

        scanner.close();
        System.out.println("Consola finalizada.");
        System.exit(0);
    }
}