package cn.edu.gdin.service.impl;

import cn.edu.gdin.mapper.RoleMapper;
import cn.edu.gdin.po.Role;
import cn.edu.gdin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;

    public Role findByUserAccount(String userAccount) {
        return roleMapper.selectByUserAccount(userAccount);
    }
}
