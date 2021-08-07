package com.melon.sx.study.model;

import java.util.List;

/**
 *
 * 暑假作业对象
 *
 * @author melonkid
 * @date 2021/8/3
 */
public class HomeworkModel {

    /** 口算式 */
    private List<Expression> calculateLines;

    /** 分解式 */
    private List<Expression> separeteLines;

    /** 列数式 */
    private List<Expression> verticalLines;

    /** 单位换算 */
    private List<Expression> unitSwitchLines;

    public List<Expression> getCalculateLines() {
        return calculateLines;
    }

    public void setCalculateLines(List<Expression> calculateLines) {
        this.calculateLines = calculateLines;
    }

    public List<Expression> getSepareteLines() {
        return separeteLines;
    }

    public void setSepareteLines(List<Expression> separeteLines) {
        this.separeteLines = separeteLines;
    }

    public List<Expression> getVerticalLines() {
        return verticalLines;
    }

    public void setVerticalLines(List<Expression> verticalLines) {
        this.verticalLines = verticalLines;
    }

    public List<Expression> getUnitSwitchLines() {
        return unitSwitchLines;
    }

    public void setUnitSwitchLines(List<Expression> unitSwitchLines) {
        this.unitSwitchLines = unitSwitchLines;
    }

    @Override
    public String toString() {
        return "HomeworkModel{" + "calculateLines=" + calculateLines + ", separeteLines=" + separeteLines + ", verticalLines=" + verticalLines + ", unitSwitchLines=" + unitSwitchLines + '}';
    }
}
