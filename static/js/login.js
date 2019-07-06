const urlHost = 'http://localhost:8080';
const url = urlHost + '/api/manager/login'

$(function() {
	$("form").prop("action", url)
});