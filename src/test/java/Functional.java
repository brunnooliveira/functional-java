import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Functional {

  @Test
  public void function() {
    Function<Integer, Integer> incrementByOne = number -> number + 1;
    Function<Integer, Integer> multiplyBy10 = number -> number * 10;
    Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOne.andThen(multiplyBy10);
    Integer result = addBy1AndThenMultiplyBy10.apply(1);
    System.out.println(result);

    assertEquals(20, result);
  }

  @Test
  public void biFunction() {
    BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply =
      (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
    Integer result = incrementByOneAndMultiply.apply(1, 10);
    System.out.println(result);

    assertEquals(20, result);
  }



}
