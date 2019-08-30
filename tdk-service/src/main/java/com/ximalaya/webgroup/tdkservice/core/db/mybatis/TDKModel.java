package com.ximalaya.webgroup.tdkservice.core.db.mybatis;

public class TDKModel {

    private String title222;
    private String descccc;
    private String keword;
    private String uniqueCode;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle222() {
        return title222;
    }

    public String getDescccc() {
        return descccc;
    }

    public String getKeword() {
        return keword;
    }


    public String getUniqueCode() {
        return uniqueCode;
    }

    public TDKModel() {
    }

    public TDKModel(String title222, String descccc, String keword, String uniqueCode) {
        this.title222 = title222;
        this.descccc = descccc;
        this.keword = keword;
        this.uniqueCode = uniqueCode;
    }

    public TDKModel(String title222, String descccc, String keword, String uniqueCode, Long id) {
        this.title222 = title222;
        this.descccc = descccc;
        this.keword = keword;
        this.uniqueCode = uniqueCode;
        this.id = id;
    }
}
