package HomeworkOne;

public class Main {


    public static void main(String[] args) {

        /*Создание массива. Не очень понял условие, сделал, чтобы он считал результат даже с неправильной таблицей и
        * наличием множества символов. Также я определяю все места на которых символы, а не только первое. Поэтому и вывод
        * номера ячейки перед броском исключения. Если бросать исключение сразу, то он и недосчитывает сумму цифровых элементов
        * и ну как- то не очень. */

        /*В main создаём таблицу используя try-catch, чтобы выловить исключение MyArraySizeException
        * Аналогично с методом dataSummarize.*/

        try {
            Table.createArray(4,4);
        }
        catch (MyArraySizeException mase) { System.out.println("Размер не соответствует условию 4x4, но продолжаем считать.");
        }
        try {Table.dataSummarize(Table.array);
            System.out.println("Сумма численных элементов таблицы равна "+ Table.getResult());
        }   catch (MyArrayDataException made) {
            System.out.println("Сумма численных элементов таблицы равна "+ Table.getResult());
        }
    }

}
