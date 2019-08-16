const urlHost = 'http://www.xiuwenli.cn:8080';
const urlMap = {
	users: urlHost+"/host/api/manager/users",
	awards: urlHost+"/host/api/manager/awards",
	news: urlHost+"/host/api/manager/news"
}

$(function()
{
	getUserList();

	$("#btn-users").click(()=> {
		getUserList();
	});
	$("#btn-revise-memeber-status").click(()=> {
		reviseMemberStatus();
	});
});

function getUserList()
{
	$.ajax({
		type: "post",
		headers: {
			"Authorization": $.cookie("token")
		},
		data: $.param({
			userId: $.cookie("userId"),
		}),
		url: urlMap["users"]+"/list",
		dataType: "json",
		success: function (data) {
			//console.log(data);
			createTable(data.data);
		},
		error: function(data) {
			//console.log(data);
			alert("获取用户列表失败，请确认服务器是否正常");
		}
	});
}

function createTable(userList)
{
	$table = $("#user-list");
	$tbody = $(`
		<tbody> </tbody>
	`);

	const props = ["username", "totalStep", "type"];

	$.each(userList, (i, user)=>
	{
		$tr = $(`<tr></tr>`);
		$th = $(`<th scope="row"></th>`).text(user["id"]);
		$tr.append($th);

		$.each(props, (i, prop) =>
		{
			if( prop === "type")
				user[prop] = user[prop]?"会员": "非会员";

			$td = $("<td></td>").text(user[prop]);
			$tr.append($td);
		});
		$tr.append($(`
			<input list="datalist-type"/>
			<datalist id="datalist-type">
				<option>会员</option>
				<option>非会员</option>
			</datalist>
		`));
		//console.log($tr.children().eq(4));
		$tbody.append($tr);
	});

	$table.append($tbody);
}


function reviseMemberStatus()
{
	ls_data = []
	$.each($("tr"), (i, e)=> {
		ls = $(e).children();
		$input = $(ls[4]);
		if( $input.context && $input.val() !== '')
		{
			ls_data.push({
				userId: $.cookie("userId"),
				updateId: $(ls[0]).text(),
				type: String($input.val())==="会员"? 1: 0,
			});
		}
	});

	if( !ls_data.length) return ;

	var succ = 1;
	for( let i = 0; i < ls_data.length; i++)
	{
		data = ls_data[i];
		console.log(data);

		$.ajax({
			type: "post",
			headers: {
				"Authorization": $.cookie("token")
			},
			url: urlMap["users"]+"/update",
			data: $.param(data),
			async: false,
			error: function(xhr) {
				succ = 0;
			},
			success: function(data) {
				console.log(data);
			}
		});

		if( !succ) {
			alert("上传请求失败");
			break;
		}
	}

	if( succ) window.location.reload();
}