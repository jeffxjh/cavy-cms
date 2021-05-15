package com.jh.cavycms.service;

import cn.hutool.core.bean.BeanUtil;
import com.jh.cavycms.domain.SysMenu;
import com.jh.cavycms.mapper.SysMenuMapper;
import com.jh.cavycms.vo.SysMenuVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuService{

    @Resource
    private SysMenuMapper sysMenuMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(SysMenu record) {
        return sysMenuMapper.insert(record);
    }

    
    public int insertSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    
    public SysMenu selectByPrimaryKey(Integer id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKey(record);
    }

    public List<SysMenuVO> queryList() {
        List<SysMenu> sysMenus = sysMenuMapper.queryList();
        List<SysMenuVO> sysMenuVOS = new ArrayList<>();
        for (SysMenu sysMenu : sysMenus) {
            sysMenuVOS.add(BeanUtil.copyProperties(sysMenu, SysMenuVO.class));
        }
        return sysMenuVOS;

    }
}
