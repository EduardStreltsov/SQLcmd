package com.sqlcmd;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DabaBaseManagerTest {

    private DabaBaseManager dbManager;

    @Before
    public void setup(){
        dbManager = new DabaBaseManager();
        dbManager.connect("sqlcmd", "postgres", "postgres");
    }

    @Test
    public void testGetTableNames(){
        String[] tables = dbManager.getNamesOfTables();
        assertEquals("[users, test]", Arrays.toString(tables));
    }


}