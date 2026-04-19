/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Pinned
 * Project Author: Troy Stratford
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */
var board = mutableListOf<String>()
var player1Name: String = ""
var player2Name: String = ""
var win = 0
var p1 = 0
var p2 = 1
var winner = ("undecided")
var loser = ("undecided")

fun main() {
    playerNames()
    createBoard()
    addCounters()
    showBoard()
    getPlayerAction()


}

fun playerNames() {
    print("Player 1 Name: ")
    player1Name = readln()



    print("Player 2 Name: ")
    player2Name = readln()

    println()
    println("$player1Name vs $player2Name")


}

// Creating the board -----------------------------------------------------

fun createBoard() {
    while (board.size < 16) {
        board.add(" ")
    }
}

fun addCounters() {
    val x_counter = "x"

    repeat(4) {
        while (true) {
            val x_counterPosition = (1..<board.size).random()
            if (board[x_counterPosition] == " ") {
                board[x_counterPosition] = x_counter
                break
            }
        }
    }

    val o_counter = "o"

    repeat(1) {
        while (true) {
            val o_counterPosition = (1..<board.size).random()
            if (board[o_counterPosition] == " ") {
                board[o_counterPosition] = o_counter
                break
            }
        }
    }
}




fun showBoard() {
    println()


    println()

    print("  1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16")

    println()
    print("┌───")
    print("┬───".repeat(board.size - 1))
    println("┐")


    for (i in 0..<board.size) {
        print("│")
        print(" ${board[i]}".padEnd(3))
    }
    println("│")

    print("└───")
    print("┴───".repeat(board.size - 1))
    println("┘")
}
fun getPlayerAction() {

    while (win == 0) {

        playerAction()

    }

    println()
    println("Congratulations $winner, you've won the game")
    println("$loser, you suck ass")



}


fun playerAction() {


  if (win == 0) {
      player1Action()
      p1++
      p2--
      showBoard()
      checkWin()
  }
  if (win == 0) {
      player2Action()
      p1--
      p2++
      showBoard()
      checkWin()
  }

}



fun player1Action() {

    var pickCounter = 0

    while (true) {
    // choosing counter ⏷ ----------------------------------------------------------------
        print("$player1Name Choose A Counter: ")
        pickCounter = readln().toInt() - 1
        if (board[pickCounter] == "x" || board[pickCounter] == "o") {
            if (board[pickcounter - 1] ==  "x" )
        }
    }

    println()
    var moveCounter = 0

    while (true) {
        // asking where to move it ⏷ ---------------------------------------------------------
        print("Where Do You Want To Move It: ")
        moveCounter = readln().toInt() - 1

        if (moveCounter >= pickCounter) {
            continue
        }

        // Doing the move ⏷ ------------------------------------------------------

        var counterCount = 0

        for (index in moveCounter..<pickCounter ) {
            if (board[index] == "x" || board[index] == "o") {
                counterCount++
            }

        }
        if (counterCount > 0) {
            continue
        }else {
            if (moveCounter == 0) {

                board[pickCounter] = " "
                break

            } else {

                val choice1 = board[pickCounter]
                val choice2 = board[moveCounter]

                board[moveCounter] = choice1
                board[pickCounter] = choice2
                break

            }
        }
    }
}


fun player2Action() {

    var pickCounter = 0

    while (true) {
        // choosing counter ⏷ ----------------------------------------------------------------
        print("$player2Name Choose A Counter: ")
        pickCounter = readln().toInt() - 1
        if (board[pickCounter] == "x" || board[pickCounter] == "o") break
    }

    println()
    var moveCounter = 0

    while (true) {
        // asking where to move it ⏷ ---------------------------------------------------------
        print("Where Do You Want To Move It: ")
        moveCounter = readln().toInt() - 1

        if (moveCounter >= pickCounter) {
            continue
        }

        // Doing the move ⏷ ------------------------------------------------------

        var counterCount = 0

        for (index in moveCounter..<pickCounter ) {
            if (board[index] == "x" || board[index] == "o") {
                counterCount++
            }

        }
        if (counterCount > 0) {
            continue
        }else {
            if (moveCounter == 0) {

                board[pickCounter] = " "
                break

            } else {

                val choice1 = board[pickCounter]
                val choice2 = board[moveCounter]

                board[moveCounter] = choice1
                board[pickCounter] = choice2
                break
            }
        }
    }
}

fun checkWin() {

    var oCounterCount = 0
    
    for (index in 0..<board.size) {
        if (board[index] == "o") {
            oCounterCount++
        }

    }
    if (oCounterCount == 0) {
        win++
    }

// check winner ------------------------

    if (win == 1) {
        val highest = maxOf(p1, p2)

        if (highest == p1) {
            winner = player1Name
            loser = player2Name
        }else {
            winner = player2Name
            loser = player1Name
        }
    }




}





