package com.lab_assignment_2.q1;

public class Circle {

    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Radius must be positive. Setting radius to 1.0");
            this.radius = 1.0;
        }
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
