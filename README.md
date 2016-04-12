# wfly-4616
This project show bug in default configuration of wildfly in session distributable.


## Installation
1. Download wildfly from http://download.jboss.org/wildfly/10.0.0.Final/wildfly-10.0.0.Final.zip
2. mvn clean install
3. deploy war and run wildfly in standalone-full-ha mode,
./standalone --server-config=standalone-full-ha.xml

## Usage

1. Run http://localhost:8080/wfly-4616/test to test if application is running correctly, it should return hello.
2. Run http://localhost:8080/wfly-4616/test-long, and then run http://localhost:8080/wfly-4616/test in second tab. Now wildfly should not respond to second request, and throw following exception

21:17:18,908 ERROR [org.infinispan.interceptors.InvocationContextInterceptor] (default task-11) ISPN000136: Error executing command LockControlCommand, writing keys []: org.infinispan.util.concurrent.TimeoutException: ISPN000299: Unable to acquire lock after 15 seconds for key kFh6IrinUtFG99yivevwYefCqo_IZWmDRv4fjRTj and requestor GlobalTransaction:<prezess-macbook-air>:8:local. Lock is held by GlobalTransaction:<prezess-macbook-air>:6:local
	at org.infinispan.util.concurrent.locks.impl.DefaultLockManager$KeyAwareExtendedLockPromise.lock(DefaultLockManager.java:236)
	at org.infinispan.interceptors.locking.AbstractLockingInterceptor.lockAllAndRecord(AbstractLockingInterceptor.java:199)
	at org.infinispan.interceptors.locking.AbstractTxLockingInterceptor.checkPendingAndLockAllKeys(AbstractTxLockingInterceptor.java:199)
	at org.infinispan.interceptors.locking.AbstractTxLockingInterceptor.lockAllOrRegisterBackupLock(AbstractTxLockingInterceptor.java:165)
	at org.infinispan.interceptors.locking.PessimisticLockingInterceptor.visitLockControlCommand(PessimisticLockingInterceptor.java:184)
.....
