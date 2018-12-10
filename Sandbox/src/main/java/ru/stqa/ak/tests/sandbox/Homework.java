package ru.stqa.ak.tests.sandbox;

public class Homework {
    public static void main(String[] args) {

        Point p1 = new Point (0.0, 0.0);
        Point p2 = new Point (3.0, 4.0);

        double distMethod = p1.distance(p2);
        System.out.println("Distance between points = " + distMethod + " (calculated in method inside object)");

        double distFunction = distance(p1, p2);
        System.out.println("Distance between points = " + distFunction + " (calculated in static function) ");
    }
    public static double distance(Point p1, Point p2) {
        double dist = Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
        return dist;
        }

    }




