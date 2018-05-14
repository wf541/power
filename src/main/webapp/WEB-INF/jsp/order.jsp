<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单确认页</title>
<link type="text/css" href="${ contextPath}/assets/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${ contextPath}/assets/js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${ contextPath}/assets/js/js.js"></script>
</head>
<body>
<div class="hrader" id="header">
  <div class="top">
   <a href="/login/" style="color:#C94E13;">请登录</a> 
   <a href="/reg/">注册</a>
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
    <a href="order.html"><img src="${ contextPath}/assets/images/dingdan.jpg" width="106" height="32" /></a>
   </div><!--ding/-->
   <div class="gou">
    <a href="car.html"><img src="${ contextPath}/assets/images/gouwuche.jpg" width="126" height="32" /></a>
   </div><!--gou/-->
   <div class="clears"></div>
  </div><!--ding-gou/-->
 </div><!--mid-->
 <div class="navBox navBg3">
  <ul class="nav">
   <li><a href="index.html">首页</a></li>
   <li><a href="buy.html">买家</a></li>
   <li><a href="sell.html">卖家</a></li>
   <li><a href="/login/vip/{id}">会员中心</a></li>
   <li><a href="xuanshang.html">悬赏榜</a></li>
   <li><a href="luntan.html" class="luntan">论坛</a></li>
   <li class="navCur"><a href="help.html">帮助</a></li>
   <div class="clears"></div>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="car">
  <div class="cont">
   <div class="carImg"><img src="${ contextPath}/assets/images/car2.jpg" width="961" height="27" /></div>
   
   <h4 class="orderTitle">支付方式</h4>
   <ul class="zhiList">
   <li>网银支付-借记卡</li>
   <li>网银支付-信用卡</li>
   <li>财付通-余额支付</li>
   <li>支付宝-余额支付</li>
   <div class="clears"></div>
  </ul><!--zhiList/-->
  <div class="zhifufangshi">
   <ul class="yinhang">
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin1.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin2.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin3.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin4.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin5.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin6.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin7.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin8.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin9.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin1.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin2.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin3.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin4.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin5.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin6.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin7.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin8.gif" /></li>
    <div class="clears"></div>
   </ul>
  </div><!--zhzhifufangshii/-->
  <div class="zhifufangshi">
   <ul class="yinhang">
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin7.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin8.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin9.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin1.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin2.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin3.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin4.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin5.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin6.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin7.gif" /></li>
    <li><input type="radio" /><img src="${ contextPath}/assets/images/yin8.gif" /></li>
    <div class="clears"></div>
   </ul>
  </div><!--zhzhifufangshii/-->
  <div class="zhifufangshi">
   <ul class="yinhang">
    <li><input type="radio" /><img src="${ contextPath}/assets/images/caifutong.jpg" /></li>
    <div class="clear"></div>
   </ul>
  </div><!--zhzhifufangshii/-->
  <div class="zhifufangshi">
   <ul class="yinhang">
    <li><input type="radio" /><img src="${ contextPath}/assets/images/zhifubao.jpg" /></li>
    <div class="clear"></div>
   </ul>
  </div><!--zhzhifufangshii/-->
  <h4 class="orderTitle">购物清单</h4>
  <table class="orderList">
    <tr>
     <th width="20"></th>
     <th width="430">商品</th>
     <th width="135">单价</th>
     <th width="135">数量</th>
     <th width="135">总金额</th>
     <th>操作</th>
    </tr>
    <tr>
     <td><input type="checkbox" /></td>
     <td>
      <dl>
       <dt><a href="proinfo.html"><img src="${ contextPath}/assets/images/pro1.jpg" width="85" height="85" /></a></dt>
       <dd>全球最大的中文搜索引擎、致力于让网民更便捷<br /><span class="red">有货：</span>从上海出发</dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td>
     <div class="a" class="Spinner"></div>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td><a href="#" class="green">收藏</a><br /><a href="#" class="green">删除</a></td>
    </tr>
    <tr>
     <td><input type="checkbox" /></td>
     <td>
      <dl>
       <dt><a href="proinfo.html"><img src="${ contextPath}/assets/images/pro1.jpg" width="85" height="85" /></a></dt>
       <dd>全球最大的中文搜索引擎、致力于让网民更便捷<br /><span class="red">有货：</span>从上海出发</dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td>
     <div class="jia_jian">
      <img src="${ contextPath}/assets/images/jian.jpg" width="21" height="25" class="jian" />
      <input type="text" class="shuliang" value="1" />
      <img src="${ contextPath}/assets/images/jia.jpg" width="21" height="25" class="jia" />
     </div>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td><a href="#" class="green">收藏</a><br /><a href="#" class="green">删除</a></td>
    </tr>
    <tr>
     <td><input type="checkbox" /></td>
     <td>
      <dl>
       <dt><a href="proinfo.html"><img src="${ contextPath}/assets/images/pro1.jpg" width="85" height="85" /></a></dt>
       <dd>全球最大的中文搜索引擎、致力于让网民更便捷<br /><span class="red">有货：</span>从上海出发</dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td>
     <div class="jia_jian">
      <img src="${ contextPath}/assets/images/jian.jpg" width="21" height="25" class="jian" />
      <input type="text" class="shuliang" value="1" />
      <img src="${ contextPath}/assets/images/jia.jpg" width="21" height="25" class="jia" />
     </div>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td><a href="#" class="green">收藏</a><br /><a href="#" class="green">删除</a></td>
    </tr>
    <tr>
     <td><input type="checkbox" /></td>
     <td>
      <dl>
       <dt><a href="proinfo.html"><img src="${ contextPath}/assets/images/pro1.jpg" width="85" height="85" /></a></dt>
       <dd>全球最大的中文搜索引擎、致力于让网民更便捷<br /><span class="red">有货：</span>从上海出发</dd>
       <div class="clears"></div>
      </dl>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td>
     <div class="jia_jian">
      <img src="${ contextPath}/assets/images/jian.jpg" width="21" height="25" class="jian" />
      <input type="text" class="shuliang" value="1" />
      <img src="${ contextPath}/assets/images/jia.jpg" width="21" height="25" class="jia" />
     </div>
     </td>
     <td><strong class="red">￥70.20</strong></td>
     <td><a href="#" class="green">收藏</a><br /><a href="#" class="green">删除</a></td>
    </tr>
    <tr>
     <td colspan="6"><div class="shanchu"><img src="${ contextPath}/assets/images/lajio.jpg" /> 全部删除</div></td>
    </tr>
   </table><!--orderList/-->
   <table class="zongjia" align="right">
    <tr>
     <td width="120" align="left">商品总价：</td>
     <td width="60"><strong class="red">+7.88</strong></td>
    </tr>
    <tr>
     <td width="120" align="left">运费总额：</td>
     <td><strong class="red">+121.88</strong></td>
    </tr>
    <tr>
     <td width="120" align="left">促销优惠：</td>
     <td><strong class="red">+341.88</strong></td>
    </tr>
    <tr>
     <td width="120" align="left">合计：</td>
     <td><strong class="red">+2271.88</strong></td>
    </tr>
    <tr>
     <td colspan="2" style="height:50px;">
      <a href="/success/"><img src="${ contextPath}/assets/images/tijao.png" width="142" height="32" /></a>
     </td>
    </tr>
   </table><!--zongjia/-->
   <div class="clears"></div>
  </div><!--cont/-->
 </div><!--car/-->
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