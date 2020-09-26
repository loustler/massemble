package io.loustler.massemble;

public class JRandom {
    private static java.util.Random instance = new java.util.Random();

    public static int nextInt() {
        return instance.nextInt();
    }

    public static int nextInt(int max) {
        return instance.nextInt(max);
    }
}
