package entity.weapon;

import javafx.scene.image.Image;
import entity.rats.Rat;
import entity.Entity;
import main.level.Level;
import tile.Tile;

import java.util.ArrayList;

/**
 * NoEntrySign
 *
 * @author Harry Boyce, Bryan Kok
 */

public class NoEntrySign extends Item{

    public NoEntrySign(int x, int y) {
        this.entityName = "No Entry Sign";
        this.image = new Image(System.getProperty("user.dir") + "/src/resources/images/game/entities/no-entry-sign.png");
        this.hp = 5;
        this.damage = 0;
        this.range = 1;
        this.friendlyFire = true;
        this.isAttackable = false;
        this.currentPosX = x;
        this.currentPosY = y;
    }

    public void activate() {

        Tile[][] tile = Level.getTiles();
        ArrayList<Entity> entitiesOnTile = tile[this.currentPosY][this.currentPosX].getEntitiesOnTile();

        if (entitiesOnTile != null) {
            for (Entity entity : entitiesOnTile) {
                if (entity.getEntityName().equals("Rat")) {
                    Rat targetRat = (Rat) entity;
                    // [needs a method to prevent targetRat from passing here]
                    this.hp -= 1;
                    switch (this.hp) {
                        case 4 -> this.image = null;
                        case 3 -> this.image = null;
                        case 2 -> this.image = null;
                        case 1 -> this.image = null;
                        case 0 -> {
                            this.image = null;
                            tile[this.currentPosY][this.currentPosX].removeEntityFromTile(this);
                        }
                    }

                }
            }
        }


    }

}
