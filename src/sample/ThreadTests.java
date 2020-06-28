package sample;

import java.io.PrintStream;

class ThreadTests {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) throws InterruptedException {

        //Вынес заполнение единицами за пределы методов, так как все равно не считаем время на заполнение

        for (int i = 0; i < arr.length; i++) {arr[i] = 1;}

        //Два метода (однопоточный и двухпоточный).

        System.out.println(monoThread(arr));
        System.out.println(doubleThread(arr));


    }
        // Считает целый массив
    public static long monoThread(float[] arr) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Whole array counted, size: " + arr.length);
        return (System.currentTimeMillis()-a);
    }

         // Делит массив на два и считает в двух потоках.
    public static long doubleThread(float[] arr) throws InterruptedException {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread threadOne = new Thread(new Task(a1,0));

        //Во второй массив добавляем 5000000 для увеличения инкремента в расчете( иначе получаться две одинаковые половины).
        Thread threadTwo = new Thread(new Task(a2,5000000));
        threadOne.start();
        threadTwo.start();

        //Ждем завершения двух потоков.
        threadOne.join();
        threadTwo.join();


        //Альтернативный способ дождаться завершения потоков. Не уверен, что так можно, хотел бы услышать мнение специалиста.
//        while (threadOne.isAlive() || threadTwo.isAlive()) {
//            Thread.sleep(1);
//        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        return (System.currentTimeMillis() - a);
        }

    }


    // Класс, описывающий метод выполняемый в потоке. Не в run() потому что подаем аргументы на вход метода.
class Task implements Runnable {

    public Task(float[] array, long k) {
          for (int i =0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + (i+k) / 5) * Math.cos(0.2f + (i+k) / 5) * Math.cos(0.4f + (i+k) / 2));
          }
    }

    @Override
    public void run() {
    }
}
