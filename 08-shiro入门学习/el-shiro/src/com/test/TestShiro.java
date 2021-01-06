package com.test;

import com.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试登录
 */
public class TestShiro {

    public static void main(String[] args) {

        // 准备3个用户:zhang3,li4,wang5
        User zhang3 = new User();
        zhang3.setName("zhang3");
        zhang3.setPassword("12345");

        User li4 = new User();
        li4.setName("li4");
        li4.setPassword("abcde");

        User wang5 = new User();
        wang5.setName("wang5");
        wang5.setPassword("wang5");

        List<User> users = new ArrayList<>();
        users.add(zhang3);
        users.add(li4);
        users.add(wang5);

        // 准备2个角色：管理员，产品经理
        String roleAdmin = "admin";
        String roleProductManager = "productManager";

        List<String> roles = new ArrayList<>();
        roles.add(roleAdmin);
        roles.add(roleProductManager);

        // 准备2个权限：添加产品，添加订单
        String permitAddProduct = "addProduct";
        String permitAddOrder = "addOrder";

        List<String> permits = new ArrayList<>();
        permits.add(permitAddProduct);
        permits.add(permitAddOrder);

        // 测试登录
        for (User user : users) {
            if (login(user)) {
                System.out.printf("%s\t登录成功，用的密码为%s\t%n", user.getName(), user.getPassword());
            } else {
                System.out.printf("%s\t登录失败，用的密码为%s\t%n", user.getName(), user.getPassword());
            }
        }
        System.out.println("-------测试登录结束-------");

        // 判断能登录的用户是否拥有某个角色
        for (User user : users) {
            for (String role : roles) {
                if (login(user)) {
                    if (hasRole(role)) {
                        System.out.printf("%s\t 拥有角色: %s\t%n", user.getName(), role);
                    } else {
                        System.out.printf("%s\t 不拥有角色: %s\t%n", user.getName(), role);
                    }
                }
            }
        }
        System.out.println("-------拥有角色结束-------");

        // 判断能够登录的用户，是否拥有某种权限
        for (User user : users) {
            for (String permit : permits) {
                if (login(user)) {
                    if (isPermitted(permit)) {
                        System.out.printf("%s\t 拥有权限: %s\t%n", user.getName(), permit);
                    } else {
                        System.out.printf("%s\t 不拥有权限: %s\t%n", user.getName(), permit);
                    }
                }
            }
        }
        System.out.println("-------拥有权限结束-------");
    }

    // 权限
    private static boolean isPermitted(String permit) {
        Subject subject = getSubject();
        return subject.isPermitted(permit);
    }

    // 角色
    private static boolean hasRole(String role) {
        Subject subject = getSubject();
        return subject.hasRole(role);
    }

    // 登录
    private static boolean login(User user) {
        Subject subject = getSubject();
        // 如果已经登录过了，退出
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        // 封装用户的数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            // 将用户的数据token 最终传递到Realm中进行比较
            subject.login(token);
        } catch (AuthenticationException e) {
            return false;
        }

        return subject.isAuthenticated();
    }

    private static Subject getSubject() {
        // 获取安全管理者实例,获取本地资源文件,设置realm为本地的资源文件
        DefaultSecurityManager dm = new DefaultSecurityManager();
        // 获取安全管理者实例
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        dm.setRealm(iniRealm);
        // 将安全管理者放入全局对象
        SecurityUtils.setSecurityManager(dm);
        // 全局对象通过安全管理者生成Subject对象
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }
}