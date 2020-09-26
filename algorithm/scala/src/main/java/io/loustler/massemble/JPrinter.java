package io.loustler.massemble;

public class JPrinter {
    public static void print(int[] arr) {
        StringBuilder builder = new StringBuilder(arr.length * 2 + 1);

        builder.append("[");

        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);

            if (i < arr.length - 1) builder.append(",");
        }

        builder.append("]");

        System.out.println(builder.toString());
    }
}
