package com.vens.handler;

import com.vens.enums.DeliverStatusType;
import com.vens.enums.GenderType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliverStatusTypeHandler implements TypeHandler<DeliverStatusType> {
    public void setParameter(PreparedStatement ps, int i, DeliverStatusType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    public DeliverStatusType getResult(ResultSet rs, String columnName) throws SQLException {
        return DeliverStatusType.getEnumFromCode(rs.getInt(columnName));
    }

    public DeliverStatusType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return DeliverStatusType.getEnumFromCode(rs.getInt(columnIndex));
    }

    public DeliverStatusType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return DeliverStatusType.getEnumFromCode(cs.getInt(columnIndex));
    }
}
