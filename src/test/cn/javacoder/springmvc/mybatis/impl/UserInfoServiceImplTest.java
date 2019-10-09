package cn.javacoder.springmvc.mybatis.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.javacoder.springmvc.mybatis.dao.UserInfoDao;
import cn.javacoder.springmvc.mybatis.entity.User;
import cn.javacoder.springmvc.mybatis.service.UserInfoService;

/**
 * Created by aijun.fu@mtime.com
 * Date:2016/8/22
 * Time:19:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:etc/spring/spring-servlet.xml","classpath:etc/spring/spring-mybatis.xml"})
public class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void testSelectUserById() throws Exception {
        User user = userInfoService.selectUserById(1);
        System.err.println(user);
    }
    @Test
    public void testAutowired() throws Exception {
        System.err.println("bean of UserInfoService: " + userInfoService);
        System.err.println("bean of userInfoDao: " + userInfoDao);
    }
    @Test
    public void testBeanCopy() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUserName("tom");
        System.err.println("source：" + user);
        SubUser subUser = new SubUser();
        System.err.println("before copy：" + subUser);
        BeanUtils.copyProperties(user, subUser);
        System.err.println("after copy：" + subUser);
    }
    @Test
    public void testSelectUserByName() throws Exception {
        User user = new User();
        user.setUserName("a");
        List<User> users = userInfoDao.selectUserByName(user);
        System.err.println(users);
    }
    @Test
    public void testSelectSlaveUserByName() throws Exception {
        User user = new User();
        user.setUserName("a");
        List<User> users = userInfoDao.selectSlaveUserByName(user);
        System.err.println(users);
    }

    @Test
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUserName("mtime");
        user.setPassword("mtime123456");
        String result = "";
        try{
            userInfoService.insertUser(user);
            result = " OK!";
        }catch(Exception e){
            result = "Roll Back";
        }
        System.out.println(result);
    }
}