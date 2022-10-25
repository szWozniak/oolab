package agh.ics.oop;

import javax.swing.text.html.Option;

import static agh.ics.oop.Direction.*;

public class World {

    private static void run(Direction[] directions) {
        for (Direction direction : directions) {
            switch (direction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.println("Zwierzak skręca w prawo");
                case RIGHT -> System.out.println("Zwierzak skręca w lewo");
                default -> System.out.println("Wprowadzono błędną wartość");
            }
        }
    }

    private static Direction[] getDirections(String[] args) {
        Direction[] directions = new Direction[args.length];
        for(int i = 0; i < args.length; i++) {
            directions[i] = switch(args[i]) {
                case "f" -> FORWARD;
                case "b" -> BACKWARD;
                case "l" -> LEFT;
                case "r" -> RIGHT;
                default -> UNEXPECTED;
            };
        }

        return directions;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        MoveDirection[] directions = OptionsParser.parse(args);
        for(MoveDirection move : directions) {
            animal.move(move);
        }
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal.toString());
    }
}
