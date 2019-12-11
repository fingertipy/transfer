package transfer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description Api Controller
 * @Author      dayu
 * @Date        2019/12/11 12:10
 * @Version     v1.0
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hallo")
    public Integer hallo(){
        return 1;
    }
}
