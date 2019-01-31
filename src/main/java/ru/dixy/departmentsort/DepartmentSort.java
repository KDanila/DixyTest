package ru.dixy.departmentsort;

import java.util.*;

/**
 * DepartmentSort class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class DepartmentSort {

    /**
     * Sorting department.
     *
     * @param departments - list of departments.
     * @return treeset.
     */
    Set<String> sort(List<String> departments) {
        Set<String> toReturn = new TreeSet<>(new CompareDepartmentsDown());
        String tempLine;
        int lastIndex;
        for (int i = 0; i < departments.size(); i++) {
            tempLine = departments.get(i);
            toReturn.add(tempLine);
            lastIndex = tempLine.lastIndexOf("\\");
            while (lastIndex != -1) {
                tempLine = tempLine.substring(0, lastIndex);
                toReturn.add(tempLine);
                lastIndex = tempLine.lastIndexOf("\\");
            }
        }
        return toReturn;
    }
}
