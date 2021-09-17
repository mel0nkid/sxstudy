package com.melon.sx.study.dao;

import java.lang.reflect.Field;

/**
 * Dao抽象层
 *
 * @author imelonkid
 * @date 2021/09/18 00:09
 **/
public abstract class AbstractDao {

    public abstract String getTableName();

    public <T> String generateInsert(T obj) {
        StringBuilder sb = new StringBuilder("insert into ");
        sb.append(getTableName()).append(" (");

        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            sb.append(field.getName()).append(", ");
        }
        String sqltmp = sb.substring(0, sb.length() - 2);
        StringBuilder sqlBuilder = new StringBuilder(sqltmp).append(")").append(" values (");

        for (int i = 0; i < fields.length; i++) {
            sqlBuilder.append("?, ");
        }

        return sqlBuilder.substring(0, sqlBuilder.length() - 2) + ")";
    }

}
