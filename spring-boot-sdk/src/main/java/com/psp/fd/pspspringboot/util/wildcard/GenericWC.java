package com.psp.fd.pspspringboot.util.wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

//public  class GenericWC<T> {
// use this to make a whole class become generic
//}
public class GenericWC {

//    use ? as a wildcard for a meth
    public List<?> sort(List<?> requests) {
        return new ArrayList<>();
    }

    public static void ExampleOneAppend(Collection<? super Integer> integer) {
        //reason that ? super Integer because Number is bigger than Integer (Number > Integer)
        IntStream.rangeClosed(1,5).forEach(integer::add);
    }

    public static double ExampleTwoSum(Collection<? extends Number> number) {
         // (Integer < Number)
        return number.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void main(String[] args) {
        //ExampleOneAppend
        List<Number> nums = new ArrayList<>();
        ExampleOneAppend(nums);
        nums.add(33.1);
        System.out.println(nums);
        //ExampleOneAppend

        //ExampleTwoSum
        List<Integer> num = Arrays.asList(12,3,2);
        System.out.println(ExampleTwoSum(num));
        //ExampleTwoSum
    }
}
