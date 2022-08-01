

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortArray(int* nums, int numsSize, int* returnSize){
    *returnSize = numsSize;
    mergeSort(nums, 0, numsSize - 1);
    //printf("%d\n", *(returnSize + 1));
    return nums;
}

void mergeSort(int *nums, int start, int end) {
    if (start >= end) {
        return;
    }
    int mid = (end + start) / 2;
    mergeSort(nums, start, mid);
    mergeSort(nums, mid + 1, end);
    merge(nums, start, mid, end);
    
}

void merge(int* nums, int start, int mid, int end) {
    int length = (end - start + 1);
    int* temp = malloc(length * sizeof(int));
    int index = 0;
    int i1 = start;
    int i2 = mid + 1;
    while (index < length) {
        if (i1 > mid) {
            while (i2 <= end) {
                *(temp + index) = *(nums + i2);
                i2++;
                index++;
            }
        } else if (i2 > end) {
            while (i1 <= mid) {
                *(temp + index) = *(nums + i1);
                i1++;
                index++;
            }
        } else {
            int num1 = *(nums + i1);
            int num2 = *(nums + i2);
            if (num1 < num2) {
                *(temp + index) = num1;
                i1++;
            } else {
                *(temp + index) = num2;
                i2++;
            }
            index++;
        }
        
    }
    
    for (int i = start; i <= end; i++) {
        *(nums + i) = *(temp + (i - start));
    }
    free(temp);
}
