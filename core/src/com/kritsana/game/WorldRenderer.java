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

  private MazeRenderer mazeRenderer;

  public WorldRenderer (PacmanGame pacmanGame, World world) {
    this.world = world;

    this.pacmanGame = pacmanGame;
    batch = pacmanGame.batch;

    pacmanImage = new Texture("pacman.png");

    mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
  }

  public void render (float delta) {
    mazeRenderer.render();

    Vector2 position = world.getPacman().getPosition();
    
    batch.begin();
    batch.draw(pacmanImage, position.x, position.y);
    batch.end();
  }
}
