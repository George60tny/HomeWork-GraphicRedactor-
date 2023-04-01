package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я фігури:");
        String name = scanner.nextLine();

        System.out.println("Виберіть тип фігури:");
        System.out.println("1 - Коло");
        System.out.println("2 - Квадрат");
        System.out.println("3 - Трикутник");
        System.out.println("4 - Прямокутник");
        System.out.println("5 - П'ятикутник");

        int choice = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    break;
                }
            }
            System.out.println("Некоректний ввід. Будь ласка, введіть ціле число від 1 до 5.");
            scanner.nextLine();
        }

        Shape shape = null;
        double area = 0.0;
        switch (choice) {
            case 1:
                System.out.println("Введіть радіус кола:");
                double radius = scanner.nextDouble();
                shape = new Circle(name, radius);
                area = shape.getArea();
                break;
            case 2:
                System.out.println("Введіть довжину сторони квадрата:");
                double side = scanner.nextDouble();
                shape = new Quad(name, side);
                area = shape.getArea();
                break;
            case 3:
                System.out.println("Введіть довжину основи трикутника:");
                double base = scanner.nextDouble();
                System.out.println("Введіть висоту трикутника:");
                double height = scanner.nextDouble();
                shape = new Triangle(name, base, height);
                area = shape.getArea();
                break;
            case 4:
                System.out.println("Введіть ширину прямокутника:");
                double width = scanner.nextDouble();
                System.out.println("Введіть висоту прямокутника:");
                height = scanner.nextDouble();
                shape = new Rectangle(name, width, height);
                area = shape.getArea();
                break;
            case 5:
                System.out.println("Введіть довжину сторони п'ятикутника:");
                side = scanner.nextDouble();
                shape = new Pentagon(name, side);
                area = shape.getArea();
                break;
            default:
                System.out.println("Некоректний вибір!");
                break;
        }

        if (shape != null) {
            ShapeNamePrinter shapeNamePrinter = new ShapeNamePrinter();
            shapeNamePrinter.printShapeName(shape);
        }
    }
}

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();

    public abstract String getType();
}

class Circle extends Shape {
    private double radius;
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String getType() {
        return "Коло";
    }
}

class Quad extends Shape {
    private double side;

    public Quad(String name, double side) {
        super(name);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    public String getType() {
        return "Квадрат";
    }

}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return base * height / 2;
    }

    public String getType() {
        return "Трикутник";
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public String getType() {
        return "Прямокутник";
    }
}

class Pentagon extends Shape {
    private double side;

    public Pentagon(String name, double side) {
        super(name);
        this.side = side;
    }

    @Override
    public double getArea() {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }
    public String getType() {
        return "П'ятикутник";
    }
}


class ShapeNamePrinter {
    public void printShapeName(Shape shape) {
        System.out.println("Назва фігури: " + shape.getName());
        System.out.println("Тип фігури: " + shape.getType());
        System.out.println("Площа фігури: " + shape.getArea());
    }
}