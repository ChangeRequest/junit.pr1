jUnit. Practice Task 1
======================

[![Join the chat at https://gitter.im/changerequest/junit.pr1](https://badges.gitter.im/changerequest/junit.pr1.svg)](https://gitter.im/changerequest/junit.pr1?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

# 1. Create jUnit rule

Create a new jUnit rule to provide functionality of test cases rerun on exceptions.

Test rule should have 2 parameters:

1. `retryCount` — amount of retries before test should be failed.
1. Array of exception classes on which retry should be performed.

# 2. Create jUnit runner

Create a new jUnit runner to provide functionality of test cases rerun on exceptions.

Functionality of the runner should be the same as functionality of the rule, you have created.

Think about the runner parameters, how the runner can be configured?
