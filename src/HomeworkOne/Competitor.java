package HomeworkOne;

/*Интерфейс для объединения классов человек, кот и робот, ведь наследоваться запрещено условием*/

public interface Competitor {
    void jump(Wall wall);

    void run(RunningTrack runningTrack);

    boolean getAbility();


}
