package com.samsung.business.spaceinvaders.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Administrator on 2018-04-05.
 */

public class Singleton {
    private static Singleton instance=null;
    private static Preferences pref=null;
    private Singleton(){

    }
    public static Singleton getInstance() {
        if(instance==null){instance=new Singleton();}
        pref=  Gdx.app.getPreferences("preferences");
    return instance;
    }
    public void putBestScore(int score){
        pref.putInteger("Score",score);

    }
    public int getBestScore(){
        return pref.getInteger("Score",0);
    }

}
