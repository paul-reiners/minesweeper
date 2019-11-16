package org.reiners.triplebyte


class StateTest extends org.scalatest.FunSuite {
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
