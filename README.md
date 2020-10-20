README.md

## *Tasking*

![](/Users/junbin/Downloads/增长黑马Tasking.jpg)

## 技术方案

### *前端*

* HTML

* CSS

* JavaScript

* React  

* Redux（有难度）

### *后端*

* Java

* SpringBoot

* Mysql

* Hibernate

* Gradle

* Jackson

* Lombok

## *开发工具*

* IDEA
* PostMan
* Typora 
* VsCode 
* Sequel Ace 数据库连接工具
* Gitmind 脑图工具

## *功能需求*

- 用户

  - 一.平台主页

    - 1.打开链接，显示平台首页

      - 导航栏

        - 平台名字

        - 首页

        - 商品（点击，进入商品展示页面，展示所有公司的商品）

        - 购物车
          - （点击购物车，若用户未登录，跳转到登录页面；若已登录，则跳转到购物车页面）

        - 登录

        - 注册

      - 主要内容

        - 三个公司的页面链接（待定）

          - （用户不登录也可以点击三个不同公司页面链接，浏览商品）

          - 进入不同的公司页面，展示该公司商品

  - 二.用户登录与注册

    - 1.用户登录需要输入用户名和密码

    - 2.新用户注册需要填写用户名、密码

    - 3.需要校验用户名是否重复，密码是否正确，若正确，则注册成功，奖励一张A公司的优惠券

  - 三.购买商品

    - 1.点击商品导航栏，进入商品展示页面，
      - （若用户未登录时，跳转到登录页面；若处于登录状态，则可以正常购买）

    - 2.当用户浏览商品时，可以选择将某件商品放入购物车

    - 3.用户可以浏览购物车，看到自己加入购物车的商品

    - 4.在购物车中点击结账之后，跳转到支付界面，进行支付，可以使用优惠券

    - 5.支付完成后，清空购物车，同时商品库存相应地减少

    - 6.生成订单，存入数据库

    - 商品展示页面（商品依次排列）

      - 商品图片

      - 商品名称

      - 商品价格

      - 公司名称

      - 查看商品详情按钮

      - 购买按钮

    - 商品详情页面

      - 左侧
        - 商品图片

      - 右侧

        - 商品名称

        - 商品编码

        - 商品型号

        - 商品价格

        - 商品简介

        - 加入购物车按钮

    - 购物车页面

      - 商品栏 （展示商品信息）

      - 按钮（继续购买，清空购物车，结账）

    - 支付页面

      - 商品信息（名称、型号、编码、价格、数量）

      - 订单金额（总金额）

      - 优惠券信息

      - 按钮（返回购物车修改、确认按钮）

  - 四.B公司独有功能

    - 1.任务页面

      - 用户根据页面提示和说明，完成任务，熟悉平台一些特定功能，奖励用户B公司的优惠券。

        - 说明

        - 提示

        - 任务内容

        - 按钮（提交任务答案）

    - 2.兑换页面
      - 用户可以使用优惠劵兑换高级功能（例如：）

  - 五.C公司独有功能

    - 用户浏览对应商品超过一定时长，出现中奖页面，领取当前商品优惠券。

      - 1.中奖页面

        - 优惠券信息

        - 领取按钮

- 管理员

  - 一.打开链接，显示管理员登陆界面

    - 1.管理员登录需要用户名和密码

    - 2.需要校验用户名是否正确，密码是否正确，若正确，则进入管理员主页面

  - 二.管理员主页面

    - 选择栏

      - 用户管理

        - 展示（编号、账号、名称）

        - 设置表签

      - 优惠券管理

        - 优惠券列表
          - 展示（编号、名称、时间、金额、公司、 备注）

        - 添加优惠券
          - 设置名称、时间、金额、公司、备注

      - 财务管理
        - 显示活动开销成本、利润

      - 订单管理
        - 显示订单信息（时间、编号、金额、状态、收件人、操作）

      - 运营管理

        - 显示了解活动的人数、活动参与人数、获取优惠券人数

        - 添加任务（任务提示、说明、内容、奖励）

      - 商品管理

        - 显示商品信息（ID、 名称、型号、编码、库存、价格、操作（修改））

          - 修改页面

            - 商品名称

            - 商品价格

            - 商品编码

            - 商品型号

            - 商品库存

            - 封面图片

            - 商品介绍

            - 保存按钮

        - 添加按钮

          - 添加页面

            - 商品名称
            - 商品价格
            - 商品编码
            - 商品型号
            - 商品库存
            - 封面图片
            - 商品介绍
            - 保存按钮

![](/Users/junbin/Downloads/功能需求结构.png)



