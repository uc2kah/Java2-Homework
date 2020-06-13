package HomeworkOne;

/*Класс имплементирует интерфейс, чтобы можно было внести его в один массив с котом и роботом*/

public class Human implements Competitor {

    /*параметры человека (высота прыжка и длина бега), а также переменная, которая указывает прошел ли он текущее
    * испытание. По- умолчанию true, если не прошёл, то меняется на false и дальше не проходит испытания*/

    private double jumpheight;
    private double runlength;
    private boolean ability = true;

    // конструктор класса человек

    public Human (double jumpheight, double runlength, int q) {
        this.jumpheight= jumpheight;
        this.runlength= runlength;
    }

    //Метод прыжка. Если не смог пробежать указываем статус false

    public void jump(Wall wall) {
        if (wall.height< jumpheight)
            System.out.println("human jump");
        else {
            System.out.println("human failed to jump");
            ability = false;
        }

    }

    //Метод бега. Если не смог пробежать указываем статус false

    public void run(RunningTrack runningTrack) {
        if (runningTrack.length< runlength)
            System.out.println("human run");
        else {
            System.out.println("human failed to run");
            ability = false;
        }
    }

    // Геттер статуса

    public boolean getAbility() {
        return ability;
    }

}
