package cn.bugstack.springframework.core.io;

/**
 * 包装资源加载器
 * @author zhu
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 资源获取接口
     * @param location
     * @return
     */
    Resource getResource(String location);
}
