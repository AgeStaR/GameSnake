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
