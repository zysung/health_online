package cn.edu.gdin.service;

import cn.edu.gdin.po.Role;

public interface RoleService {
    Role findByUserAccount(String userAccount);
}
