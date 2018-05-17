<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
              <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
              <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员中心--收获地址管理</title>
<link type="text/css" href="${ contextPath}/assets/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${ contextPath}/assets/js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${ contextPath}/assets/js/js.js"></script>
</head>
<body>
<div class="hrader" id="header">
  <div class="top">
   <a href="${ contextPath}/login" style="color:#C94E13;">请登录</a> 
   <a href="${ contextPath}/reg">注册</a>
   <ul class="topNav">
    <li><a href="/order/">我的订单 </a></li>
    <li class="gouwuche"><a href="/car/">购物车</a> <strong style="color:#C94E13;">3</strong></li>
    <li class="shoucangjia"><a href="shoucang.html">收藏夹</a></li>
    <li class="kefus"><a href="#">联系客服</a></li>
<li><a href="#" class="lan">中文</a></li>
    <li><a href="#" class="lan">English</a></li>
    <div class="clears"></div>
   </ul><!--topNav/-->
  </div><!--top/-->
 </div><!--hrader/-->
 <div class="mid">
  <h1 class="logo" style="text-align:left;">
  <a href="index.html"><img src="${ contextPath}/assets/images/logo.png" width="304" height="74" /></a>
  </h1>
  <form action="#" method="get" class="subBox">
   <div class="subBox2">
    <input type="text" class="subText" />
    <input type="image" src="${ contextPath}/assets/images/sub.jpg" width="95" height="32" class="subImg" />
    <div class="hotci">
    <a href="#">酷派大神</a>
    <a href="#">三星s5</a>
    <a href="#">诺基亚1020</a>
    <a href="#">Iphone 6</a>
    <a href="#">htc one</a>
   </div><!--hotci/-->
   </div><!--subBox2/-->
  </form><!--subBox/-->
  <div class="ding-gou">
   <div class="ding">
    <a href="/order/"><img src="${ contextPath}/assets/images/dingdan.jpg" width="106" height="32" /></a>
   </div><!--ding/-->
   <div class="gou">
    <a href="/car/"><img src="${ contextPath}/assets/images/gouwuche.jpg" width="126" height="32" /></a>
   </div><!--gou/-->
   <div class="clears"></div>
  </div><!--ding-gou/-->
 </div><!--mid-->
 <div class="navBox navBg1">
  <ul class="nav">
   <li><a href="index.html">首页</a></li>
   <li><a href="buy.html">买家</a></li>
   <li><a href="sell.html">卖家</a></li>
   <li class="navCur"><a href="${ contextPath}/userinfo">会员中心</a></li>
   <li><a href="xuanshang.html">悬赏榜</a></li>
   <li><a href="luntan.html" class="luntan">论坛</a></li>
   <li><a href="help.html">帮助</a></li>
   <div class="clears"></div>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="vipBox">
  <div class="vipLeft">
   <h2 class="headImg"><img src="${ contextPath}/assets/images/vipImg.jpg" width="183" height="169" /></h2>
   <h3 class="vipName">测试webqin</h3>
   <dl class="vipNav">
    <dt class="vip_1 vipCur">买家中心</dt>
     <dd><a href="vipOrder.html">我的订单</a></dd>
     <dd><a href="vipShoucang.html">收藏关注</a></dd>
    <dt class="vip_2">账户设置</dt>
     <dd><a href="vip.html">个人信息</a></dd>
     <dd><a href="${ contextPath}/vipPwd">密码修改</a></dd>
     <dd class="ddCur"><a href="${ contextPath}/vipAddress">收货地址</a></dd>
     <dd><a href="${ contextPath}/vipXiaofei/">消费记录</a></dd>
    <dt class="vip_3">客户服务</dt>
     <dd><a href="vipQuxiao.html">取消订单/退货</a></dd>
     
     <dd><a href="vipTousu.html">我的投诉</a></dd>
   </dl><!--vipNav/-->
  </div><!--vipLeft/-->
  <div class="vipRight">
   <h2 class="vipTitle">收货地址</h2>
   <form method="post" action="/address-edit/{id}" name="myform">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   <div class="address">
    <div class="addList">
     <label><span class="red">* </span>选择地区:</label>
     <select name="area">
   
      <option >请选择省</option>
      <option value="湖南省">湖南省</option>
     </select>
     <select name="area">
      <option>请选择市</option>
      <option value="">长沙市</option>
     </select>
     <select name="area">
      <option>请选择地区</option>
      <option>开福区</option>
     </select>
    </div>
    <div class="addList">
     <label><span class="red">* </span>详细地址:</label>
     <input type="text" name="address" value="${edit.address }"/>
    </div>
    <div class="addList">
     <label><span class="red">* </span>邮政编码:</label>
     <input type="text" name="postCode" value="${edit.postCode }"/>
    </div>
    <div class="addList">
     <label><span class="red">* </span>收件人:</label>
     <input type="text" name="arelname" value="${edit.arelname }"/>
    </div>
    <div class="addList">
     <label><span class="red">* </span>手机号码:</label>
     <input type="text" phone="phone" name="aphone" value="${edit.aphone }"/> 或者固定电话 <input type="text" />
    </div>
    <div class="addList2">
     <input name="" value=" 确 认 " type="submit" class="submit" onclick="action1"/>
    </div>
   </div></form><!--address/-->
   <table class="vipAdress">
	<tr><td><span class="green add">[添加]</span></td></tr>
    <tr>
     <th>收货人</th>
     <th>所在地区</th>
     <th>街道地址</th>
     <th>邮编</th>
     <th>电话/手机</th>
     <th>操作</th>
    </tr>
    <c:forEach var="address" items="${address }">
    <tr>
     <td>${address.arelname }</td>
     <td>${address.area }</td>
     <td>${address.address }</td>
     <td>${address.postCode }</td>
     <td>${address.aphone }</td>
     <td><span class="green upd">[修改]</span> </td>
    </tr>
    </c:forEach>
   </table><!--vipAdress/-->
  </div><!--vipRight/-->
  <div class="clears"></div>
 </div><!--vipBox/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="index.html"><img src="${ contextPath}/assets/images/ftlogo.jpg" width="240" height="64" /></a>
    <h3 class="ftphone">400 000 0000 </h3>
    <div class="ftKe">
     客服 7x24小时(全年无休)<br />
     <span>客服邮箱：kefu@webqin.net </span>
    </div><!--ftKe/-->
   </div><!--footersLeft/-->
   <div class="footersRight">
    <ul>
     <li class="ftTitle">新手指南</li>
     <li><a href="#">购物流程</a></li>
     <li><a href="#">会员计划及划分</a></li>
     <li><a href="#">优惠券规则</a></li>
     <li><a href="#">联系客服</a></li>
     <li><a href="#">常见问题</a></li>
    </ul>
    <ul>
     <li class="ftTitle">付款方式</li>
     <li><a href="#">在线支付</a></li>
     <li><a href="#">礼品卡支付</a></li>
     <li><a href="#">货到付款</a></li>
     <li><a href="#">银行付款</a></li>
    </ul>
    <ul>
     <li class="ftTitle">配送服务</li>
     <li><a href="#">配送时效及运费</a></li>
     <li><a href="#">超时赔付</a></li>
     <li><a href="#">验货与签收</a></li>
     <li><a href="#">配货信息跟踪</a></li>
    </ul>
    <ul>
     <li class="ftTitle">售后服务</li>
     <li><a href="#">退换货政策</a></li>
     <li><a href="#">退换货区域</a></li>
     <li><a href="#">退款时限</a></li>
     <li><a href="#">先行赔付</a></li>
     <li><a href="#">发票说明</a></li>
    </ul>
    <ul>
     <li class="ftTitle">特色服务</li>
     <li><a href="#">礼品卡</a></li>
     <li><a href="#">产品试用</a></li>
     <li><a href="#">花粉中心</a></li>
     <li><a href="#">快速购物</a></li>
     <li><a href="#">推荐好友</a></li>
    </ul>
    
    <div class="clears"></div>
   </div><!--footersRight/-->
   <div class="clears"></div>
  </div><!--footers/-->
 </div><!--footBox/-->
 <div class="footer" style="text-align:left;">
  <a href="#">关于我们</a>
  <a href="#">友情链接</a>
  <a href="#">版权声明</a>
  <a href="#">网站地图</a>
  <br />
  <span>&copy; 2014 Unqezi 使用前必读 沪ICP备 12007626号-1</span>
 </div><!--footer/-->

</body>
</html>