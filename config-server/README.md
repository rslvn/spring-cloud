# spring-cloud

## config from repo

## config from a local folder

### end points of properties

#### config-client endpoints
##### Test: 
[http://localhost:8888/config-client/test](http://localhost:8888/config-client/test) or 
[http://localhost:8888/config-client/test/master](http://localhost:8888/config-client/test/master)
[http://localhost:8888/master/config-client-test.yml](http://localhost:8888/master/config-client-test.yml)


##### Prod: 
[http://localhost:8888/config-client/prod](http://localhost:8888/config-client/prod) or 
[http://localhost:8888/config-client/prod/master](http://localhost:8888/config-client/prod/master)

##### Development: 
[http://localhost:8888/config-client/development](http://localhost:8888/config-client/development) or 
[http://localhost:8888/config-client/development/master](http://localhost:8888/config-client/development/master)

##### Acceptance: 
[http://localhost:8888/config-client/acceptance](http://localhost:8888/config-client/acceptance) or 
[http://localhost:8888/config-client/acceptance/master](http://localhost:8888/config-client/acceptance/master)

##### Personal: 
[http://localhost:8888/config-client/personal](http://localhost:8888/config-client/personal) or 
[http://localhost:8888/config-client/personal/master](http://localhost:8888/config-client/personal/master)

#### request
```shell script
curl http://localhost:8888/config-client/test
curl http://localhost:8888/config-client/test/master
```

#### response
```json
{
  "name": "config-client",
  "profiles": [
    "test"
  ],
  "label": "master",
  "version": "37483a37e6ce57a849751c049caa04134e185abc",
  "state": null,
  "propertySources": [
    {
      "name": "https://github.com/rslvn/spring-cloud-config-repo/config-client-test.yml",
      "source": {
        "sample.value.min": 5,
        "sample.value.max": 100,
        "sample.value.fix": "test"
      }
    }
  ]
}
```

#### request
```shell script
curl http://localhost:8888/master/config-client-test.yml
curl http://localhost:8888/master/config-client-test.yaml
```

#### response
```yaml
sample:
  value:
    fix: test
    max: 100
    min: 5
```

#### request
```shell script
curl http://localhost:8888/master/config-client-test.properties
curl http://localhost:8888/config-client-test.properties
```

#### response
```yaml
sample.value.fix: test
sample.value.max: 100
sample.value.min: 5
```
