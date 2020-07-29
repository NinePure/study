package com.studies.study;

import com.studies.study.robot.MouseFrame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import com.studies.study.algorithm.sort.ISort;

@SpringBootTest
class StudyApplicationTests {
    @Autowired
    private ISort sort;

    @Test
    void contextLoads() {

    }

    @Test
    void algorithm() {
        int n = 100;
        int[] arr = this.generateRandomArray(n, 0, n);
        System.out.println(Arrays.toString(arr));

    }

    @Test
    void sortTest() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numList.add(new Random().nextInt(100000));
        }
//        List<Integer> numList = Arrays.asList(5, 2, 3, 1, 4, 5, 2, 7, 9,2);
        int[] nums = numList.stream().mapToInt(Integer::valueOf).toArray();
//        System.out.println(numList);
        sort.shellSort(Arrays.copyOf(nums, nums.length));
        sort.bucketSort(Arrays.copyOf(nums, nums.length));
        sort.bubbleSort(Arrays.copyOf(nums,nums.length));
        sort.selectionSort(Arrays.copyOf(nums,nums.length));
        sort.quickSort(Arrays.copyOf(nums, nums.length));
        sort.insertionSort(Arrays.copyOf(nums, nums.length));
    }

    /**
     *
     * @param n 元素数量
     * @param rangeL 元素范围左
     * @param rangeR 元素范围右
     * @return
     */
    private int[] generateRandomArray(int n ,int rangeL,int rangeR) {
        if (rangeL >= rangeR) {
            System.out.println("元素范围不正确");
            return null;
        }
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangeR - rangeL) + rangeL;
        }
        return arr;
    }



}
