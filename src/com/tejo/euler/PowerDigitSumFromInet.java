package com.tejo.euler;

//http://stackoverflow.com/questions/16249631/summing-up-digits-of-a-very-long-binary-number
public class PowerDigitSumFromInet {
	public long sumOfDigits(int base, int exp) {
        int numberOfDigits = (int) Math.ceil(exp * Math.log10(base));
        int[] digits = new int[numberOfDigits];
        digits[0] = base;
        int currentExp = 1;

        while (currentExp < exp) {
            currentExp++;
            int carry = 0;
            for (int i = 0; i < digits.length; i++) {
                int num = base * digits[i] + carry;
                digits[i] = num % 10;
                carry = num / 10;
            }
        }

        long sum = 0;
        for (int digit : digits)
            sum += digit;

        return sum;
    }

    public static void main(String[] args) {
        int base = 2;
        int exp = 1000;
        System.out.println(new PowerDigitSumFromInet().sumOfDigits(base, exp));
    }

}
