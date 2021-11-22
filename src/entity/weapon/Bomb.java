package entity.weapon;

import entity.rats.Rat;
import main.level.Level;
import tile.Tile;
import entity.Entity;

import java.lang.Math;
import java.util.ArrayList;

/**
 * Bomb
 *
 * @author Harry Boyce
 * @author Gareth Wade (1901805)
 * @author Bryan Kok
 */

public class Bomb extends Item { //used to extend Entities.Item

    public Bomb(int x, int y){
        this.entityName = "Bomb";
        this.hp = 8; // 8 ticks = 4 seconds
        this.damage = 5;
        this.range = 2;
        this.friendlyFire = true;
        this.isAttackable = false;
        this.currentPosX = x;
        this.currentPosY = y;
    }

    public void countdown() {
        this.hp -= 1;
        //bomb sprite advances based on cooldown
        if (this.hp == 0) activate();
    }

    public void activate(){
        Tile[][] tiles = Level.getTiles();
        for (int i = 0; i < this.range; i++) {
            for (int j = 0; j < this.range; j++) {
                ArrayList<Entity> entitiesOnTile = tiles[this.currentPosY + j - 1][this.currentPosX + i - 1].getEntitiesOnTile();
                if (entitiesOnTile != null) {
                    for (int k = 0; k < entitiesOnTile.size(); k++) {
                        if (entitiesOnTile.get(k).getEntityName().equals("Rat")){
                            inflictDamage(this.damage, entitiesOnTile.get(k));
                        }
                    }
                }
            }
        }
    }
}
