import java.util.ArrayList;
import java.util.Arrays;

public class structure {
   public char[][] array;
   public int n;
   public int initI;
   public int initJ;
   public int cost;
   public int depth;
   public int h;
    public structure parent=null;
    moves m = new moves();

    public void deepCopy(char[][] arr, char[][] newarr) {
        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr.length; ++j) {
                newarr[i][j] = arr[i][j];
            }
        }

    }

    public structure(int level) {
        this.n = level;
        this.initI = this.n - 1;
        this.initJ = this.n - 1;
        this.array = new char[this.n * 2 - 1][this.n * 2 - 1];

        int i;
        int j;
        for(i = 0; i < this.n; ++i) {
            for(j = 0; j < this.n; ++j) {
                this.array[i][j] = 'R';
            }
        }

        for(i = this.n - 1; i < this.n * 2 - 1; ++i) {
            for(j = this.n - 1; j < this.n * 2 - 1; ++j) {
                this.array[i][j] = 'B';
            }
        }

        this.array[this.n - 1][this.n - 1] = '*';
    }

    public ArrayList checkMove(structure str) {
        ArrayList<String> moves = new ArrayList();
        if (str.m.moveStepUp(str.array, false, str)) {
            moves.add("oneUp");
        }

        if (str.m.moveTowStepUp(str.array, false, str)) {
            moves.add("towUp");
        }

        if (str.m.moveStepDown(str.array, false, str)) {
            moves.add("oneDown");
        }

        if (str.m.moveTowStepDown(str.array, false, str)) {
            moves.add("towDown");
        }

        if (str.m.moveStepRight(str.array, false, str)) {
            moves.add("oneRight");
        }

        if (str.m.moveTowStepRight(str.array, false, str)) {
            moves.add("towRight");
        }

        if (str.m.moveStepLeft(str.array, false, str)) {
            moves.add("oneLeft");
        }

        if (str.m.moveTowStepLeft(str.array, false, str)) {
            moves.add("towLeft");
        }

        return moves;
    }

//    public ArrayList<structure> getNextState(structure str) {
//        ArrayList<String> position = str.checkMove(str);
//        ArrayList<structure> nextState = new ArrayList<structure>();
//        for(String pos : position){
//
//            structure obj = new structure(str.n);
//            obj.parent=str;
//            moves movObj;
//            if (position.contains("oneUp")) {
//                obj = new structure(n);
//                deepCopy(str.array, obj.array);
//                movObj = new moves();
//                movObj.moveStepUp(obj.array, true, obj);
//                obj.print(obj);
//                nextState.add(obj);
//            }
//
//            if (position.contains("towUp")) {
//                obj = new structure(n);
//                deepCopy(str.array, obj.array);
//                movObj = new moves();
//                movObj.moveTowStepUp(obj.array, true, obj);
//                obj.print(obj);
//                nextState.add(obj);
//            }
//
//            if (position.contains("oneDown")) {
//                obj = new structure(n);
//                deepCopy(str.array, obj.array);
//                movObj = new moves();
//                movObj.moveStepDown(obj.array, true, obj);
//                obj.print(obj);
//                nextState.add(obj);
//            }
//
//            if (position.contains("towDown")) {
//                obj = new structure(n);
//                deepCopy(str.array, obj.array);
//                movObj = new moves();
//                movObj.moveTowStepDown(obj.array, true, obj);
//                obj.print(obj);
//                nextState.add(obj);
//            }
//
//            if (position.contains("oneRight")) {
//                obj = new structure(n);
//                deepCopy(str.array, obj.array);
//                movObj = new moves();
//                movObj.moveStepRight(obj.array, true, obj);
//                obj.print(obj);
//                nextState.add(obj);
//            }
//
//            if (position.contains("towRight")) {
//                obj = new structure(n);
//                deepCopy(str.array, obj.array);
//                movObj = new moves();
//                movObj.moveTowStepRight(obj.array, true, obj);
//                obj.print(obj);
//                nextState.add(obj);
//            }
//
//            if (position.contains("oneLeft")) {
//                obj = new structure(n);
//                deepCopy(str.array, obj.array);
//                movObj = new moves();
//                movObj.moveStepLeft(obj.array, true, obj);
//                obj.print(obj);
//                nextState.add(obj);
//            }
//
//            if (position.contains("towLeft")) {
//                obj = new structure(n);
//                deepCopy(str.array, obj.array);
//                movObj = new moves();
//                movObj.moveTowStepLeft(obj.array, true, obj);
//               obj.print(obj);
//                nextState.add(obj);
//            }
////            nextState.add(str);
//        }
//
//        return nextState;
//    }

    public void deepCopy(structure s, structure s1) {
        s1.initI = s.initI;
        s1.initJ = s.initJ;
        s1.n = s.n;

        for(int i = 0; i < s.array.length; i++) {
            for(int j = 0; j < s.array.length; j++ ) {
                if (s.array[i][j] == 'R' || s.array[i][j] == 'B' || s.array[i][j] == '*') {
                    s1.array[i][j] = s.array[i][j];
                }
            }
        }

        s1.parent = s.parent;
    }
    public ArrayList<structure> getNextState(structure s){
        ArrayList<structure> next_states = new ArrayList<>();
        ArrayList<String> possible_positions = checkMove(s);
        for(String position : possible_positions){
            structure s1 = new structure(s.n);
            moves movObj=new moves();
//            movObj.swap(s.array,s.initI,s.initJ ,s1.initI, s1.initJ);
            deepCopy(s,s1);

            s1.parent = s;
            switch (position) {
                case "oneRight":
                    movObj.moveStepRight(s1.array, true, s1);
//                    s1.print(s1);
                    break;
                case "towRight":
                    movObj.moveTowStepRight(s1.array, true, s1);
//                    s1.print(s1);
                    break;
                case "oneLeft":
                    movObj.moveStepLeft(s1.array, true, s1);
//                    s1.print(s1);
                    break;
                case "towLeft":
                    movObj.moveTowStepLeft(s1.array, true, s1);
//                    s1.print(s1);
                    break;

                case "oneUp":
                    movObj.moveStepUp(s1.array, true, s1);
//                    s1.print(s1);
                    break;
                case "towUp":
                    movObj.moveTowStepUp(s1.array, true, s1);
//                    s1.print(s1);
                    break;
                case "oneDown":
                    movObj.moveStepDown(s1.array, true, s1);
//                    s1.print(s1);
                    break;

                case "towDown":
                    movObj.moveTowStepDown(s1.array, true, s1);
//                    s1.print(s1);
                    break;



                default:
                    break;
            }
            next_states.add(s1);
        }
        return next_states;
    }

    public void printNextState(structure str) {
        System.out.println(str.getNextState(str));
    }


public boolean isFinshed(structure s ){
    boolean done = true;

    for(int i=0;i<(s.array.length+1)/2;i++){
        for(int j=0;j<(s.array.length+1)/2;j++){
            if(i == s.array.length/2 && j== s.array.length/2)
                break;
            else{
                if(s.array[i][j] != 'B'){
                    done = false;
                    break;
                }
            }
        }
        if(done == false){
            break;
        }
    }
//
    if(s.array[s.array.length/2][s.array.length/2] != '*')
        done = false;
    for(int i=s.array.length/2;i<s.array.length;i++){
        for(int j=s.array.length/2;j<s.array.length;j++){
            if(i == s.array.length/2 && j== s.array.length/2)
                break;
            else{
                if(s.array[i][j] != 'R'){
                    done = false;
                    break;
                }
            }
        }
        if(done == false){
            break;
        }
    }
    if(done == false)
        return false;
    else
        return true;
}
    public void print(structure board) {
        for(int i = 0; i < n * 2 - 1; ++i) {
            for(int j = 0; j < n * 2 - 1; ++j) {
                if (board.array[i][j] == 'R') {
                    System.out.print("\u001b[31m" + board.array[i][j] + "\u001b[0m" + " ");
                } else if (board.array[i][j] == 'B') {
                    System.out.print("\u001b[34m" + board.array[i][j] + "\u001b[0m" + " ");
                } else if (board.array[i][j] == '*') {
                    System.out.print(board.array[i][j] + " ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }

    }
    public boolean isEqual(ArrayList<structure> list , structure ss){
        for(structure s : list){
            int c = 0;
            for(int i=0;i<ss.array.length;i++){
                for(int j=0;j<ss.array.length;j++){
                    if(ss.array[i][j] == 'R' || ss.array[i][j] == 'B' || ss.array[i][j] == '*'){
                        if(ss.array[i][j] == s.array[i][j])
                            c++;
                    }
                    else
                        c++;
                }
            }
            if(c == (ss.array.length * ss.array.length)){
                return true;
            }
        }
        return  false;
    }
    public boolean equal(structure s1,structure s2){
        int c=0;
        for(int i=0;i<s2.array.length;i++){
            for(int j=0;j<s2.array.length;j++){
                if(s2.array[i][j] == 'R' || s2.array[i][j] == 'B' || s2.array[i][j] == '*'){
                    if(s2.array[i][j] == s1.array[i][j])
                        c++;
                }
                else
                    c++;
            }
        }
        if(c == (s2.array.length * s2.array.length)){
            return true;
        }else{
            return false;
        }
    }
    public boolean equall(ArrayList<structure> arr, structure s){
        int one= Arrays.deepHashCode(s.array);
        for(structure str : arr ){
            int two=Arrays.deepHashCode(str.array);
            if(one==two)
                return true;
        }
        return false;
    }
}

