package agh.ics.oop;

public class World {
    private static void run(String[] args) {
        System.out.println("Zwierzak idzie do przodu...");
        boolean firstArg = true;
        for (String arg : args) {
            if(!firstArg) {
                System.out.print(", ");
            } else {
                firstArg = false;
            }
            System.out.print(arg);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("System wystartował...");
        run(args);
        System.out.println("System zakończył działanie...");
    }
}
