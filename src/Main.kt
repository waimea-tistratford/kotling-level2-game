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
var win = false

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

    while (true) {
        player1Action()
        showBoard()

        player2Action()
        showBoard()
    }
}

fun player1Action() {

    var pickCounter = 0

    while (true) {
       print("$player1Name Choose A Counter: ")
       pickCounter = readln().toInt() - 1
       if (board[pickCounter] == "x" || board[pickCounter] == "o")break
   }

    println()
    var moveCounter = 0

    while (true){
        print("Where Do You Want To Move It: ")
        moveCounter =readln().toInt() - 1
        if (moveCounter == 0 ) {
            board[pickCounter] = " "
            break
        } else {
            if (moveCounter <pickCounter && board[moveCounter] == " ") break
            }
    }
    val choice1 = board[pickCounter]
    val choice2 = board[moveCounter]

    board[moveCounter] = choice1
    board[pickCounter] = choice2



}

fun player2Action() {

    var pickCounter = 0

    while (true) {
        print("$player2Name Choose A Counter: ")
        pickCounter = readln().toInt() - 1
        if (board[pickCounter] == "x" || board[pickCounter] == "o") break
    }

    println()
    var moveCounter = 0

    while (true) {
        print("Where Do You Want To Move It: ")
        moveCounter = readln().toInt() - 1
        if (moveCounter == 0 ) {
            board[pickCounter] = " "
            break

        } else {
            if (moveCounter <pickCounter && board[moveCounter] == " ") break
        }
    }
    var highestX = 0

    for (space in board) {
        if (space > board[moveCounter] && space < board[pickCounter] && ( space == "x" || space == "o")){
            highestX =
        }

    }

    val choice1 = board[pickCounter]
    val choice2 = board[moveCounter]

    board[moveCounter] = choice1
    board[pickCounter] = choice2

}

fun checkWin() {

    win = true
}





