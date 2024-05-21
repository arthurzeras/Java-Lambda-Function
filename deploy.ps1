$BUCKET_NAME = Get-Content -Path ./bucket-name -Raw

mvn package

aws cloudformation package --template-file template.yml --s3-bucket $BUCKET_NAME --output-template-file out.yml
aws cloudformation deploy --template-file out.yml --stack-name first-java-lambda --capabilities CAPABILITY_NAMED_IAM