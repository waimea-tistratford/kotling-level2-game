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

fun main() {
    playerNames()
    createBoard()
    addCounters()
    showBoard()

}

fun playerNames() {
    print("Player 1 Name: ")
    player1Name = readln()



    print("Player 2 Name: ")
    player2Name = readln()


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

    println("$player1Name vs $player2Name")

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

fun player1Action() {

}

fun player2Action() {

}




