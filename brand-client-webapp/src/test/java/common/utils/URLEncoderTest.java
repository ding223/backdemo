package common.utils;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Hunter on 2020-06-25.
 */
public class URLEncoderTest {

    /**
     * 测试提交是否包含iml文件
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test() throws UnsupportedEncodingException {
        String name = "钙-calcium";
        String encode = URLEncoder.encode(name, "utf-8");
        System.out.println(encode);
        String decode = URLDecoder.decode(encode, "UTF-8");
        System.out.println(decode);
    }
}
