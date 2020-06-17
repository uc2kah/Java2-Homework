package HomeworkOne;

//Класс, отвечающий за таблицу.

public class Table {

    public static String[][] array;
    private static long result;

    //Result- это сумма числовых элементов в таблице ниже геттеры и сеттеры соответственно

    public static void setResult(long result) {
        Table.result = result;
    }

    public static long getResult() {
        return result;
    }

// Автоматов создаём массив по размеру указанному в аргументах.
    // Меняем статус, чтобы выбросить исключение в конце создания.
    public static void createArray(int a, int b) throws MyArraySizeException {
        boolean status= false;

        if (a!=b || a!=4) {status = true;}
        array = new String[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                array[i][j] = "1";
            }
            }


            //Просто вручную указал эллементы. Можно здесь сделать это с помощью сканнера, если есть желание.
        //Сделал так просто для наглядности.
        array[0][3] = " simbol ";
        array[1][1] = " simbol ";
        array[2][3] = " simbol ";
        array[3][1] = " simbol ";

        //Вывожу таблицу. На всякий случай catch, чтобы не останавливаться, если не иниц. переменная в таблице (НУ ВДРУГ)
        // В конце исключение, если не 4х4
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
               try { System.out.print(array[i][j]);} catch (NullPointerException|ArrayIndexOutOfBoundsException
                       exception) {}
            }
            System.out.println();
        }
        if (status) throw new MyArraySizeException();
    }

    //Суммирование элементов с учётом возможных символов. Если ошибка приведения типа, то пропускаем его и считаем дальше.
    // В конце исключение
    public static void dataSummarize(String[][] array) throws MyArraySizeException {
        int sum = 0;
        boolean status= false;
        int b= 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    b= Integer.valueOf(array[i][j]);
                    sum= sum+b;
                    setResult(sum);
                }
                catch (NumberFormatException|NullPointerException e) {
                    b=0;
                    status = true;
                    sum= sum+b;
                    setResult(sum);
                    System.out.println("Ошибка приведения типа к int на позиции "+"["+i+"]"+"["+j+"]");
                }

            }
        }
        if (status) throw new MyArrayDataException();
    }
}
