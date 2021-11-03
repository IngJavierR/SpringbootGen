package mx.com.[%= company %].web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.[%= company %].commons.to.UserTO;
import mx.com.[%= company %].services.facade.I[%= titleName %]Facade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("[%= lowerName %]")
@Api(value="[%= lowerName %]")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    I[%= titleName %]Facade I[%= titleName %]Facade;

    @GetMapping(value = "/users", produces = "application/json")
    @ApiOperation(value = "Buscar Usuarios",
            notes = "Retorna todos los usuarios",
            response = UserTO.class,
            produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        List<UserTO> users = this.I[%= titleName %]Facade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/ping", produces = "application/json")
    @ApiOperation(value = "Ping",
            notes = "Pong",
            produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
