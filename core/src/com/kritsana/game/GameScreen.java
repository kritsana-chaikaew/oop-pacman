package com.kritsana.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
  private PacmanGame game;

  private World world;

  private Texture pacmanImage;

  public GameScreen (PacmanGame game) {
    this.game = game;
    pacmanImage = new Texture("pacman.png");

    world = new World(game);
  }

  @Override
  public void render (float delta) {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    update(delta);

    SpriteBatch batch = game.batch;

    batch.begin();
    Vector2 position = world.getPacman().getPosition();
    batch.draw(pacmanImage, position.x, position.y);
    batch.end();
  }

  public void update (float delta) {
    world.update(delta);
  }
}
