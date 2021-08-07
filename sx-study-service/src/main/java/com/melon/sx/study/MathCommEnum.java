package com.melon.sx.study;

/**
 * @author melonkid
 * @date 2021/7/29
 */
public enum  MathCommEnum {

    YUAN("YUAN", "元", 0),JIAO("JIAO", "角", 1),FEN("FEN","分",  2);

    private String code;
    private String name;
    private int flag;

    /**
     * 大转小
     * @param fromUnit
     * @param toUnit
     * @param amount
     * @return
     */
    public static int toUnit(MathCommEnum fromUnit, MathCommEnum toUnit, int amount){
//        if(!fromUnit.bigger(toUnit)) {
//            throw new Exception("异常");
//        }
        if(fromUnit == toUnit) {
            return amount;
        }
        if(fromUnit == YUAN && toUnit == JIAO) {
            return amount * 10;
        }
        if(fromUnit == YUAN && toUnit == FEN) {
            return amount * 10 * 10;
        }
        if(fromUnit == JIAO && toUnit == FEN) {
            return amount * 10;
        }

        return amount;
    }

    public static MathCommEnum getByFlag(int num){
        for(MathCommEnum commEnum : MathCommEnum.values()) {
            if(commEnum.flag == num) {
                return commEnum;
            }
        }

        return null;
    }


    MathCommEnum(String code, String name, int flag) {
        this.code = code;
        this.name = name;
        this.flag = flag;
    }

    public boolean bigger(MathCommEnum unit){
        if(this == YUAN && unit != YUAN) {
            return true;
        }
        if(this == JIAO && unit == FEN) {
            return true;
        }

        return false;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getFlag() {
        return flag;
    }
}
