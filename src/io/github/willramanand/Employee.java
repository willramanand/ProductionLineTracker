package io.github.willramanand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

  private final String emailExtension = "@oracleacademy.Test";

  private String name;
  private String email;
  private String username;
  private String password;

  public Employee(String name, String password) {
    this.name = name;
    if(checkName(name)) {
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

  private boolean checkName(String name) {

    if (!name.matches("\\S+")) {
      return true;
    } else {
      return false;
    }
  }

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
        + "\nInitial Password : " +  password;
  }
}
