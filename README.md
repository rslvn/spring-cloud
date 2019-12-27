# spring-cloud

## config from repo

## config from a local folder

### end points of properties

<div>
    <a href="http://localhost:8888/config-client/test" target="_blank">http://localhost:8888/config-client/test</a>
    <br/>
    <a href="http://localhost:8888/config-client/test/master" target="_blank">http://localhost:8888/config-client/test/master</a>
</div>

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

