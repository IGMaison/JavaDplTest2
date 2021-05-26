import java.util.HashMap;

class Human extends People {

    static HashMap<CellType, Integer> speed = new HashMap<>();

    static {
        speed.put(CellType.S, 5);
        speed.put(CellType.W, 2);
        speed.put(CellType.T, 3);
        speed.put(CellType.P, 1);
    }
}
