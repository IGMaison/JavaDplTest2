import java.util.*;

public class Solution {

    public static int getResult(String fieldString, String peopleType) {

        Field field;                                    //игоовое поле
        ArrayList<Cell> nearestCells;                   //набор ближайших клеток(Cell) для данной клетки поля
        Queue<Cell> cellsToCheckQueue;                  //очередь из клеток поля, с приоритетом по минимальному distance

        field = new Field(fieldString);
        PeopleType peopleType_ = PeopleType.valueOf(peopleType.toUpperCase());

        cellsToCheckQueue = new PriorityQueue<Cell>(16,
                Comparator.comparingInt((Cell o) -> o.distance));

        cellsToCheckQueue.add(field.fieldCells[0][0]);

        while (!cellsToCheckQueue.isEmpty()) {

            Cell currCel = cellsToCheckQueue.remove();
            nearestCells = field.getNearest(currCel);

            for (Cell nearestCell : nearestCells) {

                if (nearestCell.toCheck) {

                    if (nearestCell.distance > currCel.distance +
                            People.getSpeed(peopleType_, nearestCell.cellType) || nearestCell.distance == 0) {

                        nearestCell.distance = currCel.distance + People.getSpeed(peopleType_, nearestCell.cellType);
                        cellsToCheckQueue.add(nearestCell);
                    }
                }
            }
            currCel.toCheck = false;

        }

        return field.fieldCells[3][3].distance;              // minDistanse
    }
}
