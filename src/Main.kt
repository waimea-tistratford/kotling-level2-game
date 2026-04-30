@file:Suppress("DuplicatedCode")

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



    while(true) {
        win = 0
        createBoard()
        addCounters()
        showBoard()
        won()

        var replayCheck: String

        while (true) {
            print("Do you want to play again? Y/N: ")
            replayCheck = readln()

            if (replayCheck.isNotBlank()) break
        }

        if (replayCheck.uppercase() == "N") break
        else {
            continue
        }
    }
}


fun instructions() {
    println("- ─- ─ ─-──- ──-─-──-────────────────────────────────────────────────────-──-─ -──--─-- -  -")
    println("                                        PINNED \uD83D\uDCCC \n" +
            "- -  ─- -─- ─-────-───────────────────────────────────────────────────-────-──--───-─---  -\n" +
            "\n" +
            "-  -─ --─- ─--─ ────────────-────-───┤ Game Setup ├─-─────────────--───-──-─ -─-  ─ -\n" +
            "\n" +
            "A row of 16 squares, numbered 1 to 16 from left to right \n" +
            "\n" +
            "5 counters (total) are placed randomly on the board - 4 white and 1 black  \n" +
            "\n" +
            "Decide who goes first \n" +
            "\n" +
            "- ─- ─- -─- ─── ───-──-───────────────┤ Gameplay ├─────────-────────---──-─ --─ ─-  - \n" +
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
            "- -── ─-─ -─-─ ─── -────--─────────┤ Win Condition ├─────────────-───-─-───- -─--─- -- -  \n" +
            "\n" +
            "The player who removes the black counter from square 1 wins \n")
    println("- -  ─- -─- ─-────-───────────────────────────────────────────────────-────-──--───-─--- -  -")
    println()


}
// getting the names of each player ----------------------------------------------
fun playerNames() {
   while (true) {
       print("Player 1 Name: ")
       player1Name = readln()

       if (player1Name.isNotBlank()) break
   }

    println()

   while (true) {
       print("Player 2 Name: ")
       player2Name = readln()

       if (player2Name.isNotBlank()) break
   }

       println()
       println("$player1Name vs $player2Name")
       println("Welcome to PINNED")


}

// Creating the board -----------------------------------------------------

fun createBoard() {
    while (board.size < 16) {
        board.add(" ")
    }
}

fun addCounters() {
    val xCounter = "x"

    repeat(4) {
        while (true) {
            val xCounterposition = (1..<board.size).random()
            if (board[xCounterposition] == " ") {
                board[xCounterposition] = xCounter
                break
            }
        }
    }

    val oCounter = "o"

    repeat(1) {
        while (true) {
            val oCounterposition = (1..<board.size).random()
            if (board[oCounterposition] == " ") {
                board[oCounterposition] = oCounter
                break
            }
        }
    }
}



// showing the board -----------------------------------------------------------
fun showBoard() {

    println("────────────────────────────────-────-──--───-─--- -  -")

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

    println("──────-────-──--───-─--- -  -")
}


fun won() {

    while (win == 0) {

        gameTurn()

    }

    println()
    println("Congratulations $winner, you've won the game")
    println("$loser, you're horrible at this")
    println()



}

// the main game loop ------------------------------------------------
fun gameTurn() {


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

    var pickCounter: Int?
    var moveCounter: Int?

    while (true) {
    // choosing counter ⏷ ----------------------------------------------------------------

        while (true) {
            print("$player1Name Choose A Counter: ".green())
            pickCounter = readlnOrNull()?.toIntOrNull()

            if (pickCounter != null) break
        }

        pickCounter = pickCounter!! - 1

        if (board[pickCounter] == "x" || board[pickCounter] == "o") {
            if (board[pickCounter - 1] ==  "x" || board[pickCounter - 1] == "o" ){
                continue
            } else break
        }
    }

    println()

    while (true) {
        // asking where to move it ⏷ ---------------------------------------------------------
        while (true) {
            print("Where Do You Want To Move It: ".green())
            moveCounter = readlnOrNull()?.toIntOrNull()

            if (moveCounter != null) break
        }

        moveCounter = moveCounter!! - 1

        if (moveCounter >= pickCounter!!) {
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

    var pickCounter: Int?
    var moveCounter: Int?

    while (true) {
        // choosing counter ⏷ ----------------------------------------------------------------
       while (true) {
           print("$player2Name Choose A Counter: ".green())
           pickCounter = readlnOrNull()?.toIntOrNull()

           if (pickCounter != null) break
       }

        pickCounter = pickCounter!! - 1

        if (board[pickCounter] == "x" || board[pickCounter] == "o") {
            if (board[pickCounter - 1] ==  "x" || board[pickCounter - 1] == "o" ){
                continue
            } else break
        }
    }

    println()

    while (true) {
        // asking where to move it ⏷ ---------------------------------------------------------
        while (true) {
            print("Where Do You Want To Move It: ".green())
            moveCounter = readlnOrNull()?.toIntOrNull()

            if (moveCounter != null) break
        }

        moveCounter = moveCounter!! - 1

        if (moveCounter >= pickCounter!!) {
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





