package kg.geectech.game.players;

import kg.geectech.game.general.RPG_GAME;

public class Berserc extends Hero{
    public Berserc(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
            int saveDamageAndRevert = boss.getDamage() / 2;

            boss.setHealth(boss.getHealth()+ saveDamageAndRevert);

            System.out.println("Берсерк забрал: (" + saveDamageAndRevert + ") урона ");

    }
}

