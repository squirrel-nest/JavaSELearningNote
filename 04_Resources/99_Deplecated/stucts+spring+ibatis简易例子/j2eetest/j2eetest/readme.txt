
1. ͨ��import����Ŀ������
2. ����һ�����test��sql����
create table TEST
(
  ID     VARCHAR2(8) not null,
  NAME   VARCHAR2(30),
  REMARK VARCHAR2(30)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table TEST
  add constraint PK_TEST primary key (ID);
3. jdbc.properties���ø�һ�£����Ӧ���ݿ��IP���û���������
4. ����tomcat5
5. ����tomcat5
6. ��IE������:
http://localhost:8089/j2eetest/jsp/doTestAction.do?postMethod=getTestInfList&issearch=1
ע������8089Ϊtomcat��Ӧ�˿ڣ���ͬ����ġ�

