aws-s3-file-uploader (Play application)
=======================================

In order to execute this project, is required to have installed the latest version of [Play framework.](https://www.playframework.com/download)

### Configuration

Before execution, you must have the AWS credentials configuration. See more at the oficial web site documentation: http://docs.aws.amazon.com/cli/latest/userguide/cli-chap-getting-started.html

### Execute

* Run the "activator" command from the root folder of the project
* Type "compile" and enter
* Type "run" and enter

The API will be listen at [localhost:9000](http://localhost:9000)

### Resources

##### POST /images/local

Upload images to the API local machine

##### POST /images/aws

Upload images to AWS S3

### Test it

From a web browser at [localhost:9000](http://localhost:9000) you can test it both resources with provided html form.