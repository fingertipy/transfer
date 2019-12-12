package transfer.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import transfer.constatns.GlobalConstants;
import transfer.entity.Response;
import transfer.service.Transfer;
import transfer.utils.LogUtils;
import transfer.utils.PythonUtils;

/**
 * @Description 传输接口实现
 * @Author      dayu
 * @Date        2019/12/12 12:19
 * @Version     v1.0
 */
@Service
public class TransferImpl implements Transfer {

    @Value("${python.analysis.model1}")
    private String path1;

    @Value("${python.analysis.model2}")
    private String path2;

    @Override
    public String invok(Integer type, String... args) {
        String result = null;
        switch (type){
            case GlobalConstants.ANALYSIS_MODEL_1:
                result = PythonUtils.exec(path1, args);
                break;
            case GlobalConstants.ANALYSIS_MODEL_2:
                result = PythonUtils.exec(path2, args);
                break;
            default:
                break;
        }
        LogUtils.info(result);
        Response response = JSONObject.parseObject(result, Response.class);
        LogUtils.info(response.toString());
        LogUtils.info(response.getMsg());
        return result;
    }
}
