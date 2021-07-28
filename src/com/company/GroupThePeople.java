package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class GroupThePeople {
    int groupLimit = 0;
    List<Integer> group;

    static public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> retList = new ArrayList<>();
        Hashtable<Integer,GroupThePeople> arrGroup = new Hashtable<>();
        GroupThePeople groupObj;

        for(int i=0; i<groupSizes.length;i++){
            if(arrGroup.get(groupSizes[i]) != null && arrGroup.get(groupSizes[i]).group !=null){
                arrGroup.get(groupSizes[i]).group.add(i);
                arrGroup.get(groupSizes[i]).groupLimit = arrGroup.get(groupSizes[i]).groupLimit-1;
                //System.out.println("groupLimit: "+arrGroup.get(groupSizes[i]).groupLimit);
                //System.out.println("size: "+arrGroup.get(groupSizes[i]).group.size());
                if(arrGroup.get(groupSizes[i]).groupLimit == 0){
                   //System.out.println("Second i: "+i);
                    retList.add(arrGroup.get(groupSizes[i]).group);
                    arrGroup.put(groupSizes[i],new GroupThePeople());
                }
            }else{
                groupObj = new GroupThePeople();
                groupObj.groupLimit = groupSizes[i]-1;
                groupObj.group = new ArrayList<>();
                groupObj.group.add(i);
                arrGroup.put(groupSizes[i],groupObj);

                if(arrGroup.get(groupSizes[i]).groupLimit == 0){
                    //System.out.println("Second i: "+i);
                    retList.add(arrGroup.get(groupSizes[i]).group);
                    arrGroup.put(groupSizes[i],new GroupThePeople());
                }
            }
        }
        return retList;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {3,3,3,3,3,1,3};
        List<List<Integer>> list = groupThePeople(arr);
        for(int i=0; i<list.size();i++){
            for(int j=0; j<list.get(i).size();j++){
                System.out.println(list.get(i).get(j));
            }
            System.out.println("");
        }
    }
}
