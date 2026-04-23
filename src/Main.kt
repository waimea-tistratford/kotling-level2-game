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
var winner = ("")
var loser = ("")

fun main() {
    instructions()
    playerNames()
    createBoard()
    addCounters()
    showBoard()
    getPlayerAction()


}

fun instructions() {
    println("───────────────────────────────────────────────────────────────────────-─────-──-─-────--─-- -   -")
    println("Pinned \uD83D\uDCCC \n" +
            "\n" +
            "Game Setup \n" +
            "\n" +
            "A row of 16 squares, numbered 1 to 16 from left to right \n" +
            "\n" +
            "5 counters (total) are placed randomly on the board - 4 white and 1 black  \n" +
            "\n" +
            "Decide who goes first \n" +
            "\n" +
            "Gameplay \n" +
            "\n" +
            "Players take turns - You may not skip your turn \n" +
            "\n" +
            "On your turn you must do exactly one of the following: \n" +
            "\n" +
            "Slide any counter (black or white) any number of squares to the left\n" +
            "\n" +
            "As long as no other counter is in the way and the destination square is empty\n" +
            "\n" +
            "Or remove the counter on square 1 (only if a counter is there) \n" +
            "\n" +
            "Win Condition \n" +
            "\n" +
            "The player who removes the black counter from square 1 wins \n" +
            "\n" +
            "Variant \n" +
            "\n" +
            "Counters can slide either left or right (but still can’t jump other counters) ")
    println("───────────────────────────────────────────────────────────────────────────-────-──--───-─--- -  -")
    println()


}
// getting the names of each player ----------------------------------------------
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



// showing the board -----------------------------------------------------------
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

        gameLoop()

    }

    println()
    println("Congratulations $winner, you've won the game")
    println("$loser, you suck ass")



}

// the main game loop ------------------------------------------------
fun gameLoop() {


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


// player 1 move --------------------------------------------------------------------
fun player1Action() {

    var pickCounter = 0

    while (true) {
    // choosing counter ⏷ ----------------------------------------------------------------
        print("$player1Name Choose A Counter: ")
        pickCounter = readln().toInt() - 1
        if (board[pickCounter] == "x" || board[pickCounter] == "o") {
            if (board[pickCounter - 1] ==  "x" || board[pickCounter - 1] == "o" ){
                continue
            } else break

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

// player 2 move --------------------------------------------------------
fun player2Action() {

    var pickCounter = 0

    while (true) {
        // choosing counter ⏷ ----------------------------------------------------------------
        print("$player2Name Choose A Counter: ")
        pickCounter = readln().toInt() - 1
        if (board[pickCounter] == "x" || board[pickCounter] == "o") {
            if (board[pickCounter - 1] ==  "x" || board[pickCounter - 1] == "o" ){
                continue
            } else break
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

// checking for a win -------------------------------
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

// check for the  winner ------------------------

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





