Chocolate Box Distribution (Minimal Maxima)
=======================================
You have 'n' (n <= 10^5) boxes of chocolate. Each bow contains a[i] (a[i] <= 1000) chocolates.You need to distribute these boxed among 'm' students such that the maximum number of chocolates allocated to a student is minimum.
1. One box will be allocated to exactly one student.
2. All the boxes should be allocated.
3. Each student has to be allocated at least one box.
4. Allotment should be in contiguous order, for instance, a student cannot be allocated box 1 and 3, skipping 2.

**Input: `Boxes = [12, 34, 67, 90]` <br>
Output: `113`**

### Solution
To solve this problem, we can use the binary search algorithm to find the minimum possible maximum chocolates that can be allocated to a student.

First, we need to define the range of values for the binary search. The minimum possible value would be the maximum number of chocolates in a single box (since each student has to be allocated at least one box, we need to allocate boxes with the maximum number of chocolates first). The maximum possible value would be the sum of all the chocolates in all the boxes (since we need to allocate all the boxes).

For each mid value during the binary search, we can check if it is possible to allocate the boxes such that the maximum number of chocolates allocated to a student is less than or equal to the mid value. To do this, we can iterate through the boxes and allocate them to students one by one, keeping track of the current student's allocated chocolates. If the current student's allocated chocolates exceed the mid value, we cannot allocate any more boxes to that student, so we move on to the next student. If we reach the end of the boxes and all students have been allocated boxes, then the allocation is possible with the current mid value.

If the allocation is possible with the mid value, we can try a smaller mid value (search the left half of the range). If the allocation is not possible with the mid value, we need to try a larger mid value (search the right half of the range).

Once the binary search is complete, we will have found the minimum possible maximum chocolates that can be allocated to a student.

### Solution Code
```java
public static boolean isDivisionPossible(int[] boxes, int m, int mid) {
    int students = 1; // start with one student
    int allocatedChocolates = 0;
    for (int box : boxes) {
        if (box > mid) {
            // we cannot allocate a box with more chocolates than the mid value
            return false;
        }
        if (allocatedChocolates + box > mid) {
            // allocate this box to the next student
            students++;
            allocatedChocolates = box;
            if (students > m) {
                // we have exceeded the maximum number of students
                return false;
            }
        } else {
            // allocate this box to the current student
            allocatedChocolates += box;
        }
    }
    return true;
}

public static int minMaxChocolates(int[] boxes, int students) {
    int low = 1; // minimum possible value
    int high = 0; // maximum possible value
    for (int box : boxes) {
        high += box; // sum of all chocolates in all boxes
    }
    int result = high;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (isDivisionPossible(boxes, students, mid)) {
            // allocation is possible with this mid value, try a smaller mid value
            result = mid;
            high = mid - 1;
        } else {
            // allocation is not possible with this mid value, try a larger mid value
            low = mid + 1;
        }
    }
    return result;
}
```

Race Track (Maximal Minima)
=======================================
A new racing track for kids is being built in New York with 'n' starting spots. The spots are located along a straight line at position x1, x2,... xn(xi <= 10^9). For each 'i', xi+1 > xi.
At a time only 'm' children are allowed to enter the race. Since the race track is for kids, they may run into each other while running. To prevent this, we want to choose the starting spots such that the minimum distance between any two of then is as large as possible. What is the largest minimum distance?

**Input: `n = [1, 2, 4, 8, 9]` <br>
Output: `3`**

### Solution
First, we need to define the range of values for the binary search. The minimum possible value would be 1 (since the spots are located along a straight line, the minimum distance between any two spots is 1). The maximum possible value would be the distance between the first and last spots (since we want to maximize the minimum distance between any two spots).

For each mid value during the binary search, we can check if it is possible to choose the starting spots such that the minimum distance between any two spots is greater than or equal to the mid value. To do this, we can iterate through the spots and check if the distance between the current spot and the last chosen spot is greater than or equal to the mid value. If it is, we can choose the current spot as the next starting spot. If we reach the end of the spots and have chosen at least 'm' starting spots, then the choice is possible with the current mid value.

If the choice is possible with the mid value, we can try a larger mid value (search the right half of the range). If the choice is not possible with the mid value, we need to try a smaller mid value (search the left half of the range).

Once the binary search is complete, we will have found the largest possible minimum distance between any two starting spots.

### Solution Code
```java
public static boolean isDivisionPossible(int[] spots, int m, int mid) {
    int lastSpot = spots[0];
    int chosenSpots = 1; // start with one spot
    for (int i = 1; i < spots.length; i++) {
        if (spots[i] - lastSpot >= mid) {
            // choose this spot as the next starting spot
            lastSpot = spots[i];
            chosenSpots++;
            if (chosenSpots == m) {
                // we have chosen enough starting spots
                return true;
            }
        }
    }
    return false;
}

public static int maxMinDistance(int[] spots, int m) {
    int low = 1; // minimum possible value
    int high = spots[spots.length - 1] - spots[0]; // maximum possible value
    int result = 0;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (isDivisionPossible(spots, m, mid)) {
            // choice is possible with this mid value, try a larger mid value
            result = mid;
            low = mid + 1;
        } else {
            // choice is not possible with this mid value, try a smaller mid value
            high = mid - 1;
        }
    }
    return result;
}
```























