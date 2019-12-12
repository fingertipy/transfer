package transfer.service;

/**
 * @Description 传输接口
 * @Author      dayu
 * @Date        2019/12/12 12:15
 * @Version     v1.0
 */
public interface Transfer {
    /**
     * @Description 执行
     * @Author      dayu
     * @Date        2019/12/12 12:18
     * @Param       type
     * @Param       args
     * @Return      java.lang.String
     */
    String invok(Integer type, String ... args);
}
