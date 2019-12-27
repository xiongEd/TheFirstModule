package Study;

public class QuickSort {
    private static void Quick_Sort(int[] arrays){
        int len = arrays.length;
        if (len == 0)
            return;
        int head = 0, tail = len - 1, stake = arrays[head];
        Sort(arrays, head, tail);
    }

    private static void Sort(int[] arrays, int head, int tail){
        int start = head,end = tail;
        int len = arrays.length;
        if (len == 0 || tail <= head)
            return ;
        int stake = arrays[head];
        while (head < tail){
            while (head < tail){
                if (arrays[tail] < stake){
                    arrays[head] = arrays[tail];
                    break;
                }
                tail --;
            }
            while (head < tail){
                if (arrays[head] > stake){
                    arrays[tail] = arrays[head];
                    break;
                }
                head ++;
            }
        }
        arrays[head] = stake;

       Sort(arrays, start, head - 1);
        Sort(arrays, head + 1, end);
    }

    public static void main(String[] args){
        int[]a = {5,7,3,1,2,6,9,4,9,15,24,8};
        Quick_Sort(a);
        for (int c : a)
            System.out.print(c + " ");
    }
}
