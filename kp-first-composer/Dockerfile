FROM amazoncorretto:17-alpine
ARG UNAME=first_composer
ARG UID=20006
ARG GID=10006
ENV FIRST_SERVICE_URL = $FIRST_SERVICE_URL
RUN addgroup --gid $GID -S $UNAME
RUN adduser $UNAME -S --uid $UID -G $UNAME -h /home/$UNAME --disabled-password
USER $UNAME
COPY ./target/*.jar /opt/app/first-composer.jar
ENTRYPOINT ["java", "-jar", "/opt/app/first-composer.jar"]