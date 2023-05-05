package com.example.pendataanpenduduk;

public class Authentication {
  private static boolean FLAG = false;
  private String username;
  private String password;
  private final String USER_ACCOUNT = "user";
  private final String USER_PASSWORD = "user";
  private final String ADMIN_ACCOUNT = "admin";
  private final String ADMIN_PASSWORD = "admin";

  public Authentication(String username, String password) {
    setUsername(username);
    setPassword(password);
  }


  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean validateLength() {
    if(getUsername().length() == 0 || getPassword().length() == 0) {
      return false;
    }
    else if (getUsername().length() < 4 || getPassword().length() < 4) {
      return false;
    }
    else {
      return true;
    }
  }

  public boolean isMatched() {
    if (
      (getUsername().equals(this.getADMIN_ACCOUNT()) && getPassword().equals(this.getADMIN_PASSWORD())) ||
      (getUsername().equals(this.getUSER_ACCOUNT()) && getPassword().equals(this.getUSER_PASSWORD()))
    ) {
      setFLAG(true);
      return true;
    }
    else {
      setFLAG(false);
      return false;
    }
  }

  public String getUSER_ACCOUNT() {
    return USER_ACCOUNT;
  }

  public String getUSER_PASSWORD() {
    return USER_PASSWORD;
  }

  public String getADMIN_ACCOUNT() {
    return ADMIN_ACCOUNT;
  }

  public String getADMIN_PASSWORD() {
    return ADMIN_PASSWORD;
  }

  public static boolean isNotLogin() {
    return FLAG;
  }

  public static void setFLAG(boolean FLAG) {
    FLAG = FLAG;
  }
}
