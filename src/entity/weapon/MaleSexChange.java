package entity.weapon;

import entity.Item;
import entity.rat.Rat;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import entity.Entity;
import main.level.Level;
import tile.Tile;
import main.external.Audio;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

import static main.external.Audio.playGameEffect;

/**
 * MaleSexChange
 *
 * @author Dafydd-Rhys Maund
 * @author Harry Boyce
 * @author Bryan Kok
 */

public class MaleSexChange extends Item {

    public MaleSexChange() {
        setEntityType(EntityType.ITEM);
        setEntityName("MaleSexChange");
        setImage(new Image(System.getProperty("user.dir") + "/src/resources/images/game/entities/male-change.png"));
        setHp(1);
        setDamage(0);
        setRange(1);
        setFriendlyFire(false);
        setCanBeAttacked(false);
        setType(TYPE.MALE_CHANGE);
        setOffsetY(4);
        //setSound(new Sound(System.getProperty("user.dir") + "/src/resources/audio/game"));
    }

    @Override
    public Item createNewInstance() {
        return new MaleSexChange();
    }

    @Override
    public void playSound() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        playGameEffect(System.getProperty("user.dir") + "/src/resources/audio/game/sex_change.wav");
    }

    public void activate(Level level, GraphicsContext gc) {
        Tile[][] tile = level.getTiles();
        ArrayList<Entity> entitiesOnTile = tile[getCurrentPosY()][getCurrentPosX()].getEntitiesOnTile();

        if (!entitiesOnTile.isEmpty()) {
            for (int i = 0; i < entitiesOnTile.size(); i++) {
                if (entitiesOnTile.get(i).getEntityType() == EntityType.RAT) {
                    Rat target = (Rat) entitiesOnTile.get(i);

                    if (target.getGender() == Rat.Gender.FEMALE) {
                        target.setGender(Rat.Gender.MALE);
                        target.setImage(new Image(System.getProperty("user.dir") +
                                "\\src\\resources\\images\\game\\entities\\male-rat.png"));
                        target.getImages();
                        // TODO audio here
                        try {
                            playSound();
                        } catch (UnsupportedAudioFileException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (LineUnavailableException e) {
                            e.printStackTrace();
                        }
                        this.hp -= 1;
                        level.getItems().remove(this);
                        entitiesOnTile.remove(this);
                        return;
                    } else {
                        this.hp -= 1;
                        level.getItems().remove(this);
                        entitiesOnTile.remove(this);

                    }
                }
            }

        }
    }
}