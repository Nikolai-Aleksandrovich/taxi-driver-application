package com.calculator.security;
import com.calculator.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;


@Data
public class RegistrationForm {

  private String username;
  private String password;
  private String fullname;
  private String city;
  private String district;
  private String street;
  private String phonenumber;
  
  public User toUser(PasswordEncoder passwordEncoder) {
    return new User(
        username, passwordEncoder.encode(password), 
        fullname,city, district, street, phonenumber);
  }
  
}
