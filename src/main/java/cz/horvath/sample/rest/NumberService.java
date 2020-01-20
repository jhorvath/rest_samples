package cz.horvath.sample.rest;

import org.springframework.stereotype.Component;

/**
 * Number scrambling service.
 * 
 */
@Component
public class NumberService {

    public long scramble(long number) {
        // compute number of digits and create byte array representation of the input number
        byte[] digits = new byte[(int) (Math.log10(number) + 1)];
        
        int multiply = 0;
        int sevens = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (byte) (number % 10);
            number /= 10;
            if (digits[i] >= 8) {
                // increase number of digits to multiply by 2
                multiply++;
            }
            if (digits[i] == 7) {
                // increase number of digits to skip
                sevens++;
            }
        }
        
        // move numbers smaller of equal 3 one place right
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i - 1] <= 3) {
                byte a = digits[i - 1];
                digits[i - 1] = digits[i];
                digits[i] = a;
            }

        }
        
        // create result array with proper lenght. increase by number of digits to multiply, decrease by skipped numbers
        byte[] result = new byte[digits.length + multiply - sevens];
        int j = 0;
        
        // fill the result array, skip number 7 and multiply 8 and 9 by 2
        for (int i = 0; i < digits.length; i++) {
            switch (digits[i]) {
                case 7:
                    continue;
                case 8:
                case 9:
                    result[j++] = 1;
                    result[j++] = (byte) ((digits[i] * 2) % 10);
                    continue;
                default:
                    result[j++] = digits[i];
            }
        }
        
        // compute long from the result array, compute number of even digits
        long resultNumer = 0;
        int evens = 0;
        for (int i = 0; i < result.length; i++) {
            resultNumer += Math.pow(10, result.length - i - 1) * result[i];
            if ((result[i] & 1) == 0) {
                evens++;
            }
        }
        
        if (evens == 0) {
            // prevent odd results
            evens = 1;
        }
        // return result divided by number of even numbers
        return resultNumer / evens;
    }

}
