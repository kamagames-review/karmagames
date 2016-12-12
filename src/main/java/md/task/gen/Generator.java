package md.task.gen;

import md.task.AppConsts;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.stream.Stream;

/**
 * Created by VMakarenko on 04.12.2016.
 */
public class Generator {

    private class Point {
        double x, y;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Point point = new Generator().generateGeo("geo.csv", 10_000_000L, AppConsts.W * 2, AppConsts.H * 2);
        new Generator().generateLabels("lbl.csv", 10_000L, point.x, point.y);
    }

    private Point generateGeo(String filename, Long totalPointsMax,
                              Float wStep,
                              Float hStep) throws FileNotFoundException {
        long totalSqrt = Math.round(Math.floor(Math.sqrt(totalPointsMax)));
        float h = 0;
        PrintWriter pw = new PrintWriter(filename);
        Point point = new Point();
        point.x = wStep * totalSqrt;

        for (int i = 0; i < totalSqrt; i++) {
            h += hStep;
            for (int j = 0; j < totalSqrt; j++) {
                String line = "" + (float) (Math.random() * (wStep + hStep) / 2) + "," + wStep * j + "," + h + "\n";
                pw.print(line);
                if ((i * totalSqrt + j) % 100000 == 0) {
                    System.out.println("generated geo " + i*totalSqrt + j);
                }
            }

        }

        point.y = h;

        pw.flush();
        return point;
    }

    private void generateLabels(String filename, Long usersTotal, Double wMax, Double hMax) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);

        Stream.iterate(1L, n -> n + 1).limit(usersTotal).forEach(userId -> {
            String line = "" + userId + "," + Math.random() * wMax + "," + Math.random() * hMax + "\n";
            pw.print(line);

            if (userId % 10000 == 1) {
                System.out.println("generated lbl " + userId);
            }
        });

        pw.flush();
    }
}
