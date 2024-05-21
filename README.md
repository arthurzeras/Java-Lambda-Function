# First Java Lambda

This is a study project in order to understand how to deploy an AWS Lambda Function using Java.

Note: The function is prepared to work with API Gateway, so to use it you'll need to create a trigger for the function using API Gateway. This was not covered in example, I did it manually in AWS Console.

### Versions
- Java 17
- Maven 3.9

## Usage

The function simply receives a parameter `message` via query string and returns it on request body, for example, if you send `https://example.com/endpoint?message=Hello from query string` you'll get a response like this: 

```json
{"message":  "Hello from query string"}
```

If no `message` parameter is received, a default message is sent: `Hello world!`.

## Deployment

### Requirements
- AWS CLI configured for a user with permissions to read and modify lambda functions and S3 buckets
- Create a Bucket on AWS S3
- Create a file called `bucket-name` and simply write the bucket name on it, without spaces and line breaks

To deploy the function, just run the `deploy.sh` file (if you are on windows, run `deploy.ps1` on PowerShell terminal).

The script will build project with maven and deploy the function using AWS CLI.

## Test Locally

There's a hack to test the function locally, a Main.java file that import the handler class and simulate the request.
