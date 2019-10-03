<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>汤圆商城</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<%@include file="/jsp/header.jsp" %>

			<!--
            	描述：轮播条
            -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${pageContext.request.contextPath}/img/ad/1.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/ad/2.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/ad/3.jpg">
							<div class="carousel-caption">

							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--

            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10" id="hot_product">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					
				</div>
			</div>
			<!--

            	描述：广告部分
            -->
            <div class="container-fluid">
				<img src="products/hao/ad.jpg" width="100%"/>
			</div>
			<!--

            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/img/title2.jpg"/></h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10" id="new_product">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a href="product_info.htm">
							<img src="products/hao/middle01.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					
				</div>
			</div>			
			<%@include file="/jsp/footer.jsp" %>
	</body>
	<script>
	//界面加载完成后执行
	$(function(){
		
		//向服务端CategoryServlet__>gteAllCats发起ajax请求,服务端经过处理,
		//将所有分类信息以JSON格式的数据返回,获取到返回的所有分类绑定在页面的显示分类区域
		var url = "/store_v7/ProductServlet";
		var obj1 = {"method":"findHotProduct"};
		//三个参数 url,方法，返回数据
		$.post(url,obj1,function(data){
			$.each(data,function(i,obj){
				var div ="<div class=\"col-md-2 yes-right-border\" style=\"text-align:center;height:200px;padding:10px 0px;\">"
				+"<a href=\"${pageContext.request.contextPath}/ProductServlet?method=finProductInfo&pid="+obj.pid+"\">"
				+"<img src=\""+obj.pimage+"\" width=\"130\" height=\"130\" style=\"display: inline-block;\"></a>"
				+"<p><a href=\"${pageContext.request.contextPath}/ProductServlet?method=finProductInfo&pid="+obj.pid+"\" style=\'color:#666\'>"+obj.pname+"</a></p>"
				+"<p><font color=\"#E4393C\" style=\"font-size:16px\">&yen;"+obj.shop_price+"</font></p></div>";
				$("#hot_product").append(div);

			});
		},"json"); 
		var obj2 = {"method":"findNewProduct"};
		$.post(url,obj2,function(data){
			$.each(data,function(i,obj){
				var div ="<div class=\"col-md-2 yes-right-border\" style=\"text-align:center;height:200px;padding:10px 0px;\">"
				+"<a href=\"${pageContext.request.contextPath}/ProductServlet?method=finProductInfo&pid="+obj.pid+"\">"
				+"<img src=\""+obj.pimage+"\" width=\"130\" height=\"130\" style=\"display: inline-block;\"></a>"
				+"<p><a href=\"${pageContext.request.contextPath}/ProductServlet?method=finProductInfo&pid="+obj.pid+"\" style=\'color:#666\'>"+obj.pname+"</a></p>"
				+"<p><font color=\"#E4393C\" style=\"font-size:16px\">&yen;"+obj.shop_price+"</font></p></div>";
				$("#new_product").append(div);

			});
		},"json"); 	
	});
	
		
	</script>
</html>