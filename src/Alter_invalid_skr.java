/*    */ 
/*    */ 
/*    */ public class Alter_invalid_skr
/*    */ {
/*    */   public void create() {
/*  6 */     String alterInvalid = "set pagesize 200" + windowNunc.newLine;
/*  7 */     alterInvalid = String.valueOf(alterInvalid) + "set heading off" + windowNunc.newLine;
/*  8 */     alterInvalid = String.valueOf(alterInvalid) + "set echo off" + windowNunc.newLine;
/*  9 */     alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
/* 10 */     alterInvalid = String.valueOf(alterInvalid) + "spool " + "\"" + windowNunc.path + "\\alter_invalid.sql" + "\"" + windowNunc.newLine;
/* 11 */     alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
/* 12 */     alterInvalid = String.valueOf(alterInvalid) + "select 'alter package ' || substr(objecT_name,1,60) || ' compile package;'" + windowNunc.newLine;
/* 13 */     alterInvalid = String.valueOf(alterInvalid) + "from user_objects" + windowNunc.newLine;
/* 14 */     alterInvalid = String.valueOf(alterInvalid) + "where status = 'INVALID' and" + windowNunc.newLine;
/* 15 */     alterInvalid = String.valueOf(alterInvalid) + "object_type = 'PACKAGE'" + windowNunc.newLine;
/* 16 */     alterInvalid = String.valueOf(alterInvalid) + "order by object_type, object_name;" + windowNunc.newLine;
/* 17 */     alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
/* 18 */     alterInvalid = String.valueOf(alterInvalid) + "select 'alter package ' || substr(objecT_name,1,60) || ' compile body;'" + windowNunc.newLine;
/* 19 */     alterInvalid = String.valueOf(alterInvalid) + "from user_objects" + windowNunc.newLine;
/* 20 */     alterInvalid = String.valueOf(alterInvalid) + "where status = 'INVALID' and" + windowNunc.newLine;
/* 21 */     alterInvalid = String.valueOf(alterInvalid) + "object_type = 'PACKAGE BODY'" + windowNunc.newLine;
/* 22 */     alterInvalid = String.valueOf(alterInvalid) + "order by object_type, object_name;" + windowNunc.newLine;
/* 23 */     alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
/* 24 */     alterInvalid = String.valueOf(alterInvalid) + "select 'alter ' || object_type ||' ' || substr(objecT_name,1,60) || ' compile;'" + windowNunc.newLine;
/* 25 */     alterInvalid = String.valueOf(alterInvalid) + "from user_objects" + windowNunc.newLine;
/* 26 */     alterInvalid = String.valueOf(alterInvalid) + "where status = 'INVALID' and" + windowNunc.newLine;
/* 27 */     alterInvalid = String.valueOf(alterInvalid) + "objecT_type not in ( 'PACKAGE', 'PACKAGE BODY' )" + windowNunc.newLine;
/* 28 */     alterInvalid = String.valueOf(alterInvalid) + "order by object_type, object_name;" + windowNunc.newLine;
/* 29 */     alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
/* 30 */     alterInvalid = String.valueOf(alterInvalid) + "select 'Prompt ' from dual;" + windowNunc.newLine;
/* 31 */     alterInvalid = String.valueOf(alterInvalid) + "select 'Prompt --------------------------------------------------' from dual;" + windowNunc.newLine;
/* 32 */     alterInvalid = String.valueOf(alterInvalid) + "select 'Prompt Invalidni paketi:' from dual;" + windowNunc.newLine;
/* 33 */     alterInvalid = String.valueOf(alterInvalid) + "select 'select substr(object_name,1,60)" + windowNunc.newLine;
/* 34 */     alterInvalid = String.valueOf(alterInvalid) + "from user_objects where status = ''INVALID''" + windowNunc.newLine;
/* 35 */     alterInvalid = String.valueOf(alterInvalid) + "and object_type like ''PACKAGE%'' order by object_type, object_name; '" + windowNunc.newLine;
/* 36 */     alterInvalid = String.valueOf(alterInvalid) + "from dual;" + windowNunc.newLine;
/* 37 */     alterInvalid = String.valueOf(alterInvalid) + "select 'Prompt --------------------------------------------------' from dual;" + windowNunc.newLine;
/* 38 */     alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
/* 39 */     alterInvalid = String.valueOf(alterInvalid) + "spool off" + windowNunc.newLine;
/*    */     
/* 41 */     WriteTextFile.create(String.valueOf(windowNunc.path) + "\\alter_invalid1.skr", alterInvalid);
/*    */   }
/*    */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\Alter_invalid_skr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */