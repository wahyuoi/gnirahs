package com.gedewahyu.w44;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Reflection {
  private void readFieldFromClass() {
    Class clazz = SampleClass.class;

    Field[] declaredFields = clazz.getDeclaredFields();
    for (Field declaredField : declaredFields) {
      System.out.println("Name: " + declaredField.getName());
      System.out.println("Modifier: " + declaredField.getModifiers());
    }
  }

  private void failFillData() throws IllegalAccessException {
    Class clazz = SampleClass.class;
    SampleClass sample = new SampleClass();

    Field[] declaredFields = clazz.getDeclaredFields();
    for (Field declaredField : declaredFields) {
      declaredField.set(sample, "string apa aja");
    }

    System.out.println(sample);
  }


  private void okFillData() throws IllegalAccessException {
    Class clazz = SampleClass.class;
    SampleClass sample = new SampleClass();


    Field[] declaredFields = clazz.getDeclaredFields();
    for (Field declaredField : declaredFields) {
      declaredField.setAccessible(true);
      declaredField.set(sample, "1");
    }

    System.out.println(sample);
  }

  private void okFillData(List<String> data) throws IllegalAccessException {
    Class clazz = SampleClass.class;
    SampleClass sample = new SampleClass();

    Field[] declaredFields = clazz.getDeclaredFields();
    for (int ii = 0; ii < declaredFields.length; ii++) {
      Field declaredField = declaredFields[ii];
      declaredField.setAccessible(true);
      declaredField.set(sample, data.get(ii));
    }

    System.out.println(sample);
  }

  public static void main(String[] args) throws IllegalAccessException {
    Reflection reflection = new Reflection();
    reflection.readFieldFromClass();
    reflection.failFillData();
    reflection.okFillData();
    reflection.okFillData(Arrays.asList("budi", "budi@gg.com", "080989999", "Jalan Raya"));
  }
}
