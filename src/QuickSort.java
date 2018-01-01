import java.util.Arrays;
import java.util.Comparator;

//Quick Sort using random pivot selection

public class QuickSort {
    public static <E> void quicksort(E[] array, int start, int end, Comparator<E> comparator){
        if (end - start <= 0){
            return;
        }
        int pivotIndex = (int)((end-start)*Math.random())+start;
        swap(array, pivotIndex, end-1);
        int i = start;
        int j = end - 1;
        boolean movingI = true;

        while (i < j){
            if(comparator.compare(array[i], array[j])>0){
                swap(array, i, j);
                movingI = !movingI;
            }else{
                if(movingI){
                    i++;
                }else{
                    j--;
                }
            }
        }
        quicksort(array, start, i, comparator);
        quicksort(array, i+1, end, comparator);
    }

    public static <E> void quicksort(E[] array,Comparator<E> comparator){
        quicksort(array, 0, array.length, comparator);
    }

    public static <E> void swap(E[] array, int i, int j){
        if(i==j){
            return;
        }
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String arg[]){
        Integer[] array = new Integer[]{10, 5, 12, 21, 30, 2, 1, 90, 92, 11, 23};
        quicksort(array, Comparator.comparingInt(a -> a));
        System.out.print(Arrays.toString(array));
    }
}
