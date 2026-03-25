/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: PROJECT AUTHOR HERE
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */

val squares = mutableListOf<String?>()

fun clearScreen() {
    for (i in 0..100) {
        println()
    }
}

fun gameName(){
    println()
    println(
        "                                           \n" +
                " __________________________________________\n" +
                "/_____/_____/_____/_____/_____/_____/_____/\n" +
                "__________.__                         .___ \n" +
                "\\______   \\__| ____   ____   ____   __| _/ \n" +
                " |     ___/  |/    \\ /    \\_/ __ \\ / __ |  \n" +
                " |    |   |  |   |  \\   |  \\  ___// /_/ |  \n" +
                " |____|   |__|___|  /___|  /\\___  >____ |  \n" +
                "                  \\/     \\/     \\/     \\/  "
    )
    println()
}

fun main() {


    while (true) {

        val action = intro()

        when (action) {
            'P' -> GetPlayerNames()
            'H' -> howToPlay()
        }
        break

    }
    createCells()
    addCounters()
    showsquares()
    game()
}


fun createCells() {
    for (i in 1..16){
        squares.add("...")
    }
}

fun addCounters() {
    while (true) {
        val white1 = (0..15).random()
        if (squares[white1] == "...") {
            squares[white1] = "⬤"
            break
        }
    }
    while (true) {
        val white2 = (0..15).random()
        if (squares[white2] == "...") {
            squares[white2] = "⬤"
            break
        }
    }
    while (true) {
        val white3 = (0..15).random()
        if (squares[white3] == "...") {
            squares[white3] = "⬤"
            break
        }
    }
    while (true) {
        val white4 = (0..15).random()
        if (squares[white4] == "...") {
            squares[white4] = "⬤"
            break
        }
    }
    while (true) {
        val black = (0..15).random()
        if (squares[black] == "...") {
            squares[black] = "◯"
            break
        }
        if (squares[black] == "-1") {gamewin()}
    }
}

fun showsquares() {
    for (i in 1..squares.size) {
        print("Square $i  ".padEnd(length = 11))
    }
    println()
    print("┌──────────")
    print("┬──────────".repeat(squares.size-1))
    println("┐")

    for (cell in squares){
        print("│ ${cell?.padEnd(8)} ")
    }
    print("│")
    println()
    print("└──────────")
    print("┴──────────".repeat(squares.size-1))
    println("┘")
}

fun intro(): Char {

    gameName()
    println("Welcome to Pinned")
    println("[P]lay")
    println("[H]ow to play")
    println()

    print("Choice: ")
    println()

    val input = readlnOrNull()?.uppercase()

    if (input.isNullOrEmpty()) {
        println("No input entered.")
        return ' '
    }

    return input[0]


}
    fun GetPlayerNames(){
        clearScreen()
        gameName()
        print("What is player ones name? ")
        val p1Name = readln()

        print("What is player twos name? ")
        val p2Name = readln()

        clearScreen()
        print("Hello $p1Name and $p2Name")
        println()

}



fun howToPlay(){
    clearScreen()
println("Pinned \uD83D\uDCCC\n" +
        "Game Setup\n" +
        ""+
        "A row of 16 squares, numbered 1 to 16 from left to right\n" +
        "5 counters (total) are placed randomly on the board - 4 white and 1 black\n" +
        "Decide who goes first\n")
        println()
       println("Gameplay")

        println("Players take turns - You may not skip your turn\n" +
        "On your turn you must do exactly one of the following:\n" +
        "Slide any counter (black or white) any number of squares to the left, as long as no other counter is in the way and the destination square is empty, or...\n" +
        "Remove the counter on square 1 (only if a counter is there)\n" )
    println()
    println("Win Condition")
    print("The player who removes the black counter from square 1 wins\n")
    println()
    println()
    println("Variant\n" +
        "Counters can slide either left or right (but still can't jump other counters)")

    intro()

}

fun playerTurns() {
    val playerTurn = ("")

}


fun game(){

    while (true) {
        clearScreen()
        showsquares()
        gameName()




    }
    gamewin()
}

fun gamewin (){
    clearScreen()
    gameName()
    println("Player name won")

    println("Would you like to play again? ")
}



