package kg.geectech.game.general;

import kg.geectech.game.players.*;

import java.util.Random;

public class RPG_GAME {
    public static boolean statusStun = false;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss(1000, 100);
        Warrior warrior = new Warrior(270, 24);
        Medic doc = new Medic(200, 5, 15);
        Medic medic = new Medic(200, 10, 5);
        Berserc berserc = new Berserc(250, 20);
        Magic magic = new Magic(240, 20);
        Thor thor= new Thor(220,15);

        Hero[] hero = {warrior, doc, medic, berserc, magic, thor};
        printStatistics(boss, hero);

        while (!isGameFinish(boss, hero)) {
            round(boss, hero);
        }
    }

    private static void heroesApplyAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) ;
            heroes[i].applySuperPower(boss, heroes);

        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHits(boss, heroes);
        heroesApplyAbility(boss, heroes);
        printStatistics(boss, heroes);

    }

    private static boolean isGameFinish(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes Win");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead) {
            System.out.println("Boss Win");
        }
        return allHeroesDead;
    }

    private static void heroesHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());

        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        if (!statusStun) {
            System.out.println("Thor"+" "+ statusStun);
            for (int i = 0; i < heroes.length; i++) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());

            }
        }else {
            statusStun= false;
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("___________________________");
        System.out.println("Boss health " + boss.getHealth() +
                "[" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " "+ "health " + heroes[i].getHealth() +
                    "[" + heroes[i].getDamage() + "]");
        }
    }

}