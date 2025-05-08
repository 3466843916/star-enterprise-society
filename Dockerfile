# 依赖JDK17环境
FROM openjdk:17

# 对外暴露9002端口
EXPOSE 9002

# 设置工作目录
WORKDIR /app

# 复制JAR文件到容器中
COPY target/software-studio-front-0.0.1-SNAPSHOT.jar app.jar

# 执行命令
RUN bash -c 'touch /app/app.jar'

# 启动应用
ENTRYPOINT ["java", "-jar", "/app/app.jar", "--spring.profiles.active=pro"]
