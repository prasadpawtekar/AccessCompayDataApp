package com.netwintest.accesscompaydata.data;

import android.net.Uri;

/**
 * Created by Admin on 7/24/2018.
 */

public class Table {

    public static class Employee {
        public static final String TABLE_NAME = "tbl_emp";

        public static final class Column {
            public static final String EMP_ID = "emp_id",
                    EMP_NAME = "emp_name",
                    EMP_AGE = "emp_age",
                    EMP_DESIGNATION = "emp_designation",
                    EMP_DOJ = "emp_doj";
        }

        public static final Uri uri = Uri.parse("content://com.netwintest.companyapp.companydata/employee");
    }
}
