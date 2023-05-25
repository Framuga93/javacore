package org.example.core;

import java.util.*;

public class Menu {

    public static int showMenu() {
        int result = 0;
        String run = Prompt.prompt("Welcome to CALCULATION for A and B\n " +
                "Choose your destiny\n" +
                "ADD\n" +
                "SUM\n" +
                "SUBTRACT(SUB)\n" +
                "DIFFERENCE(DIF)\n" +
                "ClOSE the door\n");

        int a = Integer.parseInt(Prompt.prompt("Enter number A: "));
        int b = Integer.parseInt(Prompt.prompt("Enter number B: "));
        String command = run.toUpperCase();

        if (command.equals("ADD")){
            result = Service.add(a,b);
        }
        if (command.equals("SUM")){
            result = Service.sum(a,b);
        }
        if (command.equals("SUB")){
            result = Service.sub(a,b);
        }
        if (command.equals("DIF")){
            result = Service.dif(a,b);
        }
        if (command.equals("CLOSE")){
            System.out.println("why did you come here?");
        }
        return result;
    }

}
