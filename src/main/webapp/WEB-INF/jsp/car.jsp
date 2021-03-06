<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link type="text/css" href="${ contextPath}/assets/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${ contextPath}/assets/js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${ contextPath}/assets/js/js.js"></script>
<script type="text/javascript" src="${ contextPath}/assets/js/payfor.js"></script>
<script type="text/javascript" src="${ contextPath}/assets/js/jiajian.js"></script>
</head>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<body>
<div class="hrader" id="header">
  <div class="top">
  <%@ include file="header.jspf" %>
   <a href="${ contextPath}/login" style="color:#C94E13;">请登录</a> 
   <a href="${ contextPath}/reg">注册</a>
   <ul class="topNav">
    <li><a href="${ contextPath}/order">我的订单 </a></li>
    <li class="gouwuche"><a href="${ contextPath}/car">购物车</a> <strong style="color:#C94E13;">3</strong></li>
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
  <a href="index.html"><img src=" ${ contextPath}/assets/images/logo.png" width="304" height="74" /></a>
  </h1>
  <form action="${ contextPath}/car" method="post" class="subBox">
   <div class="subBox2">
    <input type="text" class="subText" />
    <input type="image" src="${ contextPath}/assets/images/sub.jpg" width="95" height="32" class="subimg src="" />
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
    <a href="order.html"><img src=" ${ contextPath}/assets/images/dingdan.jpg" width="106" height="32" /></a>
   </div><!--ding/-->
   <div class="gou">
    <a href="car.html"><img src=" ${ contextPath}/assets/images/gouwuche.jpg" width="126" height="32" /></a>
   </div><!--gou/-->
   <div class="clears"></div>
  </div><!--ding-gou/-->
 </div><!--mid-->
 <div class="navBox navBg3">
  <ul class="nav">
   <li><a href="index.html">首页</a></li>
   <li><a href="buy.html">买家</a></li>
   <li><a href="sell.html">卖家</a></li>
   <li><a href="${ contextPath}/userinfo">会员中心</a></li>
   <li><a href="xuanshang.html">悬赏榜</a></li>
   <li><a href="luntan.html" class="luntan">论坛</a></li>
   <li class="navCur"><a href="help.html">帮助</a></li>
   <div class="clears"></div>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <form action="${contextPath}/vipOrder" method="post" id="jiesuan">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 <div class="car">
  <div class="cont">
   <div class="carimg src=""><img src=" ${ contextPath}/assets/images/car1.jpg" width="951" height="27" /></div>
   <h4 class="orderTitle">收货地址</h4>
   <table class="ord">
    <c:forEach items="${addresses }" var="addr">
    <tr>
     <td width="30%" >
      <input type="radio" name="addressId" value="${addr.id }"/> ${addr.arelname }
     </td>
     <td width="50%" >
      ${addr.province },${addr.city},${addr.area},${addr.address},${addr.postCode},${addr.aphone}
     </td>
     <td>
      <span class="green upd"><a href="${ contextPath}/vipAddress/${addr.id}">[修改]</a></span> | <span class="green add">[添加]</span> 
     </td>
    </tr>
    </c:forEach>
   </table><!--ord/-->
  
   <table class="orderList">
    <tr>
     <th width="20"></th>
     <th width="450">商品</th>
     <th width="130">单价</th>
     <th width="130">数量</th>
     <th width="130">总金额</th>
     <th width="105">操作</th>
    </tr>
    <tr>
    <c:forEach items="${car}" var="car">
    <tr>
     <td><input type="checkbox" name="carId" value="${car.id}"/></td>
     <td>
      <dl>
       <dt><a href="proinfo.html"><img src=" ${ contextPath}/assets/images/phone.png" width="85" height="85" /></a></dt>
       <dd>${car.commodity.name},${car.commodity.describe}<br /><span class="red">有货：</span>从上海出发</dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥${car.commodity.price}</strong></td>
     <td>
     <div class="jia_jian">
			 <img src="${contextPath}/assets/images/jian.jpg" width="21" height="25" class="jian" name="${car.id}" />
   			<input type="text" class="shuliang" value="${car.counts }" name="${car.id}"/>
	      	<img src="${contextPath}/assets/images/jia.jpg" width="21" height="25" class="jia" name="${car.id}" />
     </div>
     </td>
     <td class="${car.id }">
			总价：<strong class="red" name="${car.id }">￥
			${car.commodity.price*car.counts}
			</strong>
		</td>
     <td><a href="#" class="green">收藏</a><br /><a href="${contextPath}/del/${car.id}" class="green" >删除</a></td>
    </tr>
    <c:set var="totalPrice" value="${totalPrice+ car.commodity.price*car.counts}"></c:set>
    </c:forEach>
    </tr>
    <tr>
     <td colspan="6"><div class="shanchu"><img src=" ${ contextPath}/assets/images/lajio.jpg" />
     <a href="#" class="green" id="batch-delete-btn"> 全部删除</a>
     </div>
     </td>
    </tr>
   </table><!--orderList/-->
   <div class="zongji">
    <strong>所需运费：</strong>￥0.00 &nbsp;&nbsp;
    <strong>总计(不含运费)：</strong><strong class="red" name="all">￥${totalPrice}</strong>
   </div><!--zongji/-->
   <div class="jiesuan">
    <a href="index.html" class="jie_1">继续购物&gt;&gt;</a>
    <button type = "submit"  class="jie_2">立即结算&gt;&gt;</button>
    <div class="clears"></div>
   </div><!--jiesuan/-->
   <div class="clears"></div>
  </div><!--cont/-->
 </div><!--car/-->
 </form>
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="index.html"><img src=" ${ contextPath}/assets/images/ftlogo.jpg" width="240" height="64" /></a>
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
<form style="display: none;" 
		action="deleteSome" method="post" 
 		id="batch-delete-form">
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
 	<script>	
 		$('#batch-delete-btn').click(function() {
 			console.log('batch delete...');
 			var checkedProdIds = $('input[type=checkbox][name=carId]')
 				.filter(function() {
 					return this.checked;
 				});
			console.log('checkedProdIds', checkedProdIds); 		
			
			if (checkedProdIds.length > 0) {
				$('#batch-delete-form').append(checkedProdIds).submit();
			}
 		});
	</script>
</body>
</html>