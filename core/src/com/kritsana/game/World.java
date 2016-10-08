package com.kritsana.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class World {
  private PacmanGame pacmanGame;
  private Pacman  pacman;
  private Maze maze;

  public World (PacmanGame pacmanGame) {
    this.pacmanGame = pacmanGame;

    maze = new Maze();

    pacman = new Pacman(60, 60, maze);
  }

  public void update (float delta) {
    pacman.update();
    updatePacmanDirection();
  }

  private void updatePacmanDirection () {
    if (Gdx.input.isKeyPressed(Keys.LEFT)) {
      pacman.setNextDirection(Pacman.DIRECTION_LEFT);
    }
    else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
      pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
    }
    else if (Gdx.input.isKeyPressed(Keys.UP)) {
      pacman.setNextDirection(Pacman.DIRECTION_UP);
    }
    else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
      pacman.setNextDirection(Pacman.DIRECTION_DOWN);
    } else {
      pacman.setNextDirection(Pacman.DIRECTION_STILL);
    }
  }

  Pacman getPacman () {
    return pacman;
  }

  Maze getMaze () {
    return maze;
  }
}
