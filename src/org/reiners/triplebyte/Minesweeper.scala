package org.reiners.triplebyte

object Minesweeper {

  def getPlayerChoice: (Integer, Integer) = {
    print("Choose a row: ")
    val row = scala.io.StdIn.readInt()
    print("Choose a column: ")
    val col = scala.io.StdIn.readInt()

    (row, col)
  }


  def main(args: Array[String]): Unit = {
    val state: State = new org.reiners.triplebyte.State()
    while (!done) {
      state.printBoard()
      val playerChoice: (Integer, Integer) = getPlayerChoice
      state.update(playerChoice)
    }
  }

  def done: Boolean = false
}
