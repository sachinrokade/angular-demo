# Jython script for WebSphere wsadmin
# This script assumes profile AppSrv01 and server server1 already exist.
# It installs the EAR file and saves the configuration.

appName = 'hello-ear'
earPath = '/work/config/hello-ear.ear'
serverName = 'server1'
cell = AdminControl.getCell()
node = AdminControl.getNode()
appManager = AdminControl.queryNames('type=ApplicationManager,process=server1,*')

print 'Installing application:', appName
AdminApp.install(eaPath=earPath, symbolicname=appName, ignoreIfExist='true')
AdminConfig.save()
print 'Application installed.'
