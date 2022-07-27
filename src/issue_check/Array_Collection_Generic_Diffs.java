package issue_check;

import java.util.Arrays;

public class Array_Collection_Generic_Diffs {

    public static void main(String[] args) {

        Integer[] ia = new Integer[10];
        Number[] na = ia;
        na[0] = 1.4; // java.lang.ArrayStoreException

        System.out.println(Arrays.stream(na).toArray());

    }
}
