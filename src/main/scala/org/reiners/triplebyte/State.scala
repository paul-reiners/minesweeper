package org.reiners.triplebyte

class State(val n: Int) {
  def this(n: Int, containsBomb: Array[Array[Boolean]]) {
    this(n)
    this.containsBomb = containsBomb
  }

  def playerLost(): Boolean = {
    (0 until n).exists((row: Int) => (0 until n).exists((col: Int) => containsBomb(row)(col) && chosen(row)(col)))
  }

  def playerWon(): Boolean = {
    (0 until n).forall((row: Int) => (0 until n).forall((col: Int) => exposed(row)(col) || containsBomb(row)(col)))
  }

  def gameOver(): Boolean = {
    playerWon() || playerLost()
  }

  def update(playerChoice: (Integer, Integer)): Unit = {
    val row: Int = playerChoice._1
    val col: Int = playerChoice._2
    exposed(row)(col) = true
    chosen(row)(col) = true
    for (rowOffset <- -1 to 1) {
      val adjRow = row + rowOffset
      if (0 <= adjRow && adjRow < n) {
        for (colOffset <- -1 to 1) {
          val adjCol = col + colOffset
          if (0 <= adjCol && adjCol < n) {
            if (!exposed(adjRow)(adjCol) && getNeighboringBombCount(adjRow, adjCol) == 0) {
              update(adjRow, adjCol)
            }
          }
        }
      }
    }
  }

  private val random = new java.util.Random()
  private val bombCount = 10
  private var containsBomb: Array[Array[Boolean]] = Array.ofDim[Boolean](n, n)
  private val exposed = Array.ofDim[Boolean](n, n)
  private val chosen = Array.ofDim[Boolean](n, n)
  for (row <- 0 until n) {
    for (col <- 0 until n) {
      if (random.nextDouble < bombCount.toDouble / (n * n).toDouble) {
        containsBomb(row)(col) = true
      }
    }
  }

  def getNeighboringBombCount(row: Int, col: Int): Int = {
    var count = 0
    for (r <- row - 1 to row + 1) {
      for (c <- col - 1 to col + 1) {
        if (!(r < 0 || r >= n || c < 0 || c >= n)) {
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
    } else if (exposed(row)(col) && containsBomb(row)(col)) {
      "ó"
    } else {
      getNeighboringBombCount(row, col).toString
    }
  }

  def printBoard(): Unit = {
    print("  ")
    for (col <- 0 until n) {
      print(col + " ")
    }
    println()
    for (row <- 0 until n) {
      print(" ")
      for (_ <- 0 until n) {
        print("--")
      }
      println("-")
      print(row)
      for (col <- 0 until n) {
        val squareDisplay = getSquareDisplay(row, col)
        print("|" + squareDisplay)
      }
      println("|")
    }
    print(" ")
    for (_ <- 0 until n) {
      print("--")
    }
    println("-")
  }
}
