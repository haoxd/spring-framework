package org.haoxd.spring.ioc.beans;

import org.haoxd.spring.ioc.annotation.Super;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
@Super
public class SuperUser extends  User {

    private  String address;


    public SuperUser() {

    }

    public SuperUser(Integer userId, String userName, String address) {
        super(userId, userName);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                '}' + super.toString();

    }
}
