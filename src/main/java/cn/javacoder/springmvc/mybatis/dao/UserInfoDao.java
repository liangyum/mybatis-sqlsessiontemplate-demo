package cn.javacoder.springmvc.mybatis.dao;

import cn.javacoder.springmvc.mybatis.entity.User;
import cn.javacoder.springmvc.mybatis.service.UserInfoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by aijun.fu@mtime.com
 * Date:2016/8/17
 * Time:15:48
 */

@Repository
public class UserInfoDao extends AbstractDao {
    @Autowired
    private UserInfoService userInfoService;

    public User selectUserById(int userId) {
        return sqlTpl.selectOne("cn.javacoder.springmvc.mybatis.entity.UserMapper.selectUserById",userId);
    }

    @Transactional
    public void insertUser(User user) {
        int i = sqlTpl.insert("cn.javacoder.springmvc.mybatis.entity.UserMapper.insertUser",user);
        throw new RuntimeException();
    }

    /**
     * @param user
     * @return
     */
    public List<User> selectUserByName(User user) {
        return sqlTpl.selectList("cn.javacoder.springmvc.mybatis.entity.UserMapper.selectUserByName",user);
    }
    
    public List<User> selectSlaveUserByName(User user) {
        return sqlTplSlave.selectList("cn.javacoder.springmvc.mybatis.entity.UserMapper.selectUserByName",user);
    }
}
