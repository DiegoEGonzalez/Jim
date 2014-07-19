
public class Main {

    public static void main(String[] args) {
        GameEngine frame = new GameEngine();//Creates a JFrame using GameEngine
        final Game game = new Game();
        frame.add(game);
        frame.setVisible(true); //makes the JFrame visible

        Runnable r1 = new Runnable() {
            public void run() { //Sets an operation for a thread to do, currently used for the actual game application
                try {
                    while (true) {
                        game.repaint();//repaint the Game
                        game.update();//update the Game
                        Thread.sleep(35); //sleeps the thread, makes it wait, 35 milliseconds
                    }
                } catch (InterruptedException iex) {}
            }
        };
        Thread thr1 = new Thread(r1); //Creates a thread with runnable r1
        thr1.start(); //starts the first thread
    }
}
