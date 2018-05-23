$(function(){
	// 获取meta中的csrf token
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	// 将token作为请求头发送
	var headers = {};
	headers[header] = token;
	$(".jian").click(function(){
		var id1 = $(this).attr("name");
		$.ajax({
			url:"/jiancar",
			headers:headers,
			type:"POST",
			contentType:"application/json; charset=UTF-8",
			data:JSON.stringify({id:id1,counts:$(".shuliang").val()}),
			success:function(carStr){
				console.log($("strong.red[name='"+id1+"']")[0]);
				if(!carStr){
					$("car"+id1).remove();
				}else{
					console.log($(".shuliang").val());
					console.log(parseInt(($("strong.red[name='"+id1+"']")[0].innerHTML).substr(1)));
//					console.log($("."+id1+"").val());
					
					$(".shuliang[name='"+id1+"']").val(carStr.counts);
					$("strong.red[name='"+id1+"']")[0].innerHTML="￥"+(carStr.commodity.price * carStr.counts);
					$("strong.red[name='all']")[0].innerHTML="￥"+(parseInt(($("strong.red[name='all']")[0].innerHTML).substr(1))-carStr.commodity.price);
				}
			},
			error:function(){
				alert("aaa")
			}
		});
	});
	
	
	$(".jia").click(function(){
		var id1 = $(this).attr("name");
		$.ajax({
			url:"/car",
			headers:headers,
			type:"POST",
			contentType:"application/json; charset=UTF-8",
			data:JSON.stringify({id:id1}),
			dataType:"JSON",
			success:function(carStr){
				console.log(carStr);
				$(".shuliang[name='"+id1+"']").val(carStr.counts);
				$("strong.red[name='"+id1+"']")[0].innerHTML="￥"+(carStr.commodity.price * carStr.counts);
				$("strong.red[name='all']")[0].innerHTML="￥"+(parseInt(($("strong.red[name='all']")[0].innerHTML).substr(1))+carStr.commodity.price);
			}
		});
	});
});