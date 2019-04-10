package textgame.backend;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import textgame.*;

public class PlayerTest {
    @Test
    public void test_charGetPosY_works() {
        Player p = new Player(1, 0);
        assertEquals("getPosY() should return the y position", 0, p.getPosY());
    }

    @Test
    public void test_getPosX_works() {
        Player p = new Player();
        p.setInitPos(1, 0);
        assertEquals("getPosX() should return the x position", 1, p.getPosX());
    }

    @Test
    public void test_getHealth_works() {
        Player p = new Player();
        p.setHealth(5);
        assertEquals("getHealth() should return the current health", 5, p.getHealth());
    }

    @Test
    public void test_copyConstructor_health() {
        Player p = new Player(4, 0, 1);
        Player cP = new Player(p);
        assertEquals("copy constructor should copy all values", 4, cP.getHealth());
    }

    @Test
    public void test_copyConstructor_posX() {
        Player p = new Player(4, 0, 1);
        Player cP = new Player(p);
        assertEquals("copy constructor should copy all values", 0, cP.getPosX());
    }

    @Test
    public void test_copyConstructor_posY() {
        Player p = new Player(4, 0, 1);
        Player cP = new Player(p);
        assertEquals("copy constructor should copy all values", 1, cP.getPosY());
    }
}