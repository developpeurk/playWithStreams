package functionalprogramming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {


   public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);
        Integer increment2 = incrementByOneFunction.apply(4);
        System.out.println(increment2);

       Integer multiply = _Function.multiplyBy10Function.apply(increment2);
       System.out.println(multiply);

       Function<Integer, Integer> addBy1AndMultiplyBy10 =
               incrementByOneFunction.andThen(multiplyBy10Function);
       Integer apply = addBy1AndMultiplyBy10.apply(4);
       System.out.println(apply);


       System.out.println(incrementByOneAndMultiply(4,100));
       System.out.println(incrementByOneAndMultiplyBiFunction.apply(4,100));


   }

   // function takes 1 arguments and produces 1 result
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;



    static int incrementByOne(int number) {
        return number+1;
    }


    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne,numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
    static int  incrementByOneAndMultiply (int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy ;
    }

}
