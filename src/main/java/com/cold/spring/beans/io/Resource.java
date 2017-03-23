package com.cold.spring.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 标识一个外部资源，通过getInputStream()获取一个输入流
 * Created by faker on 2017/3/18.
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
