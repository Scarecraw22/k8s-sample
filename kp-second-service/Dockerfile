FROM amazoncorretto:17-alpine
ARG UNAME=second_service
ARG UID=20006
ARG GID=10006
RUN addgroup --gid $GID -S $UNAME
RUN adduser $UNAME -S --uid $UID -G $UNAME -h /home/$UNAME --disabled-password
USER $UNAME
COPY ./target/*.jar /opt/app/second-service.jar
ENTRYPOINT ["java", "-jar", "/opt/app/second-service.jar"]