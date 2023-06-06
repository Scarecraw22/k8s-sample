FROM amazoncorretto:17-alpine
ARG UNAME=second_composer
ARG UID=20006
ARG GID=10006
ENV SECOND_SERVICE_URL = $SECOND_SERVICE_URL
RUN addgroup --gid $GID -S $UNAME
RUN adduser $UNAME -S --uid $UID -G $UNAME -h /home/$UNAME --disabled-password
USER $UNAME
COPY ./target/*.jar /opt/app/second-composer.jar
ENTRYPOINT ["java", "-jar", "/opt/app/second-composer.jar"]