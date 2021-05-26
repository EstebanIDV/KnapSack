public class grains {
    static void merging(Objeto array[], int start, int half, int end)
    {
        int index1 = half - start + 1;
        int index2 = end - half;

        Objeto[] left= new Objeto[index1];
        Objeto[] right= new Objeto[index2];

        for (int i = 0; i < index1; i++)
            left[i] = array[start + i];
        for (int j = 0; j < index2; j++)
            right[j] = array[half + 1 + j];


        int i = 0;
        int j = 0;
        int k = start;

        while (i < index1 && j < index2) {
            if (left[i].getValue() <= right[j].getValue()) {
                array[k] = left[i];
                i++;
            }
            else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < index1) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < index2) {
            array[k] = right[j];
            j++;
            k++;
        }

    }

    static void mergeSort(Objeto[] array, int start, int end)
    {
        if(start<end){
            int half = start+((end-start)/2);
            mergeSort(array, start,half);
            mergeSort(array, half+1, end);
            merging(array, start, half, end);
        }else{
            return;
        }


    }
    public static void sacoGranos(Objeto[] granos, int capacidad){
        double  valorSaco= 0;
        int  pesogranos= 0;
        int i =granos.length-1;
        while (i>0&& capacidad>0){
            if (capacidad - granos[i].getWeight() >= 0) {
                capacidad -= granos[i].getWeight();
                valorSaco += granos[i].getValue();
                i--;
            }
            else {
                double filler = ((double)capacidad / (double)granos[i].getWeight());
                valorSaco += (granos[i].getValue() * filler);
                capacidad = (int)(capacidad - (granos[i].getWeight() * filler));
                break;
            }

        }
        System.out.println("Valor del saco: " + valorSaco+ " capacidad restante:  "+capacidad);
    }

    public static void main(String[] args) {
        Objeto[] val = { new Objeto(20,40), new Objeto(20,40), new Objeto(130,30), new Objeto(130,20) };
        mergeSort(val, 0,  val.length-1);
        sacoGranos(val,70);

    }
}
