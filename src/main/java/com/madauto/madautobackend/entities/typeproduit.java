package com.madauto.madautobackend.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

public enum typeproduit implements Serializable {


    AVANT("AVANT"),
    ARRIÈRE("ARRIÈRE"),
    RÈTROVISEURS("RÈTROVISEURS");
    String code;
    private typeproduit(String code) {
        this.code=code;
    }

    public String getCode() {
        return code;
    }
}
