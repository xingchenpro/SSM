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
    <link rel="stylesheet" href="<%=path%>/static/assets/js/jquery-3.1.1.js"/>
    <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon"/>
</head>
<body>
<div id="layout">
    <header></header>

    <%--页面提交表单内容--%>
    <form id="my-editor-form">

        <input type="text" placeholder="请输入标题" id="title" name="title" autocomplete="off" >
        <input name="my_submit" id="my_submit" value="提交" type="button">
    <div id="test-editormd">
        <textarea class="editormd-markdown-textarea" id="editor-md-doc" name="editor-md-doc" style="display:none;"></textarea>
        <textarea class="editormd-html-textarea" id="editor-md-html" name="editor-md-html"></textarea>
    </div>
    </form>
</div>
<script src="<%=path%>/static/html/editor/editor.md-master/examples/js/jquery.min.js"></script>
<script src="<%=path%>/static/html/editor/editor.md-master/editormd.min.js"></script>
<script>

    $("#my_submit").click(function () {
        alert("正在提交");
        submit_atricle();
    })

    function submit_atricle() {
        var title = $("#title").val();
        var htmlContent = $("#editor-md-html").val();
        var markdownContent = $("#editor-md-doc").val();
        $.ajax({
            url:"<%=path%>/fileUpload/editorContent",
            data:JSON.stringify({title:title,htmlContent:htmlContent,markdownContent:markdownContent}),
            type:"POST",
            contentType:'application/json',
            success:function () {
                alert("发布成功");
            },
            error:function () {
                alert("发布失败");
            }
        })
    }
</script>
<script type="text/javascript">
    var testEditor;

    $(function () {
        testEditor = editormd("test-editormd", {/*上面div的值*/
            width: "70%",//编辑器大小官方默认90%
            height: 640,
            syncScrolling: "single",
            path: "<%=path%>/static/html/editor/editor.md-master/lib/",
            saveHTMLToTextarea : true,//注意3：这个配置，textarea可以提交

            emoji: true,//emoji表情，默认关闭
            tocm : true, // Using [TOCM]
            tex : true, // 开启科学公式TeX语言支持，默认关闭
            flowChart : true, // 开启流程图支持，默认关闭
            /**上传图片相关配置如下*/
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "<%=path%>/fileUpload/editorMDUpload",//注意你后端的上传图片服务地址
            onload: function () { //上传成功之后的回调

            },

            //editorTheme: "pastel-on-dark",//编辑器的主题颜色
            theme: "gray",//顶部的主题
            previewTheme: "dark"//显示的主题

        });

    });
</script>
</body>
</html>