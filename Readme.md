**nginx configure:**

```
server {
    listen 80;	# the port you'd like to assign
    server_name www.example.com;	# your host name
    root /path/to/folder;	# the folder of this project is AppDevelopment
    index login.html; 	# the default page is login.html
}
```
