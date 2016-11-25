package com.company;


public abstract class Player {
        PlayerState state = PlayerState.IN_GAME;
        Hand hand = new Hand();
    private Intellect intellect;
     String name;

    public Player(Intellect intellect, String name) {
        this.intellect = intellect;
        this.name = name;
    }



    public void take(Card current) {
        hand.add(current);
    }

    public Command decision() {
        int score = hand.getScore();
        if (score > 21)
            return Command.STAND;
        return intellect.decide(score);

    }

}
