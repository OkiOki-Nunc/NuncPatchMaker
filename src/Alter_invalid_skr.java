public class Alter_invalid_skr
{
  public void create() {
    String alterInvalid = "set pagesize 200" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "set heading off" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "set echo off" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "spool " + "\"" + windowNunc.path + "\\alter_invalid.sql" + "\"" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "select 'alter package ' || substr(objecT_name,1,60) || ' compile package;'" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "from user_objects" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "where status = 'INVALID' and" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "object_type = 'PACKAGE'" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "order by object_type, object_name;" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "select 'alter package ' || substr(objecT_name,1,60) || ' compile body;'" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "from user_objects" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "where status = 'INVALID' and" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "object_type = 'PACKAGE BODY'" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "order by object_type, object_name;" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "select 'alter ' || object_type ||' ' || substr(objecT_name,1,60) || ' compile;'" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "from user_objects" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "where status = 'INVALID' and" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "objecT_type not in ( 'PACKAGE', 'PACKAGE BODY' )" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "order by object_type, object_name;" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "select 'Prompt ' from dual;" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "select 'Prompt --------------------------------------------------' from dual;" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "select 'Prompt Invalidni paketi:' from dual;" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "select 'select substr(object_name,1,60)" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "from user_objects where status = ''INVALID''" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "and object_type like ''PACKAGE%'' order by object_type, object_name; '" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "from dual;" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "select 'Prompt --------------------------------------------------' from dual;" + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + windowNunc.newLine;
    alterInvalid = String.valueOf(alterInvalid) + "spool off" + windowNunc.newLine;
    
    WriteTextFile.create(String.valueOf(windowNunc.path) + "\\alter_invalid1.skr", alterInvalid);
  }
}