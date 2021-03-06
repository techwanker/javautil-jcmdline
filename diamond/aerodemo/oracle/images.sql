

  CREATE TABLE IC_LOT_IMAGE
   (	LOT_NBR integer NOT NULL ,
	IMG_IMAGE_SET_HDR_NBR integer NOT NULL ,
	CERT_CD varchar(8),
	QA_APPRV_FLG varchar(1) NOT NULL ,
	 CHECK (QA_APPRV_FLG IN ('Y', 'N')) ,
	 PRIMARY KEY (LOT_NBR, CERT_CD, IMG_IMAGE_SET_HDR_NBR),
	 FOREIGN KEY (CERT_CD)
	  REFERENCES IC_CERT_CD (CERT_CD) ,
	 FOREIGN KEY (IMG_IMAGE_SET_HDR_NBR)
	  REFERENCES IMG_IMAGE_SET_HDR (IMG_IMAGE_SET_HDR_NBR) ,
	 FOREIGN KEY (LOT_NBR)
	  REFERENCES IC_LOT_MAST (LOT_NBR) 
   ) ;

  CREATE TABLE IMG_IMAGE
   (	IMG_IMAGE_NBR integer NOT NULL ,
	IMG_IMAGE_PATH varchar(255),
	IMG_IMAGE_FILE_NM varchar(128),
	IMAGE_DESCR varchar(60),
	 PRIMARY KEY (IMG_IMAGE_NBR)
   ) ;




  CREATE TABLE IMG_IMAGE_SET_HDR
   (	IMG_IMAGE_SET_HDR_NBR integer NOT NULL ,
	IMG_IMAGE_SET_DESCR varchar(255),
	SCAN_SET_FLG varchar(1) NOT NULL ,
	 CHECK (SCAN_SET_FLG IN ('Y', 'N')) ,
	 PRIMARY KEY (IMG_IMAGE_SET_HDR_NBR)
   ) ;

  CREATE TABLE IMG_IMAGE_SET_DTL
   (	IMG_IMAGE_SET_HDR_NBR integer NOT NULL ,
	IMG_IMAGE_NBR integer NOT NULL ,
	IMG_IMAGE_SET_DTL_DESCR varchar(255),
	 PRIMARY KEY (IMG_IMAGE_SET_HDR_NBR, IMG_IMAGE_NBR),
	 FOREIGN KEY (IMG_IMAGE_NBR)
	  REFERENCES IMG_IMAGE (IMG_IMAGE_NBR) ,
	 FOREIGN KEY (IMG_IMAGE_SET_HDR_NBR)
	  REFERENCES IMG_IMAGE_SET_HDR (IMG_IMAGE_SET_HDR_NBR) 
   ) ;

  CREATE TABLE IMG_SCAN_BATCH
   (	IMG_SCAN_BATCH_NBR integer NOT NULL ,
	SCAN_DEVICE_TYPE_ID varchar(20),
	IMG_CAPTURE_TM DATE,
	INDIV_NBR_CAPTURE integer,
	IMG_IMAGE_SET_HDR_NBR integer,
	 PRIMARY KEY (IMG_SCAN_BATCH_NBR),
	 FOREIGN KEY (IMG_IMAGE_SET_HDR_NBR)
	  REFERENCES IMG_IMAGE_SET_HDR (IMG_IMAGE_SET_HDR_NBR) 
   ) ;


