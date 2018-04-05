package com.samsung.business.spaceinvaders;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.samsung.business.spaceinvaders.manager.ScoreManager;
import com.samsung.business.spaceinvaders.manager.Singleton;
import com.samsung.business.spaceinvaders.screens.GameOverScreen;
import com.samsung.business.spaceinvaders.screens.GameScreen;
import com.samsung.business.spaceinvaders.screens.MainMenuScreen;
import com.samsung.business.spaceinvaders.screens.WinScreen;

public class SpaceInvaders extends Game {
    public SpriteBatch batch;
    private ScoreManager score;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new MainMenuScreen(this));
        score = new ScoreManager(0);

    }
    @Override
    public void render() {
        super.render(); //important!
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void gameOver() {if(Singleton.getInstance().getBestScore()<score.getValue()){
        Singleton.getInstance().putBestScore(score.getValue());}
        this.setScreen(new GameOverScreen(this));
    }

    public void win() {if(Singleton.getInstance().getBestScore()<score.getValue()){
        Singleton.getInstance().putBestScore(score.getValue());
    }
        this.setScreen(new WinScreen(this));
    }

    public ScoreManager getScore() {
        return score;
    }

    public void restart() {
        score.reset();
        start();
    }

    public void start() {
        this.setScreen(new GameScreen(this));

    }
}
