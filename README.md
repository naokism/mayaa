mayaa
=====

[mayaa](http://mayaa.seasar.org)用の独自プロセッサ  
既存のAttributeProcessorではnameに式言語を使えないので、
式言語を使えるように拡張しました。

jarの作成

    mvn jar:jar

作成できたjarファイルを対象のプロジェクトのlibにコピーします。
利用する際にはmayaaファイルに以下のようにnamespaceの設定が必要です。

    <?xml version="1.0" encoding="UTF-8"?>
    <m:mayaa xmlns:m="http://mayaa.seasar.org" xmlns:n="http://com.github.naokism/mayaa">

	    <m:echo id="test">
		    <n:attribute name="${xxxxxx}" value="hoge"/>
	    </m:echo>

    </m:mayaa>
