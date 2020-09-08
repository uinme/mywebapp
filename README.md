# Mywebapp

## Preview toolの使い方

このツールは、`war` ファイルを実際に Web ブラウザ上で確認するためのものです。

### 1. プレビュー環境の構築

`preview_tool` ディレクトリー下の `Build.cmd` をダブルクリックして実行してください。
このバッチ処理では、OpenJDKの実行環境とTomcatをダウンロードし、解凍と配置を行ないます。

### 2. Tomcatサーバーの起動

`preview_tool/startup.cmd` をダブルクリックして `Tomcat` サーバーを起動します。

### 3. warファイルの配置

[Releases](https://github.com/uinme/mywebapp/releases)からダウンロードした
 `war` ファイルを `tomcat/apache-tomcat-*.*.**/webapps` にコピーまたは移動
してください。

しばらくすると、warファイルが `Tomcat` によって展開され、閲覧の準備が整います。

### 4. Webブラウザからアクセスする

Webブラウザを開いて、`http://localhost:8080/mywebapp/index` にアクセスしてください。

### 5. Tomcatサーバーを終了する

`preview_tool/shutdown.cmd` をダブルクリックしてくだだい。自動的にサーバーが終了します。
