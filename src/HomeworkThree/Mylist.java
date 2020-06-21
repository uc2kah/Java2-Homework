package HomeworkThree;

import java.util.ArrayList;

public class Mylist {


    public void countDiff(ArrayList<String> locallist) {

        /*Берем слово, сверяем его со следующим и дальше до конца. если два слова совпадут, то мы добавляем ammount и
        вырезаем повторяющееся слово из листа. Таким образом мы не будем сверять по несколько раз одно и тоже слово, а в
        конце у нас останется таблица уникальных слов. Ее размер и есть кол-во слов.
        * */
        int ammount = 1;
        for (int i = 0; i < locallist.size(); i++) {
            for (int j = i+1; j < locallist.size()-1; j++) {
                if (locallist.get(i) == locallist.get(j)) {
                    locallist.remove(j);
                    ammount++;
                }
            }
            System.out.printf("Количество повторений слова <%s>: %d%n", locallist.get(i), ammount);
            ammount = 1;
        }
        System.out.println("Кол-во разных слов:" + locallist.size());
    }
}
