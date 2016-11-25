package com.company;

import java.util.Scanner;

/**
 * Created by falyanguzov on 21.11.2016.
 */
public class ConsoleIntellect extends Intellect {


    private Scanner in = new Scanner(System.in);

    @Override
    public Command decide(int score) {
        while (true) {
            System.out.println("HIT/STAND?");
            String c = in.nextLine();

            if ("stand".startsWith(c.toLowerCase()))
                return Command.STAND;
            if ("hit".startsWith(c.toLowerCase()))
                return Command.HIT;
            System.out.println("Can't understand, please repeat");


        return Command.STAND;}
    }
}
