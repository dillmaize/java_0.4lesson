package ru.stqa.ak.tests.sandbox;

public class Point {

    public double x;
    public double y;

    public double distance(Point p) {
        double dist = Math.sqrt((this.x - p.x)*(this.x - p.x) + (this.y - p.y)*(this.y - p.y));
        return dist;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
