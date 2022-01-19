package com.ejlchina.searcher.operator;

import com.ejlchina.searcher.FieldOp;

import java.util.List;

import static com.ejlchina.searcher.util.ObjectUtils.firstNotNull;
import static java.util.Collections.singletonList;

/**
 * 起始运算符
 * @author Troy.Zhou @ 2022-01-19
 * @since v3.3.0
 */
public class EndWith implements FieldOp {

    @Override
    public String name() {
        return "EndWith";
    }

    @Override
    public boolean isNamed(String name) {
        return "ew".equals(name) || "EndWith".equals(name);
    }

    @Override
    public List<Object> operate(StringBuilder sqlBuilder, String dbField, Object[] values) {
        sqlBuilder.append(" like ?");
        return singletonList("%" + firstNotNull(values));
    }

}
