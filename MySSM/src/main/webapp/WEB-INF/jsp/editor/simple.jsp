<%--
  Created by IntelliJ IDEA.
  User: hly
  Date: 2018/8/15
  Time: 16:17
  github :github.com/SiriusHly
  blog :blog.csdn.net/Sirius_hly
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();%>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>Simple example - Editor.md examples</title>
    <link rel="stylesheet" href="<%=path%>/static/html/editor/editor.md-master/examples/css/style.css"/>
    <link rel="stylesheet" href="<%=path%>/static/html/editor/editor.md-master/css/editormd.css"/>
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
</head>
<body>
<div id="layout">
    <header>
        <h1>Simple example</h1>
    </header>
    <div id="test-editormd">
        <textarea style="display:none;"></textarea>
        <textarea class="editor-md-html" name="editor-md-html"></textarea>
    </div>
</div>
<script src="<%=path%>/static/html/editor/editor.md-master/examples/js/jquery.min.js"></script>
<script src="<%=path%>/static/html/editor/editor.md-master/editormd.min.js"></script>
<script type="text/javascript">
    var testEditor;

    $(function () {
        testEditor = editormd("test-editormd", {
            width: "70%",//编辑器大小官方默认90%
            height: 640,
            syncScrolling: "single",
            path: "<%=path%>/static/html/editor/editor.md-master/lib/",
            saveHTMLToTextarea : true,//注意3：这个配置，textarea可以提交

            emoji: true,//emoji表情，默认关闭
            /**上传图片相关配置如下*/
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "<%=path%>/fileUpload/editorMDUpload",//注意你后端的上传图片服务地址
            onload: function () { //上传成功之后的回调

            },


            //editorTheme: "pastel-on-dark",//编辑器的主题颜色
            theme: "gray",//顶部的主题
            previewTheme: "dark"//显示的主题

            //editor.md期望得到一个json格式的上传后的返回值，格式是这样的：
            /*
            {
                success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
                message : "提示的信息，上传成功或上传失败及错误信息等。",
                url     : "图片地址"        // 上传成功时才返回
            }
            */

        });

        /*
        // or
        testEditor = editormd({
            id      : "test-editormd",
            width   : "90%",
            height  : 640,
            path    : "../lib/"
        });
        */
    });
</script>
</body>
</html>