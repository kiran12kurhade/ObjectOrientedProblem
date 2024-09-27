package com.account;

import java.util.Random;
/*
Author :Kiran Kisan Kurhade
Desc:Write a Program DeckOfCards.java, to initialize deck of cards having suit
("Clubs", "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8",
"9", "10", "Jack", "Queen", "King", "Ace"). Shuffle the cards using Random
method and then distribute 9 Cards to 4 Players and Print the Cards received by
the 4 Players using 2D Array
Date :27/09/2024
 */

public class DeckOfCards {

    // Suits and Ranks of the cards
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    // Deck of cards represented as a 1D array
    private static String[] deck = new String[52];

    // 2D array to represent the cards distributed to 4 players (9 cards each)
    private static String[][] players = new String[4][9];

    // Initialize the deck
    public static void initializeDeck() {
        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index++] = rank + " of " + suit;
            }
        }
    }

    // Shuffle the deck using the Random class
    public static void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = random.nextInt(deck.length);
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    // Distribute 9 cards to 4 players
    public static void distributeCards() {
        int cardIndex = 0;
        for (int player = 0; player < 4; player++) {
            for (int card = 0; card < 9; card++) {
                players[player][card] = deck[cardIndex++];
            }
        }
    }

    // Print the cards received by each player
    public static void printPlayerCards() {
        for (int player = 0; player < 4; player++) {
            System.out.println("Player " + (player + 1) + "'s cards:");
            for (int card = 0; card < 9; card++) {
                System.out.println(players[player][card]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Initialize, shuffle, distribute, and print the cards
        initializeDeck();
        shuffleDeck();
        distributeCards();
        printPlayerCards();
    }
}
