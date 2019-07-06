const urlHost = 'http://localhost:8080';
const urlMap = {
	users: urlHost+"/api/manager/users",
	awards: urlHost+"/api/manager/awards",
	news: urlHost+"/api/manager/news"
}

$(function()
{
	$("#text-news-date").val(
		new Date().toISOString().
			slice(0,10).replace(/-/g,"-")
	);

	$("#btn-news-submit").click(()=>
	{
		data = {}
		data.title = $("#text-news-title").val();
		data.date = $("#text-news-date").val();
		data.content= $("#text-news-content").val();

		$.ajax({
			type: "post",
			url: urlMap["news"]+"/update",
			data: JSON.stringify(data),
			contentType: "application/json;charset=UTF-8",
			error: function(xhr) {
				alert("上传请求失败");
			},
			success: function() {
				window.location.reload();
			}
		});
	})
});