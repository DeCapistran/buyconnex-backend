package com.buyconnex.buyconnex.entity.utils;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FILES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Files implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @SequenceGenerator(name = "FILES_SEQ_ID", sequenceName = "SEQ_OID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILES_SEQ_ID")
    @Column(name = "ID_FILE")
    private Long id;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "ABREVIATION")
    private String abreviation;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MIME_TYPE")
    private String mimeType;

    @Column(name = "THE_BLOB")
    @Lob
    private byte[] theBlob;

    @Transient
    private byte[] theBlobCopy;

    @Column(name = "FILE_PATH")
    private String path;

    @Column(name = "OWNER1_ID")
    private Long owner1Id;

    @Column(name = "OWNER2_ID")
    private Long owner2Id;

    @Column(name = "OWNER3_ID")
    private Long owner3Id;

    @Column(name = "TYPE_ID")
    private Long typeId;

    @Column(name = "AUTEUR")
    private String auteur;

    @Column(name = "DATE_MAJ")
    private Date dateMja;

    @Column(name = "DATE_UPLOAD")
    private Date dateUpload;

    @Column(name = "SS_TYPE_1_ID")
    private Long sousType1Id;

    @Column(name = "SS_TYPE_2_ID")
    private Long sousType2Id;

    @Column(name = "SS_TYPE_3_ID")
    private Long sousType3Id;

    @Column(name = "MULTI_DOSSIER")
    private int multiDossier;

    @Column(name = "B_FILESYSTEM")
    private boolean isStoredInFileSystem = false;

    @Column(name = "FILE_SIZE")
    private Long fileSize;

    @SuppressWarnings("removal")
	public Long getSizeToCompare() {
        if (getFileSize() != null) {
            return getFileSize();
        } else if (theBlob != null) {
            return new Long(theBlob.length);
        } else {
            return 0L;
        }
    }
}
