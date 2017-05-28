package com.sqlcmd;

public class DataSet {

    private static class Data {
        private String name;
        private Object value;

        public Data (String name, Object value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Object getValue() {
            return value;
        }
    }




}
