
no rows selected


alter package INIS_VMESNIKI_ZA_GEN compile body;                                
alter package MET_DOK_SIS_EPODPIS compile body;                                 
alter package MET_DOKUMENTNI_SISTEM compile body;                               
alter package MET_DOKUMENTNI_SISTEM_2 compile body;                             
alter package MET_WS_EPERO compile body;                                        
alter package OZP_WS compile body;                                              

6 rows selected.


alter PROCEDURE P_PRENOS_AML compile;                                           


Prompt                                                                          


Prompt --------------------------------------------------                       


Prompt Invalidni paketi:                                                        


select substr(object_name,1,60)                                                 
from user_objects where status = 'INVALID'                                      
and object_type like 'PACKAGE%' order by object_type, object_name;              
                                                                                


Prompt --------------------------------------------------                       

