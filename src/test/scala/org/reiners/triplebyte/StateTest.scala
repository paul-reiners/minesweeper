package org.reiners.triplebyte


class StateTest extends org.scalatest.FunSuite {
  test("2x2 with 1 bomb - win") {
    val n = 2
    val containsBomb = Array.ofDim[Boolean](n, n)
    containsBomb(0)(0) = true
    val state = new State(n, containsBomb)
    val gameOverBefore = state.gameOver()
    assert(!gameOverBefore)
    val playerWonBefore = state.playerWon()
    assert(!playerWonBefore)
    val playerLostBefore = state.playerLost()
    assert(!playerLostBefore)

    state.update(0, 1)

    val gameOverAfter = state.gameOver()
    assert(!gameOverAfter)
    val playerWonAfter = state.playerWon()
    assert(!playerWonAfter)
    val playerLostAfter = state.playerLost()
    assert(!playerLostAfter)

    state.update(1, 0)

    val gameOverAfter2 = state.gameOver()
    assert(!gameOverAfter2)
    val playerWonAfter2 = state.playerWon()
    assert(!playerWonAfter2)
    val playerLostAfter2 = state.playerLost()
    assert(!playerLostAfter2)

    state.update(1, 1)

    val gameOverAfter3 = state.gameOver()
    assert(gameOverAfter3)
    val playerWonAfter3 = state.playerWon()
    assert(playerWonAfter3)
    val playerLostAfter3 = state.playerLost()
    assert(!playerLostAfter3)
  }

  test("2x2 with 1 bomb - lose") {
    val n = 2
    val containsBomb = Array.ofDim[Boolean](n, n)
    containsBomb(0)(0) = true
    val state = new State(n, containsBomb)
    val gameOverBefore = state.gameOver()
    assert(!gameOverBefore)
    val playerWonBefore = state.playerWon()
    assert(!playerWonBefore)
    val playerLostBefore = state.playerLost()
    assert(!playerLostBefore)

    state.update(0, 0)

    val gameOverAfter = state.gameOver()
    assert(gameOverAfter)
    val playerWonAfter = state.playerWon()
    assert(!playerWonAfter)
    val playerLostAfter = state.playerLost()
    assert(playerLostAfter)
  }

  test("2x2 without bomb") {
    val n = 2
    val containsBomb = Array.ofDim[Boolean](n, n)
    val state = new State(n, containsBomb)
    val gameOverBefore = state.gameOver()
    assert(!gameOverBefore)
    val playerWonBefore = state.playerWon()
    assert(!playerWonBefore)
    val playerLostBefore = state.playerLost()
    assert(!playerLostBefore)

    state.update(0, 0)

    val gameOverAfter = state.gameOver()
    assert(gameOverAfter)
    val playerWonAfter = state.playerWon()
    assert(playerWonAfter)
    val playerLostAfter = state.playerLost()
    assert(!playerLostAfter)
  }

  test("1x1 without bomb") {
    val n = 1
    val containsBomb = Array.ofDim[Boolean](n, n)
    val state = new State(n, containsBomb)
    val gameOverBefore = state.gameOver()
    assert(!gameOverBefore)
    val playerWonBefore = state.playerWon()
    assert(!playerWonBefore)
    val playerLostBefore = state.playerLost()
    assert(!playerLostBefore)

    state.update(0, 0)

    val gameOverAfter = state.gameOver()
    assert(gameOverAfter)
    val playerWonAfter = state.playerWon()
    assert(playerWonAfter)
    val playerLostAfter = state.playerLost()
    assert(!playerLostAfter)
  }

  test("1x1 with bomb") {
    val n = 1
    val containsBomb = Array.ofDim[Boolean](n, n)
    containsBomb(0)(0) = true
    val state = new State(n, containsBomb)
    val playerWonBefore = state.playerWon()
    assert(playerWonBefore)
    val playerLostBefore = state.playerLost()
    assert(!playerLostBefore)
    val gameOverBefore = state.gameOver()
    assert(gameOverBefore)
  }
}
