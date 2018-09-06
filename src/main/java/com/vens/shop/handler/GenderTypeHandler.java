package com.vens.shop.handler;

import com.vens.shop.enums.GenderType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GenderTypeHandler implements TypeHandler<GenderType> {
    public void setParameter(PreparedStatement preparedStatement, int i, GenderType genderType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,genderType.getCode());
    }

    public GenderType getResult(ResultSet resultSet, String s) throws SQLException {
        return GenderType.getEnumFromCode(resultSet.getInt(s));
    }

    public GenderType getResult(ResultSet resultSet, int i) throws SQLException {
        return GenderType.getEnumFromCode(resultSet.getInt(i));
    }

    public GenderType getResult(CallableStatement callableStatement, int i) throws SQLException {
        return GenderType.getEnumFromCode(callableStatement.getInt(i));
    }
}
