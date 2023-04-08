Count Sort
=======================================
Count sort is a sorting algorithm that works by determining the frequency of each distinct element in the input array, and using that information to sort the array. It creates a count array to store the frequency of each element, then calculates the cumulative frequency of each element in the count array. Finally, it uses the cumulative frequency to place each element in the correct position in the output array.

Count Sort is called so because it sorts the elements of an array by counting their occurrences, making it an efficient sorting algorithm for datasets with a limited range of values.

### How it Works
The count sort algorithm works by iterating over the input array and counting the number of occurrences of each element. It then uses this count to construct a sorted array by placing each element in its correct position in the sorted array.

Here is the code for count sort in Java:

```java
static void countSort(int[] arr) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[findMax(arr) + 1];

    for (int i = 0; i < n; i++) {
        count[arr[i]]++;
    }

    for (int i = 1; i <= findMax(arr); i++) {
        count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
        output[count[arr[i]] - 1] = arr[i];
        count[arr[i]]--;
    }

    for (int i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}

static int findMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int value : arr) {
        if (value > max) {
            max = value;
        }
    }
    return max;
}
```
### Example
Let's take an example array [4, 1, 3, 2, 7, 5] and see how Quick Sort works on it:

| Step | arr                | output        | count                 | i | arr[i] | count[arr[i]] | count[i]+count[i-1] | output                      | Explanation                                                          |
|------|--------------------|---------------|-----------------------|---|--------|---------------|---------------------|-----------------------------|----------------------------------------------------------------------|
 | 0    | [4, 1, 3, 2, 7, 5] | []            | [0, 0, 0, 0, 0, 0, 0] |   |        |               |                     |                             | Initialize array, output, and count                                  |
 | 1    | [4, 1, 3, 2, 7, 5] | []            | [0, 1, 0, 0, 1, 1, 1] |   |        |               |                     |                             | Count occurrences of each element                                    |
 | 2    | [4, 1, 3, 2, 7, 5] | []            | [0, 1, 1, 1, 2, 3, 4] |   |        |               |                     |                             | Calculate cumulative count                                           |
 | 3    | [4, 1, 3, 2, 7, 5] | [ , , , , , ] | [0, 1, 1, 1, 2, 3, 4] |   |        |               |                     |                             | Initialize output                                                    |
 | 4    | [4, 1, 3, 2, 7, 5] | [ , , , , ,4] | [0, 1, 1, 1, 2, 3, 3] | 5 | 5      | 1 + 0         | [ , , , ,3,4]       | Place 5 in correct position |
 | 5    | [4, 1, 3, 2, 7, 5] | [ , , , ,3,4] | [0, 1, 1, 2, 2, 3, 3] | 4 | 7      | 1 + 2         | [ , , ,2,3,4]       | Place 7 in correct position |
 | 6    | [4, 1, 3, 2, 7, 5] | [ , , ,2,3,4] | [0, 1, 2, 2, 2, 3, 3] | 3 | 2      | 1 + 1         | [ , ,1,2,3,4]       | Place 2 in correct position |
 | 7    | [4, 1, 3, 2, 7, 5] | [ , ,1,2,3,4] | [0, 1, 2, 2, 2, 3, 3] | 2 | 3      | 2 + 1         | [ ,1,1,2,3,4]       | Place 3 in correct position |
 | 8    | [4, 1, 3, 2, 7, 5] | [ ,1,1,2,3,4] | [0, 1, 2, 2, 2, 3, 3] | 1 | 1      | 1 + 0         | [1,1,1,2,3,4]       | Place 1 in correct position |
 | 9    | [4, 1, 3, 2, 7, 5] | [1,1,1,2,3,4] | [0, 1, 2, 2, 2, 3, 3] | 0 | 4      | 2 + 0         | [1,1,1,2,3,4]       | Place 4 in correct position |
 | 10   | [4, 1, 3, 2, 7, 5] | [1,1,1,2,3,4] | [0, 1, 2, 2, 2, 3, 3] |   |        |               | [ ,1,1,2,3,4]       |                             | All elements have been placed in correct positions, sorting complete |

The algorithm is now finished, and the array is sorted.

### Time & Space Complexity
The time complexity of Count Sort is O(n+k), where n is the number of elements in the array and k is the range of the input.

The space complexity of Count Sort is O(n+k), which is the size of the output array.

### Stability
Count Sort is a stable sorting algorithm, as the relative order of equal elements remains unchanged during the sorting process.

### Uses
Count Sort is useful when the range of the input elements is small compared to the number of elements in the array. It is often used as a subroutine in other sorting algorithms such as radix sort. Count Sort can also be used to sort non-comparative data such as strings, and it is efficient for sorting integers and floating-point numbers. However, Count Sort requires extra space for the output array, which can be a limitation in some applications.



Redix Sort
=======================================
Radix sort is a sorting algorithm that works on integers by sorting them digit by digit. It can be considered a generalization of counting sort.

Radix Sort is called so because it sorts the elements of an array based on their radix or base, which is the number of distinct symbols or digits used to represent numbers in that base. The algorithm uses a stable sort mechanism to sort elements at each digit position, leading to an overall efficient sorting algorithm for datasets with a limited range of values.

### How it Works
Radix sort sorts an array of integers by first grouping the digits of the same place value. Then, it sorts the elements based on the value of their digits, starting from the least significant digit to the most significant digit. This process is repeated for each digit until the whole array is sorted.

Here is the code for radix sort in Java:

```java
static int findMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int value : arr) {
        if (value > max) {
            max = value;
        }
    }
    return max;
}

static void countSort(int[] arr, int place) {
    // Find the maximum element in the array
    int max = findMax(arr);
    // Frequency array
    int[] count = new int[10];
    for (int i : arr) {
        count[(i / place) % 10]++; // increment the count of the digit at the given place
    }
    // Prefix sum
    for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1]; // calculate the cumulative count of the digits
    }
    int[] out = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
        int idx = count[(arr[i] / place) % 10] - 1; // calculate the index of the element in the output array
        out[idx] = arr[i]; // place the element in the output array
        count[(arr[i] / place) % 10]--; // decrement the count of the digit at the given place
    }
    // copy the sorted array from the output array to the input array
    System.arraycopy(out, 0, arr, 0, arr.length);
}

static void radixSort(int[] arr) {
    int max = findMax(arr); // find the maximum element in the array
    for (int place = 1; max / place > 0; place *= 10) { // loop through each digit place
        countSort(arr, place); // sort the array by the digit at the current place
    }
}
```
### Example
Let's take an example array [4, 1, 3, 2, 7, 5] and see how Quick Sort works on it:

| Step | `arr`                | `place` | `max` | `count`                          | `out`                |
|------|----------------------|---------|-------|----------------------------------|----------------------|
|      | `[4, 1, 3, 2, 7, 5]` |         | 7     | `[0, 0, 0...]`                   | `[0, 0, 0...]`       |
| 1    | `[4, 1, 3, 2, 7, 5]` | 1       | 7     | `[0, 1, 1, 1, 1, 0, 0, 0, 0, 0]` | `[0, 0, 0, 0, 0, 0]` |
| 2    | `[1, 2, 3, 4, 5, 7]` | 10      | 7     | `[0, 1, 1, 2, 1, 1, 1, 0, 0, 0]` | `[0, 0, 0, 0, 0, 0]` |
| 3    | `[1, 2, 3, 4, 5, 7]` | 100     | 7     | `[1, 1, 1, 1, 1, 0, 0, 0, 0, 0]` | `[0, 0, 0, 0, 0, 0]` |
| 4    | `[1, 2, 3, 4, 5, 7]` | 1000    | 7     | `[1, 1, 1, 1, 1, 0, 0, 0, 0, 0]` | `[0, 0, 0, 0, 0, 0]` |

The algorithm is now finished, and the array is sorted.

### Time & Space Complexity
The time complexity of Radix Sort is O(d*(n+k)), where n is the number of elements in the array, k is the maximum value of elements, and d is the number of digits in the maximum value.

The space complexity of Radix Sort is O(n+k), which is the size of the output array.

### Stability
Radix Sort can be stable or unstable, depending on the implementation. If a stable sorting algorithm is used as a subroutine in the radix sort, then the overall sorting algorithm is also stable.

### Uses
Radix Sort is useful when the range of the input elements is large compared to the number of elements in the array. It is efficient for sorting integers and floating-point numbers. Radix Sort can also be used to sort non-comparative data such as strings. However, Radix Sort requires extra space for the output array, which can be a limitation in some applications. Radix Sort is often used as a subroutine in other sorting algorithms such as bucket sort.




Bucket Sort
=======================================
Bucket sort is a sorting algorithm that divides an array into a finite number of buckets or subarrays, then sorts each bucket individually using another sorting algorithm or recursively applying the bucket sort algorithm.

Bucket sort is called so because it sorts elements by distributing them into buckets based on their values, similar to how one would distribute objects into physical buckets based on their characteristics.

### How it Works
The bucket sort algorithm divides the input array into a set of buckets based on the values of the elements. Each bucket contains a range of values that fall within a specific range. Then, the elements in each bucket are sorted using another sorting algorithm or recursively applying the bucket sort algorithm. Finally, the sorted elements from all buckets are merged back into the original array.

Here is the code for radix sort in Java:

```java
public static void bucketSort(int[] arr) {
    // Buckets
    ArrayList<Integer>[] buckets = new ArrayList[10];

    // Initialize empty buckets
    for (int i = 0; i < buckets.length; i++) {
        buckets[i] = new ArrayList<Integer>();
    }

    // Add elements to buckets
    for (int elem : arr) {
        int digit = (elem / 10) % 10;
        buckets[digit].add(elem);
    }

    // Sort buckets
    for (ArrayList<Integer> bucket : buckets) {
        Collections.sort(bucket);
    }

    // Copy buckets to original array
    int index = 0;
    for (ArrayList<Integer> bucket : buckets) {
        for (int elem : bucket) {
            arr[index++] = elem;
        }
    }
}
```
### Example
Let's take an example array [25, 10, 35, 5, 30, 15, 20, 40, 5, 10, 56, 30, 25] and see how Bucket Sort works on it:

| Step       | buckets                                                                    |
|------------|----------------------------------------------------------------------------|
| Initialize | {}, {}, {}, {}, {}, {}, {}, {}, {}, {}                                     |
| Add elems  | {5, 5}, {10, 10}, {20}, {15}, {25, 25}, {35}, {30, 30}, {}, {40}, {56}     |
| Sort       | {5, 5}, {10, 10}, {15, 20, 25, 25}, {30, 30}, {35}, {40}, {56}, {}, {}, {} |
| Copy       | {5, 5, 10, 10, 15, 20, 25, 25, 30, 30, 35, 40, 56}                         |

The algorithm is now finished, and the array is sorted.

### Time & Space Complexity
The time complexity of Bucket Sort is O(n + k), where n is the number of elements in the input array and k is the number of buckets used.

The space complexity of Bucket Sort is O(n + k), where n is the number of elements in the input array and k is the number of buckets used.

### Stability
Bucket Sort can be made stable if the sorting algorithm used to sort the individual buckets is stable.

### Uses
Bucket Sort is useful when the input is uniformly distributed over a range. It is often used as a subroutine in radix sort. Bucket Sort can also be used to sort strings and floating-point numbers by first converting them to integers. However, it may not be suitable for sorting large datasets with a small range of values.