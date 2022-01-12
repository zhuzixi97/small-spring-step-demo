package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
    /**
     * 定义接口，提供获取inputStream流的方法，接下去再来实现三种不同的流文件操作：classPath、FileSystem、URL
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
