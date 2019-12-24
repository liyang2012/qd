package cn.com.myproject.qd.service;

import java.util.concurrent.Future;

public interface ILoginNotService {
    Future<String> login(String phone, String token);
}
