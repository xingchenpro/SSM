package com.hly.spring.SpringIOC.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @date :2018/5/12
 */
@Component("role")
public class BeanRole {
    @Value("1")
    private int rolerId;
    @Value("hly")
    private String roleName;
    @Value("god")
    private String roleNote;

    public int getRolerId() {
        return rolerId;
    }

    public void setRolerId(int rolerId) {
        this.rolerId = rolerId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNote() {
        return roleNote;
    }

    public void setRoleNote(String roleNote) {
        this.roleNote = roleNote;
    }
}
