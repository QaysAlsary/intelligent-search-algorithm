
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("please enter level: ");
        int n = read.nextInt();
        structure board = new structure(n);
        String move = "";
        moves m = new moves();
        Logic logic=new Logic();
//        m.print(board, board.n);
        board.print(board);
        String chose="";
        System.out.println("type user for user mode");
        System.out.println("type bfs for BFS algorithm mode");
        System.out.println("type dfs for DFS algorithm mode");

        chose=read.next();
  switch (chose){
      case "user":
      while (!board.isFinshed(board) || !"stop".equals(move)) {
          System.out.println("to move one step up write muo \n to move tow step up write mut \n to move one  step down write mdo \n to move  tow step down write mdt \n to move one  step right write mro \n to move tow step right write mrt \n to move one  step left write mlo \n to move tow step left write mlt \n to stop the game write s ");
          System.out.println("****************************************");
          System.out.println(board.checkMove(board));
//          board.getNextState(board);
          move = read.next();
          System.out.println("****************************************");
          switch (move) {
              case "muo":
                  m.moveStepUp(board.array, true, board);
                  break;
              case "mut":
                  m.moveTowStepUp(board.array, true, board);
                  break;
              case "mdo":
                  m.moveStepDown(board.array, true, board);
                  break;
              case "mdt":
                  m.moveTowStepDown(board.array, true, board);
                  break;
              case "mro":
                  m.moveStepRight(board.array, true, board);
                  break;
              case "mrt":
                  m.moveTowStepRight(board.array, true, board);
                  break;
              case "mlo":
                  m.moveStepLeft(board.array, true, board);
                  break;
              case "mlt":
                  m.moveTowStepLeft(board.array, true, board);
                  break;

              case "print":
                  board.printNextState(board);
          }

          System.out.println(board.isFinshed(board));
//            m.print(board, board.n);
          board.print(board);
      }
      break;
      case "bfs":
                logic.BFS(board);
                break;
      case "dfs":
          logic.DFS(board);
          break;
      case "ucs":
          logic.UCS(board);
          break;
      case "A*":
          logic.aStar(board);
          break;

  }


    }
}

//case "bfs":
//                    logic.BFS(board);