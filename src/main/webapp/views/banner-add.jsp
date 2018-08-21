<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/js_common.jsp" %>
<!DOCTYPE html><html><head>
<title>Bootstrap 实例 - 内联表单</title>
<%--<link rel="stylesheet" href="//apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">--%>
<%--<script src="//apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
<%--<script src="//apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>--%>
</head>
<body>
<form class="form-inline" role="form" id="inputForm">
    <div class="form-group">
        <label class="sr-only" for="name">名称</label>
        <input type="text" class="form-control" id="name" name="name"
               placeholder="请输入名称">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox" name="choice"> 请打勾 </label>
    </div>
    <button type="button" class="btn btn-primary" id="ctb">确定</button>
    <%--<button type="submit" class="btn btn-default">提交</button>--%>
</form>
</body>
</html>
<script>

    $(function () {
        $.fn.serializeJson = function () {
            console.log($.isArray(this));
            var serializeObj = {};
            var array = this.serializeArray();
            $(array).each(
                function () {
                    if (serializeObj[this.name]) {
                        if ($.isArray(serializeObj[this.name])) {
                            serializeObj[this.name].push(this.value);
                        } else {
                            serializeObj[this.name] = [
                                serializeObj[this.name], this.value];
                        }
                    } else {
                        serializeObj[this.name] = this.value;
                    }
                });
            return serializeObj;
        };
    });

    $("#ctb").click(function () {
        var url = '${request.contextPath}/banner';
        var json = $("#inputForm").serializeJson();
        $.ajax({
            type: "POST",
            url: url,
            data: JSON.stringify(json),// 你的formid
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                alert(data);
//                if (data.isSuccess == true) {
//                    parent.$('#returnValue').val("success");
//                    parent.layer.close(index);
//                } else {
//                    layer.close(loadIndex);
//                    layer.alert(data.msg);
//                }
            }
        });
    });


</script>