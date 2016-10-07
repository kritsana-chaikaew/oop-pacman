package com.kritsana.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
  private PacMan game;
  private Texture pacmanImage;

  public GameScreen (PacMan game) {
    this.game = game;
    pacmanImage = new Texture("pacman.png");
  }

  @Override
  public void render (float delta) {
    SpriteBatch batch = game.batch;
    batch.begin();
    batch.draw(pacmanImage, 100, 100);
    batch.end();
  }
}
