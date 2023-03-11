package ru.netology.javaqa.javaqamvn.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.domain.Game;
import ru.netology.javaqa.javaqamvn.domain.NotRegisteredException;
import ru.netology.javaqa.javaqamvn.domain.Player;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(4567, "Solay", 1);
    Player player2 = new Player(4000, "Rozaline", 2);
    Player player3 = new Player(375, "Angel", 11);
    Player player4 = new Player(11, "Freya", 7);
    Player player5 = new Player(01, "Lisa Cristal", 0);
    Player player6 = new Player(9999, "Rozaline", 9);
    Player player7 = new Player(673, "Haburu", 1);

    @BeforeEach
    public void addPlayers() throws NotRegisteredException {
        game.registration(player1);
        game.registration(player2);
        game.registration(player3);
        game.registration(player4);
        game.registration(player5);
        game.registration(player7);
    }

    @Test
    public void comparePlayersWhenFirstIsWeakerThanSecond() throws NotRegisteredException {


        int expected = 2;
        int actual = game.round("Rozaline", "Angel");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void comparePlayersWhenFirstIsStrongerThanSecond() throws NotRegisteredException {

        int expected = 1;
        int actual = game.round("Rozaline", "Solay");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void comparePlayersOfEqualStrength() throws NotRegisteredException {

        int expected = 0;
        int actual = game.round("Haburu", "Solay");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareStrengthsPlayersIfBothAreUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sonya Blaid", "Pain");
        });
    }

    @Test
    public void compareStrengthPlayersIfFirstIsUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Pain", "Lisa Cristal");
        });

    }

    @Test
    public void compareStrengthPlayersIfSecondIsUnregistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Solay", "Sonya Blaid");
        });

    }

    @Test
    public void compareStrengthsPlayersNamesNotIncluded() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "");
        });

    }

    @Test
    public void addPlayerWhoseNameAlreadyUse() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.registration(player6);
        });


    }
}
