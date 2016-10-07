package com.kritsana.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class GameScreen extends ScreenAdapter {
  private World world;
  private PacmanGame game;
  private WorldRenderer worldRenderer;

  public GameScreen (PacmanGame game) {
    this.game = game;

    world = new World(game);
    worldRenderer = new WorldRenderer(game, world);
  }

  @Override
  public void render (float delta) {
    update(delta);

    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    worldRenderer.render(delta);
  }

  public void update (float delta) {
    world.update(delta);
  }
}
