package com.melon.sx.study.model;

import com.melon.sx.study.common.CommConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式
 *
 * @author melonkid
 * @date 2021/8/3
 */
public class Expression {

  List<String> expressions;

  public List<String> getExpressions() {
    return expressions;
  }

  public void setExpressions(List<String> expressions) {
    this.expressions = expressions;
  }

  public static Expression mockExpressions(int expressNums) {
    Expression expression = new Expression();
    List<String> expressions = new ArrayList<>(expressNums);
    expression.setExpressions(expressions);

    // mock
    for (int i = 0; i < expressNums; i++) {
      //            expressions.add("&emsp;");
      expressions.add(CommConstants.XSL_SPACE_FLAG);
    }

    return expression;
  }
}
