## 管理员页面功能需求
1. 更换礼品
	- 手动添加礼品图片与描述
2. 解决工单
	- 上传文本
3. 用户管理
	- 普通用户与会员的放权与撤权
4. 新闻推送

<br/>

***
## 路由及接口
- 下述若无特殊说明后端请一律通过控制响应头的 status_code 表示请求是否成功。
- 安全性方面，暂定明文传输，所有请求接口基于session判别身份

### 登录
```
http://host/api/manager/login
```
```
{  // request post
	"passwd": "VzEIxwQU"
}
```

&ensp; 若登录成功后服务器请重定向页面
```
http://host/path/to/home.html
```

### 奖品
#### 奖品列表
&ensp; get方式无参请求
```
http://host/api/manager/awards/list
```
```
[  // respond
	{
		"id": 1,
		"name": "huawei P90",
		"img": '/path/to/file',
		"desc": "Lorem ipsum dolor sit amet consectetur adipisicing elit.",
		"step": 1000	// rewards threshold
	},
	{
		"id": 2,
		"name": "rongyao v20",
		"img": '/path/to/file',
		"desc": "Lorem ipsum dolor sit amet consectetur adipisicing elit.",
		"step": 1000
	}
]
```

#### 添加奖品
```
http://host/api/manager/awards/update
```
```
{  // request post
	"img": "base64Code",
	"name": "huawei P90",
	"desc": "Lorem ipsum dolor sit amet consectetur adipisicing elit.",	// description
	"step": 1000	// rewards threshold
}
```

#### 删除奖品
```
http://host/api/manager/awards/delete
```
```
[  // request post
	{id: 1},
	{id: 2}
]
```

### 解决工单
&ensp; 等前端完成..

### 用户列表
#### 请求用户列表
&ensp; get方式无参请求
```
http://host/api/manager/users/list
```
```
[  // respond
	{
		"id": 1,
		"name": "foo",
		"type": 0,	// 0--normal; 1--member
		"step": 1000
	},
	{
		"id": 2,
		"name": "bar",
		"type": 1,
		"step": 0
	}
]
```
#### 修改用户身份
```
http://host/api/manager/users/update
```
```
[  // request post
	{id: 1},
	{id: 2}
]
```

### 新闻推送
```
http://host/api/manager/news/update
```
```
{  // request post
	"title": 'Untitled-1',
	"date": "2019-07-06",
	"content": 'Lorem ipsum dolor sit amet consectetur adipisicing elit.'
}
```
