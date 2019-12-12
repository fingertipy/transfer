package transfer.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class PythonUtils {

    private PythonUtils(){}

    //python executor
    private static String executor;

    @Value("${python.executor}")
    public void setExecutor(String executor){
        this.executor = executor;
    }

    //logger
    private static Logger logger = LoggerFactory.getLogger(PythonUtils.class);

    /**
     * @Description execute python program
     * @Author      dayu
     * @Date        2019/12/3 10:56
     * @Param
     * @Return      void
     */
    public static void exec(String path){
        try {
            logger.info("======================== Execute python program : start===========================");
            //执行脚本
            Process process = Runtime.getRuntime().exec(new String[]{executor, path});
            //接口执行结果
            BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            //处理执行结果
            while ((line = buffer.readLine()) != null){
                System.out.println(line);
            }
            //关闭资源
            buffer.close();
            process.waitFor();
            logger.info("======================== Execute python program :   end===========================");
        } catch (Exception e) {
            logger.error("Execute python program exception: ", e);
        }
    }

    /**
     * @Description execute python program
     * @Author      dayu
     * @Date        2019/12/3 10:56
     * @Param
     * @Return      void
     */
    public static String exec(String path, String ... args){
        try {
            logger.info("======================== Execute python program : start===========================");
            //执行脚本
            Process process = Runtime.getRuntime().exec(new String[]{executor, path, JSONObject.toJSONString(args)});
            //接口执行结果
            BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            //缓冲
            StringBuffer result = new StringBuffer();
            //处理执行结果
            while ((line = buffer.readLine()) != null){
                result.append(line);
            }
            //关闭资源
            buffer.close();
            process.waitFor();
            logger.info("======================== Execute python program :   end===========================");
            return result.toString();
        } catch (Exception e) {
            logger.error("Execute python program exception: ", e);
            return null;
        }
    }
}
