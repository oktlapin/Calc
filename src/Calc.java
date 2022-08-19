public class Calc {
    public static String calc(String input) throws Exception {

        String[] strInput = input.split("[ ]"); //Создал строчный массив для ввода данных в консоли (через пробел)

        if (strInput.length != 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } //если длина массива превышает более 3-х значений, выводим ошибку.


        RomanNumber[] romanNumbers = RomanNumber.values(); //Создал массив из римских цифр
        String operand1 = strInput[0]; //для 1 операнда выделил ячейку 0 в массиве
        String operand2 = strInput[2]; //для 2 операнда выделил ячейку 2 в массиве
        String operator = strInput[1]; //для оператора (+,-,/,*) выделил значение 1 в массиве
        String result = ""; //строка с выводом резултата решения


        if (CheckRoman.chRoman(operand1) && CheckRoman.chArabian(operand2)
                || CheckRoman.chArabian(operand1) && CheckRoman.chRoman(operand2)) {
            throw new Exception("используются одновременно разные системы счисления");
        } //если операнды содержат одновременно римские и арабские цифры, выводим ошибку

        if (CheckRoman.chArabian(operand1) && CheckRoman.chArabian(operand2)) { //если оба операнда арабские, начинаем считать
            int num1 = Integer.valueOf(operand1);
            int num2 = Integer.valueOf(operand2);
            if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1) {
                throw new Exception("Введите число от 1 до 10"); //Ограничиваем ввод данных от 1 до 10
            }

            switch (operator) {
                case "+":
                    result = Integer.toString(num1 + num2);
                    break;
                case "-":
                    result = Integer.toString(num1 - num2);
                    break;
                case "*":
                    result = Integer.toString(num1 * num2);
                    break;
                case "/":
                    result = Integer.toString(num1 / num2);
                    break;
                default:
                    result = "Введен некорректный знак";
            }
            return result;
        }


        if (CheckRoman.chRoman(operand1) && CheckRoman.chRoman(operand2)) { //аналогично с арабскими
            int num1 = RomanNumber.valueOf(operand1).getArabicNumber(); //берем данные из массива Enum
            int num2 = RomanNumber.valueOf(operand2).getArabicNumber();
            int resultRoman; //создаем переменную для вывода резултата римскими цифрами
            if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1) {
                throw new Exception("Введите число до 10ти"); //аналогично с арабскими
            } else {

                switch (operator) { //считаем
                    case "+":
                        resultRoman = num1 + num2;
                        break;
                    case "-":
                        resultRoman = num1 - num2;
                        break;
                    case "*":
                        resultRoman = num1 * num2;
                        break;
                    case "/":
                        resultRoman = num1 / num2;
                        break;
                    default:
                        resultRoman = 10000;
                }
                if (resultRoman > 0) { //ограничиваем отрицательный результат решения
                    return String.valueOf(romanNumbers[resultRoman - 1]); //в результат подставлем значения из массива Enum начиная с [0] ячейки
                }
                throw new Exception("В римской системе нет отрицательных числе");
            }


        }

        return result;
    }

}
