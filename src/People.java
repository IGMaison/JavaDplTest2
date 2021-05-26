import java.util.HashMap;

abstract class People {

    static Integer getSpeed (String peopleType, CellType cellType) {

        HashMap<CellType, Integer> speed = null;

        try {

            Class peopleClass = PeopleType.valueOf(peopleType.toUpperCase()).peopleClass;
            speed = (HashMap<CellType, Integer>) peopleClass.getDeclaredField("speed").get(null);
            return speed.get(cellType);

        } catch (IllegalAccessException | NoSuchFieldException e) {

            e.printStackTrace();
            return null;
        }



    }
}
