package org.reiners.triplebyte

class State {
  def update(playerChoice: (Integer, Integer)): Unit = {
    val row: Int = playerChoice._1
    val col: Int = playerChoice._2
  }

  private val random = new java.util.Random()
  private val N = 20
  private val containsBomb = Array.ofDim[Boolean](N, N)
  private val exposed = Array.ofDim[Boolean](N, N)
  for (row <- 0 until N) {
    for (col <- 0 until N) {
      if (random.nextDouble < 0.25) {
        containsBomb(row)(col) = true
      }
    }
  }

  def getNeighboringBombCount(row: Int, col: Int): Int = {
    var count = 0
    for (r <- row - 1 to row + 1) {
      for (c <- col - 1 to col + 1) {
        if (!(r < 0 || r >= N || c < 0 || c < N - 1)) {
          if (containsBomb(r)(c)) {
            count += 1
          }
        }
      }
    }

    count
  }

  def getSquareDisplay(row: Int, col: Int): String = {
    if (!exposed(row)(col)) {
      " "
    } else {
      getNeighboringBombCount(row, col).toString
    }
  }

  def printBoard(): Unit = {
    for (row <- 0 until N) {
      for (col <- 0 until N) {
        val squareDisplay = getSquareDisplay(row, col)
        print("|" + squareDisplay)
      }
      println("|")
    }
  }
}
