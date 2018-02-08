package com.joshchappelle.sandbox.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.joshchappelle.sandbox.bucket.BucketDropGame;
import com.joshchappelle.sandbox.mesh.MeshDemoGame;

public class DesktopLauncher
{
    public static void main(String[] args)
    {
        System.out.println("Starting " + args[0]);
        ApplicationListener game = null;
        LwjglApplicationConfiguration config = null;
        String gameName = args[0];
        if("bucketdrop".equalsIgnoreCase(gameName))
        {
            config = new LwjglApplicationConfiguration();
            config.title = "Drop";
            config.width = 800;
            config.height = 480;
            game = new BucketDropGame();
        }
        else if("meshdemo".equalsIgnoreCase(gameName))
        {
            game = new MeshDemoGame();
        }
        else
        {
            throw new IllegalArgumentException(String.format("No game named '%s'", gameName));
        }
        new LwjglApplication(game, config == null ? new LwjglApplicationConfiguration() : config);
    }
}
