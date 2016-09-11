# exampleBoot
Spring BootとMyBatisで検索しよう （2016年5月）

## 開発環境
下記の環境で開発、及び動作の確認をしています。

* Windows7 (64bit)
* Java 1.8.0_74
* Spring Boot 1.3.5
* Thymeleaf 2.1.4
* Eclipse 4.5
* Eclipse plugin STS(Spring Tool Suite)
* SQLite 3.8.11
* Mybatis 3.4.0

## テーブル
* spaData （exampleSpa.db）

|フィールド名      |データ型   |フィールドコメント     |
|:-----------------|:----------|:----------------------|
|spaGroup          |TEXT       |温泉地                 |
|spaName           |TEXT       |施設名                 |
|stateCd           |TEXT       |県コード               |
|hotType           |TEXT       |泉質                   |
|hotTemp           |TEXT       |泉温                   |
|spaAddr           |TEXT       |住所                   |
|spaMemo           |TEXT       |メモ                   |


## 概要
* この例は、温泉情報の検索、及び登録をする機能となっています。
* 検索では、画面から条件を指定し、条件を満たす情報を一覧表示、選択されたデータの詳細表示を行います。
* 登録では、画面からの入力をチェックした後、DBへ保存しています。


## 使い方

### 検索

* http://localhost:8080/SpaInfo

* 検索の条件を入力する（県名[選択]、温泉地[任意]）　→〔検索〕
* 検索結果のリストが表示される
* ☆マークを選択　→ 詳細情報が表示される

---
### 登録

* http://localhost:8080/SpaInfo

* 〔登録〕を選択　→ 登録画面が表示される
* 情報を入力する　→〔登録〕
* 登録内容が表示される


