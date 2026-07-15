package org.learnings.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionaingPersonController {

    @GetMapping("v1/person")
    public PersonV1 getFirstVersionOfName(){
        return new PersonV1("Prasana Kumar M D");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionOfName(){
        return new PersonV2(new Name("Prasana Kumar", "M D"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfNameRequestParameter(){
        return new PersonV1("Prasana Kumar M D");
    }

    @GetMapping(path="/person", params = "version=2")
    public PersonV2 getSecondVersionOfNameRequestParameter(){
        return new PersonV2(new Name("Prasana Kumar", "M D"));
    }

    @GetMapping(path = "/person/header1", headers = "X-API-HEADER=1")
    public PersonV1 getFirstVersionOfNameRequestHeader(){
        return new PersonV1("Prasana Kumar M D");
    }

    @GetMapping(path="/person/header2", headers = "X-API-HEADER=2")
    public PersonV2 getSecondVersionOfNameRequestHeader(){
        return new PersonV2(new Name("Prasana Kumar", "M D"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfNameAcceptHeader(){
        return new PersonV1("Prasana Kumar M D");
    }

    @GetMapping(path="/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfNameAcceptHeader(){
        return new PersonV2(new Name("Prasana Kumar", "M D"));
    }

}
