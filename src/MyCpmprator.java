import java.util.Comparator;

public class MyCpmprator implements Comparator<structure> {
    @Override
    public int compare(structure str1, structure str2) {
        if(str1.cost>str2.cost)
            return 1;
        else if (str1.cost<str2.cost) {
            return -1;
        }
        return 0;
    }
}
