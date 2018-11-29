package com.gedewahyu.w44;

public class SampleClass {
  private String name;
  String email;
  protected String phoneNumber;
  public String address;

  public String getName() {
    return name;
  }

  public SampleClass setName(String name) {
    this.name = name;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public SampleClass setEmail(String email) {
    this.email = email;
    return this;
  }

  @Override public String toString() {
    return "SampleClass{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}
