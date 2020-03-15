
# 安装
## 下载
## 安装

# 环境搭建
## Java Envelopment Setting
   * JAVA_HOME 和 Path 设置
   
      + Windows  - 后续完善
      ```txt
      JAVA_HOME=
	    Path=;%JAVA_HOME%\bin
      ```
      + MacOs  -  待补充
   * Eclipse Preference 的 Installed Java JREs
      + 步骤
         - Windows --> Preferences --> Java --> Installed JREs --> Add --> 选择：C:\Program Files\Java\jdk1.8.0_xxx --> Ok
         - MacOS 将 jdk 路径 设置 为 Linux 格式
   * 包管理插件（plugin）的安装与设置
      1. Ant plugin 的安装与设置 --> Ant 已经式微了，不知会不会 咸鱼翻身--一切皆有可能。。。
         + 步骤
            a. 打开Eclipse，点击导航栏的"Window"-->"Preferences"-->"Ant", 点击：Add Ant Home
            b. set ANT_HOME=E:\Softwares\Apache\Ant\apache-ant-x.x.x
            c. 打开Ant项目 --> 参考：3.Eclipse_升级_项目导入.txt
      2. Maven plugin
         + 步骤
	    a. 网址
	       - http://maven.apache.org/  --> https://maven.apache.org/ide.html --> http://www.eclipse.org/m2e/ --> 不知是否还是这样。。年代久远了
