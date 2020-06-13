package HomeworkOne;

/*Класс имплементирует интерфейс, чтобы можно было внести его в один массив с человеком и роботом*/

public class Cat implements Competitor{

    /*параметры кота (высота прыжка и длина бега), а также переменная, которая указывает прошел ли он текущее
     * испытание. По- умолчанию true, если не прошёл, то меняется на false и дальше не проходит испытания*/

    private double jumpheight;
    private double runlength;
    private boolean ability = true;

    // конструктор класса кот

    public Cat (double jumpheight, double runlength, int q) {
        this.jumpheight= jumpheight;
        this.runlength= runlength;
    }

    //Метод прыжка. Если не смог пробежать указываем статус false

    public void jump(Wall wall) {
        if (wall.height< jumpheight)
            System.out.println("cat jump");
        else {
            System.out.println("cat failed to jump");
            ability = false;
        }

    }

    //Метод бега. Если не смог пробежать указываем статус false

    public void run(RunningTrack runningTrack) {
        if (runningTrack.length< runlength)
            System.out.println("cat run");
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
