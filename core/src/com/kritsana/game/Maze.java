package com.kritsana.game;

public class Maze {
  private String [] MAP = new String [] {
    "####################",
    "#..................#",
    "#.###.###..###.###.#",
    "#.#...#......#...#.#",
    "#.#.###.####.###.#.#",
    "#.#.#..........#.#.#",
    "#.....###..###.....#",
    "#.#.#..........#.#.#",
    "#.#.###.####.###.#.#",
    "#.#...#......#...#.#",
    "#.###.###..###.###.#",
    "#..................#",
    "####################"
  };

  private int height;
  private int width;

  public Maze () {
    height = MAP.length;
    width = MAP[0].length();
  }

  public int getHeigth () {
    return height;
  }

  public int getWidth () {
    return width;
  }

  public boolean hasWallAt (int row, int column) {
    return MAP[row].charAt(column) == '#';
  }

  public boolean hasDotAt (int row, int column) {
    return MAP[row].charAt(column) == '.';
  }
}