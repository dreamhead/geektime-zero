# Geektime Zero

## 简介

这是《极客时间》专栏《10x 程序员工作法》的《30 | 一个好的项目自动化应该是什么样子的？》中的示例项目，目的是演示基本的项目自动化。

## 基本用法

* 生成 IDEA 工程

```shell
./gradlew idea
```

* 检查

```shell
./gradlew check
```

* 数据库迁移

```shell
./gradlew flywayMigrate
```

* 生成构建产物

```shell
./gradlew build
```

* 运行应用

```shell
./gradlew bootRun
```