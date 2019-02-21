/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textgame;
import java.util.ArrayList;

import demo1.Enemy;
/**
 *
 * a class to handle a ArrayList<Enemy>
 * 
 * @author George Smith
 */
public class EnemyHandler {
    private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    public EnemyHandler()
    {
        this(new ArrayList<Enemy>());
    }

    public EnemyHandler(ArrayList<Enemy> enemyList)
    {
        this.enemyList = enemyList;
    }

    public EnemyHandler(EnemyHandler enemyHandlerToCopy)
    {
        this.enemyList = enemyHandlerToCopy.enemyList;
    }

    public void removeEnemy(int index)
    {
        enemyList.remove(index);
    }

    public void removeEnemy(Enemy enemy)
    {
        enemyList.remove(enemy);
    }

    public addEnemy(Enemy enemy)
    {
        enemyList.add(enemy);
    }

    
}
