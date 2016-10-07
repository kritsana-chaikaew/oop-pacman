package com.kritsana.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class World {
  private PacmanGame pacmanGame;
  private Pacman  pacman;
  public World (PacmanGame pacmanGame) {
    this.pacmanGame = pacmanGame;

    pacman = new Pacman(100, 100);
  }

  public void update (float delta) {
    if (Gdx.input.isKeyPressed(Keys.LEFT)) {
      pacman.move(Pacman.DIRECTION_LEFT);
    }
    else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
      pacman.move(Pacman.DIRECTION_RIGHT);
    }
    else if (Gdx.input.isKeyPressed(Keys.UP)) {
      pacman.move(Pacman.DIRECTION_UP);
    }
    else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
      pacman.move(Pacman.DIRECTION_DOWN);
    }
  }

  Pacman getPacman () {
    return pacman;
  }
}
