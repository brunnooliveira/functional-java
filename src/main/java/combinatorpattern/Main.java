package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

  public static void main(String[] args) {
    Customer brunno = new Customer(
      "Brunno",
      "bgdo@teste.com",
      "+0999999999",
      LocalDate.of(2000, 1, 1)
    );

    ValidationResult validationResult = isEmailValid()
      .and(isPhoneNumberValid())
      .and(isAdult())
      .apply(brunno);

    if(validationResult != ValidationResult.SUCCESS) {
      throw new IllegalStateException(validationResult.name());
    } else {
      System.out.println(validationResult.name());
    }

//    System.out.println(new CustomerValidatorService().isValid(brunno));

  }
}
