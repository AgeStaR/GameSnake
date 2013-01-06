class PrimeThread extends Thread {
    World world;
    MyPanel panel;

    PrimeThread(World world,MyPanel panel ) {
        this.world = world;
        this.panel = panel;
    }
    

    public void run() {
        try {
            while (true) {
                world.tick();
                panel.repaint();
                Thread.sleep(150);
            }
        } catch (InterruptedException ex) {
        }
    }
}
