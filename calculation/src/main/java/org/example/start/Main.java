package org.example.start;

import org.example.core.Menu;
import org.example.core.View;

public class Main {
    public static void main(String[] args) {
        System.out.println(View.showAnswer(Menu.showMenu()));
    }
}