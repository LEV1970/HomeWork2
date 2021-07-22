package HomeWork2;

public class Main {
    public static int arraySum(String[][] twoDimArray) throws MyArraySizeException, MyArrayDataException {
        if (twoDimArray.length != 4) {
            throw new MyArraySizeException("Длина массива != 4");
        }

        for (String[] array : twoDimArray) {
            if (array.length != 4) {
                throw new MyArraySizeException("Высота массива != 4");
            }
        }

        int sum = 0;
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(twoDimArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Не число в элементе:" + i  + "," + j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        String[][] successArray = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};

        try {
            System.out.println(arraySum(successArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        String[][] invalidDataArray = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"},
                {"1", "2", "3", "t"}};

        try {
            System.out.println(arraySum(invalidDataArray));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }
}
        /*
        1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4. При подаче массива
        другого размера необходимо бросить исключение MyArraySizeException.
        2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо
        числа),надо бросить исключение MyArrayDataException с детализацией, в какой ячейке неверные данные.
        3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException
        и MyArrayDataException и вывести результат расчета.
         */