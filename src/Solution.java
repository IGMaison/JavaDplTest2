import java.util.*;

public class Solution {

    public static int getResult(String fieldString, String peopleType) {

        Field field;                                    //игоовое поле
        ArrayList<Cell> nearestCells;                   //набор ближайших клеток(Cell) для данной клетки поля
        Queue<Cell> cellsToCheckQueue;                  //очередь из клеток поля, с приоритетом по минимальному distance

        field = new Field(fieldString);

        cellsToCheckQueue = new PriorityQueue<>(16,
                Comparator.comparingInt((Cell o) -> o.distance));

        cellsToCheckQueue.add(field.fieldCells[0][0]);

        while (!cellsToCheckQueue.isEmpty()) {

            Cell currCel = cellsToCheckQueue.remove();
            nearestCells = field.getNearest(currCel);

            try {

                for (Cell nearestCell : nearestCells)
                    if (nearestCell.toCheck) if (nearestCell.distance > currCel.distance +
                            People.getSpeed(PeopleType.fromString(peopleType), nearestCell.cellType) || nearestCell.distance == 0) {

                        nearestCell.distance = currCel.distance +
                                People.getSpeed(PeopleType.fromString(peopleType), nearestCell.cellType);

                        cellsToCheckQueue.add(nearestCell);
                    }
            }
            catch (IllegalAccessException | NoSuchFieldException e ) {

                e.printStackTrace();

            }
            currCel.toCheck = false;

        }

        return field.fieldCells[3][3].distance;
    }
}
