import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class Streams {

  @Test
  public void streams() {
    List<Person> people = List.of(
      new Person("Brunno", Gender.MALE),
      new Person("Eveline", Gender.FEMALE),
      new Person("João", Gender.MALE),
      new Person("Felipe", Gender.MALE),
      new Person("Neta", Gender.FEMALE)
    );

    people.stream()
      .map(Person::getName)
      .mapToInt(String::length)
      .forEach(System.out::println);

    Function<Person, String> getName = Person::getName;
    ToIntFunction<String> length = String::length;
    IntConsumer println = System.out::println;

    people.stream()
      .map(getName)
      .mapToInt(length)
      .forEach(println);

    Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.getGender());
    boolean allMatch = people.stream().allMatch(personPredicate);
    System.out.println(allMatch);

  }


}
