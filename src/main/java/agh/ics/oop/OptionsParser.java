package agh.ics.oop;

import static agh.ics.oop.MoveDirection.*;

public class OptionsParser {
    public static MoveDirection[] parse(String[] options) {
        int max = options.length;
        for (String option : options) {
            if (option == null) {
                max -= 1;
            }
        }
        MoveDirection[] directions = new MoveDirection[max];

        int j = 0;
        for (String option : options) {
            MoveDirection move = switch (option) {
                case "f", "forward" -> FORWARD;
                case "b", "backward" -> BACKWARD;
                case "r", "right" -> RIGHT;
                case "l", "left" -> LEFT;
                default -> null;
            };
            if(move == null)  throw new IllegalArgumentException("Argument " + option + " is not legal move specification");
            else {
                directions[j] = move;
                j += 1;
            }
        }

        return directions;
    }
}
