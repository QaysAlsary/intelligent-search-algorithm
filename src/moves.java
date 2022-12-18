public class moves {
    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_RESET = "\u001b[0m";

    public moves() {
    }

    public void swap(char[][] arr, int i, int j, int ni, int nj) {
        char temp = arr[i][j];
        arr[i][j] = arr[ni][nj];
        arr[ni][nj] = temp;
    }


    public boolean moveStepUp(char [][]array, boolean swap , structure s){
        if(s.initI-1 >= 0 && s.initJ<(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI-1][s.initJ];
                array[s.initI-1][s.initJ] = temp;
                s.initI--;
            }
            return true;
        }
        else if(s.initI-1 >= (array.length)/2 && s.initJ>(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI-1][s.initJ];
                array[s.initI-1][s.initJ] = temp;
                s.initI--;
            }
            return true;
        }
        else if(s.initI-1 >= 0 && s.initJ==(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI-1][s.initJ];
                array[s.initI-1][s.initJ] = temp;
                s.initI--;
            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean moveTowStepUp(char [][]array , boolean swap , structure s){
        if(s.initI-2 >= 0 && s.initJ<(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI-2][s.initJ];
                array[s.initI-2][s.initJ] = temp;
                s.initI-=2;
            }
            return true;
        }
        else if(s.initI-2 >= (array.length)/2 && s.initJ>(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI-2][s.initJ];
                array[s.initI-2][s.initJ] = temp;
                s.initI-=2;
            }
            return true;
        }
        else if(s.initI-2 >= 0 && s.initJ==(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI-2][s.initJ];
                array[s.initI-2][s.initJ] = temp;
                s.initI-=2;
            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean moveStepDown(char [][]array  , boolean swap ,structure s){
        if(s.initI+1 < (array.length+1)/2 && s.initJ<(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI+1][s.initJ];
                array[s.initI+1][s.initJ] = temp;
                s.initI++;
            }
            return true;
        }
        else if(s.initI+1 < array.length && s.initJ>(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI+1][s.initJ];
                array[s.initI+1][s.initJ] = temp;
                s.initI++;
            }
            return true;
        }
        else if(s.initI+1 < array.length && s.initJ==(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI+1][s.initJ];
                array[s.initI+1][s.initJ] = temp;
                s.initI++;
            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean moveTowStepDown(char [][]array , boolean swap , structure s){
        if(s.initI+2 < (array.length+1)/2 && s.initJ<(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI+2][s.initJ];
                array[s.initI+2][s.initJ] = temp;
                s.initI+=2;
            }
            return true;
        }
        else if(s.initI+2 < array.length && s.initJ>(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI+2][s.initJ];
                array[s.initI+2][s.initJ] = temp;
                s.initI+=2;
            }
            return true;
        }
        else if(s.initI+2 < array.length && s.initJ==(array.length)/2){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI+2][s.initJ];
                array[s.initI+2][s.initJ] = temp;
                s.initI+=2;
            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean moveStepRight(char [][]array , boolean swap ,structure s){
        if(s.initJ+1 < (array.length+1)/2 && s.initI < (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ+1];
                array[s.initI][s.initJ+1] = temp;
                s.initJ++;
            }
            return true;
        }
        else if(s.initJ+1 < array.length && s.initI > (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ+1];
                array[s.initI][s.initJ+1] = temp;
                s.initJ++;
            }
            return true;
        }
        else if(s.initJ+1 < array.length && s.initI == (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ+1];
                array[s.initI][s.initJ+1] = temp;
                s.initJ++;
            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean moveTowStepRight(char [][]array ,  boolean swap , structure s){
        if(s.initJ+2 < (array.length+1)/2 && s.initI < (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ+2];
                array[s.initI][s.initJ+2] = temp;
                s.initJ+=2;
            }
            return true;
        }
        else if(s.initJ+2 < array.length && s.initI > (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ+2];
                array[s.initI][s.initJ+2] = temp;
                s.initJ+=2;
            }
            return true;
        }
        else if(s.initJ+2 < array.length && s.initI == (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ+2];
                array[s.initI][s.initJ+2] = temp;
                s.initJ+=2;
            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean moveStepLeft(char [][]array , boolean swap , structure s){
        if(s.initJ-1 >= 0 && s.initI < (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ-1];
                array[s.initI][s.initJ-1] = temp;
                s.initJ--;
            }
            return true;
        }
        else if(s.initJ-1 >= (array.length)/2 && s.initI > (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ-1];
                array[s.initI][s.initJ-1] = temp;
                s.initJ--;
            }
            return true;
        }
        else if(s.initJ-1 >= 0 && s.initI == (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ-1];
                array[s.initI][s.initJ-1] = temp;
                s.initJ--;
            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean moveTowStepLeft(char [][]array ,  boolean swap , structure s){
        if(s.initJ-2 >= 0 && s.initI < (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ-2];
                array[s.initI][s.initJ-2] = temp;
                s.initJ-=2;
            }
            return true;
        }
        else if(s.initJ-2 >= (array.length)/2 && s.initI > (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ-2];
                array[s.initI][s.initJ-2] = temp;
                s.initJ-=2;
            }
            return true;
        }
        else if(s.initJ-2 >= 0 && s.initI == (array.length)/2 ){
            if(swap == true){
                char temp = array[s.initI][s.initJ];
                array[s.initI][s.initJ] = array[s.initI][s.initJ-2];
                array[s.initI][s.initJ-2] = temp;
                s.initJ-=2;
            }
            return true;
        }
        else{
            return false;
        }
    }


}

