package cn.pan.server.provide;

import cn.pan.api.TestService;

public class TestServiceImpl implements TestService {

    @Override
    public Float sum(Float a, Float b) {
        return a + b;
    }

    @Override
    public String upperCase(String str) {
       StringBuilder result = new StringBuilder();
        int ch;
        for(int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            }else {
                result.append((char)ch);
            }
        }
        return result.toString();
    }
}
