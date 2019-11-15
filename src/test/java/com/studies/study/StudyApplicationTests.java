package com.studies.study;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.studies.study.arithmetic.sort.ISort;

@SpringBootTest
class StudyApplicationTests {
    @Autowired
    private ISort sort;

    @Test
    void contextLoads() {
        int[] sortedNums = new int[]{5, 2, 4, 3, 1, 9, 5, 4, 7};
        sort.bubbleSort(Arrays.copyOf(sortedNums,sortedNums.length));
        sort.selectionSort(Arrays.copyOf(sortedNums,sortedNums.length));
    }

}
