//This application is a rock, paper and scissors game written in Scala
//I wrote this program to learn the basics of Scala 
//The user plays with the character Elon who is an AI
//The game is played on the Scala console
//This is text based game where the user replies with 'rock', 'paper' or 'scissors'

object App {
  def main(arrgs: Array[String]): Unit = {

    def name: String = System.getProperty("user.name")


    var win: Boolean = false //win is used to determine the state of the game, if the player wins or looses, it is set to true and the program exits
    var tries = 3 //This is the number of tries the user has
    var answers = Array("rock", "paper", "scissors") //These are the possible answers
    var playerGuess = new String //Holds the player's guess
    var elonGuess = new String //Holds Elon's guess
    var playerWins = 0 //Holds the player's guess
    var elonWins = 0 //Holds Elon's guess
    val correctGuess = scala.util.Random //Elon's guess is random, so it selects from the three answers

   //This Array holds all the lines said by Elon
    def speech = Array(
      "Hello, " + name + "!",
      "My name is Elon!",
      "",
      "I am an AI.",
      "",
      "Let's play a game!",
      "Hmmm... what game should we play?",
      "How about a game of Rock, Paper, Scissors?!",
      "",
      "Best out of three rounds win.",
      "",
      "Go ahead and make your choice by typing rock, paper or scissors:",

      "Well since you have "+playerWins+" wins and I have "+elonWins+"...", //12
      "You Won! Bye for now!",
      "",
      "You must be pretty smart to beat an AI.",
      "",//16

      "Look at my hand, it's "+elonGuess+", which is equal to "+playerGuess+". How about we do that round again?",//17
      "So far you have "+playerWins+" wins and I have "+elonWins+" wins",
      "We still have "+ tries.toString +" rounds left:",//19

      "Look at my hand, it's "+elonGuess+", which beats "+playerGuess+". Better luck next round!",//20
      "So far you have "+playerWins+" wins and I have "+elonWins+" wins",
      "There is still "+ tries.toString +" rounds to go:", //22

      "Look at my hand, it's "+elonGuess+", which is beaten by "+playerGuess+". Nice one!", //23
      "So far you have "+playerWins+" wins and I have "+elonWins+" wins",
      "There is still "+ tries.toString +" rounds to go:", //25

      "Well since you have "+playerWins+" wins and I have "+elonWins+"...", //26
      "Looks like I won!",
      "",
      "AI's are smarter than humans anyway... so don't fret! You could always try again.",
      "", //30
      
      "You do know how to play right? I'm gonna pretend you didn't type that...", //31
      "Let's try this again, shall we?:") //32

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
      Thread.sleep(0) //Added for typing effect
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
    if(tries != -1 ) {
      if ((playerWins == 2)||(elonWins == 2)) { //Game Over
          tries = -1
          if(playerWins>elonWins){
            textIndex = 12
            textStop = 16
          }else{
            textIndex = 26
            textStop = 30
          }
        }else{
      elonGuess = answers(correctGuess.nextInt(3)) //Elon plays a new hand each time
      System.out.print("> ")
      playerGuess = scala.io.StdIn.readLine()
      if (playerGuess == elonGuess) {
        textIndex = 17
        textStop = 19
      } else {
        tries -= 1
        if((playerGuess.length() == 8) && (elonGuess.length()==5)){ // Scissors Beats Paper (Player Wins)
            playerWins += 1
            textIndex = 23
            textStop = 25
        } else if((playerGuess.length() == 5) && (elonGuess.length()==8)){ // Scissors Beats Paper (Elon Wins)
            elonWins += 1
            textIndex = 20
            textStop = 22
        } else if((playerGuess.length() == 5) && (elonGuess.length()==4)){ // Paper Beats Rock (Player Wins)
            playerWins += 1
            textIndex = 23
            textStop = 25
        } else if((playerGuess.length() == 4) && (elonGuess.length()==5)){ // Paper Beats Rock (Elon Wins)
            elonWins += 1
            textIndex = 20
            textStop = 22
        }else if((playerGuess.length() == 4) && (elonGuess.length()==8)){ // Rock Beats Scissors (Player Wins)
            playerWins += 1
            textIndex = 23
            textStop = 25
        } else if((playerGuess.length() == 8) && (elonGuess.length()==4)){ // Rock Beats Scissors (Elon Wins)
            elonWins += 1
            textIndex = 20
            textStop = 22
        } else {
          tries += 1
          textIndex = 31
          textStop = 32
        } 
    

      }
        }
    }else{win = true}


}while(win != true)

  }
}
