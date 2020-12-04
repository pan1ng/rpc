public class TTest<T>{

    private T x;
    private T y;

    public TTest (T t, T g) {
        this.x = t;
        this.y = g;
    }

    public T add() {
        if (x.equals(y))
            return x;
        return null;
    }

    public static void main(String[] args) {
        TTest<Integer> a = new TTest<>(1,2);
        TTest<Double> b = new TTest<>(1.2, 1.2);
        System.out.println(a.add());
        System.out.println(b.add());
    }
}
