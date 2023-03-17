
package tiago.rasia.converter;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rasia
 */
public class RomanNumberConverter {
    
    
    
    
    public static void main(String[] args) {
        /*
        int number = 763;
        String romanNumeral = convertToRoman(number);
        System.out.println(number + " in Roman numerals is " + romanNumeral);
        
        
        System.out.println();
        
        //romanNumeral = "MCCXXXIV";
        number = convertToInt(romanNumeral);
        System.out.println(romanNumeral + " in integer form is " + number);
        */
    }
    
    
    public static String convertToRoman(int number) {
        // limitar até 3999 para evitar caracteres especiais dos números romanos
        if(number >= 4000)
            return "";
        
        // as letras representando 5k e 10k, V e X possuem um caractere especial, um traço sobre elas 
        String[] thousands = {"", "M", "MM", "MMM","MV","V","VM","VMM","IX","X"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder roman = new StringBuilder();

        roman.append(thousands[number / 1000]);
        roman.append(hundreds[(number % 1000) / 100]);
        roman.append(tens[(number % 100) / 10]);
        roman.append(ones[number % 10]);

        return roman.toString();
    }    
    
    public static int convertToInt(String romanNumeral) {
        Map<Character, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I', 1);
        romanToInteger.put('V', 5);
        romanToInteger.put('X', 10);
        romanToInteger.put('L', 50);
        romanToInteger.put('C', 100);
        romanToInteger.put('D', 500);
        romanToInteger.put('M', 1000);

        int result = 0;

        for (int i = 0; i < romanNumeral.length(); i++) {
            int current = romanToInteger.get(romanNumeral.charAt(i));
            int next = i + 1 < romanNumeral.length() ? romanToInteger.get(romanNumeral.charAt(i + 1)) : 0;

            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
    

    // 
    // https://www.geeksforgeeks.org/validating-roman-numerals-using-regular-expression/
    // https://www.oreilly.com/library/view/regular-expressions-cookbook/9780596802837/ch06s09.html
    /*
    M{0,3} specifies the thousands section and basically restrains it to between 0 and 4000 
    (CM|CD|D?C{0,3}) is for the hundreds section. 
    (XC|XL|L?X{0,3}) is for the tens place. 
    Finally, (IX|IV|V?I{0,3}) is the units section. 
    */ 
    public static boolean isValidRomanNumber(String s) {
        String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return s.matches(regex);
    }
    
}
