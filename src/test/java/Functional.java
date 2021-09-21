import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

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

  @Test
  public void consumer() {
    Consumer<String> greetPeople = people -> System.out.println("Hello " + people);
    greetPeople.accept("Brunno");

    List<String> people = List.of("Brunno", "Oliveira");
    people.stream().forEach(greetPeople);
  }

  @Test
  public void biConsumer() {
    BiConsumer<String, String> greetPeople = (firstName, lastName) -> System.out.println("Hello " + firstName.concat(" " + lastName));
    greetPeople.accept("Brunno", "Oliveira");

    Map<String, String> people = Map.of("Brunno", "Oliveira", "Eveline", "Oliveira");
    people.entrySet().stream().forEach(entry -> greetPeople.accept(entry.getKey(), entry.getValue()));
  }

  @Test
  public void predicate() {
    List<String> people = List.of("Brunno", "Oliveira");

    Predicate<String> isStringLengthGreaterThan6 = s -> s.length() > 6;
    Predicate<String> isStringLengthIsEven = s -> s.length() % 2 == 0;

    boolean testeFalse = isStringLengthGreaterThan6.and(isStringLengthIsEven).test("teste");
    assertFalse(testeFalse);

    boolean testeFalseOr = isStringLengthGreaterThan6.or(isStringLengthIsEven).test("teste");
    assertFalse(testeFalseOr);

    boolean testeTrue = isStringLengthGreaterThan6.and(isStringLengthIsEven).test("Oliveira");
    assertTrue(testeTrue);

    long count = people.stream().filter(isStringLengthGreaterThan6).count();
    assertEquals(1, count);

    String name = people.stream().filter(isStringLengthGreaterThan6).findFirst().orElseThrow();
    assertEquals("Oliveira", name);
  }

  @Test
  public void supplier() {
    Supplier<List<String>> namesSuplier = () -> List.of("Brunno" , "Oliveira");
    List<String> names = namesSuplier.get();
    System.out.println(names);

    assertEquals("Oliveira", names.get(1));
  }

}
