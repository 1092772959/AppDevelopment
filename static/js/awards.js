const urlHost = 'http://localhost:8080';
const urlMap = {
	users: urlHost+"/api/manager/users",
	awards: urlHost+"/api/manager/awards",
	news: urlHost+"/api/manager/news"
};


$(function()
{
	getAwardList();
	$("#file-upload").change((event)=> {
		uploadImage(event);
	});
	$("#btn-awards-upload").click(()=> {
		uploadInfo();
	});
	$("#btn-del-awards").click(()=> {
		executeDelete();
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

function uploadInfo()
{
	var data = {}
	data.img = $("#img-display").prop("src");
	data.name = $("#text-name").val();
	data.desc = $("#text-awards-desc").val();
	data.step = $("#text-step-threshold").val();

	$.ajax({
		type: "post",
		url: urlMap["awards"]+"/update",
		data: JSON.stringify(data),
		contentType: "application/json;charset=UTF-8",
		error: function(xhr) {
			alert("上传请求失败");
		},
		success: function() {
			window.location.reload();
		}
	});
}

function getAwardList()
{
	$.ajax({
		type: "get",
		url: urlMap["awards"]+"/list",
		dataType: "json",
		success: function (data) {
			createTable(data);
		},
		error: function(data) {
			alert("获取奖品列表失败，请确认服务器是否正常");
		}
	});
}

function createTable(awardsList)
{
	$table = $("#awards-list");
	$tbody = $(`<tbody> </tbody>`);

	const props = ["name", "img", "desc", "step"];

	$.each(awardsList, (i, awards)=>
	{
		$tr = $(`<tr></tr>`);
		$th = $(`<th scope="row"></th>`).text(awards["id"]);
		$tr.append($th);

		$.each(props, (i, prop) =>
		{
			if( prop === "img")
			{
				$elem = $("<img>");
				$elem.prop("src", awards[prop]);
				$elem.css("width", 50);
				$td = $("<td></td>").append($elem);
			}
			else $td = $("<td></td>").text(awards[prop]);
			$tr.append($td);
		});

		$tr.append($(`<input type='checkbox'>`));
		$tbody.append($tr);
	});

	$table.append($tbody);
}

function executeDelete()
{
	data = []
	$.each($("tr"), (i, e)=> {
		ls = $(e).children();
		$input = $(ls[5]);
		if( $input.prop("checked")) {
			// console.log($(ls[0]).text());
			data.push({id: $(ls[0]).text()});
		}
	});

	if( !data.length) return ;

	$.ajax({
		type: "post",
		url: urlMap["awards"]+"/delete",
		data: JSON.stringify(data),
		contentType: "application/json;charset=UTF-8",
		error: function(xhr) {
			alert("上传请求失败");
		},
		success: function() {
			window.location.reload();
		}
	});
}