package ru.gus.generics;


/**
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 22.01.2019
 */
public class Stats<T extends Number> {

    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean sameAvg(Stats<?> ob) {
        return this.average() == ob.average();
    }
}
