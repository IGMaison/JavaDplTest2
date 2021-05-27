import java.util.HashMap;

abstract class People {

    static Integer getSpeed (PeopleType peopleType, CellType cellType) throws NoSuchFieldException, IllegalAccessException {

        HashMap<CellType, Integer> speed;

        Class peopleClass = peopleType.peopleClass;
        speed = (HashMap<CellType, Integer>) peopleClass.getDeclaredField("speed").get(null);
        return speed.get(cellType);
    }
}
