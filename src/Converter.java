class Converter {
    public static String arabicToRoman(int number) throws CalcException {
        RomanNumbers[] romanNumbers = RomanNumbers.values();
        StringBuilder result = new StringBuilder();
        int i = 0;

        if(number <= 0){
            throw new CalcException("В римской системе нет отрицательных чисел");
        }
        while ((number > 0) && (i < romanNumbers.length)) {
            RomanNumbers curSymbol = romanNumbers[i];
            if (curSymbol.getValue() <= number) {
                result.append(curSymbol.name());
                number -= curSymbol.getValue();
            } else {
                i++;
            }
        }

        return result.toString();
    }

    enum RomanNumbers {
        C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        private int value;

        RomanNumbers(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}