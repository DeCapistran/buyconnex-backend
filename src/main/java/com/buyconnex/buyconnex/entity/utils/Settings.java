package com.buyconnex.buyconnex.entity.utils;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SETTINGS")
@Getter
@Setter
@NoArgsConstructor
public class Settings {

    @Id
    @Getter
    @Column(name = "ID_SETTING")
    private Long id;

    @Column(name = "VALUE_STR")
    private String valueStr;

    @Column(name = "DEFAULT_VALUE_STR")
    private String defaultValueStr;

    @Column(name = "VALUE_BOOL")
    private Boolean valueBool;

    @Column(name = "DEFAULT_VALUE_BOOL")
    private Boolean defaultValueBool;

    @Column(name = "VALUE_LONG")
    private Long valueLong;

    @Column(name = "DEFAULT_VALUE_LONG")
    private Long defaultValueLong;

    @Column(name = "VALUE_NB")
    private BigDecimal valueNb;

    @Column(name = "DEFAULT_VALUE_NB")
    private BigDecimal defaultValueNb;

    @Column(name = "VALUE_BLOB")
    private byte[] valueBlob;

    @Column(name = "LIBELLE")
    private String libelle;

    @Getter @Setter
    @Column(name = "VALUE_DATE")
    private Date valueDate;

    @Column(name = "DEFAULT_VALUE_DATE")
    private Date defaultValueDate;

    @Lob
    @Column(name = "VALUE_CLOB")
    String valueClob;

    @Lob
    @Column(name = "DEFAULT_VALUE_CLOB")
    String defaultValueClob;

    public String getValueClobSetting() {
        return valueClob != null ? valueClob : defaultValueClob;
    }

}
