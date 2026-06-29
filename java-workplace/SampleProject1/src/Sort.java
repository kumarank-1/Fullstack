public class Sort {

    static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void bubbleSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {10, 12, 34, 54, 7, 80, 75, 13, 9, 42};

        System.out.println("Array before sorting:");
        Sort.printArray(ages);

        Sort.bubbleSort(ages);

        System.out.println("Array after sorting:");
        printArray(ages);
    }
}