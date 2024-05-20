package com.iremse.meditasyonuygulamasi;

public class DataClass {
    private String dataTitle;
    private String dataDesc; // int dataDesc -> String dataDesc

    private int dataImage;

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDesc() { // int getDataDesc() -> String getDataDesc()
        return dataDesc;
    }

    public int getDataImage() {
        return dataImage;
    }

    public DataClass(String dataTitle, String dataDesc, int dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataImage = dataImage;
    }
}

