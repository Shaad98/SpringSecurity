#### 1. Getting password at console and accessing application with that is done.

``` 

    username : user

    password : < at console you get it >

```
#### 2. Storing username and password in application file is done.

```
    spring.security.user.name=Shanks
    spring.security.user.password=s@123
```

#### NOTE
1.Above two implementations disadvantage is only 1 username and password you have  
2.In application file UsernamePaswordAutheticationFilter check you define username and password or not if not it provide to console.
3.Where you want to do Post,Put,Delete req from there first get csrf (if postman then postman,if browser then browser (It's IMP))



