package ru.dixy.departmentsort;

import org.junit.Test;
import ru.dixy.departmentsort.DepartmentSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DepartmentSortTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class DepartmentSortTest {
    /**
     * The first test.
     */
    @Test
    public void downToUpTest() {
        List<String> test = new ArrayList<>(Arrays.asList(
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"));

        DepartmentSort departmentSort = new DepartmentSort();
        CompareDepartmentsDown cpd = new CompareDepartmentsDown();
        ArrayList<String> result = new ArrayList<>(departmentSort.sort(test));
        List<String> expected = new ArrayList<>(Arrays.asList(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        ));
        assertThat(result, is(expected));
    }
}
/*
 “K2”
“K2\SK1”
“K2\SK1\SSK2”
“K2\SK1\SSK1”
“K1”
“K1\SK2”
“K1\SK1”
“K1\SK1\SSK2”
“K1\SK1\SSK1”

 */