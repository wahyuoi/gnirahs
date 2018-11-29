package com.gedewahyu.w48;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Kelas implements Runnable {

  public static void main(String[] args)
      throws IllegalAccessException, InstantiationException, InvocationTargetException {
    Task task = new Task();

    Method[] methods = task
        .getClass()
        .getDeclaredMethods();

    for (Method method : methods) {
      Todo annotation = method.getAnnotation(Todo.class);
      if (annotation == null) continue;

      Class<Kelas> clazz = annotation.clazz();
      Kelas kelas = clazz.newInstance();
      for (Method declaredMethod : kelas
          .getClass()
          .getDeclaredMethods()) {
        SelaluJalan sj = declaredMethod.getAnnotation(SelaluJalan.class);
        if (sj == null) continue;

        declaredMethod.invoke(kelas);
      }

      method.invoke(task);
    }
  }

  @java.lang.Override
  @SelaluJalan
  public void run() {
    System.out.println("Run");
  }


  @SelaluJalan
  public void jalan() {
    System.out.println("Jalan");
  }

  @SelaluJalan
  public void yuk() {
    System.out.println(24*60*60*1000*10*1000L);
    System.out.println((';' + 'l') + "Hey");
  }


}

// override
