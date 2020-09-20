package ConsoleCommandAnalysis;

/**
 * @author wang-hc
 */

public enum FLAGENUM {
    //
    BOOLEAN("l","true"),STRING("d",""),NUMBER("p","0");
    private String flag;
    private String defaultValue;

    FLAGENUM(String flag, String defaultValue) {
        this.flag = flag;
        this.defaultValue = defaultValue;
    }

    public String getFlag() {
        return flag;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    //    public Object getDefaultValue(String flag){
//        return FLAGENUM.valueOf(flag);
//    }


}
