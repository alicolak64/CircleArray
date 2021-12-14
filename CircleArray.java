/**
 * @author Ali Çolak
 * 8.10.2021
 */
public class CircleArray {

    private int [] circleArray;
    private int count;
    private int capacity;

    public CircleArray(int capacity) {
        circleArray = new int[0];
        count=0;
        this.capacity=capacity;
    }

    public int[] getCircleArray() {
        return circleArray;
    }

    public boolean isEmpty() {
        return count==0;
    }

    public int size() {
        return count;
    }

    public int getValue(int index) {
        if (count!=0) {
            int tempIndex = index%count;
            return circleArray[tempIndex];
        } else throw new RuntimeException("Henüz eleman eklemediniz");

    }

    public void insert (int index, int value) {
        if (count<capacity) {
            if (isEmpty()){
                count++;
                circleArray = new int[count];
                circleArray[0]=value;
            } else {
                count++;
                int tempIndex = index%count;
                int [] tempArray = new int[count];
                for (int i = 0; i < tempIndex; i++) {
                    tempArray[i] = circleArray[i];
                }
                for (int i = tempIndex+1; i < count; i++) {
                    tempArray[i] = circleArray[i-1];
                }
                tempArray[tempIndex] = value;

                circleArray = tempArray;
            }
        } else throw new RuntimeException("Circle Array maksimum uzunluğa ulaştı");
    }

    public void update (int index, int value) {
        if (!isEmpty()) {
            int tempIndex = index%count;
            circleArray[tempIndex] = value;
        } else throw new RuntimeException("Update edecek elemanı bulamadık");

    }

    public int delete (int index) {
        int deletedValue = 0;
        if (!isEmpty()) {
            int tempIndex = index%count;
            count--;
            deletedValue = circleArray[tempIndex];
            int [] tempArray = new int[count];
            for (int i = 0; i < tempIndex; i++) {
                tempArray[i] = circleArray[i];
            }
            for (int i = tempIndex+1; i < count+1; i++) {
                tempArray[i-1] = circleArray[i];
            }
            circleArray=tempArray;
        } else throw new RuntimeException("Silinecek  eleman bulunamadı");
        return deletedValue;
    }

}