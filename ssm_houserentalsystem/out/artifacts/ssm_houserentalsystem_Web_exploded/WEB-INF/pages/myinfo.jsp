<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div class="wapper" style="width: 500px;margin-top: 40px">
    <fieldset class="layui-elem-field layui-field-title">
        <legend style="font-size: 26px">修改个人信息</legend>
    </fieldset>
    <form class="layui-form" action="updateUser" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户ID</label>
            <div class="layui-input-inline">
            	<input type="hidden" name="id" value="${loginUser.uID }">
                <input readonly type="text" name="uID" value="${loginUser.uID }" required lay-verify="required" placeholder="原密码" autocomplete="off"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登录名字</label>
            <div class="layui-input-inline">
                <input readonly type="text" name="uName" value="${loginUser.uName }" required lay-verify="required|pass" placeholder="请填写登录名字"
                       autocomplete="off"
                       class="layui-input" lay-verify="pass">
            </div>
         </div>
        <div class="layui-form-item">
            <label class="layui-form-label">电话号码</label>
            <div class="layui-input-inline">
                <input type="text" name="uPhoneNumber" value="${loginUser.uPhoneNumber }" lay-verify="required|pass" placeholder="请填写电话号码"
                       autocomplete="off"
                       class="layui-input">
            </div>
         </div>
          <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="uNickName" value="${loginUser.uNickName }" lay-verify="required|pass" placeholder="请填写昵称"
                       autocomplete="off"
                       class="layui-input">
            </div>
         </div>
           <div class="layui-form-item">
            <label class="layui-form-label">真实姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" value="${loginUser.name }" lay-verify="required|pass" placeholder="请填写真实姓名"
                       autocomplete="off"
                       class="layui-input">
            </div>
         </div>
           <div class="layui-form-item">
            <label class="layui-form-label">身份证</label>
            <div class="layui-input-inline">
                <input type="text" name="sid" value="${loginUser.sid }" lay-verify="required|pass" placeholder="请填写身份证"
                       autocomplete="off"
                       class="layui-input">
            </div>
         </div>
           <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" value="${loginUser.email }" lay-verify="required|pass" placeholder="请填写邮箱"
                       autocomplete="off"
                       class="layui-input">
            </div>
         </div>
           <div class="layui-form-item">
            <label class="layui-form-label">qq</label>
            <div class="layui-input-inline">
                <input type="text" name="qq" value="${loginUser.qq }" lay-verify="required|pass" placeholder="请填写qq"
                       autocomplete="off"
                       class="layui-input">
            </div>
         </div>
           <div class="layui-form-item">
            <label class="layui-form-label">微信</label>
            <div class="layui-input-inline">
                <input type="text" name="wechat" value="${loginUser.wechat }" lay-verify="required|pass" placeholder="请填写微信"
                       autocomplete="off"
                       class="layui-input">
            </div>
         </div>
            
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="updateuser">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script src="layui/layui.js"></script>
<script>
    layui.use(['element', 'form','layer'], function () {
  
        form.on('submit(updateuser)',function () {
            
        })
    });
</script>
</body>
</html>
