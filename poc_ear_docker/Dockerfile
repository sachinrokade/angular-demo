FROM ibmcom/websphere-traditional:latest

ENV PROFILE_NAME=AppSrv01
ENV SERVER_NAME=server1
WORKDIR /work/config

# Copy the built EAR into the image (built by `ant all` as dist/hello-ear.ear)
COPY dist/hello-ear.ear /work/config/

# Do not run wsadmin at build time to avoid requiring Jython/ Python during image build.
# The application can be installed at runtime using wsadmin or via administrative tools.

EXPOSE 9080 9443

CMD ["/bin/sh", "-c", "/opt/IBM/WebSphere/AppServer/profiles/${PROFILE_NAME}/bin/startServer.sh ${SERVER_NAME}"]
