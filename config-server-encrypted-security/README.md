# Config server with basic security

## Unauthorized
```shell script
curl http://localhost:8888/config-client/prod
```
```json

{
  "timestamp": "2019-12-27T15:34:43.098+0000",
  "status": 401,
  "error": "Unauthorized",
  "message": "Unauthorized",
  "path": "/config-client/prod"
}
```

## Authorized
```shell script
curl http://root:s3cr3t@localhost:8888/config-client/prod
```
```json
{
  "name": "config-client",
  "profiles": [
    "prod"
  ],
  "label": null,
  "version": "37483a37e6ce57a849751c049caa04134e185abc",
  "state": null,
  "propertySources": [
    {
      "name": "https://github.com/rslvn/spring-cloud-config-repo/config-client-prod.yml",
      "source": {
        "sample.value.min": 5,
        "sample.value.max": 100,
        "sample.value.fix": "prod"
      }
    }
  ]
}
```
