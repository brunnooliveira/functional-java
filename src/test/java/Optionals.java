import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Optionals {

  @Test
  public void optional() {
    List<Person> people = List.of(
      new Person("Brunno", Gender.MALE),
      new Person("Eveline", Gender.FEMALE),
      new Person("João", Gender.MALE),
      new Person("Felipe", Gender.MALE),
      new Person("Neta", Gender.FEMALE)
    );

    Optional.ofNullable(null)
      .orElseGet(() -> "default value");

    Optional.ofNullable("null")
      .ifPresent(System.out::println);

    Optional.ofNullable("null")
      .orElseThrow(() -> new IllegalArgumentException("exception"));

  }
}
