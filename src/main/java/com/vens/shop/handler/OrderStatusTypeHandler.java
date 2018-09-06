package com.vens.shop.handler;

import com.vens.shop.enums.OrderStatusType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderStatusTypeHandler implements TypeHandler<OrderStatusType> {
    public void setParameter(PreparedStatement ps, int i, OrderStatusType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    public OrderStatusType getResult(ResultSet rs, String columnName) throws SQLException {
        return OrderStatusType.getEnumFromCode(rs.getInt(columnName));
    }

    public OrderStatusType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return OrderStatusType.getEnumFromCode(rs.getInt(columnIndex));
    }

    public OrderStatusType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return OrderStatusType.getEnumFromCode(cs.getInt(columnIndex));
    }
}
