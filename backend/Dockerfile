FROM ibmcom/websphere-traditional:latest

ENV PROFILE_NAME=AppSrv01
ENV SERVER_NAME=server1
WORKDIR /work/config

COPY my-enterprise-app.ear /work/config/
COPY configure_app.py /work/config/

RUN /opt/IBM/WebSphere/AppServer/bin/wsadmin.sh -lang jython -f /work/config/configure_app.py

EXPOSE 9080 9443

CMD ["/bin/sh", "-c", "/opt/IBM/WebSphere/AppServer/profiles/${PROFILE_NAME}/bin/startServer.sh ${SERVER_NAME}"]