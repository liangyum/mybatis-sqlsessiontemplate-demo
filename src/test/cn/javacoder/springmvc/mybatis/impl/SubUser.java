/**
 * 
 */
package cn.javacoder.springmvc.mybatis.impl;

import cn.javacoder.springmvc.mybatis.entity.User;

/**
 * @author Administrator
 * @version 创建时间：2019年10月10日 上午12:36:35
 * @Description 类描述
 * @since jdk1.7
 */
public class SubUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SubUser [address=" + address + ", getAddressList()=" + getAddressList() + ", getPassword()="
                + getPassword() + ", getUserName()=" + getUserName() + ", getId()=" + getId() + "]";
    }
    

}
