# 系统开发工具及其技术简介

### **一、开发环境：**

 

  后端：
  开发工具：Intellij IDEA 2019年1月
  JDK版本： JDK8
  项目构建软件：MAVEN 3.3
  数据库：MYSQL 5.7
  服务器：TOMCAT 7.0

  前端：
  开发工具：
  Visual Studio Code
  JavaScript框架： Vue  v2.4
  运行环境
  node.js  v12.14.1
  主要组件：Element-UI
  模块加载器：
  WebPack v2.0

 

## **二、技术选型：**

开发搭建框架：  SpringBoot 2.1.6.RELEASE

​                             Spring  5.1.8.RELEASE

​                             Spring MVC 5.1.8.RELEASE

持久化框架：   Mybatis 1.3.2

数据库连接池： com.alibaba.druid 1.0.9

缓存技术：     Redis 4.0



# 三、主要实现功能：



## （1）权限管理：



<img src="https://github.com/1170159634/CollaborativeOfficeSystem/blob/master/images/1.png"  />

<img src="https://github.com/1170159634/CollaborativeOfficeSystem/blob/master/images/2.png"  />

无论是员工经理还是管理员，每个人的极别不同，为了方便开发 我们采用RBAC设计方案对每个用户的权限进行严格划分其在登录时，前端页面接受到后端权限相关信息，利用Vue特性 路由跳转给予用户可点击的页面，在访问与权限不符的页面，会出现空白。

当管理员在权限里关闭某个角色权限，那么相关角色人员在登录后自动关闭该权限相关的内容，进一步完善了公司的保密机制。

 

## （2）角色管理：

系统开发的所有功能将根据角色分配，可设定某个角色具有一些功能，与公司职位相吻合。 



## （3）人员管理:



录入新员工信息，对员工信息进行修改，删除员工信息，查询某位员工信息。

## （4）公告管理：

<img src="https://github.com/1170159634/CollaborativeOfficeSystem/blob/master/images/3.png"  />

上级发布公告，员工查看公告，设置公告阅读权限，修改公告内容，删除公告。

普通员工：查看极别相符的公告。

如果出现严重性错误，需要当前负责人员立马解决，可发送紧急消息，我们将以短信的形式发送给用户，必要情况下，我们会实现电话告警。

<img src="https://github.com/1170159634/CollaborativeOfficeSystem/blob/master/images/4.png"  />

## （5）文档管理：

文档包括：员工任务提交的文档，项目分配人员名单，办公事宜详细内容等等。





## （6）项目管理：

<img src="https://github.com/1170159634/CollaborativeOfficeSystem/blob/master/images/5.png"  />

管理员查看和发布新项目，交给项目负责人（项目经理）负责。

项目负责人分配项目任务给普通员工，更改项目内容，更改任务内容，取消任务。

普通员工提交项目任务，查看新任务。











