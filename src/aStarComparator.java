import java.util.Comparator;

public class aStarComparator implements Comparator<structure> {

    @Override
    public int compare(structure s1, structure s2) {
        if(s1.cost+s1.h > s2.cost+s2.h){
            return 1;
        }else if(s1.cost+s1.h < s2.cost+s2.h){
            return -1;
        }
        else if(s1.h>s2.h){
            return 1;
        }else if(s1.h<s2.h){
            return -1;
        }
            return 0;
    }
}
