jUnit. Practice Task 1
===============

[![Join the chat at https://gitter.im/changerequest/junit.pr1](https://badges.gitter.im/changerequest/junit.pr1.svg)](https://gitter.im/changerequest/junit.pr1?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
1\. Create jUnit rule
---------------
Create new jUnit rule to provide functionality of test cases rerun on exceptions.

Test rule should have 2 parameters:
1. retryCount - amount of retries before test should be failed.
2. Array of exception classes on which retry should be performed.

2\. Create jUnit runner
---------------
Create new jUnit runner to provide functionality of test cases rerun on exceptions.

Functionality of runner should be same as functionality of rule, you have created.

Think about runner parameters, how runner could be configured ?