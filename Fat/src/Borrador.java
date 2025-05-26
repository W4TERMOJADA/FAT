public class Borrador implements Runnable {
    private Directory tmp;
    public Borrador (Directory tmp) { this.tmp = tmp; }
    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                synchronized(tmp) {
                    tmp.list().clear();
                    System.out.println("[BorraTMP] tmp vaciado");
                }
            }
        } catch(InterruptedException e) {
            // terminando
        }
    }
}