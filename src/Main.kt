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
val spaces = mutableListOf<String>()


fun main() {
    createBoard()
    showBoard()

}

// Creating the board -----------------------------------------------------

fun createBoard() {
    while (spaces.size < 16)
    spaces.add("")
}

fun addCounters() {
    var counter = "x"
    repeat(4) {

    }


}



fun showBoard() {
    println()

    println()
    print("┌───")
    print("┬───".repeat(spaces.size - 1))
    println("┐")


    for (i in 0..<spaces.size) {
        print("│")
        print(" ${spaces[i]}".padEnd(3))
    }
    println("│")

    print("└───")
    print("┴───".repeat(spaces.size - 1))
    println("┘")
}