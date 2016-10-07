package com.kritsana.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
  public PacmanGame pacmanGame;

  public World world;

  private Texture pacmanImage;
  private SpriteBatch batch;

  private Vector2 position;

  public WorldRenderer (PacmanGame pacmanGame, World world) {
    this.world = world;

    this.pacmanGame = pacmanGame;
    batch = pacmanGame.batch;

    pacmanImage = new Texture("pacman.png");
  }

  public void render (float delta) {
    batch.begin();
    Vector2 position = world.getPacman().getPosition();
    batch.draw(pacmanImage, position.x, position.y);
    batch.end();
  }
}
