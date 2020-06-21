package HomeworkThree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //задача 1
        //Создаём массив
        Mylist e = new Mylist();


        //Заполняем вручную
        ArrayList<String> myList = new ArrayList<>();
        myList.add(0,"one");
        myList.add(1,"two");
        myList.add(2,"three");
        myList.add(3,"four");
        myList.add(4,"five");
        myList.add(5,"six");
        myList.add(6,"seven");
        myList.add(7,"one");
        myList.add(8,"eight");
        myList.add(9,"nine");
        myList.add(10,"ten");
        myList.add(11,"three");
        myList.add(12,"four");
        myList.add(13,"three");
        myList.add(14,"eleven");
        myList.add(15,"twelve");
        myList.add(16,"thirteen");
        myList.add(17,"eleven");
        myList.add(18,"two");
        myList.add(19,"fourteen");
        myList.add(20,"fourteen");
        myList.add(21,"fifteen");

        //Считаем кол-во слов и кол-во повторений для каждого слова.
        e.countDiff(myList);

        // Задача 2
        // Создаем справочник, в него можем добавлять как стандартным способом, так и нашим методом.

        PhoneList book = new PhoneList();
        HashMap<String, String> myBook = new HashMap<>();

        book.create(myBook);

        myBook.put("+111111101", "Sidorov");      myBook.put("+122222221","Sergeenko");
        myBook.put("+111111001", "Petrov");       myBook.put("+122222211","Golovin");
        myBook.put("+111110001", "Smirnov");      myBook.put("+122222111","Smirnov");
        myBook.put("+111100001", "Gorbachev");    myBook.put("+122221111","Sidorov");
        myBook.put("+111000001", "Ivanov");       myBook.put("+122211111","Sidorov");
        myBook.put("+110000001", "Lemanski");     myBook.put("+122111111","Ivanov");
        myBook.put("+100000001", "Petrenko");     myBook.put("+121111111","Smirnov");
        myBook.put("+101111111", "Golovin");      myBook.put("+111111121","Sidorov");
        myBook.put("+100111111", "Postalov");     myBook.put("+111111221","Kirov");
        myBook.put("+100011111","Klemenko");      myBook.put("+111112221","Sidorov");
        myBook.put("+100001111","Gorbunov");      myBook.put("+111122221","Ivanov");
        myBook.put("+100000111","Krivov");        myBook.put("+111222221","Ivanov");
        myBook.put("+100000011","Kirov");         myBook.put("+112222221","Kirov");

        // Вводим сначала номер, а потом фамилию, ибо номер унакальный, а фамилия нет. Чтобы не выдумывать сложности и не искать
        // способ искать несколько значений под одним ключом в HashMap, мы просто используем уникальный ключ-номер, под них
        // записываем фамилии.

        book.add("+76859494976", "Novikov");

        book.get("Sidorov");



    }




}
