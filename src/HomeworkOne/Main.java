package HomeworkOne;


public class Main {

    // массивы участников и препятствий (15 просто так)
    static Competitor[] competitor = new Competitor[15];
    static Obstacle[] obstacle = new Obstacle[15];
    static Wall[] wall = new Wall[15];
    static RunningTrack[] runningTrack = new RunningTrack[15];

    // крайние значения возможные для рандома
    static double a = 5;
    static double b = 20;


    //главный метод
    public static void main(String[] args) {


        //Создаём по пять участников
        Cat[] cat = new Cat[5];
        Robot[] robot = new Robot[5];
        Human[] human = new Human[5];


        //Рандомно присваиваем им высоту прыжка и дальность бега, чтобы не прописывать каждого вручную
        for (int i = 0; i < cat.length; i++) {
            cat[i] = new Cat(Math.random() * (b-a) + a, Math.random() * (b-a)  + a, i);
            human[i] = new Human(Math.random() * (b-a) + a, Math.random() * (b-a)  + a, i);
            robot[i] = new Robot(Math.random() * (b-a) + a, Math.random() * (b-a)  + a, i);

        //Вносим участников в общий массив
            competitor[i] = cat[i];
            competitor[i+5] = human[i];
            competitor[i+10] = robot[i];
        }


        //Создаём массивпрепятствий, задаем высоту и длину также рандомом, чтобы не делать вручную.
        //Размер массива можно любой, заполнится автоматом.
        for (int i = 0; i < obstacle.length; i = i + 2) {
            wall[i] = new Wall();
            runningTrack[i] = new RunningTrack();
            runningTrack[i].length = Math.random() * (b-a) + a;
            wall[i].height = Math.random() * (b-a) + a;
            obstacle[i] = runningTrack[i];
            if (i<obstacle.length-1){
            obstacle[i + 1] = wall[i];}
        }

        /*Проходим по каждому участнику, заставляем его прыгать/ бегать до тех пор,
        * пока не кончаться препятствия или он не провалит задание*/

        for (int i = 0; i < competitor.length; i++) {
            for (int j = 0; j < obstacle.length; j++) {

            /*Тут проверяем, справился ли участник с предыдущим заданием (getAbility), затем заставляем его
            * бежать через препятствие. Если вдруг это оказывается стена, то ловим исключение приведения типов и
            * уже пробуем через нее прыгнуть. Если и это не удалось, то тут что-то не то, я такого не встречал :)*/
                if (competitor[i].getAbility()) {
                    try {
                        System.out.print(i+ " ");
                        competitor[i].run((RunningTrack) obstacle[j]);
                    } catch (ClassCastException cce) {
                        try {
                            competitor[i].jump((Wall) obstacle[j]);
                        } catch (ClassCastException cce2) {
                            System.out.println("Что-то пошло не так");
                        }
                    }
                }

            }
        }
    }
}
