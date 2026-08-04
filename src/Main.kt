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

/**
 * clears sceen by printing lots of blank lines
 */
fun clearScreen() {
    for (i in 0..100) {
        println()
    }
}

/**
 * Shows the name of the game
 */
fun gameName(){ //game title art
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

/**
 * This is the entry point for the program
 */
fun main()  {
    // Setup the game
    intro()
    GetPlayerNames()
    createCells()
    addCounters()
    showsquares()

    // Get started
    game()
}

/**
 * Sets up the game board with blanks
 */
fun createCells() {
    for (i in 1..16){
        squares.add("...")
    }
}


/**
 * Adds white and black counters randomly to the board
 * We have four white and one black - placed on empty squares
 */
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

/**
 * Displays the game board
 */
fun showsquares() {
    // Show square numbers
    for (i in 1..squares.size) {
        print("Square $i  ".padEnd(length = 11))
    }
    println()
    print("┌──────────")
    print("┬──────────".repeat(squares.size-1))
    println("┐")

    // Show player pieces on screen
    for (cell in squares){
        print("│ ${cell?.padEnd(8)} ")
    }
    print("│")
    println()
    print("└──────────")
    print("┴──────────".repeat(squares.size-1))
    println("┘")
}

/**
 *Shows the game start and asks if you want to read rules
 * The user has to input Y to be able go to continue to the next part
 */
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
/**
 * Asks players for their names so the game can say whos turn it is
 */
    fun GetPlayerNames(){
        println("What is player ones name? ")
        p1Name = readln()

        print("What is player twos name? ")
        p2Name = readln()

        clearScreen()
        print("Hello $p1Name and $p2Name")
        println()

}
/**
 * prints how to play the game only if the player inputs Y in the intro function
 */
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

/**
 * main game loop
*/
fun game(){
    var playerTurn = p1Name

    while (true) { // Asks player if they want to move or remove the square by inputting M for move or R for remove
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

        // Switch players
        if (validTurn) {
            playerTurn = if (playerTurn == p1Name) p2Name else p1Name
        }
    }
}

/**
 * Shows win screen and tells players who won the game
*/
fun gamewin (player: String){
    clearScreen()
    gameName()
    println("$player won")

    println("Game Over")
}

/**
 * Removes the piece in square 1
 * also gives a error message if there is nothing to remove
*/
fun remove (playerturn: String): Boolean {
    val index = 0
    if (squares[index] == "...") {
        println("There is nothing on square 1 to remove")
        return false
    }

    if (squares[index] == "◯") { //if black removed from board the game end
        squares[index] = "..."
        gamewin(playerturn)
        return true
    }
    squares[index] = "..." //If nothing in board the game keeps going
    return false
}

/**
 * All movement code.
 * Ask player what and where to move
 * Check moves that are not allowed
 */
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

    // Make sure choices are in range
    if (start !in 0..15 || end !in 0..15) {
        println("Invalid squares")
        return
    }
    // Checking if there is something in the square
    if (squares[start] == "...") {
        println("Nothing there")
        return
    }
    // Checking if square is empty
    if (squares[end] != "...") {
        println("Space not empty")
        return
    }

    val step = if (end > start) 1 else -1

    var i = start + step
    while (i != end) {
        if (squares[i] != "...") { //making sure players cant jump over pieces
            println("Cannot jump over pieces")
            return
        }
        i += step
    }
    squares[end] = squares[start]
    squares[start] = "..."
}
