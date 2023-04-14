public class RaceTrack {
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


    public static void main(String[] args) {
        int[] spots = {1, 2, 4, 8, 9};
        int m = 3;
        int result = maxMinDistance(spots, m);
        System.out.println(result);
    }
}