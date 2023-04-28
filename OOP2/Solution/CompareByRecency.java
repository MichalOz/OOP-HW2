package OOP2.Solution;

import OOP2.Provided.Status;

import java.util.Comparator;

public class CompareByRecency implements Comparator<Status> {
    public CompareByRecency(){}
    @Override
    public int compare(Status s1, Status s2){
        if (s1.getId() == s2.getId())
            return 0;
        if (s1.getId() < s2.getId())
            return -1;
        return 1;
    }
}
