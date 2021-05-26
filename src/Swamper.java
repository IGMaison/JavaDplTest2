import java.util.HashMap;

class Swamper extends People {

    static HashMap<CellType, Integer> speed = new HashMap<>();

    static {
        speed.put(CellType.S, 2);
        speed.put(CellType.W, 2);
        speed.put(CellType.T, 5);
        speed.put(CellType.P, 2);
    }
}
