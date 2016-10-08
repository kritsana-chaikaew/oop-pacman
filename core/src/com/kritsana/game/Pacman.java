package com.kritsana.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {

  public static final int DIRECTION_UP = 1;
  public static final int DIRECTION_RIGHT = 2;
  public static final int DIRECTION_DOWN = 3;
  public static final int DIRECTION_LEFT = 4;
  public static final int DIRECTION_STILL = 0;

  public static final int SPEED = 5;

  private int currentDirection;
  private int nextDirection;

  private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };

  private Vector2 position;

  private Maze maze;

  public Pacman (int x, int y, Maze maze) {
    position = new Vector2(x, y);

    currentDirection = DIRECTION_STILL;
    nextDirection = DIRECTION_STILL;

    this.maze = maze;
  }

  public void update () {
    if (isAtCenter()) {
      int row = getRow();
      int column = getColumn();

      if (maze.hasDotAt(row, column)) {
        maze.removeDotAt(row, column);
      }

      if (canMoveDirection(nextDirection)) {
        currentDirection = nextDirection;
      } else {
        currentDirection = DIRECTION_STILL;
      }
    }
    position.x += SPEED * DIR_OFFSETS[currentDirection][0];
    position.y += SPEED * DIR_OFFSETS[currentDirection][1];
  }

  public Vector2 getPosition () {
    return position;
  }

  public  void setNextDirection (int direction) {
    nextDirection = direction;
  }

  public boolean isAtCenter () {
    int blockSize = WorldRenderer.BLOCK_SIZE;
    boolean isAtCenter =  ( ( ( (int)position.x - blockSize / 2 ) % blockSize ) == 0 ) &&
                          ( ( ( (int)position.y - blockSize / 2 ) % blockSize ) == 0 );
    return isAtCenter;
  }

  private boolean canMoveDirection (int direction) {
    int newRow = getRow() + DIR_OFFSETS[direction][1];
    int newColumn = getColumn() + DIR_OFFSETS[direction][0];
    return !maze.hasWallAt(newRow, newColumn);
  }

  private int getRow () {
    return ( (int)position.y ) / WorldRenderer.BLOCK_SIZE;
  }

  private int getColumn () {
    return ( (int)position.x ) /WorldRenderer.BLOCK_SIZE;
  }
}
