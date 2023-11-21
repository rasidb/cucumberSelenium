package com.junitTests.topics;

import org.junit.Test;

import java.util.*;

public class Tryn {
    @Test
    public void test1(){
        int[] arr= new int[]{5,6,8,5,5,6};
       Set<Integer> result=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
           result.add(arr[i]);
        }
        System.out.println(result);
    }
}
