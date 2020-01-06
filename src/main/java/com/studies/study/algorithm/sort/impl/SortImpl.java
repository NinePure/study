package com.studies.study.algorithm.sort.impl;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.studies.study.algorithm.sort.ISort;

/**
 * detail
 *
 * @Author gujiashun
 * @date 2019/11/15
 */
@Component
public class SortImpl implements ISort {

    /**
     * 1、冒泡排序 - 依次比较相邻两元素，若前一元素大于后一元素则交换之，直至最后一个元素即为最大；然后重新从首元素开始重复同样的操作，直至倒数第二个元素即为次大元素；依次类推。如同水中的气泡，依次将最大或最小元素气泡浮出水面。
     * <p>
     * 时间复杂度：O(N2) 　　稳定性：稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] bubbleSort(int[] sortedNums) {
        for (int i = 0; i < sortedNums.length - 1; i++) {
            for (int j = 1; j < sortedNums.length - i; j++) {
                if (sortedNums[j - 1] > sortedNums[j]) {
                    changeNum(sortedNums, j, j - 1);
                }
            }
        }
        return sortedNums;
    }

    private void changeNum(int[] sortedNums, int i,int j) {
        int item = sortedNums[j];
        sortedNums[j] = sortedNums[i];
        sortedNums[i] = item;
    }

    /**
     * 2、选择排序 - 首先初始化最小元素索引值为首元素，依次遍历待排序数列，若遇到小于该最小索引位置处的元素则刷新最小索引为该较小元素的位置，直至遇到尾元素，结束一次遍历，并将最小索引处元素与首元素交换；然后，初始化最小索引值为第二个待排序数列元素位置，同样的操作，可得到数列第二个元素即为次小元素；以此类推。
     * <p>
     * 时间复杂度：O(N2) 　　稳定性：不稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] selectionSort(int[] sortedNums) {
        for (int i = 0; i < sortedNums.length; i++) {
            int index = i;
            for (int j = i + 1; j < sortedNums.length; j++) {
                if (sortedNums[j] < sortedNums[index]) {
                    index = j;
                }
            }
            changeNum(sortedNums, i, index);
        }
        return sortedNums;
    }

    /**
     * 3、快速排序 - （类似于选择排序的定位思想）选一基准元素，依次将剩余元素中小于该基准元素的值放置其左侧，大于等于该基准元素的值放置其右侧；然后，取基准元素的前半部分和后半部分分别进行同样的处理；以此类推，直至各子序列剩余一个元素时，即排序完成（类比二叉树的思想，from up to down）
     * <p>
     * 时间复杂度：O(NlogN) 　　稳定性：不稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] quickSort(int[] sortedNums) {
        quickSortRecursive(sortedNums, 0, sortedNums.length - 1);
        return sortedNums;
    }

    /**
     * 快速排序递归方法
     *
     * @param sortedNums
     * @param begin
     * @param end
     */
    private void quickSortRecursive(int[] sortedNums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int left = begin;
        int right = end;
        int item = sortedNums[left];
        while (left < right) {
            while (left < right) {
                if (sortedNums[right] < item) {
                    sortedNums[left++] = sortedNums[right];
                    break;
                }
                right--;
            }
            while (left < right) {
                if (sortedNums[left] >= item) {
                    sortedNums[right--] = sortedNums[left];
                    break;
                }
                left++;
            }
        }
        sortedNums[left] = item;
        quickSortRecursive(sortedNums, begin, left);
        quickSortRecursive(sortedNums, left + 1, end);
    }

    /**
     * 4、插入排序 - 数列前面部分看为有序，依次将后面的无序数列元素插入到前面的有序数列中，初始状态有序数列仅有一个元素，即首元素。在将无序数列元素插入有序数列的过程中，采用了逆序遍历有序数列，相较于顺序遍历会稍显繁琐，但当数列本身已近排序状态效率会更高。
     * <p>
     * 时间复杂度：O(N2) 　　稳定性：稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] insertionSort(int[] sortedNums) {
        int mid = 0;
        while (mid < sortedNums.length - 1) {
            int item = sortedNums[mid + 1];
            for (int i = mid; i >= 0; i--) {
                if (item >= sortedNums[i]) {
                    sortedNums[i + 1] = item;
                    break;
                } else {
                    sortedNums[i + 1] = sortedNums[i];
                }
                if (i == 0) {
                    sortedNums[0] = item;
                }
            }
            mid++;
        }
        return sortedNums;
    }


    /**
     * 5、希尔排序 - 插入排序的改进版。为了减少数据的移动次数，在初始序列较大时取较大的步长，通常取序列长度的一半，此时只有两个元素比较，交换一次；之后步长依次减半直至步长为1，即为插入排序，由于此时序列已接近有序，故插入元素时数据移动的次数会相对较少，效率得到了提高。
     * <p>
     * 时间复杂度：通常认为是O(N3/2) ，未验证　　稳定性：不稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] shellSort(int[] sortedNums) {
        for (int step = sortedNums.length  / 2; step > 0; step /= 2)
        {
            for (int i = 0; i < step; i++)
            {
                for (int j = i + step; j < sortedNums.length; j += step)
                {
                    int k = j - step;
                    for ( ; k >= i; k -= step) {
                        if (sortedNums[k] <= sortedNums[j]) {
                            break;
                        }
                    }
                    if (k != j - step)
                    {
                        int tmp = sortedNums[j];
                        for (int m = j; m > k + step; m -= step) {
                            sortedNums[m] = sortedNums[m - step];
                        }
                        sortedNums[k + step] = tmp;
                    }
                }
            }
        }
        return sortedNums;
    }

    /**
     * 6、桶排序 - 实现线性排序，但当元素间值得大小有较大差距时会带来内存空间的较大浪费。首先，找出待排序列中得最大元素max，申请内存大小为max + 1的桶（数组）并初始化为0；然后，遍历排序数列，并依次将每个元素作为下标的桶元素值自增1；最后，遍历桶元素，并依次将值非0的元素下标值载入排序数列（桶元素>1表明有值大小相等的元素，此时依次将他们载入排序数列），遍历完成，排序数列便为有序数列。
     * <p>
     * 时间复杂度：O(x*N) 　　稳定性：稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] bucketSort(int[] sortedNums) {
        int max = getMaxValue(sortedNums);
        int[] indexes = new int[max + 1];
        for (int sortedNum : sortedNums) {
            indexes[sortedNum]++;
        }
        int sortIndex = 0;
        for (int i = 0; i < indexes.length; i++) {
            for (int j = 1; j <= indexes[i]; j++) {
                sortedNums[sortIndex++] = i;
            }
        }
        return sortedNums;
    }

    private int getMaxValue(int[] sortedNums) {
        int max = 0;
        for (int sortedNum : sortedNums) {
            max = sortedNum > max ? sortedNum : max;
        }
        return max;
    }

    /**
     * 7、基数排序 - 桶排序的改进版，桶的大小固定为10，减少了内存空间的开销。首先，找出待排序列中得最大元素max，并依次按max的低位到高位对所有元素排序；桶元素10个元素的大小即为待排序数列元素对应数值为相等元素的个数，即每次遍历待排序数列，桶将其按对应数值位大小分为了10个层级，桶内元素值得和为待排序数列元素个数。
     * <p>
     * 时间复杂度：O(x*N) 　　稳定性：稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] radixSort(int[] sortedNums) {
        int maxDigit = getMaxDigit(sortedNums);
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            int[][] counter = new int[mod * 2][0];
            for (int j = 0; j < sortedNums.length; j++) {
                //正数为10-19，负数为0-9
                int bucket = ((sortedNums[j] % mod) / dev) + mod;
                counter[bucket] = Arrays.copyOf(counter[bucket], counter[bucket].length + 1);
                counter[bucket][counter[bucket].length - 1] = sortedNums[j];
            }
            int index = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    sortedNums[index++] = value;
                }
            }
        }
        return sortedNums;
    }

    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        if (maxValue == 0) {
            return 1;
        }
        int maxDigit = 0;
        for (int i = maxValue; i != 0; i /= 10) {
            maxDigit++;
        }
        return maxDigit;
    }

    /**
     * 8、归并排序 - 采用了分治和递归的思想，递归&分治-排序整个数列如同排序两个有序数列，依次执行这个过程直至排序末端的两个元素，再依次向上层输送排序好的两个子列进行排序直至整个数列有序（类比二叉树的思想，from down to up）。
     * <p>
     * 时间复杂度：O(NlogN) 　　稳定性：稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] mergeSort(int[] sortedNums) {
        return null;
    }

    /**
     * 9、堆排序 - 堆排序的思想借助于二叉堆中的最大堆得以实现。首先，将待排序数列抽象为二叉树，并构造出最大堆；然后，依次将最大元素（即根节点元素）与待排序数列的最后一个元素交换（即二叉树最深层最右边的叶子结点元素）；每次遍历，刷新最后一个元素的位置（自减1），直至其与首元素相交，即完成排序。
     * <p>
     * 时间复杂度：O(NlogN) 　　稳定性：不稳定
     *
     * @param sortedNums
     */
    @Override
    public int[] heapSort(int[] sortedNums) {
        return null;
    }
}
