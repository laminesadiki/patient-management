# activite-pratique-2

### Some CMD Command to fix "8080 port already taken" issue

1- Tap "**netstat -ao |find /i "listening**" to Check what processes are running at available ports.

2- Tap "**Taskkill /F /IM #Process_Id (eg:2564)**" to stop in windows

3 - Return application

### To activate Validation
I must add the following dependency in pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

