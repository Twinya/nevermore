###  GIT关键常用指令
- 在安装好GIT之后需要配置名字和邮箱  
```
git config (--global) user.name "yourname"  
git config (--global) user.email test@test.com
```
- 生成SSH密钥

```
ssh-keygen -t rsa -C "youremail@example.com"
```  
- 配置SSH密钥，用来查看公钥 

```
cat ~/.ssh/id_rsa.pub
```

 
- 初始化 
```
git init
```
- 将所有的变化提交到缓存区，如果添加多个文件，以空格分隔（不包含删除的文件，如果要包含后缀用-A）
```
git add .
```
- 提交到本地库
```
git commit -m '添加对此次上传的注释' 
```
-  添加一个远程仓库，url一般用ssh格式

```
git remote add [shortname] [url] 
```
-   将本地库送到远程仓库，初始时可用origin master

```
git push -u [origin] [branch]  
```

- 拉取项目代码
```
git pull 
```
-   从Git仓库拷贝文件 ，一般用ssh协议，也可以用git或者HTTP协议


```
git clone <服务器地址> <没有指定的文件可不加>
```
- 用来显示上次提交更新的更改，或者写入缓存的改动

```
git status 
```
-  切换分支，前面的-b可不加，直接切换，加就是创建分支并跳转

```
git checkout -b (branchname)
```
   
## 初始化库

```
git init  
git add   
git commit -m ''  
git remote add origin ssh地址
```


### 常用命令
- 可以检查目前已有的所有配置信息
```
git config --list
```
