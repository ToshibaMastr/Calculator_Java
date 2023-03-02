import java.util.*;

public class Main {
    private static final List<String> ARABIC = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    private static final List<String> ROMAN = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    public static void main(String[] args) throws CalcException {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();

        System.out.println(calc(string));
    }

    public static String calc(String input) throws CalcException {
        String[] list = input.split(" ");
        String result;

        if(list.length != 3){
            throw new CalcException("Недопустимое выражение");
        }
        if(!(ARABIC.contains(list[0]) || ROMAN.contains(list[0])) || !(ARABIC.contains(list[2]) || ROMAN.contains(list[2]))){
            throw new CalcException("Недопустимое выражение");
        }
        if((ARABIC.contains(list[0]) && ROMAN.contains(list[2])) || (ROMAN.contains(list[0]) && ARABIC.contains(list[2]))){
            throw new CalcException("Используются одновременно разные системы счисления");
        }
        if(ARABIC.contains(list[0])){
            result = String.valueOf(calculation(ARABIC.indexOf(list[0])+1, ARABIC.indexOf(list[2])+1, list[1].charAt(0)));
        } else{
            result = Converter.arabicToRoman(calculation(ROMAN.indexOf(list[0])+1, ROMAN.indexOf(list[2])+1, list[1].charAt(0)));
        }

        return result;
    }

    private static int calculation(int a, int b, char operand) throws CalcException {
        switch (operand){
            case '-': return a-b;
            case '+': return a+b;
            case '/': return a/b;
            case '*': return a*b;
            default: throw new CalcException("Неверный операнд");
        }
    }
}
