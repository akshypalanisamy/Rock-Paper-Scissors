//This application is a rock, paper and scissors game written in Scala
//I wrote this program to learn the basics of Scala 
//The user plays with the character Jigsaw from the movie SAW
//The game is played on the Scala console
//This is text based game where the user replies with 'rock', 'paper' or 'scissors'

object App {
  def main(arrgs: Array[String]): Unit = {

    def name: String = System.getProperty("user.name")


    var win: Boolean = false //win is used to determine the state of the game, if the player wins or looses, it is set to true and the program exits
    var tries = 3 //This is the number of tries the user has
    var answers = Array("rock", "paper", "scissors") //These are the possible answers
    var playerGuess = new String //Holds the player's guess
    var jigsawGuess = new String //Holds Jigsaw's guess
    val correctGuess = scala.util.Random //Jigsaw's guess is random, so it selects from the three answers

   //This Array holds all the lines said by Jigsaw
    def speech = Array(
      "Hello, " + name + "!",
      "You don't know me but",
      "",
      " I know you.",
      "",
      "I want to play a game.",
      "There is only one way out of this.",
      "Beat me in a game of Rock, Paper, Scissors!",
      "",
      "I'll give you three chances.",
      "",
      "Go ahead and make your choice: ",

      "You exceeded my expectations.",
      "You are free to go.",
      "",
      "For now.",
      "",

      "Look at my hand, it's "+jigsawGuess+". Why don't you guess again?",
      "You have only "+ tries.toString +" tries left.",

      "Pity.",
      "",
      "This won't hurt a bit.",
      "",

      "Tsk Tsk, that's going to cost you.",
      "You have only "+ tries.toString +" tries left.")

    //These two variables determine where the dialog starts and stops, which is then used
    //in printing out the dialog in the for loop below
    var textIndex = 0
    var textStop = 11

//This do-while loop is what prints the text to the screen and takes the input from the user.
//If the player wins or looses, win is set to true and the program exits
do{

  //This for loop prints the text to the screen letter by letter with a cursor
  //Essentially writing over the same line over and over again
  for (k <- textIndex to textStop) {
    var text = speech(k)
    val textLength = text.length - 1
    var textIter = 0
    for (i <- 0 to textLength) {
      System.out.print("|")
      Thread.sleep(200) //Added for typing effect
      if (textIter <= textLength) {
        System.out.print("\r")
        for (j <- 0 to textIter) {
          System.out.print(text(j))
        }
      }
      textIter += 1
    }
    Thread.sleep(1000) //Added for pausing effect in speech
    System.out.print("\n")
  }


  //This series of if statements checks what the player answers and gives a corresponding text answer
    if(tries != 0 ) {
      jigsawGuess = answers(correctGuess.nextInt(3)) //Jigsaw plays a new hand each time
      System.out.print("> ")
      playerGuess = scala.io.StdIn.readLine()
      if (playerGuess == jigsawGuess) {
        textIndex = 12
        textStop = 16
        tries = 0
      } else {
        tries -= 1
        if (tries == 0) {
          textIndex = 19
          textStop = 22
        } else if(answers contains (playerGuess)){
            textIndex = 17
            textStop = 18
        } else {
          textIndex = 23
          textStop = 24
        }
      }
    }else{win = true}

}while(win != true)

  }
}
