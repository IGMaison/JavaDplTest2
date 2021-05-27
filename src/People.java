import java.util.HashMap;

abstract class People {

    static Integer getSpeed (PeopleType peopleType, CellType cellType) {

        HashMap<CellType, Integer> speed = null;

        try {

            Class peopleClass = peopleType.peopleClass;
            speed = (HashMap<CellType, Integer>) peopleClass.getDeclaredField("speed").get(null);
            return speed.get(cellType);

        } catch (IllegalAccessException | NoSuchFieldException e) {

            e.printStackTrace();
            return null;
        }



    }
}
