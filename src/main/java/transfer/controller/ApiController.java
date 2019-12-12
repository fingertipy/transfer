package transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import transfer.constatns.GlobalConstants;
import transfer.service.Transfer;
import transfer.utils.PythonUtils;

/**
 * @Description Api Controller
 * @Author      dayu
 * @Date        2019/12/11 12:10
 * @Version     v1.0
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private Transfer transfer;

    @GetMapping("/call")
    public void call(String args){
        transfer.invok(GlobalConstants.ANALYSIS_MODEL_1, args);
    }
}
