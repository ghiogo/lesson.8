package kg.geectech.game.players;

import kg.geectech.game.general.RPG_GAME;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && this != heroes[i]) {

                int boost = RPG_GAME.random.nextInt(30) + 3;
                heroes[i].setDamage(heroes[i].getDamage() + boost);
                boss.setHealth(boss.getHealth() - boost);
                System.out.println("Маг увеличил атаку " + heroes[i].getClass().getSimpleName() + "[" + boost + "]");
            }
        }
    }
}

