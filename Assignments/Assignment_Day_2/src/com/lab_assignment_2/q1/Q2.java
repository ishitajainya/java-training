package com.lab_assignment_2.q1;

public class Q2 {

	public static void displayCircle(Circle c) {
		System.out.println("-----------------------");
		System.out.println("Radius: " + c.getRadius());
		System.out.println("Area: " + c.getArea());
		System.out.println("Circumference: " + c.getCircumference());
	}
    public static void main(String[] args) {

        Circle c1 = new Circle();
        displayCircle(c1);
        
        Circle c2 = new Circle(5);
        displayCircle(c2);

        Circle c3 = new Circle(-3);
        displayCircle(c3);

        Circle c4 = new Circle();
        c4.setRadius(10);
        displayCircle(c4);
    }

}
