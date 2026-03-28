# Java DVD App

Java + JDBC로 만든 콘솔 기반 DVD 관리 앱.

**Tech:** Java, JDBC, MySQL, Maven

## Package Structure

```
com.study.dvd/
├── main/       # DVDApplication (entry point)
├── db/         # DBConnectionMgr, DBConfig
├── entity/     # DVD, Producer, Publisher
├── dao/        # DVDDao (CRUD queries)
└── views/      # DVDListView, DVDDetailView, DVDAddView, DVDDeleteView
```

## Setup

`DBConfig.java`는 버전 관리에서 제외되어 있습니다. 실행 전 직접 값을 채워주세요:

```java
public static final String URL = "jdbc:mysql://localhost:3306/your_database";
public static final String USERNAME = "your_username";
public static final String PASSWORD = "your_password";
```
