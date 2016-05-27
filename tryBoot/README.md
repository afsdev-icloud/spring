# tryBoot
Spring Bootを使ってみよう （2016年5月）

## 開発環境
下記の環境で開発および動作を確認しています。

* Windows7 (64bit)
* Java 1.8.0_74
* Spring Boot 1.3.5
* Thymeleaf 2.1.4
* Eclipse 4.5
* Eclipse plugin STS(Spring Tool Suite)
* SQLite 3.8.11

## テーブル
* person （sample.db）

|フィールド名      |データ型   |フィールドコメント     |
|:-----------------|:----------|:----------------------|
|id                |INTEGER    |ID                     |
|name              |TEXT       |名前                   |



## 試し方

---
### Hello Spring Boot

* http://localhost:8080/
* テキストボックスに「田中」を入力する

```
こんにちは 田中 さん !
```

---
### パスパラメータの取得

* http://localhost:8080/Param1/鈴木

```
こんにちは 鈴木 さん !
```

---
### クエリパラメータの取得

* http://localhost:8080/Param2?code=STS11&code=SVN21

```
{code=[STS11, SVN21]}
```

---
### データベースの検索（JDBC）

* http://localhost:8080/Jdbc

```
Id Name
1  佐藤 
2  鈴木 
3  田中 
```

---
### メールの送信

* application.properties にspring.mailの設定をする
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=xxxx@gmail.com
spring.mail.password=....
```

* http://localhost:8080/BootMail
* テキストボックスにメールの宛先、件名、本文を入力する

```
送信完了！
```

