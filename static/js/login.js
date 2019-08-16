$(function() {

	$("button").click(()=>
	{
		$.ajax({
			type: "post",
			url: "http://www.xiuwenli.cn:8080/host/api/manager/login",
			data: $('form').serialize(),
			dataType: "json",
			success: function (data) {
				//console.log(data);
				if( data.status === "fail") {
					alert("用户名或密码错误");
				}
				else {
					$.cookie("userId", data.data.userId);
					$.cookie("token", data.data.token);
				}

				window.location.href = "./home.html";
			},
			error: function(data) {
				//console.log(data);
				alert("连接失败");
			}
		});
	});
});
