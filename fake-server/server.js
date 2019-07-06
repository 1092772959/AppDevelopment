const jsonServer = require('json-server');
const server = jsonServer.create();
const router = jsonServer.router('db.json');
const middlewares = jsonServer.defaults();
const bodyParser = require('body-parser');

server.use(middlewares);
server.use(bodyParser.urlencoded({ extended: false }))
server.use(bodyParser.json());


server.use((req, res, next) => {
	if( !isLoginUrl(req)) next();
	else if (isAuthorized(req))
	{ // add your authorization logic here
		const url = req.headers.origin + "/home.html";
		res.redirect(url);
   		next(); // continue to JSON Server router
	 }
	 else res.sendStatus(401);
});
function isLoginUrl(req) {
	return req.url === "/api/manager/login";
}
function isAuthorized(req) {
	return req.body.passwd === "VzEIxwQU";
}

server.use(jsonServer.rewriter({
	'/api/manager/*': '/$1',
	'/awards/update': '/awardsUpdate',
	'/awards/list': '/awardsList',
	'/awards/delete': '/awardsDelete',
	'/users/update': '/usersUpdate',
	'/users/list': '/usersList',
	'/news/update': '/newsUpdate'
}));

server.use(router);
server.listen(8080, () => {
	console.log('JSON Server is running')
});

