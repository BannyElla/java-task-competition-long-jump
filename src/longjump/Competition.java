/*
Соревнование "Прыжки в длину"
Участвуют два спротсмена. Каждый по очереди совершает прыжок с разбега. Мксимальная длина, на которую может прыгнуть спортсмен - 440 см.
За каждые 40 см длины прыжка спортсмен получает 1 балл. Баллы складываются. Каждый спортсмен имеет три попытки.
Выигрывает тот, кто в сумме набрал большее количество баллов.
 */
package longjump;

/**
 *
 * @author Ella
 */
public class Competition {

    public static void main(String[] args) throws InterruptedException {
        Track ball = new Track();
        Athlete firstAthlete = new Athlete(ball, "Banny");
        Athlete secondAthlete = new Athlete(ball, "Turtle");
        Thread t1 = new Thread(firstAthlete);
        Thread t2 = new Thread(secondAthlete);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("\n" + firstAthlete.getName()
                + ": " + firstAthlete.getPoints()
                + " points");
        System.out.println(secondAthlete.getName()
                + ": " + secondAthlete.getPoints()
                + " points");

        System.out.println(getWinner(firstAthlete, secondAthlete));
    }

    private static String getWinner(Athlete g1, Athlete g2) {
        if (g1.getPoints() == g2.getPoints()) {
            return "DRAW!";
        }
        Athlete winner = g1.getPoints() > g2.getPoints() ? g1 : g2;
        return "\nWinner is " + winner.getName() + "!";
    }

}
