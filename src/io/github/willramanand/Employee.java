package io.github.willramanand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class to create Employees.
 *
 * @author William Ramanand
 */

public class Employee {

  /**
   * Constant.
   */
  private static final String emailExtension = "@oracleacademy.Test";

  /**
   * Name of employee.
   */
  private String name;
  /**
   * Email of employee.
   */
  private String email;
  /**
   * Username of employee.
   */
  private String username;
  /**
   * Password of employee.
   */
  private String password;

  /**
   * Constructor for employee.
   *
   * @param name     to set to.
   * @param password to set to.
   */
  public Employee(String name, String password) {
    this.name = name;
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    } else {
      this.username = "default";
      this.email = "user" + emailExtension;
    }

    if (validPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }

  }

  /**
   * Checks if name is has space.
   *
   * @param name to check.
   * @return boolean if name does have space.
   */
  private boolean checkName(String name) {

    if (!name.matches("\\S+")) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks if entered password is valid.
   *
   * @param password to check.
   * @return If password is valid or not.
   */
  private boolean validPassword(String password) {

    Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(password);

    if (!password.equals(password.toLowerCase())) {
      if (!password.equals(password.toUpperCase())) {
        if (m.find()) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  /**
   * Set the username using first initial then last name.
   *
   * @param name to set username value.
   */
  public void setUsername(String name) {
    String[] splitNames = name.split("\\s+");
    char firstInitial = splitNames[0].toLowerCase().charAt(0);
    String lastName = splitNames[1].toLowerCase();
    this.username = firstInitial + lastName;
  }

  public void setEmail(String name) {
    name = name.replace(" ", ".").toLowerCase();
    this.email = name + emailExtension;
  }

  @Override
  public String toString() {
    return "Employee Details"
        + "\nName : " + name
        + "\nUsername : " + username
        + "\nEmail : " + email
        + "\nInitial Password : " + password;
  }
}
