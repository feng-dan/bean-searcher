package com.ejlchina.searcher.operator;

import com.ejlchina.searcher.FieldOp;
import com.ejlchina.searcher.SqlWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 空值运算符
 * @author Troy.Zhou @ 2022-01-19
 * @since v3.3.0
 */
public class Empty implements FieldOp {

    @Override
    public String name() {
        return "Empty";
    }

    @Override
    public boolean isNamed(String name) {
        return "ey".equals(name) || "Empty".equals(name);
    }

    @Override
    public boolean lonely() {
        return true;
    }

    @Override
    public List<Object> operate(StringBuilder sqlBuilder, OpPara opPara) {
        SqlWrapper<Object> fieldSql = opPara.getDbFieldSql();
        String sql = fieldSql.getSql();
        List<Object> paras = fieldSql.getParas();
        sqlBuilder.append(sql).append(" is null").append(" or ").append(sql).append(" = ''");
        List<Object> params = new ArrayList<>(paras);
        params.addAll(paras);
        return params;
    }

}
