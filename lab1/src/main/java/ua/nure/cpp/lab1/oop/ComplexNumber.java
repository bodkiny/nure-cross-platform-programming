package ua.nure.cpp.lab1.oop;

import lombok.Value;

import java.util.List;

@Value
public class ComplexNumber {
    double real;
    double imaginary;

    /**
     * Adds two complex numbers. The result is a new complex number.
     * The real part of the result is the sum of the real parts of the operands.
     * <p>
     * The imaginary part of the result is the sum of the imaginary parts of the operands.
     *
     * @param b complex number to add
     * @return a new complex number that is the sum of the current object and the passed operand
     */
    public ComplexNumber add(ComplexNumber b) {
        return new ComplexNumber(this.real + b.real, this.imaginary + b.imaginary);
    }

    /**
     * Multiplies two complex numbers. The result is a new complex number.
     * The real part of the result is the product of the real parts of the operands minus the product of the imaginary parts.
     * <p>
     * The imaginary part of the result is the sum of the product of the real part of the first operand and the imaginary part of the second operand and the product of the imaginary part of the first operand and the real part of the second operand.
     *
     * @param b complex number to multiply
     * @return a new complex number that is the product of the current object and the passed operand
     */
    public ComplexNumber multiply(ComplexNumber b) {
        double newReal = this.real * b.real - this.imaginary * b.imaginary;
        double newImaginary = this.real * b.imaginary + this.imaginary * b.real;
        return new ComplexNumber(newReal, newImaginary);
    }

    /**
     * Adds two complex numbers. The result is a new complex number.
     * The real part of the result is the sum of the real parts of the operands.
     * <p>
     * The imaginary part of the result is the sum of the imaginary parts of the operands.
     *
     * @param a first complex number
     * @param b second complex number
     * @return a new complex number that is the sum of the passed operands
     */
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary());
    }

    /**
     * Multiplies two complex numbers. The result is a new complex number.
     * The real part of the result is the product of the real parts of the operands minus the product of the imaginary parts.
     * <p>
     * The imaginary part of the result is the sum of the product of the real part of the first operand and the imaginary part of the second operand and the product of the imaginary part of the first operand and the real part of the second operand.
     *
     * @param a first complex number
     * @param b second complex number
     * @return a new complex number that is the product of the passed operands
     */
    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        double real = a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary();
        double imaginary = a.getReal() * b.getImaginary() + a.getImaginary() * b.getReal();
        return new ComplexNumber(real, imaginary);
    }

    /**
     * Adds all complex numbers from the list. The result is a new complex number.
     * The real part of the result is the sum of the real parts of the operands.
     * <p>
     * The imaginary part of the result is the sum of the imaginary parts of the operands.
     *
     * @param numbers list of complex numbers
     * @return a new complex number that is the sum of the passed operands or ComplexNumber(0, 0) if the list is null or empty
     */
    public static ComplexNumber addAll(List<ComplexNumber> numbers) {
        if(numbers == null || numbers.isEmpty()){
            return new ComplexNumber(0, 0);
        }

        double realSum = 0;
        double imaginarySum = 0;
        for (ComplexNumber number : numbers) {
            realSum += number.getReal();
            imaginarySum += number.getImaginary();
        }
        return new ComplexNumber(realSum, imaginarySum);
    }

    /**
     * Multiplies all complex numbers from the list. The result is a new complex number.
     * The real part of the result is the product of the real parts of the operands minus the product of the imaginary parts.
     * <p>
     * The imaginary part of the result is the sum of the product of the real part of the first operand and the imaginary part of the second operand and the product of the imaginary part of the first operand and the real part of the second operand.
     *
     * @param numbers list of complex numbers
     * @return a new complex number that is the product of the passed operands or ComplexNumber(0, 0) if the list is null or empty
     */
    public static ComplexNumber multiplyAll(List<ComplexNumber> numbers) {
        if(numbers == null || numbers.isEmpty()){
            return new ComplexNumber(0, 0);
        }

        ComplexNumber result = new ComplexNumber(1, 0);
        for (ComplexNumber num : numbers) {
            if (num.getReal() == 0 && num.getImaginary() == 0) {
                return new ComplexNumber(0, 0);
            }
            result = multiply(result, num);
        }
        return result;
    }
}
