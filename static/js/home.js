const urlHost = 'http://localhost:8080';
const urlMap = {
	users: urlHost+"/api/manager/users",
	awards: urlHost+"/api/manager/awards",
	news: urlHost+"/api/manager/news"
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
		type: "get",
		url: urlMap["users"]+"/list",
		dataType: "json",
		success: function (data) {
			createTable(data);
		},
		error: function(data) {
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

	const props = ["name", "step", "type"];

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
	data = []
	$.each($("tr"), (i, e)=> {
		ls = $(e).children();
		$input = $(ls[4]);
		if( $input.context && $input.val() !== '') {
			//console.log($(ls[0]).text());
			data.push({id: $(ls[0]).text()});
		}
	});
	//console.log(data);
	if( !data.length) return ;

	$.ajax({
		type: "post",
		url: urlMap["users"]+"/update",
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