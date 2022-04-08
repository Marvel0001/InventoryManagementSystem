$(function() {
	menuClickAction();
	welcomePageInit();
	signOut();
	getRequestPrefix();
	homePage();
});

// 获取请求前缀
function getRequestPrefix(){
	requestPrefix = $('#requestPrefix').text();
}

// 注销登陆
function signOut() {
	$("#signOut").click(function() {
		$.ajax({
			type : "GET",
			url : "account/logout",
			dataType : "json",
			contentType : "application/json",
			success:function(response){
				//刷新
				window.location.reload(true);
			},error:function(response){
				
			}
		})
	})
}