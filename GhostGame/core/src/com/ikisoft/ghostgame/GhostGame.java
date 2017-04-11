package com.ikisoft.ghostgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;


public class GhostGame extends Game {

	private AssetLoader assetLoader;
	private GameRenderer renderer;
	private GameWorld world;
	private float delta;

	@Override
	public void create() {
		assetLoader = new AssetLoader();
		assetLoader.load();
		world = new GameWorld();
		renderer = new GameRenderer(world);

		Gdx.input.setInputProcessor(new GestureDetector(new GestureHandler(world.getGhost(), world)));



	}

	@Override
	public void render() {
		delta = Gdx.graphics.getDeltaTime() * 60;

		renderer.render(delta);
		world.update(delta);


	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		super.dispose();
		renderer.dispose();
		assetLoader.dispose();

	}

	@Override
	public void pause() {
	}

}