import static java.lang.Integer.max;

public class knapsack {
    static int knapsack(int capacidad, Objeto ob[], int i)
    {
        if (i == 0 || capacidad == 0)
            return 0;

        if (ob[i - 1].getWeight() > capacidad)
            return knapsack(capacidad, ob, i - 1);
        else
            return max(ob[i-1].getValue() + knapsack(capacidad - ob[i-1].getWeight(), ob, i - 1), knapsack(capacidad, ob, i - 1));
    }
    public static void main(String[] args) {
        Objeto[] val = { new Objeto(20,40), new Objeto(20,40), new Objeto(30,30), new Objeto(30,20) };
        System.out.println(knapsack(70, val, val.length));

    }
}
