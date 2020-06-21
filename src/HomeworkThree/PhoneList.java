package HomeworkThree;

import java.util.HashMap;
import java.util.Map;

public class PhoneList {

    HashMap<String,String > localBase;


    //Метод создания массива

    public void create(HashMap<String,String> localBase) {
        this.localBase = localBase;
    }

    //Метод вывода всех номеров под проверяемой фамилией.

    public void get(String surname){
        System.out.printf("Список номеров для фамилии %S:%n", surname);
        for (Map.Entry<String,String> o: localBase.entrySet()) {
            if (o.getValue().equals(surname))
                System.out.println(o.getKey());
        }
    }

    //Метод добавления номера и фамилии в справочник.

    public void add(String number, String surname) {
        localBase.put(number,surname);
    }

}
