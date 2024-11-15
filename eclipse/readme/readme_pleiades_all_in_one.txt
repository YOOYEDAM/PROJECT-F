━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Pleiades All in One 4.6 (Eclipse 4.6 Neon Windows ベース)
──────────────────────────────────────────────────
URL    : http://mergedoc.osdn.jp/
MAIL   : kashihara @ me.com
AUTHOR : Shinji Kashihara
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Pleiades All in One は開発対象となる言語によりパッケージを選択できる日本語 Eclipse ディストリビュー
ションです。インストールはダウンロードした zip ファイルを解凍するだけです。


ライセンス
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Pleiades 本体は EPL です。その他のプラグイン、ソフトウェアについては、それに含まれるライセンスの
記述を参照してください。


履歴
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

4.6.3.v20170422

・ビルド失敗により Java 8 が壊れていたため、再リリース

4.6.3.v20170421

・Pleiades 更新: MANIFEST.MF や plugin.xml が開けない問題に対応
・Java、Tomcat 更新
・Subversive 更新

4.6.3.v20170323

・Eclipse 4.6.3、各ランタイム、プラグインの更新
・PHP 版に Composer プラグイン追加

4.6.2.v20161221

・Mac 版 Pleiades All in One 追加
・Eclipse 4.6.2、各ランタイム、プラグインの更新

・自動デフォルト設定追加・変更
・コンテンツ・タイプのテキストに *.csv 追加 (BOM 検出対応)
　Windows 版ターミナル・ビューのフォントを Consolas に変更 (Windows で文字が重なるのを回避)
　Mac 版テキスト・エディターのフォントを Monaco から Menlo に変更
　Mac 版プラグイン・スパイのショートカットを ⌥⌘F1 から ⌥⇧F1 に変更

4.6.1.v20161018

・Neon 1a 緊急リリースに伴う更新 (以下の深刻なバグが修正)
　・jar などにシステム・エディターを関連付けたときに NPE が止まらなくなる
　・EGit BASIC 認証不具合

4.6.1.v20160928

・PHP、Python 版の DBViewer 削除 (Ctrl+C などのショートカットが効かなくなる不具合暫定対応)
・Eclipse 4.6.1、各ランタイム、プラグインの更新
　Glance プラグイン：長時間使用するとステータスバーがフリーズする問題を修正
　Autodetect Encoding プラグイン：文字コードの自動検出機能を追加 (デフォルトは OFF)

・自動デフォルト設定追加・変更
　一般 > ヒープ・ステータスを表示：ON ⇒ OFF (高速化)
　一般 > Glance 検索 > 強調表示：黄色 ⇒ 明るい緑
　一般 > Glance 検索 > 始動時に表示：OFF ⇒ ON
　一般 > キー > 以下のキーバインドを追加
　　ズームイン　： Ctrl+Numpad_subtract(テンキーの-)、Ctrl+;
　　ズームアウト： Ctrl+Numpad_Add(テンキーの+)
　Java > エディター > 構文の色指定 > Java > キーワード 'return'：下線 OFF ⇒ ON
　Javadoc の生成ウィザード > 追加の Javadoc オプション： -encoding UTF-8 -charset UTF-8

4.6.0.v20160622

・Eclipse 4.6 Neon 対応、各ランタイム・プラグインのバージョンアップ
・プラグイン追加 LiveReload、MoonRise UI テーマ、Encoding StatusBar
・プラグイン変更 Jadclipse (Jad + JD-Core) → Eclipse Class Decompiler
・プラグイン削除 Sysdeo Tomcat Plugin、Limy Code、JStyle (Pleiades AOP により空白文字表記変更)
・XAMPP と PHP をバージョンアップ 1.8.2-6 (PHP 5.4.31) → 5.6.21
・XAMPP コントロールパネルの日本語化

・自動デフォルト設定追加・変更
　一般 > エディター > テキスト・エディター : 空白文字を表示 ON
　　可視性の確認 : 空白 OFF、透過レベル 80 → 60
　一般 > エディター > ファイルの関連付け : *.properties > 関連付けられたエディター :
　　プロパティー・ファイル・エディター
　一般 > コンテンツ・タイプ : Java プロパティー・ファイル > デフォルト・エンコード UTF-8
　一般 > 外観 > 色とフォント : 基本 > テキスト・エディター・ブロック選択フォント 9
　Java > デバッグ :
　　ホット・コード置換に失敗したときにエラーを表示 OFF
　　ホット・コードの置換がサポートされていない場合にエラーを表示 OFF
　Java > 逆コンパイラー :
　　デフォルト逆コンパイラ FernFlower
　　逆コンパイル・レポートを表示 ON
　　オリジナル行番号をコメントとして出力 ON
　　デバッグのためにコードをそろえる ON
　　メジャー・バージョン更新の確認 OFF
　JSON > JSON ファイル > エディター > 構文の色の指定 : 文字列値 > 斜体 OFF
　検証 : JSON バリデーター OFF
