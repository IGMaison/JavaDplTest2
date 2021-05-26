import java.util.HashMap;

class Woodman extends People {

    static HashMap<CellType, Integer> speed = new HashMap<>();

    static {
        speed.put(CellType.S, 3);
        speed.put(CellType.W, 3);
        speed.put(CellType.T, 2);
        speed.put(CellType.P, 2);
    }
}
