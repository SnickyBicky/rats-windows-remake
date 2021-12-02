package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.level.Level;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Item
 *
 * @author Dafydd -Rhys Maund (2003900)
 * @author Dawid Wisniewski
 * @author Gareth Wade (1901805)
 * @author Maurice Petersen (2013396)
 */
public abstract class Item extends Entity {

    /**
     *
     */
    private boolean friendlyFire;
    /**
     *
     */
    private boolean canBeAttacked;
    /**
     *
     */
    private Image image;
    /**
     *
     */
    private TYPE type;
    /**
     *
     */
    private int yOffset;
    /**
     *
     */
    private int range;

    /**
     * Activate.
     *
     * @param level the level
     * @param gc    the gc
     */
    public abstract void activate(Level level, GraphicsContext gc);

    /**
     * Create new instance item.
     *
     * @return the item
     */
    public abstract Item createNewInstance();

    /**
     *
     */
    public abstract void playSound()
            throws UnsupportedAudioFileException, LineUnavailableException,
            IOException;

    @Override
    public int getHp() {
        return this.hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getCurrentPosX() {
        return this.currentPosX;
    }

    @Override
    public void setCurrentPosX(int currentPosX) {
        this.currentPosX = currentPosX;
    }

    @Override
    public int getCurrentPosY() {
        return this.currentPosY;
    }

    @Override
    public void setCurrentPosY(int currentPosY) {
        this.currentPosY = currentPosY;
    }

    @Override
    public String getEntityName() {
        return this.entityName;
    }

    @Override
    protected void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Is friendly fire boolean.
     *
     * @return the boolean
     */
    public boolean isFriendlyFire() {
        return friendlyFire;
    }

    /**
     * Sets friendly fire.
     *
     * @param friendlyFire the friendly fire
     */
    public void setFriendlyFire(boolean friendlyFire) {
        this.friendlyFire = friendlyFire;
    }

    /**
     * Can be attacked boolean.
     *
     * @return the boolean
     */
    public boolean canBeAttacked() {
        return canBeAttacked;
    }

    /**
     * Sets can be attacked.
     *
     * @param canBeAttacked the can be attacked
     */
    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }

    /**
     * Sets offset y.
     *
     * @param yOffset the y offset
     */
    public void setOffsetY(int yOffset) {
        this.yOffset = yOffset;
    }

    /**
     * Gets y offset.
     *
     * @return the y offset
     */
    public int getYOffset() {
        return yOffset;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TYPE getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(TYPE type) {
        this.type = type;
    }

    /**
     * Gets range.
     *
     * @return the range
     */
    public int getRange() {
        return range;
    }

    /**
     * Sets range.
     *
     * @param range the range
     */
    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        String result = "";

        result += this.getEntityName().charAt(0);

        if (this.getCurrentPosX() != 0 && this.getCurrentPosY() != 0) {
            result += this.getHp();

            result += ":";
            result += String.format("%02d", this.getCurrentPosX());
            result += ":";
            result += String.format("%02d", this.getCurrentPosY());
        }

        return result;
    }

    /**
     * The enum Type.
     */
    public enum TYPE {
        /**
         * Bomb type.
         */
        BOMB(),
        /**
         * Gas type.
         */
        GAS(),
        /**
         * Death rat type.
         */
        DEATH_RAT(),
        /**
         * Female change type.
         */
        FEMALE_CHANGE(),
        /**
         * Male change type.
         */
        MALE_CHANGE(),
        /**
         * No entry type.
         */
        NO_ENTRY(),
        /**
         * Poison type.
         */
        POISON(),
        /**
         * Sterilisation type.
         */
        STERILISATION()
    }

}
