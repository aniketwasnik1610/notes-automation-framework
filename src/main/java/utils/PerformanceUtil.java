package utils;

public class PerformanceUtil {

    public static long startTime;

    public static void start() {

        startTime =
                System.currentTimeMillis();
    }

    public static void end(
            String action) {

        long end =
                System.currentTimeMillis();

        System.out.println(
                action
                        + " Time: "
                        + (end - startTime)
                        + " ms");
    }
}