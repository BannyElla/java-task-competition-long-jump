package longjump;

/**
 *
 * @author Ella
 */
public class Athlete implements Runnable {

    private Track track;
    private String name;
    private int points = 0;

    public Athlete(Track track, String name) {
        this.track = track;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            track.jump(name);
            points += track.getPoints();
            track.startNextGamer();
        }
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }
}
