# work
## 設計の前提
* テーブルの構造が生徒情報の格納かつ、カラムにログインIDがあることから何かしらのポータルサイトシステムに使用されるテーブルと推測した
* 上記を前提に設計に落としていく

## 課題1
* データベース名：schooldb
* テーブル名：student / 生徒

| カラム名 | データ型 | NULL | Key | Default | Extra | コメント |
| --- | --- | --- | --- | --- | --- | --- |
| teacher_id   | int unsigned | NO   |     | NULL    |                | 教師ID
| student_id   | int unsigned | NO   | PRI | NULL    | auto_increment | 生徒ID
| student_name | varchar(255) | NO   |     | NULL    |                | 生徒名
| login_id     | varchar(255) | NO   | UNI | NULL    |                | ログインID
| class_id     | int unsigned | NO   |     | NULL    |                | クラスID
| class_name   | varchar(255) | NO   |     | NULL    |                | クラス名
| created_at   | datetime     | NO   |     | NULL    |                | 作成日時
| updated_at   | datetime     | NO   |     | NULL    |                | 更新日時

* 設計補足
 * テーブル構造からstudent_idがPrimary Keyであると考えたため、Primary Keyに設定
 * login_idは認証時に使用されるIDであると考えたためユニーク制約を追加
 * pdfの表にはなかったが、今後クラス替えや。教師の変更等が考えられるためタイムスタンプとしてcreated_atとupdated_atカラムを追加した
 * 教師IDやクラスIDは別なテーブルの外部キーに見えるが判然としないため、外部参照はさせない

## 課題2
### システムアーキテクチャ
* webサーバ：Apache 2.4
* アプリケーションサーバ：Tomcat 9.0
 * 耐障害性や負荷分散を考慮して、アプリケーションサーバのTomcatだけでなくwebサーバのApacheも使う
 * ApacheとTomcatの間はajpで通信させる

### アプリケーションアーキテクチャ
* 今回はjavaでSpring Bootを用いて実装を行う方針のためMVCに則りつつ、一部クリーンアーキテクチャの概念を盛り込む
  * Entity：データベースのデータを表現する
  * Repository：データベースへの問い合わせを行う
  * Service：ビジネスロジックを表現する
  * Request：クライアントからのリクエスト内容を表現する。リクエストのチェックもここで行う
  * Response：クライアントへのレスポンス内容を表現する
  * OutputBoundary：実際にクライアントに返却されるレスポンスを表現する
  * Controller：クライアントからのリクエストの受領とレスポンスの返却を行う

### 残課題
* SSL対応が間に合わなかった