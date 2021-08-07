package com.melon.sx.study.impl;

import com.melon.sx.study.GenerateMathService;
import com.melon.sx.study.MathCommEnum;
import com.melon.sx.study.common.CommConstants;
import com.melon.sx.study.model.Expression;
import com.melon.sx.study.model.HomeworkModel;
import com.melon.sx.study.util.RandomUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author melonkid
 * @date 2021/7/29
 */
@Service
public class GenerateMathServiceImpl implements GenerateMathService {

  String plus = "+";

  String subt = "-";

  String flag =
      "("
          + CommConstants.XSL_SPACE_FLAG
          + CommConstants.XSL_SPACE_FLAG
          + CommConstants.XSL_SPACE_FLAG
          + CommConstants.XSL_SPACE_FLAG
          + ")";

  @Override
  public HomeworkModel generate() {

    // 暑假作业
    HomeworkModel homeworkModel = new HomeworkModel();

    ////////////// 20道口算题
    int expressionsNums = 20;
    int expressionsNumsALine = 5;
    List<Expression> calculateLines = new ArrayList<>();
    homeworkModel.setCalculateLines(calculateLines);

    // 循环生成口算题-生成每行表达式
    for (int i = 0; i < expressionsNums / expressionsNumsALine; i++) {
      Expression line = new Expression();
      List<String> expressions = new ArrayList<>(expressionsNumsALine);
      line.setExpressions(expressions);
      calculateLines.add(line);

      // 生成每列表达式
      for (int j = 0; j < expressionsNumsALine; j++) {
        double type = Math.random();
        String mathStr = "";
        if (type < 0.5) {
          mathStr = generatePlus();
        } else {
          mathStr = generateSubt();
        }
        expressions.add(mathStr);
      }
    }

    ////////////// 10道分解式
    expressionsNums = 10;
    expressionsNumsALine = 5;
    List<Expression> separeteLines = new ArrayList<>();
    homeworkModel.setSepareteLines(separeteLines);

    // 循环生成口算题-生成每行表达式
    for (int i = 0; i < expressionsNums / expressionsNumsALine; i++) {
      Expression line = new Expression();
      List<String> expressions = new ArrayList<>(expressionsNumsALine);
      line.setExpressions(expressions);
      separeteLines.add(line);

      // 生成每列表达式
      for (int j = 0; j < expressionsNumsALine; j++) {
        double type = Math.random();
        String mathStr = "";
        if (type < 0.5) {
          mathStr = generatePlus();
        } else {
          mathStr = generateSubt();
        }
        expressions.add(mathStr);
      }

      // 追加一道空行，用来做分解式
      separeteLines.add(Expression.mockExpressions(expressionsNumsALine));
    }

    ////////////// 10道分解式
    expressionsNums = 10;
    expressionsNumsALine = 5;
    List<Expression> verticalLines = new ArrayList<>();
    homeworkModel.setVerticalLines(verticalLines);

    // 循环生成口算题-生成每行表达式
    for (int i = 0; i < expressionsNums / expressionsNumsALine; i++) {
      Expression line = new Expression();
      List<String> expressions = new ArrayList<>(expressionsNumsALine);
      line.setExpressions(expressions);
      verticalLines.add(line);

      // 生成每列表达式
      for (int j = 0; j < expressionsNumsALine; j++) {
        double type = Math.random();
        String mathStr = "";
        if (type < 0.5) {
          mathStr = generatePlus();
        } else {
          mathStr = generateSubt();
        }
        expressions.add(mathStr);
      }

      // 追加一道空行，用来做分解式
      verticalLines.add(Expression.mockExpressions(expressionsNumsALine));
      verticalLines.add(Expression.mockExpressions(expressionsNumsALine));
      verticalLines.add(Expression.mockExpressions(expressionsNumsALine));
    }

    ////////////// 10道圆角分
    expressionsNums = 10;
    expressionsNumsALine = 2;
    List<Expression> unitSwitchLines = new ArrayList<>();
    homeworkModel.setUnitSwitchLines(unitSwitchLines);

    // 循环生成口算题-生成每行表达式
    for (int i = 0; i < expressionsNums / expressionsNumsALine; i++) {
      Expression line = new Expression();
      List<String> expressions = new ArrayList<>(expressionsNumsALine);
      line.setExpressions(expressions);
      unitSwitchLines.add(line);

      // 生成每列表达式
      for (int j = 0; j < expressionsNumsALine; j++) {
        int type = (int) (Math.random() * 2);
        String mathStr = "";
        // 单位转换
        if (type == 0) {
          mathStr = swichUnit();
        }
        // 比较大小
        if (type == 1) {
          mathStr = compareUnit();
        }
        expressions.add(mathStr);
      }
    }

    // 返回作业对象
    return homeworkModel;
  }

  /**
   * 单位比较
   *
   * @return
   */
  private String compareUnit() {
    int type = RandomUtil.rand(0, 9);
    if (type == 0) {
      // 1转1
      MathCommEnum unit1, unit2;
      do {
        unit1 = MathCommEnum.getByFlag(random3());
        unit2 = MathCommEnum.getByFlag(random3());
      } while (unit1 == unit2);
      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      return money1 + unit1.getName() + flag + money2 + unit2.getName();
    }
    if (type == 1) {
      // 1比2
      MathCommEnum unit1, unit2, unit3;
      do {
        unit1 = MathCommEnum.getByFlag(random3());
        unit2 = MathCommEnum.getByFlag(random3());
      } while (unit1 == unit2);

      unit3 = MathCommEnum.getByFlag(random3());
      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      int money3 = RandomUtil.rand(1, 10);
      return money1 + unit1.getName() + money2 + flag + unit2.getName() + money3 + unit3.getName();
    }

    if (type == 2) {
      // 1 比 3
      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      int money3 = RandomUtil.rand(1, 10);
      MathCommEnum unit1 = MathCommEnum.getByFlag(random3());
      return money3
          + unit1.getName()
          + flag
          + money1
          + MathCommEnum.YUAN.getName()
          + money2
          + MathCommEnum.JIAO.getName()
          + money2
          + MathCommEnum.FEN.getName();
    }

    if (type == 3) {
      // 2 比 1
      MathCommEnum unit1, unit2, unit3;
      do {
        unit1 = MathCommEnum.getByFlag(random3());
        unit2 = MathCommEnum.getByFlag(random3());
      } while (unit1 == unit2);

      unit3 = MathCommEnum.getByFlag(random3());
      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      int money3 = RandomUtil.rand(1, 10);
      return money1 + unit1.getName() + money2 + unit2.getName() + flag + money3 + unit3.getName();
    }

    if (type == 4) {
      // 2 转 2
      MathCommEnum unit1, unit2, unit3, unit4;
      do {
        unit1 = MathCommEnum.getByFlag(random3());
        unit2 = MathCommEnum.getByFlag(random3());
      } while (unit1 == unit2);

      do {
        unit3 = MathCommEnum.getByFlag(random3());
        unit4 = MathCommEnum.getByFlag(random3());
      } while (unit3 == unit4);

      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      int money3 = RandomUtil.rand(1, 10);
      int money4 = RandomUtil.rand(1, 10);
      return money1
          + unit1.getName()
          + money2
          + unit2.getName()
          + flag
          + money3
          + unit3.getName()
          + money4
          + unit4.getName();
    }

    if (type == 5) {
      // 2 比 3
      MathCommEnum unit1, unit2;
      do {
        unit1 = MathCommEnum.getByFlag(random3());
        unit2 = MathCommEnum.getByFlag(random3());
      } while (unit1 == unit2);

      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      int money3 = RandomUtil.rand(1, 10);
      int money4 = RandomUtil.rand(1, 10);
      int money5 = RandomUtil.rand(1, 10);
      return money1
          + unit1.getName()
          + money2
          + unit2.getName()
          + flag
          + money3
          + MathCommEnum.YUAN.getName()
          + money4
          + MathCommEnum.JIAO.getName()
          + money5
          + MathCommEnum.FEN.getName();
    }

    if (type == 6) {
      // 3 比 1
      MathCommEnum unit1 = MathCommEnum.getByFlag(random3());
      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      int money3 = RandomUtil.rand(1, 10);
      int money4 = RandomUtil.rand(1, 10);
      return money1
          + MathCommEnum.YUAN.getName()
          + money2
          + MathCommEnum.JIAO.getName()
          + money3
          + MathCommEnum.FEN.getName()
          + flag
          + money4
          + unit1.getName();
    }

    if (type == 7) {
      // 3 比 2
      MathCommEnum unit1, unit2;
      do {
        unit1 = MathCommEnum.getByFlag(random3());
        unit2 = MathCommEnum.getByFlag(random3());
      } while (unit1 == unit2);

      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      int money3 = RandomUtil.rand(1, 10);
      int money4 = RandomUtil.rand(1, 10);
      int money5 = RandomUtil.rand(1, 10);
      return money1
          + MathCommEnum.YUAN.getName()
          + money2
          + MathCommEnum.JIAO.getName()
          + money3
          + MathCommEnum.FEN.getName()
          + flag
          + money4
          + unit1.getName()
          + money5
          + unit2.getName();
    }

    // 3 比 3
    int money1 = RandomUtil.rand(1, 10);
    int money2 = RandomUtil.rand(1, 10);
    int money3 = RandomUtil.rand(1, 10);
    int money4 = RandomUtil.rand(1, 10);
    int money5 = RandomUtil.rand(1, 10);
    int money6 = RandomUtil.rand(1, 10);
    return money1
        + MathCommEnum.YUAN.getName()
        + money2
        + MathCommEnum.JIAO.getName()
        + money3
        + MathCommEnum.FEN.getName()
        + flag
        + money4
        + MathCommEnum.YUAN.getName()
        + money5
        + MathCommEnum.JIAO.getName()
        + money6
        + MathCommEnum.FEN.getName();
  }

  /**
   * 单位转换 圆角分 多单位转单单位，只能从大单位转换为小单位 单单位转单单位，避免出现小数
   *
   * @return
   */
  private String swichUnit() {
    // 获取转换类型
    int type = RandomUtil.rand(0, 2);
    if (type == 0) {
      // 单单位转单单位
      return swichUnitSingle();
    }

    // 多单位转换
    return swichUnitMutil();
  }

  /**
   * 多个单位转一个单位
   *
   * @return
   */
  private String swichUnitMutil() {
    int type = RandomUtil.rand(0, 4);
    if (type == 0) {
      // 圆分角 转 角
      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      int money3 = RandomUtil.rand(1, 10);
      return money1
          + MathCommEnum.YUAN.getName()
          + money2
          + MathCommEnum.JIAO.getName()
          + money3
          + MathCommEnum.FEN.getName()
          + "="
          + flag
          + MathCommEnum.FEN.getName();
    }
    if (type == 1) {
      // 元角转角
      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      return money1
          + MathCommEnum.YUAN.getName()
          + money2
          + MathCommEnum.JIAO.getName()
          + "="
          + flag
          + MathCommEnum.JIAO.getName();
    }

    if (type == 2) {
      // 元分转分
      int money1 = RandomUtil.rand(1, 10);
      int money2 = RandomUtil.rand(1, 10);
      return money1
          + MathCommEnum.YUAN.getName()
          + money2
          + MathCommEnum.FEN.getName()
          + "="
          + flag
          + MathCommEnum.FEN.getName();
    }

    // 角分转分
    int money1 = RandomUtil.rand(1, 10);
    int money2 = RandomUtil.rand(1, 10);
    return money1
        + MathCommEnum.JIAO.getName()
        + money2
        + MathCommEnum.FEN.getName()
        + "="
        + flag
        + MathCommEnum.FEN.getName();
  }

  private String swichUnitSingle() {
    MathCommEnum unit1, unit2;
    do {
      unit1 = MathCommEnum.getByFlag(random3());
      unit2 = MathCommEnum.getByFlag(random3());
    } while (unit1 == unit2);

    int type = RandomUtil.rand(0, 2);
    // 大转小
    if (type == 0) {
      if (unit1.bigger(unit2)) {
        int money = RandomUtil.rand(1, 10);
        return money + unit1.getName() + "=" + flag + unit2.getName();
      }
      int money = RandomUtil.rand(1, 10);
      return money + unit2.getName() + "=" + flag + unit1.getName();
    }

    // 小转大
    if (unit1.bigger(unit2)) {
      int money = RandomUtil.rand(1, 10);
      int amount = MathCommEnum.toUnit(unit1, unit2, money);
      return amount + unit2.getName() + "=" + flag + unit1.getName();
    }
    int money = RandomUtil.rand(1, 10);
    int amount = MathCommEnum.toUnit(unit2, unit1, money);
    return amount + unit1.getName() + "=" + flag + unit2.getName();
  }

  private int random3() {
    int rand = (int) (Math.random() * 90);
    if (rand >= 60) {
      return 0;
    }
    if (rand >= 30) {
      return 1;
    }

    return 0;
  }

  /** 生成加法口算题 */
  private String generatePlus() {
    int sum, num1, num2;
    do {
      num1 = RandomUtil.rand(3, 100);
      num2 = RandomUtil.rand(3, 100);
      sum = num1 + num2;
    } while (sum > 100);
    return num1 + plus + num2 + "=";
  }

  /** 生成加法口算题 */
  private String generateSubt() {
    int num1, num2;
    do {
      num1 = RandomUtil.rand(3, 100);
      num2 = RandomUtil.rand(3, 100);
    } while (num1 < num2);
    return num1 + subt + num2 + "=";
  }
}
