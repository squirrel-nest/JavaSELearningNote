# JavaSE Learning Note
   * 参考
      + ✨✨✨[The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/)
      + ✨✨✨[The Java® Language Specification - Java SE 14 Edition](https://docs.oracle.com/javase/specs/jls/se14/jls14.pdf) - **Specification(Technical Standard) of Java Language**<br>
         - [Specification Homepage - 包含所有版本的规范](https://docs.oracle.com/javase/specs/index.html)<br>
      + ✨✨✨所有文档 - [JDK 14 Documentation](https://docs.oracle.com/javase/specs/jls/se14/jls14.pdf)<br>
         - API Specification - Version 14 --> [Java® Platform, Standard Edition & Java Development Kit
Version 14 API Specification](https://docs.oracle.com/en/java/javase/14/docs/api/index.html)<br>

   * YouTube
      + [Java Tutorial for Beginners](https://www.youtube.com/channel/UCxoUc7Rar2q90Gu0nT2ffuQ?sub_confirmation=1)<br>
   * GitHub
      + **如何在Github上浏览源代码：**[Navigating code on GitHub](https://help.github.com/en/github/managing-files-in-a-repository/navigating-code-on-github)<br>
      + [byhieg/JavaTutorial](https://github.com/byhieg/JavaTutorial)<br>
         - >该Java教程是学习Java过程中对Java知识点进行梳理。每一个包中的代码都有一个ReadMe来说明该包代码的作用以及知识点。 src包里面是Java的源码，test包里面是针对源码的测试
      + [JAVA-TUTORIAL](https://dunwu.github.io/javacore/#%E6%95%99%E7%A8%8B%E5%86%85%E5%AE%B9-%F0%9F%93%96) - 旧人旧思维，蛮放着参考一下<br>
      + [dunwu/java-tutorial](https://github.com/dunwu/java-tutorial) - 与上面一个同一内容<br>
      + [Kurento/kurento-tutorial-java](https://github.com/Kurento/kurento-tutorial-java)<br>
      + [redhat-developer-demos/istio-tutorial](https://github.com/redhat-developer-demos/istio-tutorial)<br>
   * 代码研究
      + [ActiveMQ Artemis 2.11.0 (January 15, 2020)](https://activemq.apache.org/components/artemis/download/)<br>
         - [Release Notes](https://activemq.apache.org/components/artemis/download/release-notes-2.11.0) | [Git Report](https://activemq.apache.org/components/artemis/download/commit-report-2.11.0) | [Documentation - Apache ActiveMQ Artemis User Manual](https://activemq.apache.org/components/artemis/documentation/latest)<br>
         - Source Code - [apache/activemq-artemis](https://github.com/apache/activemq-artemis/find/master)<br>

## 开发环境环境的安装与设置
### Eclipse
   * Eclipse的安装与设置参见：[EclipseInstallAndSettingNote](./EclipseInstallAndSettingNote.md)<br>
### IntelliJ IDEA
   * Eclipse的安装与设置参见：[IntelliJIdeaInstallAndSettingNote](IntelliJIdeaInstallAndSettingNote.md)<br>

## 预备知识
### Java的编译与运行（Command line tools）
   * 参考
      + [Tools and Commands Reference](https://docs.oracle.com/en/java/javase/12/tools/tools-and-command-reference.html)<br>
         - javac
            * >You can use the javac tool and its options to read Java class and interface definitions and compile them into bytecode and class files.
         - java
            * >You can use the java command to launch a Java application.
         - jar
            * > You can use the jar command to create an archive for classes and resources, and to manipulate or restore individual classes or resources from an archive.
      + JavaCC 
         - 参考
            * [Using JavaCC](https://cs.lmu.edu/~ray/notes/javacc/)<br>
               + >[JavaCC](http://javacc.java.net/) is a lexer and parser generator for LL(k) grammars. You specify a language's lexical and syntactic description in a JJ file, then run `javacc` on the JJ file. You will get seven java files as output, including a lexer and a parser.
                 >This page helps you get started using JavaCC. You still need to read the [online documentation](http://javacc.java.net/doc/docindex.html) to do anything really useful with the tool though.
   * Practice
      + javac 与 java 的 几点说明
         - classpath的位置 与 package的位置
            1. 例子
               a. classpath 为 文件夹： E:\JavaDev\00_JavaCode\JavaSELearningCode\lzdata-JavaBase\src\main\java
               b. 则 java 的运行方式
                  * ```
                      cd E:\JavaDev\00_JavaCode\JavaSELearningCode\lzdata-JavaBase\src\main\java
                      java -cp . com.lzsoft.lzdata.javabase.javabasic.getstarted.examples.HelloWorldApp
                    ```
### 包管理工具
   * Apache Ant™
      + 网址：[Apache Ant™](http://ant.apache.org/)<br>
         - <details>
              <summary>关于 Apache Ant 的说明</summary>
              <br>
              >Apache Ant is a Java library and command-line tool whose mission is to drive processes described in build files as targets and extension points dependent upon each other. The main known usage of Ant is the build of Java applications. Ant supplies a number of built-in tasks allowing to compile, assemble, test and run Java applications. Ant can also be used effectively to build non Java applications, for instance C or C++ applications. More generally, Ant can be used to pilot any type of process which can be described in terms of targets and tasks.
              <br>
              ><br>
              >Ant is written in Java. Users of Ant can develop their own "antlibs" containing Ant tasks and types, and are offered a large number of ready-made commercial or open-source "antlibs".<br>
              ><br>
              >Ant is extremely flexible and does not impose coding conventions or directory layouts to the Java projects which adopt it as a build tool.<br>
              ><br>
              >Software development projects looking for a solution combining build tool and dependency management can use Ant in combination with Apache Ivy.<br>
           </details>
   * Apache Maven
      + 网址：[Welcome to Apache Maven](http://maven.apache.org/)<br>
         - >Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
           >
           >If you think that Maven could help your project, you can find out more information in the "About Maven" section of the navigation: this includes an in-depth description of what Maven is and a list of some of its main features.
      + 参考
         - [MojoHaus: Build Helper Maven Plugin - Usage]()<br>
   * Gradle
      + 网址：[Gradle Build Tool](https://gradle.org/)<br>
         - >Gradle is an open-source build automation tool focused on flexibility and performance. Gradle build scripts are written using a Groovy or Kotlin DSL. Read about Gradle features to learn what is possible with Gradle.
         - 学习优先参考
            * [Gradle in Action](https://livebook.manning.com/book/gradle-in-action/about-this-book/) - 优先学习参考<br>
               + [Chapter 3. Building a Gradle project by example](https://livebook.manning.com/book/gradle-in-action/chapter-3/) - 参考其中的图解方式，非常棒！！，同时可以通过例子来学习。能够快速上手。。。<br>
                  - [maven pom文件标签详解](https://cloud.tencent.com/developer/article/1506527)<br>
                  - [maven中scope标签详解](https://www.voorp.com/a/maven%E4%B8%ADscope%E6%A0%87%E7%AD%BE%E8%AF%A6%E8%A7%A3%E5%9C%A8%E5%8A%AA%E5%8A%9B%E4%B8%B9CSDN%E5%8D%9A%E5%AE%A2)<br>
      + [Building Java Web Applications](https://guides.gradle.org/building-java-web-applications/)<br>
      + [Gradle for Java](https://hmkcode.com/gradle/gradle-for-java/)<br>
      + 参考
         - 高阶
            * [compilation-Destination-At compile time * How can I define the classpath in Gradle?](https://src-bin.com/ja/q/9ec852)<br>
            * [Spring Boot Gradle Plugin](https://www.baeldung.com/spring-boot-gradle-plugin)<br>



## Gradle 和 Maven项目的创建

## Java 的 Test 基础
   * 参考的学习资料
      + [jsonTuples: JSON Parser and Comparator in Java](https://dzone.com/articles/jsontuples-json-parser-and-comparator-in-java) - 这篇文章了解基本的测试方法。。，暂时。。<br>


## Java & Databases
   * 参考
      + [Java & Databases: An Overview of Libraries & APIs](https://www.marcobehler.com/guides/java-databases)<br>
      + Use a JDBC connection (default) - [Database Setup For MySQL](https://confluence.atlassian.com/doc/database-setup-for-mysql-128747.html)<br>
      + JavaEE的内容 - [Configuring a datasource connection](https://confluence.atlassian.com/doc/configuring-a-datasource-connection-937166084.html) - JNDI datasource<br>
   * JDBC Toturial
      + 参考 - 基本
         - 教程参考 - 这个教程步骤比较清晰：[How To Connect To A Database in Java? – JDBC Tutorial](https://www.edureka.co/blog/connect-mysql-database-in-java)<br>
         - 例子参考 - 这个例子也包含了Servlet和Jsp：[JSP Servlet JDBC MySQL Create Read Update Delete (CRUD) Example](https://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example)<br>

## 暂时不学的部分
   * Trails Covering the Basics
     + Getting Start<br>
     ["Hello World!" for the NetBeans IDE](https://docs.oracle.com/javase/tutorial/getStarted/cupojava/netbeans.html)
     + Deployment - 待后面学完，再回头学
     + Preparation for Java Programming Language Certification
   * Creating Graphical User Interfaces
     + 都不学
 ## 学习习惯
   * 
     
 ## 学习备忘
   * 远程开发：后续学习
   * tutorial放到tomcat服务器上
   * JAVA document 集成的使用
   * JAVA 与 Kotlin 的对照学习 - 养成习惯，这样学习Java的同时就能熟悉Kotlin的语法。。。
     + 笔记参考：[Kotlin Learning Note.md](https://github.com/squirrel-nest/KotlinLearningNote/blob/master/KotlinLearningNote.md)

## NetWork知识点
### 学到 RMI 时候，参考：[谁能用通俗的语言解释一下什么是 RPC 框架？](https://www.zhihu.com/question/25536695) - 粗粗了解即可，有时间看看，可看可不看<>
