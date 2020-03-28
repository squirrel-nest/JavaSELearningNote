
1. 通过import将项目导进来
2. 新增一个库表test，sql如下
create table TEST
(
  ID     VARCHAR2(8) not null,
  NAME   VARCHAR2(30),
  REMARK VARCHAR2(30)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table TEST
  add constraint PK_TEST primary key (ID);
3. jdbc.properties配置改一下，如对应数据库的IP、用户名、密码
4. 部署到tomcat5
5. 启动tomcat5
6. 打开IE，输入:
http://localhost:8089/j2eetest/jsp/doTestAction.do?postMethod=getTestInfList&issearch=1
注：其中8089为tomcat对应端口，不同请更改。

