//校验邮箱
function checkEmail(){
   var  email  = document.getElementById("email").value;
   var reg = /^[a-z0-9]\w+@[a-z0-9]{2,3}(\.[a-z]{2,3}){1,2}$/i;  // .com .com.cn
   var emailspan = document.getElementById("emailspan");
//   alert(reg.test(email));
   if(reg.test(email)){
       //符合规则 
       emailspan.innerHTML="正确".fontcolor("green");
      
       return true;
   }else{
       //不符合规则
       emailspan.innerHTML="错误,请输入正确格式".fontcolor("red");
       return false;
   }  
}

/*移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
* 联通号码段:130、131、132、136、185、186、145
* 电信号码段:133、153、180、189*/
function checkPhone(){
	   var  tel  = document.getElementById("tel").value;
	   var reg = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;  //由13，15，14，17，18开头等的验证
	   var phonespan = document.getElementById("phonespan");
//	   alert(reg.test(tel));
	   if(reg.test(tel)){
	       //符合规则 
		   phonespan.innerHTML="正确".fontcolor("green");
	      
	       return true;
	   }else{
	       //不符合规则
		   phonespan.innerHTML="错误,请输入正确格式".fontcolor("red");
	       return false;
	   }  
	}


//总体校验表单是否可以提交了 如果返回的true表单才可以提交。上面的表单项必须要每个都填写正确。
function checkForm(){
  
   var email = checkEmail();
   var phone = checkPhone();
   if(email&&phone){
       return true;
   }else{
       return false;
   }
  
}