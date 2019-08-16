const urlHost = 'http://www.xiuwenli.cn:8080';
const urlMap = {
	users: urlHost+"/host/api/manager/users",
	awards: urlHost+"/host/api/manager/awards",
	news: urlHost+"/host/api/manager/news"
}

$(function() {
	$("#file-upload").change((event)=> {
		uploadImage(event);
	});
});
function uploadImage(event)
{
	const reader = new FileReader();
	let files = event.target.files[0];

	if(/image/.test(files.type))
	{
		reader.readAsDataURL(files);
		reader.onload = ()=>
		{
			$img = $(`<img id='img-display'/>`);
			$img.prop("src", reader.result);
			console.log($img);
			$("#img-display-wrap").append($img);
		}
	}
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
		data.img = $("#img-display").prop("src");
		data.content= $("#text-news-content").val();
		data.userId = $.cookie("userId");

		console.log(data);

		$.ajax({
			type: "post",
			url: urlMap["news"]+"/update",
			headers: { Authorization: $.cookie("token") },
			data: $.param(data),
			error: function(xhr) {
				alert("上传请求失败");
			},
			success: function(data) {
				console.log(data);
				window.location.reload();
			}
		});
	});
});