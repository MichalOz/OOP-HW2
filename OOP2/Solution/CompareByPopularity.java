package OOP2.Solution;

import OOP2.Provided.Status;

import java.util.Comparator;

public class CompareByPopularity implements Comparator<Status> {
    public CompareByPopularity() {}
    @Override
    public int compare(Status s1, Status s2){
        if (s1.getLikesCount() == s2.getLikesCount())
            return 0;
        if (s1.getLikesCount() < s2.getLikesCount())
            return -1;
        return 1;
    }
}
