package entity.weapon;

import entity.Item;
import entity.rat.Rat;
import javafx.scene.image.Image;
import entity.Entity;
import main.level.Level;

import java.util.ArrayList;

/**
 * Poison
 *
 * @author Dafydd-Rhys Maund
 * @author Harry Boyce
 * @author Bryan Kok
 */
public class Poison extends Item {

    public Poison() {
        setEntityType(EntityType.ITEM);
        setEntityName("Poison");
        setImage(new Image(System.getProperty("user.dir") + "/src/resources/images/game/entities/poison.png"));
        setHp(1);
        setDamage(5);
        setRange(1);
        setFriendlyFire(true);
        setCanBeAttacked(false);
        setType(TYPE.POISON);
        setOffsetY(6);
    }

    public void activate() {
        ArrayList<Entity> entitiesOnTile = Level.getTiles()[this.currentPosY][this.currentPosX].getEntitiesOnTile();

        if (!entitiesOnTile.isEmpty()) {
            for (int k = 0; k < entitiesOnTile.size(); k++) {
                if (entitiesOnTile.get(k).getEntityType() == EntityType.RAT){
                    Rat targetRat = (Rat) entitiesOnTile.get(k);
                    inflictDamage(this.damage, targetRat);
                    setHp(getHp() - 1);

                    if (targetRat.getHp() <= 0) {
                        targetRat.kill();
                        //entitiesOnTile.remove(targetRat);
                    }
                    Level.getItems().remove(this);
                    entitiesOnTile.remove(this);
                    break;
                }
            }
        }
    }
}
