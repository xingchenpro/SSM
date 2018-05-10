package com.hly.spring.pojo.springBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author :hly
 * @date :2018/5/10
 */
@Component(value = "role")
public class Role {
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
