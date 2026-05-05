# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Can't jump over other pieces

If the player tried to jump over other pieces the game should reject what the player is doing and give the player an error

### Test Data To Use

I will try to move a piece that would jump over a different piece

### Expected Test Result

It should say be invalid because you shouldn't be able to jump over other pieces 

---

## Player's can put names in

Test if player's can put in their names. The game needs the players names so the game can say who's turn it is and also say who won the game.

### Test Data To Use

Im going to put player ones name to Ben1 and player twos name Ben2.

### Expected Test Result

It should be valid as the game should take any name

---

## Player Counter Selection - BOUNDARIES

I will test the boundaries of the counter input

### Test Data To Use

I will attempt to select counters at position 1 and position 16, the boundaries of the board
### Expected Test Result
The inputs should be accepted

---

## Ask for game instructions

When the player first loads up the game it should ask if they want to know how to play Pinned

### Test Data To Use

Im going to load up the game and see if the game asks if I want to know how to play the game.
### Expected Test Result


---

