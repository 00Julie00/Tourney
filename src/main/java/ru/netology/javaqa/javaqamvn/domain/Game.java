package ru.netology.javaqa.javaqamvn.domain;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> registeredPlayers = new ArrayList<>();


    public void registration(Player player) throws NotRegisteredException {

        if (findByName(player.getName()) == null) {
            registeredPlayers.add(player);
        } else {
            throw new NotRegisteredException("A player with the same name already exists");
        }
    }

    public Player findByName(String name) {

        for (int i = 0; i < registeredPlayers.size(); i++) {
            if (registeredPlayers.get(i).getName() == name) {
                return registeredPlayers.get(i);
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {

        int result = 7;
        Player first = findByName(playerName1);
        Player second = findByName(playerName2);

        if (first != null & second != null) {

            for (int i = 0; i < registeredPlayers.size(); i++) {

                if (first.getStrength() == second.getStrength()) {
                    result = 0;
                } else if (first.getStrength() > second.getStrength()) {
                    result = 1;
                } else {
                    result = 2;
                }

            }
        } else if (first == null & second == null) {
            throw new NotRegisteredException("Players with name" + first + " and " + second + "not registered");

        } else if (first == null) {
            throw new NotRegisteredException("Player with name" + first + "not registered");
        } else {
            throw new NotRegisteredException("Player with name" + second + "not registered");
        }
        return result;
    }
}
