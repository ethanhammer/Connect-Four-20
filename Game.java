
public class Game {
  private String[][] stringData = new String[6][7];
  int turnNum;
  boolean game;
  
  public Game() {
    turnNum = 1;
    game = true;
}
  
  //returns turn color
  public String getColor(){
    if (turnNum % 2 == 0) {
      return "red";
    } 
    return "blue";
  }

  //checks negative diagnol
  public boolean checkNegativeDiagnol(int row, int square) {
    int total= 0;
    for (int i = 1; i < 4; i++) {
     if (square + i < 7 && row + i < 6) {
      if (stringData[row + i][square+i] == stringData[row][square]) {
        total++;
        System.out.println(total);
      } else {break;}
    } 
  }
    for (int i = 1; i < 4; i++) {
     if (square - i +1 > 0 && row - i +1 > 0) {
      if (stringData[row - i][square-i] == stringData[row][square]) {
        total++;
        System.out.println(total);
      } else {break;}
    } 
  }
      if (total == 3) {
      return true;
    }
    return false;
  }

  //checks positive diagnol
  public boolean checkPositiveDiagnol(int row, int square) {
    int total= 0;
    for (int i = 1; i < 4; i++) {
     if (row + i < 6 && square - i +1 > 0) {
      if (stringData[row + i][square-i] == stringData[row][square]) {
        total++;
      } else {break;}
    } 
  }
   for (int i = 1; i < 4; i++) {
     if (square + i < 6 && row - i +1 > 0) {
      if (stringData[row - i][square+i] == stringData[row][square]) {
        total++;
      } else {break;}
    } 
  }
      if (total == 3) {
      return true;
    }
    return false;
  }

  //restart game function
  public void restartGame() {
    turnNum = 1;
    game = true;
     for (int i = 0; i < 6; i ++) {
      for (int j = 0; j < 7; j ++) {
        stringData[i][j] = null;
      }
      }
  }

  // checks for horizontal win
  public boolean checkHorizontal(int row, int square) {
    int total= 0;
    for (int i = 1; i < 5; i++) {
     if (square + i < 7) {
      if (stringData[row][square+i] == stringData[row][square]) {
        total++;
      } else {break;}
    } 
  }
    for (int i = 1; i < 5; i++) {
     if (square - i + 1 > 0) {
      if (stringData[row][square-i] == stringData[row][square]) {
        total++;
      } else {break;}
    } 
  }
    if (total == 3) {
      return true;
    }
    return false;
  }
  
  //checks for vertical win
  public boolean checkVertical(int row, int square) {
  int total = 0;
   if (row < 3) {
     for (int i = 1; i < 5; i++ ) {
       if (stringData[row+i][square] == stringData[row][square] && (row < 6 )) {
        total++;
          if (total == 3) {
            return true;
           }
       } else {break;}
     }
   }
    return false;
  }
  
  // checks all wins (master function)
  public boolean checkWin(int row, int square) {
    if (checkHorizontal(row, square) || checkVertical(row, square) || checkNegativeDiagnol(row, square) || checkPositiveDiagnol(row, square)) {
      return true;
    } return false;
  }
  
  //checks if square is empty and confirms theres a square below
  public boolean checkAvailability(int row, int square) {
    if (checkSquareBelow(row, square) && (stringData[row][square] == null)) {
      stringData[row][square] = getColor();
      return true;
    }return false;
  }
  
  //function to check if there is a square below
  public boolean checkSquareBelow(int row, int square) {
    if (row == 5) {
      return true;
  }
    if (stringData[row+1][square] != null) {
      return true;
    } return false;
  }

  
}