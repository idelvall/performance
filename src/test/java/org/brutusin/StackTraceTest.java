package org.brutusin;

public class StackTraceTest {

  private enum Type {
    Throwable,
    Filled,
    Thread
  }

  private static final int[] STACK_SIZES = {1, 10, 50, 100, 200, 400, 800};
  private static final int TIMES = 1000;

  public static void main(String[] args) {
    System.out.println(
        "## Cost of getting stack trace (ns) ([source code](" + getSourceCodeLink(StackTraceTest.class) + "))\n");
    StringBuilder sb = new StringBuilder("| Procedure |");
    for (int i = 0; i < STACK_SIZES.length; i++) {
      sb.append(" Stack length of ").append(STACK_SIZES[i]).append(" |");
    }
    System.out.println(sb);
    sb = new StringBuilder("|");
    for (int i = 0; i < STACK_SIZES.length + 1; i++) {
      sb.append(" - |");
    }
    System.out.println(sb);
    for (Type type : Type.values()) {
      sb = new StringBuilder("| ").append(type).append(" | ");
      for (int i = 0; i < STACK_SIZES.length; i++) {
        sb.append(getNano(STACK_SIZES[i], type)).append(" | ");
      }
      System.out.println(sb);
    }
  }

  private static long getNano(int stackSize, Type type) {
    if (stackSize < 1) {
      throw new IllegalArgumentException("stackSize has to be positive");
    } else if (stackSize > 1) {
      return getNano(stackSize - 1, type);
    }
    Throwable th = null;
    if (type == Type.Filled) {
      th = new Throwable();
    }
    long start = System.nanoTime();
    for (long i = 0; i < TIMES; i++) {
      StackTraceElement[] stackTrace;
      if (type == Type.Throwable) {
        stackTrace = new Throwable().getStackTrace();
      } else if (type == Type.Filled) {
        stackTrace = th.fillInStackTrace().getStackTrace();
      } else {
        stackTrace = Thread.currentThread().getStackTrace();
      }
    }
    return (System.nanoTime() - start) / TIMES;
  }

  private static String getSourceCodeLink(Class clazz) {
    return "src/test/java/" + clazz.getName().replace('.', '/') + ".java";
  }
}
