# Merchant_Catalogue_Service
This service provides API's to perform Merchant onboarding with CSV file upload and further data querying .

API’s

1.Post API url : “{url}/merchant/upload” with body ->form data key=”file” and value=

NOTE: .xlsx file sheet name should be “data” .

2.Get API url : “{url}/merchant” returns all merchant data response body as json.

3.Get API url : “{url}/merchant/id” returns data pertaining to a particular merchantId.
