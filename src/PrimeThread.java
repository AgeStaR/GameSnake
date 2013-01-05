/**
 * Created with IntelliJ IDEA.
 * User: Plobzik
 * Date: 06.01.13
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
class PrimeThread extends Thread {
    MyPanel panel;

    PrimeThread(MyPanel panel) {
        this.panel = panel;
    }

    public void run() {
        try {
            while (panel.getRunning()) {
                panel.repaint();
                Thread.sleep(150);
            }
        } catch (InterruptedException ex) {
        }
    }
}
