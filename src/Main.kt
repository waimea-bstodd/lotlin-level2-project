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
Game can be played till the end. Needs more polishing and some things with clear screen needs to be fixed/improved


 */


var squares = mutableListOf<String?>()
var p1Name: String = ""
var p2Name: String = ""
var game: String = ""

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
    intro()
    GetPlayerNames()
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
            squares[white1] = "●"
            break
        }
    }
    while (true) {
        val white2 = (0..15).random()
        if (squares[white2] == "...") {
            squares[white2] = "●"
            break
        }
    }
    while (true) {
        val white3 = (0..15).random()
        if (squares[white3] == "...") {
            squares[white3] = "●"
            break
        }
    }
    while (true) {
        val white4 = (0..15).random()
        if (squares[white4] == "...") {
            squares[white4] = "●"
            break
        }
    }
    while (true) {
        val black = (5..15).random()
        if (squares[black] == "...") {
            squares[black] = "◯"
            break
        }
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

fun intro() {

    gameName()
    println("Welcome to Pinned")
    println()

    print("Do you want instructions [y/n]: ")
    println()

    val input = readlnOrNull()?.uppercase()

    if (input.isNullOrEmpty() || input != "Y") return

    howToPlay()

}
    fun GetPlayerNames(){
        println("What is player ones name? ")
        p1Name = readln()

        print("What is player twos name? ")
        p2Name = readln()

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
}


fun game(){
    var playerTurn = p1Name

    while (true) {
        clearScreen()
        showsquares()
        println("\nIt's $playerTurn's turn")
        println("[M]ove  [R]emove")

        val choice = readlnOrNull()?.uppercase()

        var validTurn = false

        when (choice) {
            "M" -> {
                move()
                validTurn = true
            }
            "R" -> {
                val win = remove(playerTurn)
                if (win) return
                validTurn = true
            }
            else -> println("Invalid choice")
        }

        if (validTurn) {
            playerTurn = if (playerTurn == p1Name) p2Name else p1Name
        }
    }
}

fun gamewin (player: String){
    clearScreen()
    gameName()
    println("$player won")

    println("Game Over")
}

fun remove (playerturn: String): Boolean {
    val index = 0
    if (squares[index] == "...") {
        println("There is nothing on square 1 to remove")
        return false
    }

    if (squares[index] == "◯") {
        squares[index] = "..."
        gamewin(playerturn)
        return true
    }
    squares[index] = "..."
    return false
}

fun move (){
    print("Pick square to move: ")
    val from = readlnOrNull()?.toIntOrNull()

    print("Where would you like to move it to: ")
    val to = readlnOrNull()?.toIntOrNull()

    if (from == null || to == null) {
        println("Invalid square")
        return
    }

    val start = from - 1
    val end = to - 1

    if (start !in 0..15 || end !in 0..15) {
        println("Invalid squares")
        return
    }

    if (squares[start] == "...") {
        println("Nothing there")
        return
    }

    if (squares[end] != "...") {
        println("Space not empty")
        return
    }

    val step = if (end > start) 1 else -1

    var i = start + step
    while (i != end) {
        if (squares[i] != "...") {
            println("Cannot jump over pieces")
            return
        }
        i += step
    }
    squares[end] = squares[start]
    squares[start] = "..."
}