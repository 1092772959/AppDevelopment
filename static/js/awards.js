const urlHost = 'http://www.xiuwenli.cn:8080';
const urlMap = {
	users: urlHost+"/host/api/manager/users",
	awards: urlHost+"/host/api/manager/awards",
	news: urlHost+"/host/api/manager/news"
}

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

function validate(x) {
	return x === ''? '0': x;
}

function uploadInfo()
{
	var data = {}
	data.img = $("#img-display").prop("src");
	data.name = $("#text-name").val();
	data.desc = $("#text-awards-desc").val();
	data.step = validate($("#text-step-threshold").val());
	data.cnt = validate($("#text-cnt-threshold").val());
	data.userId = $.cookie("userId");

	$.ajax({
		type: "post",
		url: urlMap["awards"]+"/update",
		headers: { "Authorization": $.cookie("token") },
		data: $.param(data),
		async: false,
		error: function(xhr) {
			alert("上传请求失败");
		},
		success: function(data) {
			console.log(data);
			window.location.reload();
		}
	});
}

function getAwardList()
{
	$.ajax({
		type: "post",
		headers: { "Authorization": $.cookie("token") },
		data: $.param({ "userId": $.cookie("userId") }),
		url: urlMap["awards"]+"/list",
		dataType: "json",
		success: function (data) {
			createTable(dataHandler(data.data));
		},
		error: function(data) {
			alert("获取奖品列表失败，请确认服务器是否正常");
		}
	});
}

function dataHandler(ls)
{
	var res = []
	$.each(ls, (i, data)=> {
		res.push({
			id: data["id"],
			name: data["title"],
			desc: data["content"],
			img: data["srcUrl"],
			step: data["stepNeed"],
			num: data["remain"] +
			  " / " + data["cnt"]
		});
	});

	return res;
}

function createTable(awardsList)
{
	$table = $("#awards-list");
	$tbody = $(`<tbody> </tbody>`);

	const props = ["name", "img", "desc", "step", "num"];

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
	ls_data = []
	$.each($("tr"), (i, e)=> {
		ls = $(e).children();
		$input = $(ls[6]);
		if( $input.prop("checked")) {
			// console.log($(ls[0]).text());
			ls_data.push({prizeId: $(ls[0]).text()});
		}
	});

	if( !ls_data.length) return ;

	$.each(ls_data, (i, data)=> {
		data.userId = $.cookie("userId");
		deletePost(data);
	});
}

function deletePost(data)
{
	console.log(data);

	$.ajax({
		type: "post",
		url: urlMap["awards"]+"/delete",
		data: $.param(data),
		headers: { "Authorization": $.cookie("token") },
		async: false,
		error: function(xhr) {
			alert("上传请求失败");
		},
		success: function(data) {
			console.log(data);
			window.location.reload();
		}
	});
}