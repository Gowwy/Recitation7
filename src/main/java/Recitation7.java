public class Recitation7 {
    /*
     * You may add any private helper method you see necessary,
     * but you may NOT change the signatures of the methods below.
     */
    public static boolean lastItemReachable(int[] hopList) {
        int index = 0;
        while(index < hopList.length-1 &&  hopList[index] != 0 ){
            index += hopList[index];

        }
        return index >= hopList.length - 1;
    }

    public static int[] slidingWindowMin(int[] numberList, int windowSize){
        if (windowSize <= 0 || numberList.length < windowSize) {
            return new int[0];
        }

        int n = numberList.length;
        int[] result = new int[n - windowSize + 1];

        int minIndex = 0;
        for (int i = 1; i < windowSize; i++) {
            if (numberList[i] < numberList[minIndex]) {
                minIndex = i;
            }
        }
        result[0] = numberList[minIndex];

        for (int i = 1; i <= n - windowSize; i++) {
            if (minIndex < i || minIndex >= i + windowSize) {
                minIndex = i;
                for (int j = i + 1; j < i + windowSize; j++) {
                    if (numberList[j] < numberList[minIndex]) {
                        minIndex = j;
                    }
                }
            } else {
                if (numberList[i + windowSize - 1] < numberList[minIndex]) {
                    minIndex = i + windowSize - 1;
                }
            }
            result[i] = numberList[minIndex];
        }

        return result;
    }
}