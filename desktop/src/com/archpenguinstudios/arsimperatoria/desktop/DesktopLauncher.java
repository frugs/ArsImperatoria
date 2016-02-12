package com.archpenguinstudios.arsimperatoria.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.archpenguinstudios.arsimperatoria.ArsImperatoriaGame;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ArsImperatoriaGame(), config);
	}
}
