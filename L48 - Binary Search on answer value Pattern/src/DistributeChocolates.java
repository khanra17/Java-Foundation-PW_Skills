public class DistributeChocolates {

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


    public static void main(String[] args) {
        int[] boxes = {12, 34, 67, 90};
        int students = 2;
        int result = minMaxChocolates(boxes, students);
        System.out.println(result);
    }
}
