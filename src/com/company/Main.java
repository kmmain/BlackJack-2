package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Player> players = new LinkedList<>();
        players.add(new Computer(new LimitIntellect(14), "ses"));
        players.add(new Computer(new LimitIntellect(20), "ses1"));
        players.add(new Human(new ConsoleIntellect(), "COckSucker"));
        Dealer dealer = new Dealer();
        players.add(dealer);

        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.name+":" +player.hand);
        }

        for (Player player : players) {
            while (true) {
                System.out.println(player.hand.getScore() + ": "
                        + player.hand);
                Command command = player.decision();
                System.out.println(command);
                if (command == Command.STAND)
                    break;
                if (command == Command.HIT)
                    dealer.deal(player);
            }
        }
        for(Player player: players)
            if(player != dealer){
                if(player.hand.getScore() > 21)
                    player.state = PlayerState.LOSS;
                else if (dealer.hand.getScore()> 21)
                    player.state = PlayerState.WIN;
                else if (dealer.hand.getScore() > player.hand.getScore())
                    player.state = PlayerState.LOSS;
                else if (dealer.hand.getScore() == player.hand.getScore())
                    player.state = PlayerState.DRAW;
                else player.state = PlayerState.WIN;
                System.out.println(player.name+ " " + player.state + " " + " with " + player.hand);
            }
    }
}
