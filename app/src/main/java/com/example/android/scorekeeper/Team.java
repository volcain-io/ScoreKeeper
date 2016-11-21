package com.example.android.scorekeeper;

/**
 * This class defines a Team.
 *
 * Created by volcain on 11/21/16.
 */

public class Team {
    private String name;
    private int score;
    private int corner;
    private int freeKick;
    private int penalty;

    /**
     * Constructor. All attributes except the given name will be initialized with 0.
     * @param name
     */
    public Team(final String name) {
        this.name = name;
        this.score = 0;
        this.corner = 0;
        this.freeKick = 0;
        this.penalty = 0;
    }

    /**
     * Constructor. All attributes will be initialized with given values.
     * @param name
     * @param score
     * @param corner
     * @param freeKick
     * @param penalty
     */
    public Team(final String name, final int score, final int corner, final int freeKick, final int penalty) {
        this.name = name;
        this.score = score;
        this.corner = corner;
        this.freeKick = freeKick;
        this.penalty = penalty;
    }

    /**
     * reset all attributes except name
     */
    public void reset() {
        this.score = 0;
        this.corner = 0;
        this.freeKick = 0;
        this.penalty = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(final int score) {
        this.score = score;
    }

    public int getCorner() {
        return this.corner;
    }

    public void setCorner(final int corner) {
        this.corner = corner;
    }

    public int getFreeKick() {
        return this.freeKick;
    }

    public void setFreeKick(final int freeKick) {
        this.freeKick = freeKick;
    }

    public int getPenalty() {
        return this.penalty;
    }

    public void setPenalty(final int penalty) {
        this.penalty = penalty;
    }
}
