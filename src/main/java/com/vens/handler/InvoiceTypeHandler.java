package com.vens.handler;

import com.vens.enums.InvoiceType;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceTypeHandler implements TypeHandler<InvoiceType> {
    public void setParameter(PreparedStatement ps, int i, InvoiceType parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    public InvoiceType getResult(ResultSet rs, String columnName) throws SQLException {
        return InvoiceType.getEnumFromCode(rs.getInt(columnName));
    }

    public InvoiceType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return InvoiceType.getEnumFromCode(rs.getInt(columnIndex));
    }

    public InvoiceType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return InvoiceType.getEnumFromCode(cs.getInt(columnIndex));
    }
}
