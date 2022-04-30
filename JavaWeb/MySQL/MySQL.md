## 卸载

1. 在mysql安装目录下找到my.ini文件并打开
2. 找到`datadir="..."`
3. 卸载MySQL
4. 删除datadir路径的MySQL文件



## MySQL服务启动和关闭

* cmd --> services.msc
* net start/stop mysql

## 登陆退出

* 登录
      1. mysql -uroot -padmin
      2. mysql -h<ip> -u<user> -p<password> == mysql --host=127.0.0.1 --user=root --password=password

* 退出
      1. exit
      2. quit

## MySQL目录结构

1. MySQL安装目录
      * 配置文件 my.ini
2. MySQL数据目录
      * 数据库：文件夹
      * 表：文件
      * 数据

## SQL

* Structured Query Language: 结构化查询语言

定义了操作所有关系型数据库的规则。

## SQL通用语法

1. SQL语句可以单行或多行书写，以分号结尾；
2. 不区分大小写
3. 3种注释
   1. --注释内容
   2. /# 注释内容
   3. /* 注释内容 */
   
## SQL分类
1. DDL(Data Definition Language)数据定义语言
2. DML(Data Manipulation Language)数据操作语言
3. DQL(Data Query Language)数据查询语句
4. DCL(Data Control Language)数据控制语言

## DDL：操作数据库、表

1. 操作数据库：CRUD
   1. create
         * create database [if not exists] db character set gbk;
   2. retrieve
         * show databases;
         * show create database 数据库名;查询数据库创建语句
         * 
   3. updata
         * alter database 数据库名 charcter set utf8;
   4. delete
         * drop database [if exists] 数据库名
   5. 使用数据库
         * select database(); 查询当前正在使用的数据库名称
         * use 数据库名称;

2. 操作表
   1. create
        ```sql
        create table 表名(
            列名 数据类型,
            ...
            列名 数据类型
        );
        ```

        1. double(5, 2)
        2. data: yyyy-MM-dd
        3. datatime: yyyy-MM-dd HH:mm:ss
        4. timestamp: yyyy-MM-dd HH:mm:ss  默认使用当前时间
        5. varchar:字符串
   2. retrieve
      * show tables;
      * desc 表名;
   3. update:
      * 修改表名：alter table 表名 rename to 新表名;
      * 添加一列：alter table 表名 add 列名 数据类型;
      * 修改列：alter table 表名 change 列名 新列名 新数据类型;
        * alter table 表名 modify 列名 新数据类型;
      * 删除列：alter table 表名 drop 列名;
   4. delete:
      * drop table [if not exists] 表名;

```sql
create table student(
    id int,
    name varchar(32),
    age int,
    score double(4,1),
    birthday date,
    insert_time timestamp
);
```

## DML: 增删改表中数据

1. 添加数据：
      * insert into 表名(列名1，列名2，。。。列名n) vlaues(值1，值2， 。。。值n);
        * 列名和值一一对应
        * 如果表名后，不定义列名，则默认给所有列添加值
        * 除了数字类型，其他类型需要使用引号（单双皆可）引起来
2. 删除数据：
      * delete from 表名 [where ...];
     * truncate table 表名; 效率更高，删表+新建表
3. 修改数据：
       * update 表名 set 列名1 = 值1，列名2 = 值2...[where ...];


## DQL：查询表中的记录

1. select from [where] [group by] [having] [order by] [limit]
2. 基础查询
   1. 多个字段查询
         1. select 字段名1，字段名2.。。 from 表名;
   2. 去重：
         1. distinct
   3. 计算列
         1. ifnull（字段，替换值）
   4. 起别名
         1. as，也可省略
3. 条件查询
   1. 运算符
         1. >,<,<=,>=,=,<>
         2. between...and
         3. in
         4. like
              1. 占位符：
                 1. _：单个任意字符
                 2. %：多个任意字符
         5. is null
         6. &
         7. ||
         8. !
4. 排序查询
   1. order by 字段名 排序方式, 字段名 排序方式
         1. asc(default), desc
         2. 多个排序
5. 聚合函数：将一列数据作为一个整体，进行纵向的计算
         1. count
         2. max
         3. min
         4. sum
         5. avg
         6. 聚合函数计算，排除null值。
              解决方案：
               1. 选择不包含非空的列进行计算
               2. ifnull
6. 分组查询：
    1. goup by 分组字段
       1. 分组后查询的字段：分组字段、聚合函数
       2. where和having区别？
          1. where在分组前限定
          2. where后不可有聚合函数
7. 分页查询：
   1. limit

## 约束

* 概念： 对表中的数据进行限定，保证数据的有效性，正确性和完整性。
* 分类：
    1. primary key
    2. not null
    3. unique
    4. foreign key

* not null:
    * 在创建表时添加约束
    * 添加：`alter table 表名 modify 字段名 数据类型 not null;`
* unique
    * 创建表时添加约束
    * attention：唯一约束可以有null值，但最多一条
    * 删除唯一约束：`alter table 表名 drop index 列名;
    * 添加：`alter table 表名 modify 字段名 数据类型 unique;`
* primary key
    * attention:
      * 非空且唯一
      * 一张表一个主键
      * 主键时表中记录的唯一标识
    * 删除：
      * `alter table 表名 drop primarykey;`
    * 添加：
      * `alter table 表名 modify id int primary key;`
    * auto_increment
* foreign key
  * 创建表时，添加外键
    ```sql
    create table 表名 (
        ...
        外键列
        constraint 外键名称 foreign key (外键列名) references 主表名称(主表列名称)
    )
    ```
  * 删除外键：
    * `alter table 表名 drop foreign key 外键名称;
  * 添加外键：
    * `alter table 表名 add constraint 外键名称 foreign key (外键列名) references 主表名称(主表列名称)
  * 级联操作
      * on update cascade
      * on delete cascade

## 数据库的设计

1. 多表之间的关系
   1. 分类：
      1. 一对一
      2. 一对多
      3. 多对多
   2. 实现关系:
      1. 一对多：在多的一方建立外键，指向一的一方的主键
      2. 多对多：借助中间表；中间表至少包含两个字段，这两个字段作为第三张表的外键，分别指向两张表的主键
      3. 一对一：
2. 数据库设计的范式
   1. 设计数据库时，需要遵循的一些范式
   2. 分类：
      1. 第一范式（1NF）：每一列都是不可分割的原子数据项
      2. 第二范式（2NF）：在1NF基础上，非码属性必须完全依赖于码
         1. 函数依赖：A-->b,若通过A属性（属性组）的值，可以确定唯一B属性的值。则称B依赖于A
         2. 完全函数依赖：A-->B，如果A是一个属性组，则B属性值的确定需要依赖于A属性组中所有的属性值。
         3. 部分函数依赖：A-->B，如果A是一个属性组，则B属性值的确定需要依赖于A属性组中部分属性值。
         4. 传递函数依赖：A-->B, B-->C，则C间接依赖于A，且A!-->C
         5. 码：若在一张表中，一个属性或属性组，被其他所有属性所完全依赖，则称这个属性（属性值）为该表的码。
      3. 第三范式（3NF）：在2NF基础上，任何非主属性不依赖于其他非主属性（消除传递函数依赖）

## 数据库的备份和还原

1. 命令行
   1. `mysqldump -u<user> -p<password> <dbName> > <dir>`
   2. 还原
      1. 登录数据库
      2. 创建数据库
      3. 使用数据库
      4. 执行文件，`source <dir>`


## 多表查询

1. 内链接查询:
   1. 隐式内连接：使用where条件清楚无用数据
        ```sql
        select
            t1.name
        from
            emp t1,
            dept t2
        where
            t1.dept_id = t2.id;
        ```
   2. 显示内连接：
      1. `select * from emp inner join dept on emp.id = dept.id`
   3. 内连接查询：
      1. 从那些表中查询数据
      2. 条件是什么
      3. 查询哪些字段
2. 外链接查询：
      1. `select t1.*, t2.* from t1 left [outer] join t2 on 条件;`查询的是左表所有数据以及其交集部分。
      2. `select t1.*, t2.* from t2 right [outer] join t2 on 条件；`查询的是右表所有数据以及其交集部分
3. 子查询：
   1. 概念：查询中嵌套查询，嵌套的查询就是子查询
   2. 子查询不同情况
      1. 子查询结果是单行单列，它可作为条件，使用运算符去判断。运算符：>,<,>=,<=,=
      2. 子查询结果是多行单列，子查询可作为条件，使用运算符IN来判断；
      3. 子查询的结果是多行多列，子查询可作为**虚拟表**。


## 事务

1. 基本介绍
   1. 一个包含多个步骤的业务被事务管理，那么这些操作要么同时成功，要么同时失败。
2. 操作
   1. start transaction
   2. rollback
   3. commit
   4. mysql默认自动提交事务
      1. 查看事务的默认提交方式：`select @@autocommit; --1 自动， --0 手动`;
      2. 修改默认提交方式：`set @@autocommit = 0`
3. 事务的四大特征
   1. 原子性：是不可分割的最小操作单位，要么同时成功，要么同时失败；
   2. 持久性：当事务提交或回滚后，数据库会持久化的保存数据；
   3. 隔离性：多个事务，相互独立；
   4. 一致性：事务操作前后，数据总量不变;
4. 事务的隔离等级
   1. 概念：多个事务操作同一批数据，则会引发一些问题，设置不同的隔离级别可解决该问题。
      1. 脏读：一个事务，读取到另一个事务中没有提交的数据
      2. 不可重复读（虚读）：在同一个事务中，两次读取到的数据不一样。
      3. 幻读：一个事务操作（DML）数据表中所有记录，另一个事务添加了一条数据，则第一个事务查询不到自己的修改。
   2. 隔离级别：
      1. read uncommitted：读未提交
         1. 产生的问题：脏读、不可重复读、幻读
      2. read committed：读已提交(oracle)
         1. 产生的问题：不可重复读、幻读
      3. repeated read：可重复读(mysql)
         1. 产生的问题：幻读
      4. serializable：串行化
         1. 可以解决所有的问题
      * 隔离级别从小到大安全性越来越高，但效率越来越低
      * 数据库查询隔离界别:
        * `select @@tx_isolation;
      * 数据库设置隔离级别：
        * `set global transaction isolation level 级别字符串;`

## DCL

1. 管理用户
   1. 添加用户
      1. `create user <用户名>@<主机名> identified by <密码>`;
   2. 删除用户
      1. `drop user <用户名>@<主机号>`
   3. 查询用户
      1. `use mysql;`
      2. `select * from user;`
   4. 修改密码：
      1. `update user set password = password('new password') where user = 'username';`
      2. `set password for 'username'@'host' = password('newpassword');`
      3. 忘记root密码
         1. net stop mysql
         2. mysql --skip-grant-tables
         3. mysql + enter
         4. user mysql;
         5. update user set password = password('new password') where user = 'root';
         6. task manager, 关闭 mysqld.exe
         7. 启动mysql服务
   5. 授权：
      1. 查询权限
         1. show grant for 'user'@'host';
      2. 授予权限
         1. `grant 权限列表 on 数据库名.表名 to 'username'@'host';`
         2. 授予所有权限：`grant all on *.* to 'username'@'host';`
      3. 撤销权限
         1. `revoke 权限列表 on 数据库名.表名 from 'username'@'host';`

## JDBC

* Java Database Connectivity Java 数据据连接
* 本质：定义了了操作所有关系型数据库的规则（接口），各个数据库厂商去实现这套接口，提供数据库驱动jar包。我们可以使用这套接口（JDBC）编程，真正执行的代码时jar包中的实现类

* 快速入门
  1. 导入驱动jar包
     1. 复制mysql-connector-java-version-bin.jar到项目的libs目录下
     2. add as library
  2. 注册驱动
  3. 获取数据库连接对象Connection
  4. 定义SQL
  5. 获取执行SQL语句的对象Statement
  6. 执行SQL，接受返回结果
  7. 处理结果
  8. 释放资源

* 详解：
  1. DriverManager：驱动管理对象
     1. 功能：
        1. 注册驱动: 告诉程序该使用哪一个数据库驱动jar
            ```java
            //attention:mysql5后的驱动jar包可省略注册驱动的步骤
            static void registerDriver(Driver driver);
            Class.forname("com.mysql.jdbc.Driver");//写代码时使用
            //在"com.mysql.jdbc.Driver"类中存在静态代码块
            static {
                try {
                    java.sql.DriverManager.registerDriver(new Driver());
                } catch {
                    throw new RuntimeException("Can't register driver!");
                }
            }
            ```
        2. 获取数据库连接：
           1. `static Connection getConnection(String url, String user, String password)`
           2. 参数：
              1. url：指定连接的路径
                 1. 语法：`jdbc:mysql://ip(域名):port/database`
              2. user
              3. password
  2. Connection：数据库连接对象
     1. 功能：
        1. 获取执行SQL的对象
           1. `Statement createStatenment()`
           2. `PreparedStatement prepareStatement(String sql)`
     2. 管理事务
        1. 开启事务：`void setAutoCommit(boolean autoCommit)`:调用该方法设置参数为false，即开启事务
        2. 提交事务：`commit()`
        3. 回滚：`rollback()`
  3. Statement:执行sql对象
     1. `boolean execute(String sql)`可执行任意的sql语句
     2. `int executeUpadate(String sql)`执行DML（insert,update,delete),DDL(create, alter, drop));返回影响行数
     3. `ResultSet executeQuery(String sql)`：执行DQL(select)语句；
  4. ResultSet:结果集对象，封装结果信息
     1. `next();`游标向下移一行
     2. `getXXX(param)`获取数据，
        1. xxx表示数据类型
        2. param：
           1. int: 代表列的编号，从1开始
           2. String: 代表列名称 
     3. attention:
        1. 游标向下一行
        2. 判断是否有数据
        3. 获取数据
  5. PreparedStatement:执行sql的对象
     1. SQL注入问题：在拼接SQL时，一些SQL特殊关键字参与字符串的拼接，会造成安全性问题。
        1. 解决：使用PreparedStatement解决
     2. 预编译的SQL：参数使用？作为占位符
     3. 步骤：
        1. 导入jar包
        2. 注册驱动
        3. 获取数据库连接Connection
        4. 定义sql： sql参数使用?作为占位符
        5. 获取执行sql语句的对象PreparedStatement
        6. 给?赋值
           1. pstmt.setXXX(index, param);
        7. 执行sql
        8. 处理结果
        9.  释放资源
     4. 优势：
        1. 防止sql注入
        2. 效率更高

## 抽取JDBC工具类：JDBCUTILS

* 目的：简化书写
* 分析：
  1. 注册驱动抽取
  2. 抽取一个方法获取连接对象
     1. 通过配置文件保证工具类的通用性，不必传递参数
  3. 抽取一个方法释放资源


## JDBC控制事务：

* 使用Connection对象管理事务
  1. 开启事务：setAutoCommit(boolean autoCommit):调用该方法设置参数为false，即开启事务
  2. 提交事务：commit()
  3. 回滚事务：rollback()

## 数据库连接池

* 概念：其实是一个容器（集合），存放数据库连接的容器
* 好处：
  * 节约资源
  * 高效
* 实现：
  1. 标准接口：DataSource 
     1. 方法：
        * 获取连接：`getConnection()`
        * 归还连接：如果连接对象Connection是从连接池中获取的，那么调用Connection.close()不会关闭连接而是归还。
  2. 实现技术
     1. C3P0：数据库连接池技术
     2. Druid：数据库连接池技术

1. C3P0:
   * 步骤：
     1. 导入jar包（两个），c3p0-version.jar, machange-commons-java-0.2.12.jar，不要忘记导入数据库驱动jar包
     2. 定义配置文件：
        * 名称：c3p0.properties or c3p0-config.xml
          * 在config.xml中的jdbcURL加上`useSSL=false`
        * 路径：将文件放在src目录下即可
     3. 创建核心对象 数据库连接池对象 ComboPooledDataSource`DataSource ds = new ComboPooledDataSource();`
     4. 获取连接：getConnection `Connection conn = ds.getConnection();`
2. Druid:
   1. 步骤
      1. 导入jar包 druid-1.09.jar
      2. 定义配置文件
         1. 是properties形式
         2. 可以是任意名称，任意路径
      3. 获取数据库连接池对象：通过工厂类来获取 