import javafx.scene.shape.Arc;

public class Map{
    protected double position;
    protected boolean exist;

}

public class Item extends Map {
    private boolean toBeFound;

    protected void Use() {

    }
}

public class Entity extends Map {
    protected int hp;
    protected double meleeSkill;
    protected double rangeSkill;

    protected boolean checkDeath(int currentHP) {

    }

    protected boolean checkLevelUp(int currentEXP) {

    }

    protected void Attack() {

    }
}

public class Archetype extends Entity {
    private String Archetype;
    protected String name;

    protected void attack() {

    }

    protected void defend() {

    }
}

public class Player extends Archetype {
    private int exp;
    private int level;
    private int levelLimit;
    private int expToLevel;

    private checkEXPGain(boolean killedEnemy) {

    }
}

public class Enemy extends Archetype {
    private int expGiven;
}

public class NPC extends Archetype {
    private double posX;
    private double posY;

    protected Talk(double playerPosX, double playerPosY) {

    }
}

public class Ranger extends Player {
    private void shootArrow(Entity target) {

    }

    private void evade() {

    }
}

public class Fighter extends Player {
    private void swordSwing(Entitry target) {

    }

    private void shield() {

    }
}

public class Mob extends Enemy {
    private void claw() {

    }
}

public class Boss extends Enemy {
    
}
